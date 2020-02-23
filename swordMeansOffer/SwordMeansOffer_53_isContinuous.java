import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wb
 * @date 2020/2/22 - 13:26
 * 剑指 Offer---53. 扑克牌顺子
 */
public class SwordMeansOffer_53_isContinuous {

    /**
     * 解题思路：
     *  把大小王当癞子使用，若牌组成顺子所需的癞子数大于 numbers 大小王的数量，
     *  则返回 false
     * */
    public boolean isContinuous(int [] numbers) {
        if (numbers.length < 5) {
            return false;
        }
        Arrays.sort(numbers);
        // count 用来记录大小王的数量
        int count = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0) {
                count++;
            } else {
                break;
            }
        }
        for (int i = count; i < numbers.length - 1; i++) {
            if (numbers[i + 1] == numbers[i]) {
                return false;
            }
            count -= numbers[i + 1] - numbers[i] - 1;
        }
        return count >= 0;
    }
}
