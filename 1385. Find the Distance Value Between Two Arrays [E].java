1385. Find the Distance Value Between Two Arrays [E]
https://leetcode.com/problems/find-the-distance-value-between-two-arrays/

/*Solution 1.
*/

class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int distance = arr1.length;

        for (int v1 : arr1) {
            for (int v2 : arr2) {
                if (Math.abs(v1 - v2) <= d) {
                    distance--;
                    break;
                }
            }
        }

        return distance;
    }
}

--
Time Complexity: O(N * M), where N is number of elements in arr1 and M is number of elements in arr2.
Space Complexity: O(1).
--
Asked by:
--
