import java.util.ArrayList;
import java.util.List;

/**
 * @author wb
 * @date 2020/2/11 - 21:18
 * LeetCode---94. 二叉树的中序遍历
 */
public class LeetCode_94_InorderTraversal {

    public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
   }

    List<Integer> res = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return res;
        }
        inorderTraversal(root.left);
        res.add(root.val);
        inorderTraversal(root.right);
        return res;
    }
}
