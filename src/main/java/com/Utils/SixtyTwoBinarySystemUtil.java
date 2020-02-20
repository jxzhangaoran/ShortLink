package com.Utils;

public class SixtyTwoBinarySystemUtil {

    /**
     * 传入十进制Long类型数值ID，转换为62进制字符串
     * why62进制：
     * 0 - 9 : 10个
     * a - z : 26个
     * A - Z : 26个
     * 10 + 26 + 26 = 62
     * @param decimal
     * @return
     */
    public static String toSixtyTwoString(Long decimal){
        if(decimal.compareTo(99999999L) > 0 && decimal.compareTo(4294967295L) < 0){
            StringBuilder sb = new StringBuilder();
            while(true){
                int a = (int)(decimal % 62);
                sb.append(getOneSixtyTwoDigit(a));
                decimal /= 62;
                if(decimal == 0)break;
            }
            return sb.reverse().toString();
        }
        return "Invalid parameter!";
    }

    /**
     * 十进制0 - 61转换为62进制的一位字符
     * @return
     */
    private static char getOneSixtyTwoDigit(int b){
        if(b < 0)return '0';
        else if(b < 10)return (b + "").charAt(0);
        else if(b < 36)return (char)(b + 87);
        else if(b < 62)return (char)(b + 29);
        else return '0';
    }

    public static void main(String[] args) {
        System.out.println(SixtyTwoBinarySystemUtil.toSixtyTwoString(10000000L));
    }
}
