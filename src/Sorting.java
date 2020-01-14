/**
 * @author wb
 * @date 2020/1/13 - 19:27
 * 几种排序算法
 */
public class Sorting {

    public static void main(String[] args) {
        int[] arr = new int[] {
                5, 7, 2, 4, 5, 3, 9, 6, 1, 8, 0
        };
        sort4(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    /**
     * 选择排序：
     *  从数组中选择最小元素，将它与数组的第一个元素交换位置。
     *  再从数组剩下的元素中选择出最小的元素，将它与数组的第二个元素交换位置。
     *  不断进行这样的操作，直到将整个数组排序。
     *  选择排序需要 ~N2/2 次比较和 ~N 次交换，它的运行时间与输入无关，
     *  这个特点使得它对一个已经排序的数组也需要这么多的比较和交换操作。
     *  而选择排序又是不稳定的算法，因此不推荐使用选择排序
     * */
    private static void sort1(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n - 1; i++) {
            // 找到最小元素的下标
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (nums[j] < nums[min]) {
                    min = j;
                }
            }
            // 将最小元素与第一个元素交换位置
            int tmp = nums[i];
            nums[i] = nums[min];
            nums[min] = tmp;
        }
    }

    /**
     * 冒泡排序：
     *  从左到右不断交换相邻逆序的元素，在一轮的循环之后，可以让未排序的最大元素上浮到右侧。
     * */
    private static void sort2(int[] nums) {
        int n = nums.length;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (nums[i] < nums[j]) {
                   int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                }
            }
        }
    }

    /**
     * 每次都将当前元素插入到左侧已经排序的数组中，使得插入之后左侧数组依然有序。
     * */
    private static void sort3(int[] nums) {
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0; j--) {
                if (nums[j] < nums[j - 1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = tmp;
                }
            }
        }
    }

    /**
     * 希尔排序：
     *  希尔排序(Shell's Sort)是插入排序的一种又称“缩小增量排序”
     *  关于希尔排序的基本思想请参考其他资料，
     *  如：严蔚敏老师的《数据结构》（我们学校讲数据结构和基本算法就是用的这本书）
     * */
    private static void sort4(int[] nums) {
        int n = nums.length;
        // 初始化步长，并且最后一步的步长也必须是 1
        int h = 1;

        // 确定最大步长
        while (h < n / 3) {
            h = 3 * h + 1;
        }

        while (h >= 1) {
            for (int i = h; i < n; i++) {
                for (int j = i; j >= h; j -= h) {
                    if (nums[j] < nums[j - h]) {
                        int tmp = nums[j];
                        nums[j] = nums[j - h];
                        nums[j - h] = tmp;
                    }
                }
            }
            h = h / 3;
        }
    }

}
