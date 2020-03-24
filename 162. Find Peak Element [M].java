162. Find Peak Element [M]
https://leetcode.com/problems/find-peak-element/

/*Solution 1.
Using Binary Search.
Kevin: https://www.youtube.com/watch?v=CFgUQUL7j_c
Errichto: https://www.youtube.com/watch?v=L7gNay1c4ak
IDeserve: https://www.youtube.com/watch?v=a7D77DdhlFc

Solution:
1: Initialize left = 0, right = array.length - 1.
2: Repeat following steps till peak element is found:
   (a) Find mid = (left + right + 1)/2.
   (b) If array[mid-1] is greater than array[mid], find peak in left half of array, set right = mid - 1.
   (c) Else find peak in right half of array, set left = mid.
   (d) when left = right, that's the Peak so return any one of them.

*/

class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        int mid;

        while (left < right) {
            /*Since I want to compare mid to the previous element, so I rounded it up.
             * Consider a scenario, left = 5 and right = 6, then mid = 6.
             * Otherwise it will go in an infinite loop or outside of the array. */
            mid = (left + right + 1) / 2;
            if (nums[mid - 1] > nums[mid]) {
                right = mid - 1; /*there is a Peak in left half. */
            } else {
                left = mid; /*there is a Peak in right half. */
            }
        }
        /*At this point, left = right and that's the Peak because it's greater than left and right elements. */
        return left;
    }
}

/*Solution 2.
 Using Binary Search.
*/

class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int mid;

        while (left < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1; /*there is a Peak in right half. */
            } else {
                right = mid; /*there is a Peak in left half. */
            }
        }
        /*At this point, left = right and that's the Peak because it's greater than left and right elements. */
        return left;
    }
}

--
Time Complexity: O(log n), where n is number of elements in the array.
Space Complexity: O(1).
--
Asked by: Google, Facebook, Bloomberg.
--
