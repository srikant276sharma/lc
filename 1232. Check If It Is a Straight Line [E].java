1232. Check If It Is a Straight Line [E]
https://leetcode.com/problems/check-if-it-is-a-straight-line/

/* Solution 1: slope = (y2 - y1) / (x2 - x1).
In a straight line, slope of any 2 points will be always same.

Knowledge Center: https://www.youtube.com/watch?v=PsZ_MmFBzJA

Time complexity: O(n), where n is number of coordinates in the array.
Space complexity: O(1).

Asked by:
*/

class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        float slope = getSlope(coordinates[0], coordinates[1]);

        for (int i = 2; i < coordinates.length; i++) {
            if (slope != getSlope(coordinates[0], coordinates[i])) {
                return false;
            }
        }
        return true;
    }

    private float getSlope(int[] p1, int[] p2) {
        //If x2 and x1 are same then it's a vertical line, and in case of vertical line slope will be INF.
        if (p1[0] == p2[0]) {
            return 20001; //-10000 - (-10000) = 0 || 10000 - 10000 = 0, so use anything to represent INF.
        } else {
            return (float) (p2[1] - p1[1]) / (p2[0] - p1[0]); //slope = (y2 - y1) / (x2 - x1).
        }
    }
}
