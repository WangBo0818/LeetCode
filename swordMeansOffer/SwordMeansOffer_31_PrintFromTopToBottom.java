import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wb
 * @date 2020/2/18 - 21:36
 * 剑指 Offer---31. 从上往下打印二叉树
 */
public class SwordMeansOffer_31_PrintFromTopToBottom {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        ArrayList<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int count = queue.size();
            while (count > 0) {
                count--;
                TreeNode tmp = queue.poll();
                if (tmp == null) {
                    continue;
                }
                res.add(tmp.val);
                queue.add(tmp.left);
                queue.add(tmp.right);
            }
        }
        return res;
    }
}
