import java.util.HashMap;

/**
 * @author wb
 * @date 2020/2/19 - 22:00
 * 剑指 Offer---34. 复杂链表的复制
 */
public class SwordMeansOffer_34_Clone {

    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    public RandomListNode Clone(RandomListNode pHead) {
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode tmp = pHead;
        while (tmp != null) {
            RandomListNode copyNode = new RandomListNode(tmp.label);
            copyNode.next = tmp.next;
            copyNode.random = tmp.random;
            map.put(tmp, copyNode);
            tmp = tmp.next;
        }
        tmp = pHead;
        while (tmp != null) {
            RandomListNode copyNode = map.get(tmp);
            copyNode.next = map.get(tmp.next);
            copyNode.random = map.get(tmp.random);
            tmp = tmp.next;
        }
        return map.get(pHead);
    }
}
