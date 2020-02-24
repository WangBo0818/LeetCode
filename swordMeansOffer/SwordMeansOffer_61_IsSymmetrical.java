import java.util.ArrayList;

/**
 * @author wb
 * @date 2020/2/23 - 11:35
 * 剑指 Offer---61. 对称的二叉树
 */
public class SwordMeansOffer_61_IsSymmetrical {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 解题思路：
     *  二叉树的左子树的左叶子结点要等于右子树的右叶子结点，反之亦是
     * */

    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }
        return isMirror(pRoot, pRoot);
    }

    public boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        if (t1.val == t2.val && isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left)) {
            return true;
        } else {
            return false;
        }
    }
}
