528. Random Pick with Weight [M]
https://leetcode.com/problems/random-pick-with-weight/

/* Solution 1: Using Math.random() and Binary Search.
Math.random() return a double value and value range is "0.0 <= value < 1.0"

Knowledge Center: https://www.youtube.com/watch?v=v-_aEMtgnkI

Let N be the length of the input list.
TC: For the constructor function, the time complexity would be O(N), which is due to the construction of the concatenated weights.
    For the pickIndex() function, this time its time complexity would be O(log⁡N), since we did a binary search on the concatenated weights.

SC: For the constructor function, the space complexity remains O(N), which is again due to the construction of the concatenated weights.
    For the pickIndex() function, its space complexity would be O(1), since it uses constant memory.

Asked by:
*/

class Solution {
    int[] concWeight; //concatenated weight.
    int sum;

    public Solution(int[] w) {
        concWeight = new int[w.length];
        sum = 0;

        for (int i = 0; i < w.length; i++) {
            sum += w[i];
            concWeight[i] = sum;
        }
    }

    public int pickIndex() {
        int randomVal = (int) (Math.random() * sum); //Most important logic. Never forget ().
        return binarySearch(randomVal + 1);
    }

    private int binarySearch(int randomVal) {
        // run a binary search to find the target zone.
        int left = 0, right = concWeight.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (concWeight[mid] == randomVal) {
                return mid;
            } else if (concWeight[mid] < randomVal) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
