/**
 * @author wb
 * @date 2019/12/27 - 10:34
 * LeetCode---11. 盛最多水的容器
 */
public class maxArea {
    /**
     * 解法一：暴力破解法（不推荐，时间复杂度太差）
     * */
    public int maxArea(int[] height) {
        int max = 0;
        for(int i = 0; i < height.length - 1; i++) {
            for(int j = i + 1; j < height.length; j++) {
                // 和木桶短板理论有些类似，能装多少水取决于短木板
                int area = (j - i) * Math.min(height[i], height[j]);
                max = Math.max(max, area);
            }
        }
        return max;
    }

    /**
     * 解法二：双指针（具体思路请参照LeetCode官方题解，官方题解有张图，一看就知道了）
     * */
    public int maxArea2(int[] height) {
        int max = 0;
        int left = 0, right = height.length - 1;
        while(left < right) {
            int area = (right - left) * Math.min(height[left], height[right]);
            max = Math.max(max, area);
            if(height[left] < height[right]) {
                left++;
            }else {
                right--;
            }
        }
        return max;
    }
}
