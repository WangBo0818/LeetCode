/**
 * @author wb
 * @date 2020/1/1 - 12:02
 * LeetCode---24. 两两交换链表中的结点
 */
public class LeetCode_24_SwapPairs {

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        while(pre.next != null && pre.next.next != null) {
            ListNode start = pre.next;
            ListNode end = pre.next.next;
            pre.next = end;
            start.next = end.next;
            end.next = start;
            pre = start;
        }
        return dummy.next;
    }
}
