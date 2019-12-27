import java.util.Stack;

/**
 * @author wb
 * @date 2019/12/16 - 14:50
 * leetcode150---逆波兰表达式求值
 */
public class evalRPN {

    public static void main(String[] args) {
        System.out.println(evalRPN(new String[] {
                "4", "13", "5", "/", "+"
        }));
    }

    public static int evalRPN(String[] tokens) {
        int a, b;
        Stack<Integer> stack = new Stack<>();
        for(String s : tokens) {
            if(s.equals("+")) {
                stack.add(stack.pop() + stack.pop());
            }else if(s.equals("/")) {
                b = stack.pop();
                a = stack.pop();
                stack.add(a / b);
            }else if(s.equals("*")) {
                stack.add(stack.pop() * stack.pop());
            }else if(s.equals("-")) {
                b = stack.pop();
                a = stack.pop();
                stack.add(a - b);
            }else {
                stack.add(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }
}
