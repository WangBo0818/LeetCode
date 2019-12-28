/**
 * @author wb
 * @date 2019/12/26 - 16:39
 * LeetCode---8. 字符串转整数
 */
public class LeetCode_8_MyAtoi {
    // 个人觉得这题没有做的必要，可以跳过
    public int myAtoi(String str) {
        str = str.trim();
        int result = 0;
        boolean isPos = true;
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if(i == 0 && (c == '-'||c == '+')){
                isPos = c == '+' ? true : false;
            } else if (c >= '0' && c <= '9'){
                if(result>(Integer.MAX_VALUE - (c - '0')) / 10){
                    return isPos ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                result *= 10;
                result += c - '0';
            } else {
                return isPos ? result : -result;
            }
        }
        return isPos ? result: -result;
    }
}
