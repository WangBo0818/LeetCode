import java.util.ArrayList;

/**
 * @author wb
 * @date 2020/2/19 - 20:59
 * 剑指 Offer---33. 二叉树中和为某一个值的路径
 */
public class SwordMeansOffer_33_FindPath {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null) {
            return new ArrayList<>();
        }
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> tmp = new ArrayList<>();
        backTrack(res, tmp, root, target);
        return res;
    }

    private void backTrack(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> tmp, TreeNode root, int target) {
        if (root == null)
            return;
        tmp.add(root.val);
        if (target == 0 && root.left == null && root.right == null) {
            res.add(new ArrayList<>(tmp));
        } else {
            backTrack(res, tmp, root.left, target - root.val);
            backTrack(res, tmp, root.right, target - root.val);
        }
        tmp.remove(tmp.size() - 1);
    }
}
