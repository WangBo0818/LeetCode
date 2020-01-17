/**
 * @author wb
 * @date 2020/1/17 - 9:10
 * LeetCode---55. 跳跃游戏
 */
public class LeetCode_55_CanJump {

    /**
     * 解法一：
     *  解题思路：
     *      1. 如果某一个作为起跳点的格子可以跳跃的距离为 3，那么表示其后面 3 个格子均可作为起跳点
     *      2. 可以对每一个能作为起跳点的格子都尝试跳一次，把能跳到最远的位置不断更新
     *      3. 如果可以跳到最后一个格子，则返回 true
     * */
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int maxJump = 0;
        for (int i = 0; i < nums.length; i++) {
            // 无法跳到下一个起跳点
            if (maxJump < i) {
                return false;
            }
            // 可以跳到最后一个格子，直接返回 true
            if (maxJump >= nums.length) {
                return true;
            }
            maxJump = Math.max(maxJump, i + nums[i]);
        }
        return true;
    }

    /**
     * 使用贪心的思想
     * */
    public boolean canJump2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        // 最后一个格子当然可以跳到自己
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }

}
