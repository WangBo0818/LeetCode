/**
 * @author wb
 * @date 2020/2/22 - 14:48
 * 剑指 Offer---56. 构建乘积数组
 */
public class SwordMeansOffer_56_Multiply {

    public int[] multiply(int[] A) {
        if (A == null || A.length == 0) {
            return new int[0];
        }
        int[] B = new int[A.length];
        int tmp = 1;
        // 左边元素的乘积
        for (int i = 0; i < A.length; i++) {
            B[i] = tmp;
            tmp *= A[i];
        }
        tmp = 1;
        // 右边元素的乘积
        for (int i = A.length - 1; i >= 0; i--) {
            B[i] *= tmp;
            tmp *= A[i];
        }
        return B;
    }
}
