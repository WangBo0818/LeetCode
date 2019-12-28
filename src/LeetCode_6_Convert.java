/**
 * @author wb
 * @date 2019/12/26 - 15:51
 * LeetCode---6. Z字型变换
 */
public class LeetCode_6_Convert {

    public static void main(String[] args) {
        System.out.println(convert("LEETCODEISHIRING", 3));
    }

    public static String convert(String s, int numRows) {
        if(s.length() == 1) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        int cycleLen = numRows * 2 - 2;
        int n = s.length();
        // 按行拼接新字符串
        for(int i = 0; i < numRows; i++) {
            for(int j = 0; j + i < n; j += cycleLen) {
                sb.append(s.charAt(i + j));
                //不是第一行，也不是最后一行，下标也不会超过字符串的长度
                if(i != 0 && i != numRows - 1 && (j + cycleLen - i) < n) {
                    sb.append(s.charAt(j + cycleLen - i));
                }
            }
        }
        return sb.toString();
    }
}
