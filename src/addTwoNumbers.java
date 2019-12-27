/**
 * @author wb
 * @date 2019/12/25 - 9:54
 * LeetCode---2. 两数相加
 */
public class addTwoNumbers {

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

  /**
   * 解法：将链表l1、l2中对应结点的值相加后（要考虑到本位及存在进位的情况）存入新创建的链表中，
   *        当两个链表都遍历完之后，进位值为1时，新增一个值为1的结点
   * */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        int jinwei = 0;
        while(l1 != null || l2 != null || jinwei != 0) {
            int l1Val = l1 != null ? l1.val : 0;
            int l2Val = l2 != null ? l2.val : 0;
            int sumVal = l1Val + l2Val + jinwei;
            jinwei = sumVal / 10;

            ListNode tmp = new ListNode(sumVal % 10);
            pre.next = tmp;
            pre = tmp;
            if(l1 != null) {
                l1 = l1.next;
            }
            if(l2 != null) {
                l2 = l2.next;
            }
        }
        return dummy.next;
    }
}
