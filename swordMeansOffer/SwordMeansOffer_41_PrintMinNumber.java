import java.util.Arrays;
import java.util.Comparator;

/**
 * @author wb
 * @date 2020/2/20 - 19:50
 * 剑指 Offer---41. 将数组排成最小的数
 */
public class SwordMeansOffer_41_PrintMinNumber {

    public String PrintMinNumber(int [] numbers) {
        if (numbers == null || numbers.length == 0) {
            return "";
        }
        String[] strs = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            strs[i] = numbers[i] + "";
        }
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1 + o2).compareTo(o2 + o1);
            }
        });
        String res = "";
        for (String str: strs) {
            res += str;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
    }
}
