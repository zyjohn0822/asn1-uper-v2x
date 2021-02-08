package com.hisense.hiatmp.asn.v2x.common;

/**
 * @author zhangyong
 * @date 2020/12/22  10:13
 */
public class Utils {
    /**
     * @param bytes byte[]
     * @return: java.lang.String
     * @since: 1.0.0
     * @Author: zhangyong
     * @Date: 2020/10/30 14:00
     */
    final protected static char[] hexArray = "0123456789ABCDEF".toCharArray();

    /**
     * @param s 16进制字符串
     * @description: <br>
     * @return: byte[] byte[]
     * @since: 1.0.0
     * @Author: zhangyong
     * @Date: 2020/10/30 14:02
     */
    public static byte[] bytesFromHexString(String s) {
        if ((s.length() % 2) != 0) {
            throw new IllegalArgumentException(
                    "Converting to bytes requires even number of characters, got " + s.length());
        }
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                    + Character.digit(s.charAt(i + 1), 16));
        }
        return data;
    }

    public static String hexStringFromBytes(byte[] bytes) {

        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }

    /**
     * @param s
     * @return: java.lang.String
     * @since: 1.0.0
     * @Author: zhangyong
     * @Date: 2020/12/23 19:04
     */
    public static String hexStringToString(String s) {
        if (s == null || s.equals("")) {
            return null;
        }
        s = s.replace(" ", "");
        byte[] baKeyword = new byte[s.length() / 2];
        for (int i = 0; i < baKeyword.length; i++) {
            try {
                baKeyword[i] = (byte) (0xff & Integer.parseInt(s.substring(i * 2, i * 2 + 2), 16));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            s = new String(baKeyword, "UTF-8");
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return s;
    }

    public static int DIVISION_TWO = 2;

    public static String hexLowerSort(String hexHeight) throws Exception {
        if (hexHeight.length() % DIVISION_TWO != 0) {
            throw new Exception("���Ȳ�Ϊż��");
        }
        StringBuilder hexBuilder = new StringBuilder();
        for (int i = 8; i > 0; i--) {
            int begin = i * 2;
            hexBuilder.append(hexHeight, begin - 2, begin);
        }
        return hexBuilder.toString();
    }
}
