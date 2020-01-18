/**
 * @author wb
 * @date 2020/1/13 - 19:27
 * 几种排序算法
 */
public class Sorting {

    public static void main(String[] args) {
        int[] arr = new int[] {
                5, 7, 2, 4, 5, 3, 9, 6, 1, 8, 0, 4
        };
        heapSort(arr);
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
    private static void shellSort(int[] nums) {
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

    /**
     * 归并排序：
     *  归并排序（MERGE-SORT）是建立在归并操作上的一种有效的排序算法,
     *  该算法是采用分治法（Divide and Conquer）的一个非常典型的应用。
     *  将已有序的子序列合并，得到完全有序的序列；
     *  即先使每个子序列有序，再使子序列段间有序。
     *  若将两个有序表合并成一个有序表，称为二路归并/
     *
     *  归并排序的步骤：
     *      第一步：申请空间，使其大小为两个已经排序序列的长度之和，该空间用来存放合并后的序列
     *      第二步：设定两个指针，最初位置分别为两个已经排序序列的起始位置
     *      第三步：比较两个指针所指向的元素，选择相对小的元素放入合并空间，并移动指针到下一个位置
     *      重复步骤三直到某一指针超出序列尾
     *      将另一序列剩下的所有元素直接复制到合并序列尾
     * */
    private static void mergeSort(int[] nums, int left, int right) {
        // 如果只有一个元素，就不要排序了
        if (left == right) {
            return;
        }else {
            // 取中间的数进行拆分
            int mid = (left + right) / 2;

            // 左边的数不断进行拆分
            mergeSort(nums, left, mid);

            // 右边的数不断进行拆分
            mergeSort(nums, mid + 1, right);

            //合并
            merge(nums, left, mid + 1, right);
        }
    }

    private static void merge(int[] nums, int left, int mid, int right) {
        // 左边数组的大小
        int[] leftArr = new int[mid - left];

        // 右边数组的大小
        int[] rightArr = new int[right - mid + 1];

        // 往这两个数组中填充数据
        for (int i = left; i < mid; i++) {
            leftArr[i - left] = nums[i];
        }
        for (int i = mid; i <= right; i++) {
            rightArr[i - mid] = nums[i];
        }

        // 两个指向 leftArr 和 rightArr 初始位置的指针
        int i = 0, j = 0;
        // 指向 nums 数组的第一个元素
        int k = left;

        // 比较两个数组的元素值，哪个小，就把哪个往 nums 数组上放
        while (i < leftArr.length && j < rightArr.length) {
            // 谁比较小，谁将元素放入大数组中，并移动指针，继续比较下一个；等于的情况是保持稳定
            if (leftArr[i] <= rightArr[j]) {
                nums[k] = leftArr[i];
                i++;
                k++;
            }else {
                nums[k] = rightArr[j];
                j++;
                k++;
            }
        }

        //如果左边的数组还没比较完，右边的数都已经完了，那么将左边的数抄到大数组中(剩下的都是大数字)
        while (i < leftArr.length) {
            nums[k] = leftArr[i];
            i++;
            k++;
        }
        //如果右边的数组还没比较完，左边的数都已经完了，那么将右边的数抄到大数组中(剩下的都是大数字)
        while (j < rightArr.length) {
            nums[k] = rightArr[j];
            k++;
            j++;
        }
    }

    /**
     * 快速排序：
     *  快速排序由C. A. R. Hoare在1962年提出。它的基本思想是：通过一趟排序将要排序的数据分割成独立的两部分，
     *  其中一部分的所有数据都比另外一部分的所有数据都要小，
     *  然后再按此方法对这两部分数据分别进行快速排序，
     *  整个排序过程可以递归进行，以此达到整个数据变成有序序列。
     * */
    private static void quickSort(int[] nums, int left, int right) {
        int i = left;
        int j = right;

        // 快速排序中的支点，即该支点左边的元素都比右边的元素要小
        int pivot = nums[(left + right) / 2];

        // 左右两端开始扫描
        while (i <= j) {

            // 寻找直到比支点大的数
            while (pivot > nums[i]) {
                i++;
            }

            // 寻找直到比支点小的数
            while (pivot < nums[j]) {
                j--;
            }

            // 此时已经分别找到了比支点小的数（右边），以及比支点大的数（左边），将它们进行交换
            if (i <= j) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                i++;
                j--;
            }
        }

        // 上面的 while 循环保证了第一趟排序支点的左边比支点小，支点的右边比支点大了

        // "左边"继续排序，直到左边只剩下一个数（递归出口）
        if (left < j) {
            quickSort(nums, left, j);
        }
        // "右边"继续排序，直到右边只剩下一个数（递归出口）
        if (i < right) {
            quickSort(nums, i, right);
        }
    }

    /**
     * 三向切分快速排序：
     *  三向切分快速排序是快速排序的一种优化算法之一。
     *  对于有大量重复元素的数组，可以将数组切分为三部分，分别对应小于、等于和大于切分元素
     *  三向切分快速排序对于有大量重复元素的随机数组可以再线性时间内完成排序
     * */
    private static void ThreeWayQuickSort(int[] nums, int left, int right) {
        if (right <= left) {
            return;
        }
        int i = left, j = right;
        int k = left + 1;
        int pivot =  nums[left];
        while (k <= j) {
            if (nums[k] < pivot) {
                int tmp = nums[i];
                nums[i] = nums[k];
                nums[k] = tmp;
                i++;
                k++;
            }else if (nums[k] > pivot) {
                int tmp = nums[k];
                nums[k] = nums[j];
                nums[j] = tmp;
                j--;
            }else {
                k++;
            }
        }
        ThreeWayQuickSort(nums, left, i - 1);
        ThreeWayQuickSort(nums, j + 1, right);
    }

    /**
     * 堆排序:
     *  把最大元素和当前堆中数组的最后一个元素交换位置，并且不删除它，
     *  那么就可以得到一个从尾到头的递减序列，从正向来看就是一个递增序列，这就是堆排序。
     *
     *  第一步：构建堆
     *      无序数组建立堆最直接的方法是从左到右遍历数组进行上浮操作。
     *      一个更高效的方法是从右至左进行下沉操作，如果一个节点的两个节点都已经是堆有序，
     *      那么进行下沉操作可以使得这个节点为根节点的堆有序。
     *      叶子节点不需要进行下沉操作，可以忽略叶子节点的元素，因此只需要遍历一半的元素即可。
     *  第二步：交换堆顶元素与最后一个元素，交换之后需要进行下沉操作维持堆的有序状态。
     * */

    public static void heapSort(int []nums){
        int last = nums.length - 1;
        //N构建大根堆
        //从倒数第二层开始
        for (int i = nums.length /2 - 1 ; i >= 0; i--){
            heapIfy(nums, i, last);
        }
        while (last >= 1){
            swap(nums,0,last--);
            heapIfy(nums,0, last);
        }
    }

    //i 大根堆调整
    public static void heapIfy(int[] nums,int i,int last){
        //判断有没有子节点（左孩子）
        int left = i * 2 + 1;
        while (left <= last){
            int right = left + 1;
            //左右节点最大值
            int larger = right <= last && nums[right] > nums[left] ? right : left;
            if(nums[larger] > nums[i]){
                swap(nums, larger, i);
                i = larger;
                left = larger * 2 + 1;
            } else {
                break;
            }
        }
    }

    public static void  swap(int []nums,int a,int b){
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
