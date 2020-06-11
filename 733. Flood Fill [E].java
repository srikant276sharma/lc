733. Flood Fill [E]
https://leetcode.com/problems/flood-fill/

/* Solution 1: Using DFS (Recursive approach).

TC: O(N), where N is the number of pixels in the image. We might process every pixel.
SC: O(N), the size of the implicit call stack when calling dfs().

Asked by: Amazon
*/

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int startingColor = image[sr][sc];
        if (startingColor != newColor) {
            dfs(image, sr, sc, newColor, startingColor);
        }
        return image;
    }

    private void dfs(int[][] image, int r, int c, int newColor, int startingColor) {
        if (r < 0 || r >= image.length || c < 0 || c >= image[0].length || image[r][c] != startingColor) {
            return;
        }
        image[r][c] = newColor;
        dfs(image, r + 1, c, newColor, startingColor);
        dfs(image, r - 1, c, newColor, startingColor);
        dfs(image, r, c + 1, newColor, startingColor);
        dfs(image, r, c - 1, newColor, startingColor);
    }
}
