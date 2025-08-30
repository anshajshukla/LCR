import java.util.*;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> solutions = new ArrayList<>();
        int[][] board = new int[n][n];  // 0 = empty, 1 = queen
        backtrack(board, 0, n, solutions);
        return solutions;
    }

    private void backtrack(int[][] board, int row, int n, List<List<String>> solutions) {
        if (row == n) {
            solutions.add(construct(board, n));
            return;
        }

        // try every column in this row
        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col, n)) {
                board[row][col] = 1; // place queen
                backtrack(board, row + 1, n, solutions);
                board[row][col] = 0; // backtrack
            }
        }
    }

    private boolean isSafe(int[][] board, int row, int col, int n) {
        // check column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 1) return false;
        }

        // check upper left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) return false;
        }

        // check upper right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 1) return false;
        }

        return true;
    }

    private List<String> construct(int[][] board, int n) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb.append(board[i][j] == 1 ? 'Q' : '.');
            }
            res.add(sb.toString());
        }
        return res;
    }
}
