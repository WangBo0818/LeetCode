/**
 * @author wb
 * @date 2020/2/12 - 20:31
 * LeetCode---104. 二叉树的最大深度
 */
public class LeetCode_104_MaxDepth {

    public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
   }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftDepth = maxDepth(root.left);
            int rightDepth = maxDepth(root.right);
            return Math.max(leftDepth, rightDepth);
        }
    }
}
