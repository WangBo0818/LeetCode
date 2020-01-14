/**
 * @author wb
 * @date 2020/1/14 - 10:29
 * LeetCode---43. 字符串相乘
 */
public class LeetCode_43_Multiply {

    public String multiply(String num1, String num2) {
        if("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        int n1 = num1.length()-1;
        int n2 = num2.length()-1;

        int[] arr = new int[num1.length() + num2.length()];

        for(int i = n1; i >= 0; --i) {
            for(int j = n2; j >= 0; --j) {
                int num = (num1.charAt(i)-'0') * (num2.charAt(j)-'0');
                num += arr[i+j+1];
                // 进位
                arr[i+j] += num / 10;
                // 本位
                arr[i+j+1] = num % 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(i < arr.length-1 && arr[i] == 0) {
            i++;
        }
        for(; i < arr.length; ++i)
            sb.append(arr[i]);
        return sb.toString();
    }
}
