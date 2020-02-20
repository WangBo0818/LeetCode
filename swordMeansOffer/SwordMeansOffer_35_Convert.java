import java.util.ArrayList;
import java.util.List;

/**
 * @author wb
 * @date 2020/2/19 - 22:20
 * 剑指 Offer---35. 二叉搜索树与双向链表
 */
public class SwordMeansOffer_35_Convert {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    List<TreeNode> list = new ArrayList<>();

    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        if (pRootOfTree.left == null && pRootOfTree.right == null) {
            return pRootOfTree;
        }
        inOrder(pRootOfTree);
        list.get(0).left = null;
        list.get(0).right = list.get(1);
        for (int i = 1; i < list.size() - 1; i++) {
            list.get(i).left = list.get(i - 1);
            list.get(i).right = list.get(i + 1);
        }
        list.get(list.size() - 1).left = list.get(list.size() - 2);
        list.get(list.size() - 1).right = null;
        return list.get(0);
    }

    private void inOrder(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return;
        }
        inOrder(pRootOfTree.left);
        list.add(pRootOfTree);
        inOrder(pRootOfTree.right);
    }
}
