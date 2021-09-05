329. Longest Increasing Path in a Matrix [H]
https://leetcode.com/problems/longest-increasing-path-in-a-matrix/

//TC: O(mn).
//SC: O(mn).

class Solution {
    int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int m, n;

    public int longestIncreasingPath(int[][] matrix) {
        //input validation.
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        m = matrix.length; 
        n = matrix[0].length;
        int longestPath = 0;
        int[][] mem = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int path = dfs(matrix, i, j, mem);
                longestPath = Math.max(longestPath, path);
            }
        }
        return longestPath;
    }

    private int dfs(int[][] matrix, int i, int j, int[][] mem) {
        if (mem[i][j] > 0) {
            return mem[i][j];
        }
        int max = 0;
    
        for (int[] d : dir) {
            int x = i + d[0], y = j + d[1]; //new coordinates.
            //condition check.
            if (x >= 0 && x < m && y >= 0 && y < n && matrix[x][y] > matrix[i][j]) {
                max = Math.max(max, dfs(matrix, x, y, mem)); //try new cells.
            }
        }
        mem[i][j] = max + 1;
        return max + 1; //adding 1 for current cell.
    }
}
