33. Search in Rotated Sorted Array [M]
https://leetcode.com/problems/search-in-rotated-sorted-array/

/* Solution 1:
Using Binary Search.
Vivekanand: https://www.youtube.com/watch?v=5BI0Rdm9Yhk
*/

class Solution {
    public int search(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return -1;
        }

        /*Find pivotIndex using Binary Search.*/
        int pivotIndex = findPivotIndex(nums, 0, nums.length - 1);
        int low, high;

        /*Decide search space depending on target and pivotIndex. */
        if (target >= nums[pivotIndex] && target <= nums[nums.length - 1]) {
            low = pivotIndex;
            high = nums.length - 1;
        } else {
            low = 0;
            high = pivotIndex - 1;
        }

        /*Find the target using Binary Search. */
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target < nums[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    private int findPivotIndex(int[] nums, int low, int high) {
        int pivotIndex = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if ((mid + 1 >= 0 && mid + 1 < nums.length) && nums[mid] > nums[mid + 1]) {
                pivotIndex = mid + 1; //pivotIndex.
                break;
            } else {
                if (nums[low] > nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }

        return pivotIndex;
    }
}

--
Complexities: Considering n is number of elements in the array.
Time: O(log n).
Space: O(1).
--
Asked by: Google, Amazon, Facebook, Microsoft.
--
