/**
 * @author wb
 * @date 2020/2/12 - 21:36
 * LeetCode---171. Excel表列序号
 */
public class LeetCode_171_TitleToNumber {

    /**
     * 解题思路：
     *  等价于将 26 进制数转化为 10 进制
     * */
    public int titleToNumber(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            int num = s.charAt(i) - '0' + 1;
            res = res * 26 + num;
        }
        return res;
    }
}
