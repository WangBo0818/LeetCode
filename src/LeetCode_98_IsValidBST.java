/**
 * @author wb
 * @date 2020/2/11 - 21:27
 * LeetCode---98. 验证二叉搜索树
 */
public class LeetCode_98_IsValidBST {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    private boolean helper(TreeNode node, Integer lower, Integer upper) {
        if (node == null) {
            return true;
        }
        int val = node.val;
        // 递归出口
        if (lower != null && val <= lower) {
            return false;
        }
        if (upper != null && val >= upper) {
            return false;
        }

        // 右子树中的元素都要大于左子树中的所有元素
        if (!helper(node.left, lower, val)) {
            return false;
        }
        if (!helper(node.right, val, upper)) {
            return false;
        }

        return true;
    }
}
