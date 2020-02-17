import java.util.ArrayList;

/**
 * @author wb
 * @date 2019/12/25 - 17:59
 * 剑指offer---6. 从尾到头打印链表
 */
public class SwordMeansOffer_6_PrintListFromTailToHead {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 解法一：使用递归
     * */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(listNode != null) {
            list = printListFromTailToHead(listNode.next);
            list.add(listNode.val);
        }
        return list;
    }

    /**
     * 使用头插法构建逆序链表
     * */
    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        ListNode dummy = new ListNode(-1);
        while(listNode != null) {
            ListNode after = listNode.next;
            listNode.next = dummy.next;
            dummy.next = listNode;
            listNode = after;
        }
        ArrayList<Integer> res = new ArrayList<Integer>();
        dummy = dummy.next;
        while(dummy != null) {
            res.add(dummy.val);
            dummy = dummy.next;
        }
        return res;
    }

    /**
     * 解法三：利用栈先进后出的特性完成链表的逆序打印
     * */
}
