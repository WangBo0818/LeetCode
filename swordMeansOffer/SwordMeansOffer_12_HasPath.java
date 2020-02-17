/**
 * @author wb
 * @date 2020/2/16 - 16:38
 * 剑指 Offer---12. 矩阵中的路径
 */
public class SwordMeansOffer_12_HasPath {

    private int rows;
    private int cols;

    public boolean hasPath(char[] array, int rows, int cols, char[] str) {
        if (rows == 0 || cols == 0) {
            return false;
        }
        this.rows = rows;
        this.cols = cols;
        // 构建二维数组
        char[][] matrix = buildMatrix(array);
        // 判断是否已经访问过
        int[][] visited = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (backTrack(matrix, visited, str, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean backTrack(char[][] matrix, int[][] visited, char[] str, int pathLen, int row, int col) {
        // 递归出口
        if (pathLen == str.length) {
            return true;
        }
        if (row < 0 || row >= rows || col <0 || col >= cols || matrix[row][col] != str[pathLen] || visited[row][col] == 1) {
            return false;
        }
        visited[row][col] = 1;
        if (backTrack(matrix, visited, str, pathLen + 1, row + 1, col) || backTrack(matrix, visited, str, pathLen + 1, row,col + 1)
                || backTrack(matrix, visited, str, pathLen + 1, row - 1, col) || backTrack(matrix, visited, str, pathLen + 1, row,col - 1))
        {
            return true;
        }
        visited[row][col] = 0;
        return false;
    }

    public char[][] buildMatrix(char[] array) {
        char[][] matrix = new char[rows][cols];
        int index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = array[index];
                index++;
            }
        }
        return matrix;
    }
}
