/**
 * @author wb
 * @date 2020/1/2 - 10:31
 * LeetCode---28. 实现strStr()
 */
public class LeetCode_28_StrStr {

    /**
     * 解法一：使用 Java 提供的 indexOf() 函数
     * */
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    /**
     * 解法二：暴力匹配
     * */
    public int strStr1(String haystack, String needle) {
        if(needle == null || needle.length() == 0) {
            return 0;
        }
        char c1 = needle.charAt(0);
        for(int i = 0; i <= haystack.length() - needle.length(); i++) {
            char c2 = haystack.charAt(i);
            if(c1 == c2 && haystack.substring(i, i + needle.length()).equals(needle)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 解法三：KMP 算法
     * */
    public int strStr3(String haystack, String needle) {
        if(needle == null || needle.length() == 0) {
            return 0;
        }
        int[] next = new int[needle.length()];
        // 得到 next 数组
        getNextArr(next, needle);
        // 使用双指针进行匹配
        int i = 0, j = 0;
        while(i < haystack.length() && j < needle.length()) {
            if(j == -1 || haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            }else {
                j = next[j];
            }
        }
        return j == needle.length() ? i - j : -1;
    }

    private void getNextArr(int[] next, String needle) {
        int k = -1;
        int j = 0;
        next[0] = -1;
        while(j < needle.length() - 1) {
            if(k == -1 || needle.charAt(j) == needle.charAt(k)) {
                k++;
                j++;
                next[j] = k;
            }else {
                k = next[k];
            }
        }
    }
}
