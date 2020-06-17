130. Surrounded Regions [M]
https://leetcode.com/problems/surrounded-regions/

/* Solution 1: Using DFS.
KC: https://www.youtube.com/watch?v=FoVhnqN0B28

TC: O(N), where N is the total number of cells.
SC: O(N), because of recursive call stack.

Asked by:
*/

class Solution {
    public void solve(char[][] board) {
        int rows = board.length;
        if (rows <= 2) {
            return;
        }
        int cols = board[0].length;
        if (cols <= 2) {
            return;
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O' && (i == 0 || i == rows - 1 || j == 0 || j == cols - 1)) {
                    dfs(board, i, j); //mark all those O's which are connected to boundary O's
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'P') {
                    board[i][j] = 'O'; //revert back marked cells (P) to O's
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X'; //mark the surrounded O's to X
                }
            }
        }
    }

    //mark all those O's which are connected to boundary O's
    private void dfs(char[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'O') {
            return;
        }
        board[i][j] = 'P';
        dfs(board, i + 1, j);
        dfs(board, i - 1, j);
        dfs(board, i, j + 1);
        dfs(board, i, j - 1);
    }
}
