/**
 * @author wb
 * @date 2020/2/11 - 22:05
 * LeetCode---101. 对称二叉树
 */
public class LeetCode_101_IsSymmetric {

    public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
   }

    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    private boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        // 递归出口
        if (t1.val == t2.val && isMirror(t1.right, t2.left) && isMirror(t1.left, t1.right)) {
            return true;
        } else {
            return false;
        }
    }
}
