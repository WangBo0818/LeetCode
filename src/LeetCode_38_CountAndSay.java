/**
 * @author wb
 * @date 2020/1/13 - 9:37
 * LeetCode---38 外观数列
 */
public class LeetCode_38_CountAndSay {

    public String countAndSay(int n) {
        String str = "1";
        for(int i = 2; i <= n; i++) {
            int count = 1;
            char pre = str.charAt(0);
            StringBuilder sb = new StringBuilder();
            for(int j = 1; j < str.length(); j++) {
                char c = str.charAt(j);
                if(c == pre) {
                    count++;
                }else {
                    sb.append(count).append(pre);
                    count = 1;
                    pre = c;
                }
            }
            sb.append(count).append(pre);
            str = sb.toString();
        }
        return str;
    }
}
