/**
 * @author wb
 * @date 2020/2/17 - 22:33
 * 剑指 Offer---26. 树的子结构
 */
public class SwordMeansOffer_26_HasSubtree {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }
        return helper(root1, root2) || helper(root1.left, root2) || helper(root1.right, root2);
    }

    public boolean helper(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return true;
        }
        if (root1 == null) {
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }
        return helper(root1.left, root2.left) && helper(root1.right, root2.right);
    }
}
