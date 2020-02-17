/**
 * @author wb
 * @date 2019/12/21 - 14:29
 * 剑指offer---4.二维数组中的查找
 */
public class SwordMeansOffer_4_Find {
    /**
     * 解法一：暴力破解
     * */
    public static boolean Find(int target, int [][] array) {
        if(array == null || array.length == 0 || array[0].length == 0) {
            return false;
        }
        int rowCount = array.length;
        int colCount = array[0].length;
        for(int i = 0; i < rowCount; i++) {
            for(int j = 0; j < colCount; j++) {
                if(target == array[i][j]) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 解法二：
     *  由题意可知，小于target的值只可能存在在它的左边，大于target的值只可能存在在它的下边
     * */
    public static boolean Find2(int target, int [][] array) {
        if(array == null || array.length == 0 || array[0].length == 0) {
            return false;
        }
        int rowCount = array.length;
        int colCount = array[0].length;
        // 从右上角开始遍历
        int row = 0;
        int col = colCount - 1;
        while(row < rowCount - 1 && col >= 0) {
            if(target == array[row][col]) {
                return true;
            }else if(target < array[row][col]) {
                col--;
            }else {
                row++;
            }
        }
        return false;
    }
}
