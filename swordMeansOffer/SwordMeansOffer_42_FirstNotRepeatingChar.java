import java.util.HashMap;
import java.util.Map;

/**
 * @author wb
 * @date 2020/2/20 - 22:49
 * 剑指 Offer---42. 第一次只出现一次的字符
 */
public class SwordMeansOffer_42_FirstNotRepeatingChar {

    public int FirstNotRepeatingChar(String str) {
        if (str == null || str.length() == 0) {
            return -1;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }
        }
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (map.get(c) == 1) {
                return i;
            }
        }
        return -1;
    }
}
