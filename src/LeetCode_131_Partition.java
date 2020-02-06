import java.util.ArrayList;
import java.util.List;

/**
 * @author wb
 * @date 2020/2/6 - 20:02
 * LeetCode---131. 分割字符串
 */
public class LeetCode_131_Partition {

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if(s == null || s.length() == 0) {
            return res;
        }
        backTrack(res, new ArrayList<>(), s, 0);
        return res;
    }

    public void backTrack(List<List<String>> res, List<String> tmp, String s, int start) {
        // 递归出口
        if (start == s.length()) {
            res.add(new ArrayList<>(tmp));
        }
        for (int i = start; i < s.length(); i++) {
            if (isPalindrome(s.substring(start, i + 1))) {
                // 是回文串
                tmp.add(s.substring(start, i + 1));
                backTrack(res, tmp, s, i + 1);
                tmp.remove(tmp.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String s) {
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
