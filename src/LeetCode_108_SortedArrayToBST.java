/**
 * @author wb
 * @date 2020/2/12 - 18:27
 * LeetCode---108. 将有序数组转换为二叉搜索树
 */
public class LeetCode_108_SortedArrayToBST {

    public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
   }

    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    private TreeNode helper(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int index = (left + right) / 2;
        TreeNode root = new TreeNode(nums[index]);
        root.left = helper(nums, left, index - 1);
        root.right = helper(nums, index + 1, right);
        return root;
    }
}
