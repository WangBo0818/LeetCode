/**
 * @author wb
 * @date 2019/12/27 - 10:54
 * LeetCode---12. 整数转罗马数字
 */
public class LeetCode_12_IntToRoman {
    /**
     * 解题思路：可以参考数零钱的思想，使用贪心算法，每次选择最大的最为加法因子
     * */
    public String intToRoman(int num) {
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while(index < nums.length) {
            while(num >= nums[index]) {
                sb.append(romans[index]);
                num -= nums[index];
            }
            index++;
        }
        return sb.toString();
    }
}
