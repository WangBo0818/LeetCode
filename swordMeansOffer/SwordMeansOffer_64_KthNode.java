import java.util.ArrayList;
import java.util.List;

/**
 * @author wb
 * @date 2020/2/23 - 20:53
 * 剑指 Offer---64. 二叉搜索树的第 K 个结点
 */
public class SwordMeansOffer_64_KthNode {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    private TreeNode res;
    private int count = 0;

    TreeNode KthNode(TreeNode pRoot, int k) {
        if (k == 0) {
            return null;
        }
        if (pRoot == null) {
            return null;
        }
        inOrder(pRoot, k);
        return res;
    }

    public void inOrder(TreeNode root, int k) {
        if (root == null || count >= k) {
            return ;
        }
        inOrder(root.left, k);
        count++;
        if (count == k) {
            res = root;
        }
        inOrder(root.right, k);
    }
}
