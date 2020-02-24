/**
 * @author wb
 * @date 2020/2/23 - 11:18
 * 剑指 Offer---60. 删除链表中重复的结点
 */
public class SwordMeansOffer_60_DeleteDuplication {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = pHead;
        ListNode pre = dummy;
        ListNode cur = pre.next;
        ListNode after = cur.next;
        while (after != null) {
            if (cur.val == after.val) {
                after = after.next;
            } else {
                if (cur.next == after) {
                    pre = pre.next;
                    cur = cur.next;
                    after = after.next;
                } else {
                    pre.next = after;
                    cur = after;
                    after = cur.next;
                }
            }
        }
        if (cur.next != null) {
            pre.next = null;
        }
        return dummy.next;
    }
}
