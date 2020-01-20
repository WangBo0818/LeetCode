import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author wb
 * @date 2020/1/20 - 20:06
 * LeetCode---57. 插入区间
 */
public class LeetCode_57_Insert {

    /**
     * 这种解法让我羞愧：将两个数组合并后，沿用上一题（LeetCode 56）的解法
     * */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] arr = new int[intervals.length + newInterval.length][2];
        for (int i = 0; i < intervals.length; i++) {
            for (int j = 0; j < intervals[0].length; j++) {
                arr[i][j] = intervals[i][j];
            }
        }
        for (int i = intervals.length; i < arr.length; i++) {
            for (int j = 0; j < newInterval.length; j++) {
                arr[i][j] = newInterval[j];
            }
        }
        List<int[]> res = new ArrayList<>();
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int i = 0;
        while (i < arr.length) {
            int start = arr[i][0];
            int end = arr[i][1];
            while (i < arr.length - 1 && end >= arr[i + 1][0]) {
                end = Math.max(end, arr[i + 1][1]);
                i++;
            }
            res.add(new int[] {start, end});
            i++;
        }
        return res.toArray(new int[0][]);
    }
}
