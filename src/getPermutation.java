import java.util.ArrayList;
import java.util.List;

/**
 * @author wb
 * @date 2019/12/20 - 16:21
 * LeetCode---60：第k个排列
 */
public class getPermutation {

    public static void main(String[] args) {
        System.out.println(getPermutation(8, 13801));
    }

    public static String getPermutation(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> num_list = new ArrayList<>();
        int[] visited = new int[n];
        int[] nums = new int[n];
        for(int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        backTrack(list, num_list, nums, visited, k);
        List<Integer> res = list.get(k - 1);
        String result = "";
        for(int i = 0; i < res.size(); i++) {
            result += res.get(i);
        }
        return result;
    }

    public static void backTrack(List<List<Integer>> list, List<Integer> tmp, int[] nums, int[] visited, int k) {
        // 递归出口
        if(tmp.size() == nums.length) {
            list.add(new ArrayList<>(tmp));
            if(list.size() == k) {
                return;
            }
        }

        for(int i = 0; i < nums.length; i++) {
            if(visited[i] == 1) {
                continue;
            }
            visited[i] = 1;
            tmp.add(nums[i]);
            backTrack(list, tmp, nums, visited, k);
            visited[i] = 0;
            tmp.remove(tmp.size() - 1);
        }
    }
}
