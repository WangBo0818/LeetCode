/**
 * @author wb
 * @date 2019/12/28 - 9:40
 * LeetCode---14. 最长公共前缀
 */
public class LeetCode_14_LongestCommonPrefix {
    /**
     * 水平扫描法
     * */
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) {
            return "";
        }
        int index = 0;
        for(int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for(int j = 0; j < strs.length; j++) {
                if(i == strs[0].length() - 1 || c != strs[j].charAt(index)) {
                    return strs[0].substring(0, index);
                }
            }
            index++;
        }
        return strs[0].substring(0, index);
    }

    /**
     * 分治法
     *  在本题的LeetCode提交中，这种解法的时间复杂度和空间复杂度都不如前一种解法，
     *  但是以后再遇到这种题多一种思路也没什么不好
     * */
    public String longestCommonPrefix2(String[] strs) {
        if(strs == null || strs.length == 0) {
            return "";
        }
        return longestCommonPrefix(strs, 0, strs.length - 1);
    }

    private String longestCommonPrefix(String[] strs, int left, int right) {
        if(left == right) {
            return strs[left];
        }else {
            int mid = (left + right) / 2;
            String leftPrefix = longestCommonPrefix(strs, left, mid);
            String rightPrefix = longestCommonPrefix(strs, mid + 1, right);
            return commonPrefix(leftPrefix, rightPrefix);
        }
    }

    private String commonPrefix(String leftPrefix, String rightPrefix) {
        int minLen = Math.min(leftPrefix.length(), rightPrefix.length());
        for(int i = 0; i < minLen; i++) {
            if(leftPrefix.charAt(i) != rightPrefix.charAt(i)) {
                return leftPrefix.substring(0, i);
            }
        }
        return leftPrefix.substring(0, minLen);
    }
}
