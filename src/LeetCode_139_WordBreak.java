import java.util.*;

/**
 * @author wb
 * @date 2020/2/9 - 12:47
 * Leetcode---139. 单词拆分
 */
public class LeetCode_139_WordBreak {

    /**
     * 解题思路：
     *  宽度优先搜索，LeetCode 官方题解上的图一看就会知道
     * */
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>(wordDict);
        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[s.length()];
        queue.add(0);
        while (!queue.isEmpty()) {
            int start = queue.remove();
            if (visited[start] == 0) {
                for (int end = start + 1; end <= s.length(); end++) {
                    if (wordDictSet.contains(s.substring(start, end))) {
                        queue.add(end);
                        if (end == s.length()) {
                            return true;
                        }
                    }
                }
                visited[start] = 1;
            }
        }
        return false;
    }
}
