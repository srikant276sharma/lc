896. Monotonic Array [E]
https://leetcode.com/problems/monotonic-array/
Kevin: https://www.youtube.com/watch?v=wqgvE8X-2jk

/*Solution 2: 
  Using 1 loops.
*/

class Solution {
    public boolean isMonotonic(int[] A) {
        boolean isIncreasing = true;
        boolean isDecreasing = true;

        for (int i = 0; i < A.length - 1; i++) {
            /*Monotonic increasing check. */
            if (A[i] > A[i + 1]) {
                isIncreasing = false;
            }

            /*Monotonic decreasing check. */
            if (A[i] < A[i + 1]) {
                isDecreasing = false;
            }
        }

        return isIncreasing || isDecreasing;
    }
}

/*Solution 2: 
  Using 2 loops.
*/

class Solution {
    public boolean isMonotonic(int[] A) {
        boolean isMonotonic = true;

        /*Monotonic increasing check. */
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] > A[i + 1]) {
                isMonotonic = false;
                break;
            }
        }

        /*Monotonic decreasing check. */
        if (!isMonotonic) {
            isMonotonic = true;
            for (int i = 0; i < A.length - 1; i++) {
                if (A[i] < A[i + 1]) {
                    isMonotonic = false;
                    break;
                }
            }
        }

        return isMonotonic;
    }
}

--
Time complexity:  O(n), where n is number of elements in the array.
Space complexity: O(1).
--
Asked by: Facebook.
--
