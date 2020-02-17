/**
 * @author wb
 * @date 2020/2/15 - 23:22
 * 剑指 Offer---19. 正则表达式匹配
 */
public class SwordMeansOffer_19_Match {

    public boolean match(char[] text, char[] pattern) {
        boolean[][] dp = new boolean[text.length + 1][pattern.length + 1];
        dp[text.length][pattern.length] = true;
        for (int i = text.length; i >= 0; i--) {
            for (int j = pattern.length - 1; j >= 0; j--) {
                boolean first_match = false;
                if (i < text.length && (text[i] == pattern[j] || '.' == pattern[j])) {
                    first_match = true;
                }
                if (j < pattern.length - 1 && '*' == pattern[j + 1]) {
                    dp[i][j] = dp[i][j + 2] || first_match && dp[i + 1][j];
                } else {
                    dp[i][j] = first_match && dp[i + 1][j + 1];
                }
            }
        }
        return dp[0][0];
    }
}
