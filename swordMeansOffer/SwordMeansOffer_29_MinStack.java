import java.util.Stack;

/**
 * @author wb
 * @date 2020/2/18 - 19:06
 * 剑指 Offer---29. 包含 min 函数的栈
 */
public class SwordMeansOffer_29_MinStack {

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public void push(int node) {
        stack.push(node);
        if (minStack.isEmpty()) {
            minStack.push(node);
        } else {
            if (node < minStack.peek()) {
                minStack.push(node);
            }
        }
    }

    public void pop() {
        int tmp = stack.pop();
        if (tmp == minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
