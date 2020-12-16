/*
 Copyright 2006-2011 Abdulla Abdurakhmanov (abdulla@latestbit.com)
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
package org.bn.coders;

public interface UniversalTag {
    public final int Reserved0          =   0;
    public final int Boolean            =   1;
    public final int Integer            =   2;
    public final int Bitstring          =   3;
    public final int OctetString        =   4;
    public final int Null               =   5;
    public final int ObjectIdentifier   =   6;
    public final int ObjectDescriptor   =   7;
    public final int External           =   8;
    public final int Real               =   9;
    public final int Enumerated         =   10;
    public final int EmbeddedPdv        =   11;
    public final int UTF8String          =   12;
    public final int RelativeObject     =   13;
    public final int Reserved14         =   14;
    public final int Reserved15         =   15;
    public final int Sequence           =   16;
    public final int Set                =   17;
    public final int NumericString      =   18;
    public final int PrintableString    =   19;
    public final int TeletexString      =   20;
    public final int VideotexString     =   21;
    public final int IA5String          =   22;
    public final int UTCTime            =   23;
    public final int GeneralizedTime    =   24;
    public final int GraphicString      =   25;
    public final int VisibleString      =   26;
    public final int GeneralString      =   27;
    public final int UniversalString    =   28;
    public final int UnspecifiedString  =   29;
    public final int BMPString          =   30;
    public final int LastUniversal      =   31;
}
