import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wb
 * @date 2019/12/29 - 10:24
 * LeetCode---17. 电话号码的字母组合
 */
public class LeetCode_17_LetterCombinations {

    /**
     * 使用深度优先搜索枚举所有的组合即可
     * */
    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();
        backTrack(res, "", digits);
        return res;
    }

    private void backTrack(List<String> res, String condition, String digits) {
        Map<String, String> map = new HashMap<>();
        map.put("2", "abc");
        map.put("3", "def");
        map.put("4", "ghi");
        map.put("5", "jkl");
        map.put("6", "mno");
        map.put("7", "pqrs");
        map.put("8", "tuv");
        map.put("9", "wxyz");
        // 递归出口
        if(digits.length() == 0) {
            res.add(condition);
        }else {
            String digit = digits.substring(0, 1);
            String letters = map.get(digit);
            for(int i = 0; i < letters.length(); i++) {
                String letter = letters.substring(i, i+1);
                backTrack(res, condition+letter, digits.substring(1));
            }
        }
    }
}
