/**
 * @author wb
 * @date 2020/1/14 - 11:24
 * LeetCode---415. 字符串相加
 */
public class LeetCode_415_AddStrings {

    /**
     * 代码冗余，时间复杂度太差，思路是清晰的，但是代码阅读性太差，不够优雅
     * */
    public String addStrings(String num1, String num2) {
        if ("0".equals(num1)) {
            return num2;
        }
        if ("0".equals(num2)) {
            return num1;
        }
        int[] arr;
        if (num1.length() < num2.length()) {
            arr = new int[num1.length()];
        }else {
            arr = new int[num2.length()];
        }

        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int tmp = arr.length - 1;
        int jinwei = 0;
        while (i >= 0 && j >= 0) {
            int c1 = num1.charAt(i) - '0';
            int c2 = num2.charAt(j) - '0';
            int benwei = (c1 + c2 + jinwei) % 10;
            jinwei = (c1 + c2 + jinwei) / 10;
            arr[tmp] = benwei;
            i --;
            j--;
            tmp--;
        }

        StringBuilder sb = new StringBuilder();

        String s = "";

        while (i >= 0) {
            int c = num1.charAt(i) - '0';
            s += (c + jinwei) % 10;
            jinwei = (c + jinwei) / 10;
            i--;
        }
        while (j >= 0) {
            int c = num2.charAt(j) - '0';
            s += (c + jinwei) % 10;
            jinwei = (c + jinwei) / 10;
            j--;
        }

        if (jinwei != 0) {
            sb.append(jinwei);
        }

        for (int l = s.length() - 1; l >= 0; l--) {
            sb.append(s.charAt(l));
        }

        for (int l = 0; l < arr.length; l++) {
            sb.append(arr[l]);
        }
        return sb.toString();
    }

    /**
     * 思路差不多，但是代码更优雅
     * */
    public String addStrings2(String num1, String num2) {
        if ("0".equals(num1)) {
            return num2;
        }
        if ("0".equals(num2)) {
            return num1;
        }
        StringBuilder res = new StringBuilder("");
        int i = num1.length() - 1, j = num2.length() - 1, carry = 0;
        while(i >= 0 || j >= 0){
            int n1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int n2 = j >= 0 ? num2.charAt(j) - '0' : 0;
            int tmp = n1 + n2 + carry;
            carry = tmp / 10;
            res.append(tmp % 10);
            i--; j--;
        }
        if(carry == 1) res.append(1);
        return res.reverse().toString();
    }
}
