1344. Angle Between Hands of a Clock [M]
https://leetcode.com/problems/angle-between-hands-of-a-clock/

/*Solution 1: Using Math.

TC: O(1).
SC: O(1).
*/

class Solution {
    public double angleClock(int hour, int minutes) {
        int oneHrAngle = 360 / 12, oneMinAngle = 360 / 60;

        double hrAngle = ((hour % 12) + (double) minutes / 60) * oneHrAngle;
        int minAngle = minutes * oneMinAngle;

        double angle = Math.abs(hrAngle - minAngle);
        if (angle > 180) {
            angle = 360 - angle;
        }

        return angle;
    }
}
