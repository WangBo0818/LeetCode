import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author wb
 * @date 2020/2/23 - 9:40
 * 剑指 Offer---58. 字符流中第一个不重复的字符
 */
public class SwordMeansOffer_58_FirstAppearingOnce {

    Map<Character, Integer> map = new LinkedHashMap<>();

    //Insert one char from stringstream
    public void Insert(char ch) {
        if (!map.containsKey(ch)) {
            map.put(ch, 1);
        } else {
            map.put(ch, map.get(ch) + 1);
        }
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        Iterator iter = map.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            Character key = (Character)entry.getKey();
            if (map.get(key) == 1) {
                return key;
            }
        }
        return '#';
    }
}
