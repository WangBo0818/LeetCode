/**
 * @author wb
 * @date 2020/2/23 - 10:14
 * 剑指 Offer---59. 链表中环的入口结点
 */
public class SwordMeansOffer_59_EntryNodeOfLoop {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return null;
        }
        ListNode slow = pHead;
        ListNode fast = pHead;
        // 找到快慢结点相遇的结点位置
        do {
            slow = slow.next;
            fast = fast.next.next;
        } while (slow != fast);
        // 链表的第一个结点到环的入口结点的距离等于相遇结点到入口结点的距离
        slow = pHead;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
