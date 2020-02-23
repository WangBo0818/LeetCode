/**
 * @author wb
 * @date 2020/2/22 - 10:13
 * 剑指 Offer---51. 左旋转字符串
 */
public class SwordMeansOffer_51_LeftRotateString {

    public String LeftRotateString(String str,int n) {
        if (str == null || str.length() == 0 || n > str.length()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        String part1 = str.substring(0, n);
        String part2 = str.substring(n, str.length());
        return sb.append(part2).append(part1).toString();
    }
}
