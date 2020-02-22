/**
 * @author wb
 * @date 2020/2/21 - 20:57
 * 剑指 Offer---47. 平衡二叉树
 */
public class SwordMeansOffer_47_IsBalanced_Solution {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) {
            return true;
        }
        return IsBalanced(root);
    }

    public boolean IsBalanced(TreeNode root) {
        if (Math.abs(TreeDepth(root.left) - TreeDepth(root.right)) > 1) {
            return false;
        }
        if (root.left != null) {
            IsBalanced(root.left);
        }
        if (root.right != null) {
            IsBalanced(root.right);
        }
        return true;
    }

    public int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftDepth = TreeDepth(root.left);
            int rightDepth = TreeDepth(root.right);
            return Math.max(leftDepth, rightDepth) + 1;
        }
    }
}
