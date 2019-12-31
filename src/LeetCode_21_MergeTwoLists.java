/**
 * @author wb
 * @date 2019/12/31 - 8:34
 * LeetCode---21. 合并两个有序链表
 */
public class LeetCode_21_MergeTwoLists {

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    /**
     * 定义一个带有头结点的新链表，分别将 l1 和 l2 中的元素值进行比较，谁小就先添加到新链表
     * */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 != null) {
            return l2;
        }
        if(l1 != null && l2 == null) {
            return l1;
        }
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                pre.next = l1;
                l1 = l1.next;
            }else {
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }
        if(l1 != null) {
            pre.next = l1;
        }
        if(l2 != null) {
            pre.next = l2;
        }
        return dummy.next;
    }
}
