import java.util.Arrays;
import java.util.Comparator;

/**
 * @author wb
 * @date 2020/2/13 - 22:34
 * LeetCode---179. 最大数
 */
public class LeetCode_179_LargestNumber {

    public String largestNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1 = o1 + o2;
                String s2 = o2 + o1;
                return s1.compareTo(s2);
            }
        });
        if ("0".equals(strs[strs.length - 1])) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = strs.length - 1; i >= 0 ; i--) {
            sb.append(strs[i]);
        }
        return sb.toString();
    }
}
