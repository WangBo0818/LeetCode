import java.util.ArrayList;

/**
 * @author wb
 * @date 2020/2/23 - 13:26
 * 剑指 Offer---62. 按之字形顺序打印二叉树
 */
public class SwordMeansOffer_62_Print {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    ArrayList<ArrayList<Integer>> res = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        if (pRoot == null) {
            return new ArrayList<>();
        }
        ArrayList<Integer> list = new ArrayList<>();
        backTrack(pRoot, 0);
        return res;
    }

    public void backTrack(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (res.size() == level) {
            res.add(new ArrayList<>());
        }
        if (level % 2 == 0) {
            res.get(level).add(root.val);
        } else {
            res.get(level).add(0, root.val);
        }
        backTrack(root.left, level + 1);
        backTrack(root.right, level + 1);
    }
}
