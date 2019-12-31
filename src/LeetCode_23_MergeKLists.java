/**
 * @author wb
 * @date 2019/12/31 - 9:25
 * LeetCode---23. 合并K个排序链表
 */
public class LeetCode_23_MergeKLists {

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    /**
     * 本题如果使用暴力破解则需要merge lists.length - 1 次，但是其中很多次的 merge 是重复的
     *
     * 因此可以使用分治的思想来确保数组中的每个元素只合并一次。代码实现很简单，看一遍应该就会懂
     * */
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) {
            return null;
        }
        if(lists.length == 1) {
            return lists[0];
        }
        if(lists.length == 2) {
            return mergeTwoLists(lists[0], lists[1]);
        }
        int mid = lists.length / 2;
        ListNode[] l1 = new ListNode[mid];
        ListNode[] l2 = new ListNode[lists.length - mid];
        for(int i = 0; i < mid; i++) {
            l1[i] = lists[i];
        }
        for(int i = mid; i < lists.length; i++) {
            l2[i - mid] = lists[i];
        }
        return mergeTwoLists(mergeKLists(l1), mergeKLists(l2));
    }

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
