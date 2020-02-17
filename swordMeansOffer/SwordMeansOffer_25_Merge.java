import java.util.logging.Level;

/**
 * @author wb
 * @date 2020/1/1 - 16:56
 * 剑指offer---25. 合并两个排序的链表
 */
public class SwordMeansOffer_25_Merge {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * 解法一：迭代实现
     * */
    public ListNode Merge(ListNode list1,ListNode list2) {
        if(list1 == null) {
            return list2;
        }
        if(list2 == null) {
            return list1;
        }
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        while(list1 != null && list2 != null) {
            if(list1.val < list2.val) {
                pre.next = list1;
                list1 = list1.next;
            }else {
                pre.next = list2;
                list2 = list2.next;
            }
            pre = pre.next;
        }
        if(list1 != null) {
            pre.next = list1;
        }
        if(list2 != null) {
            pre.next = list2;
        }
        return dummy.next;
    }

    /**
     * 解法二：递归实现
     * */
    public ListNode Merge2(ListNode list1,ListNode list2) {
        if(list1 == null) {
            return list2;
        }
        if(list2 == null) {
            return list1;
        }
        if(list1.val < list2.val) {
            list1.next = Merge2(list1.next, list2);
            return list1;
        }else {
            list2.next = Merge2(list1, list2.next);
            return list2;
        }
    }
}
