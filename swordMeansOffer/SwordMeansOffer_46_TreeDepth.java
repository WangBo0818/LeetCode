/**
 * @author wb
 * @date 2020/2/21 - 20:47
 * 剑指 Offer---46. 二叉树的深度
 */
public class SwordMeansOffer_46_TreeDepth {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
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
