33. Search in Rotated Sorted Array [M]
https://leetcode.com/problems/search-in-rotated-sorted-array/

/* Solution 1:
Using Binary Search.
Aditya: 
Vivekanand: https://www.youtube.com/watch?v=5BI0Rdm9Yhk
*/

class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        
        int pivot = findPivot(nums);
        
        int res = binaryS(nums, 0, pivot - 1, target);
        if (res == -1) {
            res = binaryS(nums, pivot, n - 1, target);
        }
        return res;
    }
    
    //find pivot index.
    private int findPivot(int[] nums) {
        int n = nums.length;
        int low = 0, high = n - 1;
        
        while (low <= high) {
            if (nums[low] <= nums[high]) {
                return low;
            }
            int mid = low + (high - low) / 2;
            int prev = (mid - 1 + n) % n;
            
            if (nums[mid] <= nums[prev]) {
                return mid;
            } else if (nums[low] <= nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
    //binary search.
    private int binaryS (int[] nums, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (nums[mid] == target) {
                return mid;
            } else if (target > nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }            
        }
        return -1;
    }
}

--
Complexities: Considering n is number of elements in the array.
Time: O(log n).
Space: O(1).
--
Asked by: Google, Amazon, Facebook, Microsoft.
--
