977. Squares of a Sorted Array
https://leetcode.com/problems/squares-of-a-sorted-array/

Company: Facebook.

--Solution 1:
/*
1. Based on left and right pointers, determine which one has max absolute value.
2. Start from the end of Sorted array and put Square of max absolute value.
3. Adjust left++ and right-- pointers.

Input: [-4,-1,0,3,10]
Output: [0,1,9,16,100]
*/

class Solution {
    public int[] sortedSquares(int[] A) {
        int[] sorted = new int[A.length];
        int left = 0;
        int right = A.length - 1;

        for (int i = A.length - 1; i >= 0; i--) {
            if (Math.abs(A[left]) > A[right]) {
                sorted[i] = A[left] * A[left];
                left++;
            } else {
                sorted[i] = A[right] * A[right];
                right--;
            }
        }
        return sorted;
    }
}
--
Time Complexity: O(n) where n is the number of elements in the array.
Space Complexity: O(n).
--
Runtime: 1 ms, faster than 100.00% of Java online submissions for Squares of a Sorted Array.
Memory Usage: 42.5 MB, less than 41.46% of Java online submissions for Squares of a Sorted Array.
--
