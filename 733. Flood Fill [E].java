733. Flood Fill [E]
https://leetcode.com/problems/flood-fill/

/*Solution 1.
Using DFS (Recursive approach).
*/

class Solution {
    int startingPixelColor;
    int newClr;

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image == null || image.length == 0) {
            return image;
        }
        startingPixelColor = image[sr][sc];
        if (startingPixelColor != newColor) {
            newClr = newColor;
            fill(image, sr, sc);
        }
        return image;
    }

    private void fill(int[][] image, int r, int c) {
        if (r < 0 || r >= image.length || c < 0 || c >= image[r].length || image[r][c] != startingPixelColor) {
            return;
        }
        image[r][c] = newClr;
        fill(image, r - 1, c); //Up.
        fill(image, r + 1, c); //Down.
        fill(image, r, c - 1); //Left.
        fill(image, r, c + 1); //Right.
    }
}

--
Time Complexity: O(N), where N is the number of pixels in the image. We might process every pixel.
Space Complexity: O(N), the size of the implicit call stack when calling fill().
--
Asked by: Amazon.
--
