/**
 * @author wb
 * @date 2020/1/3 - 15:15
 * LeetCode---29. 两数相除
 */
public class LeetCode_29_Divide {

    /**
     * 解题思路：使用异或运算符判断被除数和除数的符号是否相同，将被除数和除数都转化为负数
     * 进行运算，最后再根据异或运算的结果来决定是否将 result 取反
     * */
    public static int divide(int dividend, int divisor) {
        // 使用异或运算符判断被除数和除数的符号是否相同
        boolean sign = (dividend > 0) ^ (divisor > 0);
        double result = 0;
        // 将被除数和除数都转化为负数来处理
        if (dividend > 0) {
            dividend = -dividend;
        }
        if (divisor > 0) {
            divisor = -divisor;
        }
        while (dividend <= divisor) {
            int temp_result = -1;
            int temp_divisor = divisor;
            // 当被除数小于等于 temp_divisor
            while (dividend <= (temp_divisor << 1)) {
                // 判断是否越界
                if (temp_divisor <= (Integer.MIN_VALUE >> 1)) {
                    break;
                }
                temp_result = temp_result << 1;
                temp_divisor = temp_divisor << 1;
            }
            dividend = dividend - temp_divisor;
            result += temp_result;
        }
        // 如果被除数与除数的符号不一致,则将结果取反
        if (!sign) {
            if (result < Integer.MIN_VALUE) {
                return Integer.MAX_VALUE;
            }
            result = -result;
        }
        return (int)result;
    }
}
