/**
 * @author wb
 * @date 2020/2/6 - 19:31
 * LeetCode---66. 加以
 */
public class LeetCode_66_PlusOne {

    public int[] plusOne(int[] digits) {
        if(digits[0] == 0) {
            return new int[]{1};
        }
        int i = digits.length-1;
        digits[i] += 1;
        while(i >= 1 && digits[i] > 9) {
            digits[i] = 0;
            digits[i-1] += 1;
            i--;
        }

        if(digits[0] > 9) {
            int[] res = new int[digits.length+1];
            res[0] = 1;
            for(int j = 1; j < res.length; j++) {
                res[j] = 0;
            }
            return res;
        }else {
            return digits;
        }
    }
}
