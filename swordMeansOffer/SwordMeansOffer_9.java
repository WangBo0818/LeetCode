import java.util.Stack;

/**
 * @author wb
 * @date 2020/2/7 - 20:24
 * 剑指offer---9. 用两个栈实现队列
 */
public class SwordMeansOffer_9 {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if(stack2.isEmpty()) {
            while(!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
