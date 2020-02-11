import java.util.ArrayList;
import java.util.List;

/**
 * @author wb
 * @date 2020/2/11 - 22:55
 * LeetCode---103. 二叉树的锯齿形层次遍历
 */
public class LeetCode_103_ZigzagLevelOrder {

    public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
   }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        helper(res, root, 0);
        return res;
    }

    private void helper(List<List<Integer>> res, TreeNode node, int level) {
        if (res.size() == level) {
            res.add(new ArrayList<>());
        }
        if (level % 2 == 0) {
            res.get(level).add(node.val);
        } else {
            res.get(level).add(0, node.val);
        }
        if (node.left != null) {
            helper(res, node.left, level + 1);
        }
        if (node.right != null) {
            helper(res, node.right, level + 1);
        }
    }
}
