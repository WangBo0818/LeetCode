import java.util.Stack;

/**
 * @author wb
 * @date 2020/2/18 - 20:03
 * 剑指 Offer---30. 栈的压入、弹出序列
 */
public class SwordMeansOffer_30_IsPopOrder {

    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if (pushA == null || pushA.length == 0 || popA == null || popA.length == 0) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for (int i = 0; i < pushA.length; i++) {
            stack.push(pushA[i]);
            while (!stack.isEmpty() && stack.peek() == popA[j]) {
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }
}
