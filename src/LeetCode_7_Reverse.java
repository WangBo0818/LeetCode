/**
 * @author wb
 * @date 2019/12/26 - 16:09
 * LeetCode---7. 整数反转
 */
public class LeetCode_7_Reverse {
    /**
     * 解法一：将整数转化为字符串，然后对字符串反转，最后再转化为int 类型
     *         在这个过程中，要注意x为负数的情况
     * 这种解法效率不是很好
     * */
    public int reverse(int x) {
        String s = String.valueOf(x);
        StringBuilder sb = new StringBuilder();
        char[] arr = s.toCharArray();
        if(x >= 0) {
            for(int i = arr.length-1; i >= 0; i--) {
                sb.append(arr[i]);
            }
        }else {
            for(int i = arr.length-1; i > 0; i--) {
                sb.append(arr[i]);
            }
        }
        Double result = Double.valueOf(sb.toString());

        if(result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            return 0;
        }
        Integer realresult = Integer.valueOf(sb.toString());
        if(x < 0) {
            return realresult*-1;
        }else {
            return realresult;
        }
    }

    /**
     * 解法二：参考了LeetCode官方题解，但是对官方题解做了一些改进
     * */
    public int reverse2(int x) {
        long rev = 0;
        while(x != 0) {
            int tmp = x % 10;
            rev = rev * 10 + tmp;
            if(rev > Integer.MAX_VALUE || rev < Integer.MIN_VALUE) {
                return 0;
            }
            x /= 10;
        }
        return (int)rev;
    }
}
