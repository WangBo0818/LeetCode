/**
 * @author wb
 * @date 2020/1/1 - 12:58
 * LeetCode---92. 反转链表II
 */
public class LeetCode_92_ReverseBetween {

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || head.next == null || m == n) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        // 找到m 结点的前一个结点
        for(int i = 1; i < m; i++) {
            pre = pre.next;
        }
        // 定位m 结点
        ListNode mnode = pre.next;
        for(int i = m; i < n; i++) {
            ListNode tmp = mnode.next;
            mnode.next = tmp.next;
            tmp.next = pre.next;
            pre.next = tmp;
        }
        return dummy.next;
    }
}
