import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author wb
 * @date 2019/12/25 - 19:05
 * 剑指offer---7. 重建二叉树
 */
public class SwordMeansOffer_7_ReConstructBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
  }

    /**
     * 解题思路：前序遍历的第一个值为根节点的值，利用这个值将中序遍历结果分为两部分，
     * 左部分为树的左子树中序遍历结果，右部分为数的右子树中序遍历结果。然后分别对左右子树递归求解
     * */

    private Map<Integer, Integer> map = new HashMap<>();

    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        if(pre == null || in == null || pre.length == 0 || in.length == 0) {
            return null;
        }
        for(int i = 0; i < in.length; i++) {
            map.put(in[i], i);
        }
        return reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    private TreeNode reConstructBinaryTree(int[] pre, int startPreOrder, int endPreOrder, int[] in, int startInOrder, int endInOrder) {
        // 前序遍历的第一个节点就是根节点
        TreeNode root = new TreeNode(pre[startPreOrder]);
        root.left = null;
        root.right = null;
        // 二叉树只有一个节点
        if(startPreOrder == endPreOrder) {
            if(pre[startPreOrder] == in[startInOrder] && startInOrder == endInOrder) {
                return root;
            }
        }
        // 方式一：在中序遍历中找到根节点
        /*int rootInOrder = startInOrder;
        while(rootInOrder <= endInOrder && in[rootInOrder] != root.val) {
            rootInOrder++;
        }*/

        // 方式二：可以通过哈希表将中序遍历数组的值和下标存储，以提高查找根节点的效率
        int rootInOrder = map.get(root.val);

        // 中序遍历中左子树的长度
        int leftInTreeLength = rootInOrder - startInOrder;
        // 前序遍历中左子树的长度
        int leftPreTreeEnd = leftInTreeLength + startPreOrder;

        // 如果左子树的长度大于0，则构建左子树
        if(leftInTreeLength > 0) {
            root.left = reConstructBinaryTree(pre, startPreOrder + 1, leftPreTreeEnd, in, startInOrder, rootInOrder - 1);
        }

        if(endInOrder - leftInTreeLength > startInOrder) {
            root.right = reConstructBinaryTree(pre, leftPreTreeEnd + 1, endPreOrder, in, rootInOrder + 1, endInOrder);
        }
        return root;
    }
}
