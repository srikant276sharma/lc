79. Word Search [M]
https://leetcode.com/problems/word-search/

/* Solution 1: Using Depth First Search.
Kevin: https://www.youtube.com/watch?v=vYYNp0Jrdv0

TC: O(N*4^L) where N is the number of cells in the board and L is the length of the word to be matched.
    For the backtracking function, its execution trace would be visualized as a 4-ary tree, 
    each of the branches represent a potential exploration in the corresponding direction. 
    Therefore, in the worst case, the total number of invocation would be the number of nodes in a full 4-nary tree, 
    which is about 4^L.

    We iterate through the board for backtracking, i.e.
    there could be N times invocation for the backtracking function in the worst case.

    As a result, overall the time complexity of the algorithm would be O(N * 4^L).

SC: O(L) where L is the length of the word to be matched.
    The main consumption of the memory lies in the recursion call of the backtracking function. 
    The maximum length of the call stack would be the length of the word. 
    Therefore, the space complexity of the algorithm is O(L).

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

        char temp = board[i][j]; //Keep a backup of this cell value.
        board[i][j] = ' '; //Execution will not use this cell twice.
        boolean found = dfs(board, word, index + 1, i - 1, j)
                || dfs(board, word, index + 1, i + 1, j)
                || dfs(board, word, index + 1, i, j - 1)
                || dfs(board, word, index + 1, i, j + 1);

        board[i][j] = temp; //Restore the cell value.
        return found;
    }
}
