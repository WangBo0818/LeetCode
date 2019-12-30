import java.util.Stack;

/**
 * @author wb
 * @date 2019/12/30 - 16:28
 * LeetCode---20. 有效的括号
 */
public class LeetCode_20_IsValid {

    /**
     * 这题让我想到了逆波兰式求值，利用栈先进后出的特点来判断括号是否有效
     * 可以加一些额外的判断来提高解题效率：
     *      例如：如果 s 为空，直接返回 false
     *            如果字符串的长度为奇数，直接返回 false
     * */
    public boolean isValid(String s) {
        if(s == null || s.length() == 0) {
            return true;
        }
        if(s.length() % 2 != 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }else {
                if(stack.isEmpty()) {
                    return false;
                }
                if(c == ')' && stack.pop() != '(' || c == ']' && stack.pop() != '['
                        || c == '}' && stack.pop() != '{') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
