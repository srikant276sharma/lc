79. Word Search [M]
https://leetcode.com/problems/word-search/

/* Solution 1: Using Depth First Search.
Kevin: https://www.youtube.com/watch?v=vYYNp0Jrdv0

Time complexity: O(n), where n is number of cells in the grid.
Space complexity: O(n), where n is number of cells in the grid.

Asked by: Amazon, Google, Facebook, Microsoft, Snapchat, Uber, Bloomberg, Apple, Zillow, Oracle, Quantcast, and Cruise Automation.
*/

class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0) {
            return false;
        }
        int rows = board.length, cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == word.charAt(0) && dfs(board, word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int index, int i, int j) {
        if (word.length() == index) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index)) {
            return false;
        }

        char temp = board[i][j];
        board[i][j] = ' ';
        boolean found = dfs(board, word, index + 1, i - 1, j)
                || dfs(board, word, index + 1, i + 1, j)
                || dfs(board, word, index + 1, i, j - 1)
                || dfs(board, word, index + 1, i, j + 1);

        board[i][j] = temp;
        return found;
    }
}
