/**
 * @author wb
 * @date 2020/2/23 - 9:06
 * 剑指 Offer---57. 表示数值的字符串
 */
public class SwordMeansOffer_57_IsNumeric {

    // 用正则表达式进行模式匹配
    public boolean isNumeric(char[] str) {
        if (str == null || str.length == 0) {
            return false;
        }
        return new String(str).matches("[+-]?\\d*(\\.\\d+)?([eE][+-]?\\d+)?");
    }
}
