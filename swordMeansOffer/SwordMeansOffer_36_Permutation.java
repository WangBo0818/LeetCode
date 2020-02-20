import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author wb
 * @date 2020/2/19 - 22:53
 * 剑指 Offer---36. 字符串的排列
 */
public class SwordMeansOffer_36_Permutation {

    public ArrayList<String> Permutation(String str) {
        if (str == null || str.length() == 0) {
            return new ArrayList<>();
        }
        char[] arr = str.toCharArray();
        int[] visited = new int[arr.length];
        Arrays.sort(arr);
        ArrayList<String> res = new ArrayList<>();
        backTrack(res, arr,visited, new StringBuilder());
        return res;
    }

    private void backTrack(ArrayList<String> res, char[] arr, int[] visited, StringBuilder sb) {
        // 递归出口
        if (sb.length() == arr.length) {
            res.add(sb.toString());
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (visited[i] == 1) {
                continue;
            }
            if (i != 0 && arr[i] == arr[i - 1] && visited[i - 1] == 0) {
                continue;
            }
            visited[i] = 1;
            sb.append(arr[i]);
            backTrack(res, arr, visited, sb);
            visited[i] = 0;
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
