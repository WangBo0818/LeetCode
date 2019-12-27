/**
 * @author wb
 * @date 2019/12/26 - 16:46
 * LeetCode---9. 回文数
 */
public class isPalindrome {
    /**
     * 解法一：将整数转化为字符串类型，然后进行判断；注意：负数肯定不是回文数，可以直接返回false
     * */
    public boolean isPalindrome(int x) {
        if(x < 0) {
            return false;
        }
        String s = "";
        s += x;
        if(s.length() == 1) {
            return true;
        }
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 解法二：将整数逆序，然后判断是否与原整数相等，若相等，则是回文串（推荐）
     * */
    public boolean isPalindrome2(int x) {
        if(x < 0) {
            return false;
        }
        int rev = 0;
        int tmp = x;
        while(tmp != 0) {
            int yushu = tmp % 10;
            rev = rev * 10 + yushu;
            if(rev > Integer.MAX_VALUE || rev < Integer.MIN_VALUE) {
                rev = 0;
                break;
            }
            tmp /= 10;
        }
        if(x == rev) {
            return true;
        }else {
            return false;
        }
    }
}
