/**
 * @author wb
 * @date 2019/12/30 - 15:41
 * LeetCode---19. 删除链表的倒数第N 个结点
 */
public class LeetCode_19_RemoveNthFromEnd {

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

  /**
   * 解法一：两次遍历算法
   *    删除链表的倒数第N 个结点，可以转化成删除链表的第(length - n + 1)个结点，length 代表的是
   *    链表的长度。具体实现如下
   * */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        int length = 0;
        ListNode first = head;
        while(first != null) {
            length++;
            first = first.next;
        }
        first = dummy;
        for(int i = 0; i < length - n + 1; i++) {
            first = first.next;
        }
        first.next = first.next.next;
        return dummy.next;
    }

    /**
     * 解法二：双指针一次遍历法
     *  定义两个结点指针，第一个结点先移动n 步，当第一个结点的下一个结点不为 null 时，
     *  第一个结点和第二个结点同时向后移动。当第一个结点的下一个结点为 null 时，
     *  second 指向的就是要删除的结点的前一个结点
     * */
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        // 将第一个结点移动n 步
        for(int i = 0; i < n; i++) {
            first = first.next;
        }
        // 当first 结点的下一个结点为null 时，就已经找到了要被删除的结点的前一个结点
        while(first.next != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }
}
