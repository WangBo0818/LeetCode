/**
 * @author wb
 * @date 2020/1/17 - 10:14
 * LeetCode---67. 二进制求和
 */
public class LeetCode_67_AddBinary {

    public String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        int jinwei = 0;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0) {
            int n1 = i >= 0 ? a.charAt(i) - '0' : 0;
            int n2 = j >= 0 ? b.charAt(j) - '0' : 0;
            int benwei = (n1 + n2 + jinwei) % 2;
            jinwei = (n1 + n2 + jinwei) / 2;
            sb.append(benwei);
            i--;
            j--;
        }
        if (1 == jinwei) {
            sb.append(1);
        }
        return sb.reverse().toString();
    }
}
