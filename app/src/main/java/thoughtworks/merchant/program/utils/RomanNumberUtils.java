package thoughtworks.merchant.program.utils;

/**
 * 罗马数字转换为阿拉伯数字工具类
 * Created by Liao on 2018/4/21.
 */

public class RomanNumberUtils {

    /**
     * 获取罗马数字对应的值
     *
     * @param c
     * @return
     */
    public static int getRomanNum(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }

    /**
     * 将罗马数字转化为阿拉伯数字
     *
     * @param s
     * @return
     */
    public static int getRomanNum(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int numbers[] = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            char singleRoman = s.charAt(i);
            numbers[i] = getRomanNum(singleRoman);
        }

        int sum = 0;
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] < numbers[i + 1]) {
                sum -= numbers[i];//// 当前字符比下一个小，则总和减去此数字,反之加
            } else {
                sum += numbers[i];
            }
        }
        return sum + numbers[numbers.length - 1];
    }


}
