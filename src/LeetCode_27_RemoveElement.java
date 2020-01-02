/**
 * @author wb
 * @date 2020/1/2 - 9:45
 * LeetCode---27. 移除元素
 */
public class LeetCode_27_RemoveElement {

    public int removeElement(int[] nums, int val) {
        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != val) {
                nums[count] = nums[i];
                count++;
            }
        }
        return count;
    }
}
