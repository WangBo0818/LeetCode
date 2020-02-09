/**
 * @author wb
 * @date 2020/2/9 - 19:14
 * LeetCode---148. 排序链表
 */
public class LeetCode_148_SortList {

    public class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        // 找到中间结点 slow
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode tmp = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(tmp);

        // 将链表合并
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        while (left != null && right != null) {
            if (left.val < right.val) {
                pre.next = left;
                left = left.next;
            } else {
                pre.next = right;
                right = right.next;
            }
            pre = pre.next;
        }
        // 奇数个结点的情况下还会多一个
        pre.next = left != null ? left : right;
        return dummy.next;
    }
}
