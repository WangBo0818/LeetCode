/**
 * @author wb
 * @date 2020/1/17 - 9:46
 * LeetCode---45. 跳跃游戏II
 */
public class LeetCode_45_Jump {

    /**
     * 和 LeetCode55. 跳跃游戏 解法相似，具体细微不同将两题代码对着看一遍就知道了
     * */
    public int jump(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        int end = 0;
        // 当前格子能跳到最远的格子
        int maxPos = 0;
        int steps = 0;
        for (int i = 0; i < nums.length; i++) {
            maxPos = Math.max(maxPos, i + nums[i]);
            // 需要进行下一次跳跃
            if (i == end && i != nums.length - 1) {
                end = maxPos;
                steps++;
            }
        }
        return steps;
    }
}
