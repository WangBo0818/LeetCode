/**
 * @author wb
 * @date 2020/1/1 - 12:21
 * LeetCode---206. 反转链表
 */
public class LeetCode_206_ReverseList {

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    /**
     * 解法一：迭代反转链表
     * */
    public ListNode reverseList(ListNode head) {
        if(head == null) {
            return head;
        }
        ListNode p1 = head;
        ListNode p2 = head.next;
        p1.next = null;
        while(p2 != null) {
            ListNode tmp = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = tmp;
        }
        return p1;
    }

    /**
     * 解法二：递归反转链表
     * */
    public ListNode reverseList2(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}
