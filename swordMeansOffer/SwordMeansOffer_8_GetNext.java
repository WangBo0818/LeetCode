/**
 * @author wb
 * @date 2020/2/16 - 14:51
 * 剑指 offer---8. 二叉树的下一个结点
 */
public class SwordMeansOffer_8_GetNext {

    public class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }

    /**
     * 参考：https://blog.nowcoder.net/n/37b2e6170ffb4acaa27f67f88b1b1922?f=comment
     * */
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        // 1. 该结点有右子树
        if (pNode.right != null) {
            TreeLinkNode pRight = pNode.right;
            while (pRight.left != null) {
                pRight = pRight.left;
            }
            return pRight;
        }
        // 2. 该结点无右子树，且该结点是该结点父结点的左子树，则下一个结点应该是该结点的父结点
        if (pNode.next != null && pNode == pNode.next.left) {
            return pNode.next;
        }
        // 3. 该结点无右子树，且该结点是该结点父结点的右子树，则我们一直沿着父结点追溯，
        //    直到找到某个结点是其父结点的左子树，如果存在这样的结点，则下一个结点是该结点的父结点
        if (pNode.next != null) {
            TreeLinkNode pNext = pNode.next;
            while (pNext.next != null && pNext.next.right == pNext) {
                pNext = pNext.next;
            }
            return pNext.next;
        }
        return null;
    }
}
