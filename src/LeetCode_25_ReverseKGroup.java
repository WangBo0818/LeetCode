/**
 * @author wb
 * @date 2020/1/1 - 13:23
 * LeetCode---25. K 个一组反转链表
 */
public class LeetCode_25_ReverseKGroup {

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    /**
     * 利用LeetCode92题的从指定位置反转链表，将链表按照每K 个元素进行分组，
     * 然后将每个组中的元素进行反转
     * */
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null || k == 1) {
            return head;
        }
        int count = 0;
        int index = 1;
        ListNode tmp = head;
        while(tmp != null) {
            count++;
            tmp = tmp.next;
        }
        int num = count / k;
        int end = k;
        for(int i = 0; i < num; i++) {
            head = reverseBetween(head, index, end);
            index += k;
            end += k;
        }
        return head;
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
