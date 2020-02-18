/**
 * @author wb
 * @date 2020/2/17 - 21:56
 * 剑指 Offer---22. 链表中倒数第 k 个结点
 */
public class SwordMeansOffer_22_FindKthToTail {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindKthToTail(ListNode head,int k) {
        if (head == null) {
            return head;
        }
        int count = 0;
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        pre.next = head;
        while (head != null) {
            count++;
            head = head.next;
        }
        if (count < k) {
            return null;
        }
        for (int i = 0; i <= count - k; i++) {
            pre = pre.next;
        }
        return pre;
    }
}
