/**
 * @author wb
 * @date 2020/2/19 - 20:32
 * 剑指 Offer---32. 二叉搜索树的后序遍历序列
 */
public class SwordMeansOffer_32_VerifySquenceOfBST {

    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        return VerifySquenceOfBST(sequence, 0, sequence.length - 1);
    }

    private boolean VerifySquenceOfBST(int[] sequence, int start, int end) {
        if (start >= end) {
            return true;
        }
        // 找到二叉搜索树根结点
        int root = sequence[end];
        // 找到划分左右子树的结点 split
        int split = start;
        while (split < end && sequence[split] < root) {
            split++;
        }
        // 二叉搜索树中右子树的每一个值都大于左子树中的所有值
        for (int i = split; i < end; i++) {
            if (sequence[i] < root) {
                return false;
            }
        }
        return VerifySquenceOfBST(sequence, start, split - 1) && VerifySquenceOfBST(sequence, split, end - 1);
    }
}
