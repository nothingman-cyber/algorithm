package algorithm.graphicscomputing;

import java.util.*;

public class DetermineSudokuValid {

    public static void main(String[] args) {
        int a = '.' - '0';
        int b = 1;
    }


    public boolean isValidSudoku(char[][] board) {
        int[][] rows = new int[9][9];
        int[][] columns = new int[9][9];
        int[][][] boxes = new int[3][3][9];

        for (int i = 0;i < 9;i++) {
            for (int j = 0;j < 9;j++) {
                char c = board[i][j];
                if (c != '.') {
                    int num = c - '0' - 1; // 直接作为下标使用
                    rows[i][num] ++;
                    columns[j][num] ++;
                    boxes[i/3][j/3][num] ++;
                    if (rows[i][num] > 1 || columns[j][num] > 1 || boxes[i/3][j/3][num] > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean isValidSudoku_stupid(char[][] board) {
        int[][] idxSquare = {{0,0}, {0,1}, {0,2}, {1,0}, {1,1}, {1,2}, {2,0}, {2,1}, {2,2}};
        int[][] startIdx = {{0,0}, {0,3}, {0,6}, {3,0}, {3,3}, {3,6}, {6,0}, {6,3}, {6,6}};

        int row = board[0].length;
        int column = board.length;

        boolean res = true;
        List<Integer> nums = new ArrayList<>(9);

        for (int i = 0; i < 9;i++) {
            if (!res) {
                return res;
            }
            char[] a = board[i];
            for (int ai = 0;ai < a.length;ai++) {
                nums.add(a[ai] - '0');
            }
            res = res & check9num(nums);
            nums.clear();
        }

        for (int i = 0; i < 9;i++) {
            if (!res) {
                return res;
            }
            for (int j = 0;j < 9;j++) {
                nums.add(board[j][i] - '0');
            }
            res = res & check9num(nums);
            nums.clear();
        }

        for (int i = 0; i < 9;i++) {
            if (!res) {
                return res;
            }
            int[] start_idx = startIdx[i];
            for (int j = 0;j < 9;j++) {
                nums.add(board[start_idx[0] + idxSquare[j][0]][start_idx[1] + idxSquare[j][1]] - '0');
            }
            res = res & check9num(nums);
            nums.clear();
        }


        return res;
    }


    private boolean check9num (List<Integer> nums) {
        Set<Integer> set = new HashSet<>(9);
        for (int i = 0;i < set.size();i++) {
            if (nums.get(i) == -2) {
                continue;
            }
            if (set.contains(nums.get(i))) {
                return false;
            } else {
                set.add(nums.get(i));
            }
        }
        return true;
    }
}
