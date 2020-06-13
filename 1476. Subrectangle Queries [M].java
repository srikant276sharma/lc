1476. Subrectangle Queries [M]
https://leetcode.com/problems/subrectangle-queries/

/* Solution 1:

TC: O(N * M), where N = no. of rows and M = no. of cols.
SC: O(N * M).

Asked by: Nuro.
*/

class SubrectangleQueries {
    int[][] grid;

    //SC: O(N * M) 
    public SubrectangleQueries(int[][] rectangle) {
        grid = rectangle;
    }

    //TC: O(N * M), where N = no. of rows and M = no. of cols.
    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        for (int i = row1; i <= row2; i++) {
            for (int j = col1; j <= col2; j++) {
                grid[i][j] = newValue;
            }
        }
    }

    //TC: O(1).
    public int getValue(int row, int col) {
        return grid[row][col];
    }
}

/**
 * Your SubrectangleQueries object will be instantiated and called as such:
 * SubrectangleQueries obj = new SubrectangleQueries(rectangle);
 * obj.updateSubrectangle(row1,col1,row2,col2,newValue);
 * int param_2 = obj.getValue(row,col);
 */
