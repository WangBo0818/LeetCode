import java.util.*;

/**
 * @author wb
 * @date 2019/12/29 - 11:12
 * LeetCode---18. 四数之和
 */
public class LeetCode_18_FourSum {

    public static void main(String[] args) {
        List<List<Integer>> res = fourSum2(new int[] {
                1, 0, -1, 0, -2, 2
        }, 0);
        for(int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }

    /**
     * 这题不推荐使用回溯来解决，使用回溯会比较麻烦。至于什么麻烦，你用回溯试着写写就知道了。。。
     * 下面这种解法有问题，至于是什么问题，你把代码运行一下就知道了。。。
     * */
    public static List<List<Integer>> fourSum2(int[] nums, int target) {
        Arrays.sort(nums);
        if(nums == null || nums.length == 0 || nums[0] > target || nums.length < 4) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int[] visited = new int[nums.length];
        backTrack(res, list, nums, visited, target);
        List<List<Integer>> realRes = new ArrayList<>();
        for(int i = 0; i < res.size(); i++) {
            if(res.get(i).size() == 4) {
                realRes.add(res.get(i));
            }
        }
        return realRes;
    }

    private static void backTrack(List<List<Integer>> res, List<Integer> list, int[] nums, int[] visited, int target) {
        // 递归出口
        if(target == 0) {
            if(!res.contains(list)) {
                res.add(new ArrayList<>(list));
            }
        }
        if(target < 0) {
            return ;
        }
        for(int i = 0; i < nums.length; i++) {
            if(visited[i] == 1) {
                // 已经访问过
                continue;
            }
            visited[i] = 1;
            list.add(nums[i]);
            backTrack(res, list, nums, visited, target-nums[i]);
            visited[i] = 0;
            list.remove(list.size() - 1);
        }
    }

    /**
     * 使用双循环固定两个数，用双指针找另外两个数，通过与 target 的大小比较来移动指针
     * */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>(8);
        int len = nums.length;
        if (len < 4) {
            return result;
        }
        Arrays.sort(nums);

        int minValue = nums[0] + nums[1] + nums[2] + nums[3];
        int maxValue = nums[len - 1] + nums[len - 2] + nums[len - 3] + nums[len - 4];
        if (maxValue < target || minValue > target) {
            return result;
        }
        int left = 2;
        int right = len - 1;
        //第一个固定值的值
        int oneValue = 0;
        //第2个固定值的值
        int twoValue = 0;
        int fourNumSum = 0;
        for (int one = 0; one <= len - 4; one++) {
            oneValue = nums[one];
            if (one > 0 && nums[one] == nums[one - 1]) {
                continue;
            }
            for (int two = one + 1; two <= len - 3; two++) {
                if (two > one+1 && nums[two] == nums[two - 1]) {
                    continue;
                }
                twoValue = nums[two];
                left = two + 1;
                right = len - 1;
                minValue = oneValue + twoValue + nums[two + 1] + nums[two + 2];
                maxValue = oneValue + twoValue + nums[len - 2] + nums[len - 1];
                if (maxValue < target || minValue > target) {
                    left = right;
                }
                while (left < right) {
                    fourNumSum = nums[left] + nums[right] + oneValue + twoValue;
                    if (fourNumSum > target) {
                        right--;
                        while (right > left && nums[right] == nums[right + 1]) {
                            right--;
                        }
                    } else if (fourNumSum < target) {
                        left++;
                        while (right > left && nums[left] == nums[left - 1]) {
                            left++;
                        }
                    } else {
                        List<Integer> resultOne = new ArrayList<>(4);
                        resultOne.add(oneValue);
                        resultOne.add(twoValue);
                        resultOne.add(nums[left]);
                        resultOne.add(nums[right]);
                        result.add(resultOne);

                        left++;
                        right--;
                        while (right > left && nums[right] == nums[right + 1]) {
                            right--;
                        }
                        while (right > left && nums[left] == nums[left - 1]) {
                            left++;
                        }
                    }
                }

            }
        }
        return result;
    }
}
