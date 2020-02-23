/**
 * @author wb
 * @date 2020/2/22 - 11:19
 * 剑指 Offer---52. 翻转单词顺序列
 */
public class SwordMeansOffer_52_ReverseSentence {

    public String ReverseSentence(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        int n = str.length();
        char[] arr = str.toCharArray();
        int i = 0, j = 0;
        while (j <= n) {
            if (j == n || arr[j] == ' ') {
                reverse(arr, i, j - 1);
                i = j + 1;
            }
            j++;
        }
        reverse(arr, 0, n - 1);
        return new String(arr);
    }

    public void reverse(char[] arr, int i, int j) {
        while (i < j) {
            char tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
            i++;
            j--;
        }
    }
}
