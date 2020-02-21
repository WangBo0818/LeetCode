import java.util.*;

/**
 * @author wb
 * @date 2020/2/20 - 22:01
 * 剑指 Offer---. 把字符串转化为整数
 */
public class SwordMeansOffer_StrToInt {

    public int StrToInt(String str) {
        if ("0".equals(str) || str == null || str.length() == 0) {
            return 0;
        }
        int res = 0;
        boolean flag = true;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (i == 0 && (c == '+' || c == '-')) {
                if (c == '-') {
                    flag = false;
                }
            } else if (c >= '0' && c <= '9') {
                if (res > (Integer.MAX_VALUE - (c - '0')) / 10) {
                    return flag ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                res *= 10;
                res += c - '0';
            } else {
                return 0;
            }
        }
        return flag ? res : -res;
    }
}
