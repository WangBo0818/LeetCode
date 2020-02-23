import java.util.HashMap;
import java.util.Map;

/**
 * @author wb
 * @date 2020/2/22 - 8:48
 * 剑指 Offer---48. 数组中只出现一次的数字
 */
public class SwordMeansOffer_48_FindNumsAppearOnce {

    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (!map.containsKey(array[i])) {
                map.put(array[i], 1);
            } else {
                map.put(array[i], map.get(array[i]) + 1);
            }
        }
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (map.get(array[i]) == 1) {
                if (count == 0) {
                    num1[0] = array[i];
                    count++;
                } else {
                    num2[0] = array[i];
                }
            }
        }
    }
}
