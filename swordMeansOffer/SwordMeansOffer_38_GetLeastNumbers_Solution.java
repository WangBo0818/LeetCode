import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author wb
 * @date 2020/2/20 - 0:43
 * 剑指 Offer---38. 最小的 K 个数
 */
public class SwordMeansOffer_38_GetLeastNumbers_Solution {

    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        if (input == null || input.length == 0 || k == 0 || k > input.length) {
            return new ArrayList<>();
        }
        Arrays.sort(input);
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            res.add(input[i]);
        }
        return res;
    }
}
