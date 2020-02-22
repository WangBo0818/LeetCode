import java.util.Arrays;

/**
 * @author wb
 * @date 2020/2/21 - 20:14
 * 剑指 Offer---44. 两个链表的第一个公共结点
 */
public class SwordMeansOffer_44_FindFirstCommonNode {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        ListNode tmpA = pHead1;
        ListNode tmpB = pHead2;
        while (tmpA != tmpB) {
            if (tmpA != null) {
                tmpA = tmpA.next;
            } else {
                tmpA = pHead2;
            }
            if (tmpB != null) {
                tmpB = tmpB.next;
            } else {
                tmpB = pHead1;
            }
        }
        return tmpA;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1, 2, 2, 2, 2, 3};
        System.out.println(Arrays.binarySearch(arr, 2));
    }
}
