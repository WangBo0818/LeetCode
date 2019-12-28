/**
 * @author wb
 * @date 2019/12/27 - 9:46
 * LeetCode---10.正则表达式匹配
 */
public class LeetCode_10_IsMatch {

    /**
     * 使用如下回溯算法的时间复杂度远远不如使用动态规划求解
     * 但是，目前以我对动态规划的理解和运用还做不出这道题，还要继续加油
     * */
    public boolean isMatch(String s, String p) {
        if(p.isEmpty()) {
            return s.isEmpty();
        }
        // 判断第一个字符是否匹配
        boolean first_match = false;
        if(!s.isEmpty() && (s.charAt(0) == p.charAt(0) || '.' == p.charAt(0))) {
            first_match = true;
        }
        if(p.length() >= 2 && p.charAt(1) == '*') {
            return isMatch(s, p.substring(2)) || (first_match && isMatch(s.substring(1), p));
        }else {
            return first_match && isMatch(s.substring(1), p.substring(1));
        }
    }
}
