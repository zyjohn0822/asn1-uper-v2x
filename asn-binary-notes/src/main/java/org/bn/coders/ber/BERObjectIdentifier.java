/*
 Copyright 2007 Alan Gutzeit.
 Original sources are available at www.latestbit.com

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 */

package org.bn.coders.ber;

import java.util.ArrayList;

/**
* Implementation of OID encoding by Alan Gutzeit
*/
@SuppressWarnings("unchecked")
public class BERObjectIdentifier 
{
	public static byte[] Encode(int[] oidArcArray)
    {
        int arcLength = oidArcArray.length;
        assert arcLength >= 2 : "Object id must contain at least 2 arcs";
        byte[] result = new byte[(arcLength * 5)]; // 32-bit encoding cannot exceed 5 bytes each 
        int nextAvailable = 0;
        nextAvailable += EncodeFirstTwoArcs(oidArcArray[0], oidArcArray[1], result, nextAvailable);
        for (int i = 2; i < arcLength; i++)
        {
            nextAvailable += EncodeOneArc(oidArcArray[i], result, nextAvailable);
        }
        assert nextAvailable <= 255 : "Encoded length of object id exceeded 255 bytes";
        byte[] ba = Truncate(result, nextAvailable);; 
        return  ba;
    }

    private static int EncodeFirstTwoArcs(int topArc, int secondArc, byte[] result, int nextAvailable)
    {
        assert topArc >=0 && topArc <= 2 : "Top-level arc must be 0, 1 or 2";
        assert secondArc >= 0 && secondArc <= 39 : "Second-level arc must be less than 40";
        int combinedArc = topArc * 40 + secondArc;
        return EncodeOneArc(combinedArc, result, nextAvailable);
    }

    // Encoding: 
    //         11112222333344445555666677778888 
    // 00001111x2222333x3444455x5566667x7778888

    /// <summary>
    /// Adds encoding to passed result array. Note that result array must already have adequate capacity. 
    /// </summary>
    /// <returns>length of result</returns>
    private static int EncodeOneArc(int arc, byte[] result, int nextAvailable)
    {
        long arc1 = (arc & 0x7f);
        long arc2 = (arc & 0x3f80) << 1;
        long arc3 = (arc & 0x1fc000) << 2;
        long arc4 = (arc & 0xfe00000) << 3;
        long arc5 = (arc & 0xf0000000) << 4;
        long all = arc1 | arc2 | arc3 | arc4 | arc5;

        byte[] temp = new byte[5]; 
        temp[4] = (byte)((all & 0xff));
        temp[3] = (byte)((all & 0xff00) >> 8);
        temp[2] = (byte)((all & 0xff0000) >> 16);
        temp[1] = (byte)((all & 0xff000000) >> 24);
        // temp[0] = (byte)((all & 0xff00000000) >> 32);

        int resultLength = 1;
        if (temp[0] > 0) resultLength = 5;            
        else if (temp[1] > 0) resultLength = 4;
        else if (temp[2] > 0) resultLength = 3;
        else if (temp[3] > 0) resultLength = 2;
        // temp[4] can be zero if arc = 0 so resultLength defaults to 1 

        // all bytes have high-order bit one except last byte has high-order bit zero 
        temp[0] |= 0x80; // high-bit set
        temp[1] |= 0x80; // high-bit set
        temp[2] |= 0x80; // high-bit set
        temp[3] |= 0x80; // high-bit set
        temp[4] &= 0x7f; // high-bit reset

        int sourceIndex = 5 - resultLength;
        System.arraycopy(temp, sourceIndex, result, nextAvailable, resultLength);
        return resultLength; 
    }

    // return new array by truncating passed array.
    private static byte[] Truncate(byte[] b1, int nextAvailable)
    {
        byte[] b2 = new byte[nextAvailable];
        System.arraycopy(b1, 0, b2, 0, nextAvailable);
        return b2;
    }

    // =========================================================================

    public static String Decode(byte[] oidBytes)
    {
        int[] intArray1 = BerByteArrayToIntArray(oidBytes);
        assert intArray1.length >= 1 : "Object id must contain at least 2 arcs";
        int[] intArray2 = new int[intArray1.length + 1];
        int combinedArc = intArray1[0];
        int arc1, arc2;
        if (combinedArc < 40) 
        {
            arc1 = 0;
            arc2 = combinedArc;
        }
        else if (combinedArc < 80)
        {
            arc1 = 1;
            arc2 = combinedArc - 40;
        }
        else 
        {
            arc1 = 2;
            arc2 = combinedArc - 80;
        }
        intArray2[0] = arc1;
        intArray2[1] = arc2;
        System.arraycopy(intArray1, 1, intArray2, 2, intArray2.length - 2);
        return IntArrayToDottedDecimal(intArray2);
    }

    public static String IntArrayToDottedDecimal(int[] oidIntArray)
    {
        StringBuilder sb = new StringBuilder(oidIntArray.length * 4);
        for (int i = 0; i < oidIntArray.length; i++)
        {
            if (sb.length() > 0) sb.append('.');
            sb.append(new Integer(oidIntArray[i]).toString().trim());
        }
        return sb.toString();
    }

    // Decoding: 
    // xxxx1111x2222333x3444455x5566667x7778888
    //         11112222333344445555666677778888 
    //

	public static int[] BerByteArrayToIntArray(byte[] berBytes)
    {
        ArrayList intArrayList = new ArrayList();
        ArrayList oneArcSequence = new ArrayList();
        int byteCount = 0;
        for (int i = 0; i < berBytes.length; i++)
        {
            if ((berBytes[i] & 0x80) == 0) // last byte in arc
            {
                oneArcSequence.add(berBytes[i]); 
                intArrayList.add(DecodeOneArc(oneArcSequence));
                oneArcSequence = new ArrayList();
                byteCount = 0;
            }
            else // not last byte in arc
            {
                assert byteCount < 5 : "Conversion can only handle 5 bytes";
                oneArcSequence.add(berBytes[i]); 
                byteCount++;
            }
        }
        int[] ints = new int[intArrayList.size()];
        for (int i = 0; i < ints.length; i++)
        {
        	Integer integer = (Integer) intArrayList.get(i);
            ints[i] = integer.intValue();
        }
        return (ints); 
    }
    
    // returns an single integer arc from an list of BER encoded bytes.  Note that the byte array must 
    // already contain one and only one encoded arc sequence. 
    private static int DecodeOneArc(ArrayList berByteList)
    {
        assert berByteList.size() >= 1 && berByteList.size() <= 5 : "Conversion requires from 1 to 5 bytes";
        long all = 0;
        
        int startByteIndex = berByteList.size() - 1;
        byte[] berBytes = new byte[berByteList.size()];
        for (int i = 0; i < berBytes.length; i++)
        {
        	Byte bb = (Byte) berByteList.get(i);        	
        	berBytes[i] = bb.byteValue();
        }
        for (int i = 0; i <= startByteIndex; i++)
        {
            berBytes[i] = (byte)(berBytes[i] & 0x7f); // make continuation bit zero so it doesn't affect the result
            if (i != 0) all = all << 7;
            all = all | berBytes[i];
        }
        return (int) all; 
    }
}
