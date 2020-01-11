import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wb
 * @date 2020/1/3 - 16:28
 * LeetCode---30. 串联所有单词的子串
 */
public class LeetCode_30_FindSubstring {

    /**
     * 使用双指针 + 窗口滑动(待办)
     * */
    public List<Integer> findSubstring(String s, String[] words) {
        if (s == null || s.length() == 0 || words == null || words.length == 0 ) {
            return new ArrayList<>();
        }
        int left = 0, right = 0;
        int len = words[0].length();
        List<Integer> res = new ArrayList<>();
        // 存目标单词
        Map<String, Integer> needs = new HashMap<>();
        // 存窗口
        Map<String, Integer> windows = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            if (!needs.containsKey(words[i])) {
                needs.put(words[i], 1);
            } else {
                needs.put(words[i], needs.get(words[i]) + 1);
            }
        }

        // 单词的匹配数量（包括单词和出现次数）
        int match = 0;

        // 由于字符串的长度不一定是单词长度的整数倍，所以需要遍历一个单词长度的所有情况
        for (int i = 0; i < len; i++) {
            // 初始化左右指针，match 初始值为 0
            left = right = i;
            match = 0;

            while (right <= s.length() - len) {
                // 向右滑动
                String s1 = s.substring(right, right + len);
                // 以单词长度为步长移动右指针
                right += len;
                if(!windows.containsKey(s1)) {
                    windows.put(s1, 1);
                }else {
                    windows.put(s1, windows.get(s1) + 1);
                }

                // 如果单词出现的次数与目标一致，则匹配 match 加一
                if (needs.containsKey(s1) && windows.get(s1).intValue() == needs.get(s1).intValue()) {
                    match++;
                }

                while (left < right && match == needs.size()) {

                    // right - left / len求出窗口中单词数，如果等于目标单词数，则匹配成功，将左指针位置加入list
                    if ((right - left) / len == words.length) {
                        res.add(left);
                    }

                    // 左指针右移，类似右指针方法
                    String s2 = s.substring(left, left + len);
                    left += len;
                    windows.put(s2, windows.get(s2) - 1);

                    if (needs.containsKey(s2) && windows.get(s2).intValue() < needs.get(s2).intValue()){
                        match --;
                    }
                }
            }
            // 清空窗口，进行下一次遍历
            windows.clear();
        }
        return res;
    }
}
