import java.util.HashMap;

/**
 * @author wb
 * @date 2020/1/12 - 9:47
 * LeetCode---36. 有效的数独
 */
public class LeetCode_36_IsValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer, Integer>[] rows = new HashMap[9];
        HashMap<Integer, Integer>[] cols = new HashMap[9];
        HashMap<Integer, Integer>[] blocks = new HashMap[9];

        for(int i = 0; i < 9; i++) {
            rows[i] = new HashMap<Integer, Integer>();
            cols[i] = new HashMap<Integer, Integer>();
            blocks[i] = new HashMap<Integer, Integer>();
        }

        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                char c = board[i][j];
                if(c != '.') {
                    int num = c - '0';
                    int block_index = (i / 3) * 3 + j / 3;

                    rows[i].put(num, rows[i].getOrDefault(num, 0) + 1);
                    cols[j].put(num, cols[j].getOrDefault(num, 0) + 1);
                    blocks[block_index].put(num, blocks[block_index].getOrDefault(num, 0) + 1);

                    if(rows[i].get(num) > 1 || cols[j].get(num) > 1 || blocks[block_index].get(num) > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
