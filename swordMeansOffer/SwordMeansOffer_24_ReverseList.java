/**
 * @author wb
 * @date 2020/1/1 - 16:25
 * 剑指offer---24. 反转链表
 */
public class SwordMeansOffer_24_ReverseList {

    public class ListNode {
      int val;
      ListNode next;
     ListNode(int x) { val = x; }
    }

    /**
     * 解法一：不头结点的非递归（迭代）思路
     * */
    public ListNode reverseList1(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode p1 = head;
        ListNode p2 = head.next;
        p1.next = null;
        while(p2 != null) {
            ListNode tmp = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = tmp;
        }
        return p1;
    }

    /**
     * 解法二：带头结点的非递归（迭代）思路
     * */
    public ListNode reverseList2(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        while(head != null) {
            ListNode tmp = head.next;
            head.next = dummy.next;
            dummy.next = head;
            head = tmp;
        }
        return dummy.next;
    }

    /**
     * 解法三：递归
     * */
    public ListNode reverseList3(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseList3(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}
