import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author wb
 * @date 2019/12/25 - 10:32
 * LeetCode---3. 无重复字符的最长子串
 */
public class lengthOfLongestSubstring {
    /**
     * 解法一：暴力破解法（通不过LeetCode上该题的最后一个测试点）
     *         将字符串的所有不含重复元素的子串都找出来，然后比较这些子串的长度，返回长度最长的子串
     * 这种解法的时间复杂度太差，不推荐
     * */
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        int len = s.length();
        for(int i = 0; i < len; i++) {
            for(int j = i + 1; j <= len; j++) {
                if(isLegal(s, i, j)) {
                    ans = Math.max(ans, j - i);
                }
            }
        }
        return ans;
    }

    public boolean isLegal(String s, int start, int end) {
        Set<Character> set = new HashSet<>();
        for(int i = start; i < end; i++) {
            char tmp = s.charAt(i);
            if(set.contains(tmp)) {
                return false;
            }
            set.add(tmp);
        }
        return true;
    }

    /**
     * 解法二：Sliding Window（滑动窗口）
     *  在暴力法中，我们会反复检查一个字符串中是否有相同的字符，但是这样是没有必要的。
     *  如果从索引i到j - 1的字符串已经检查为没有重复字符，那么只需检查字符s.charAt(j)是否已经存在与字符串[i,j]即可
     *
     *  通过使用HashSet 作为滑动窗口，可以用O(1)的时间来完成判断当前字符是否已经存在于当前字符串中
     *
     *  滑动窗口是数组/字符串中常见的抽象概念。窗口通常是在数组/字符串中由开始和结束索引定义的一系列元素的集合，即[i,j)（左闭右开）。
     *  而滑动窗口是可以将两个边界向某一方向“滑动”的窗口。例如，我们将[i,j) 向右滑动一个元素，则它将变为S[i+1,j+1)（左闭右开）
     *
     *  在本题中，我们使用HashSet 将字符存储在当前窗口[i,j) 中。然后向右侧滑动索引j，如果索引j对应的字符不在HashSet 中，则继续向右
     *  滑动索引j。直到s.charAt(j) 已经存在与HashSet 中。此时，我们找到的没有重复字符的最长子字符串将以索引i对应的字符开头。如果对
     *  所有的i进行这样的窗口滑动，就可以找出答案。
     * */
    public int lengthOfLongestSubstring2(String s) {
        int len = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while(i < len && j < len) {
            if(!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                j++;
                ans = Math.max(ans, j - i);
            }else {
                set.remove(s.charAt(i));
                i++;
            }
        }
        return ans;
    }

    /**
     * 解法三：优化Sliding Window（滑动窗口）
     *  在解法二中最多可能会执行2n 个步骤，但是，它可以继续被优化成执行n 个步骤
     *
     *  我们可以定义字符到索引的映射，而不是使用一个Set 集合来判断一个字符是否已经存在与当前字符串。
     *  当我们找到重复的字符时，就可以跳过该窗口。也就是说，如果s.charAt(j) 在S[i,j)范围内有与字符k 重复的字符，
     *  我们就不需要增加i。可以直接跳过[i,k]范围内的所有元素，并将i 变为 k + 1
     * */
    public int lengthOfLongestSubstring3(String s) {
        int len = s.length();
        int ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        int i = 0;
        for(int j = 0; j < len; j++) {
            if(map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }
}
