import java.util.HashMap;
import java.util.Map;

/**
 * @author wb
 * @date 2020/2/12 - 20:35
 * LeetCode---105. 从前序与中序遍历序列构造二叉树
 */
public class LeetCode_105_BuildTree {

    public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
   }

   Map<Integer, Integer> map = new HashMap<>();
    // 先序遍历的第一个结点元素
    int pre_index = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) {
            return null;
        }
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(preorder, inorder, 0, inorder.length);
    }

    private TreeNode helper(int[] preorder, int[] inorder, int in_left, int in_right) {
        // 递归出口：没有其他 TreeNode 参与构建二叉树
        if (in_left == in_right) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[pre_index]);
        // 根据 root 结点将 inorder 分为左子树和右字数两部分
        int index = map.get(preorder[pre_index]);
        pre_index++;
        root.left = helper(preorder, inorder, in_left, index);
        root.right = helper(preorder, inorder, index + 1, in_right);
        return root;
    }
}
