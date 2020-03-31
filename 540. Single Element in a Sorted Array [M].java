540. Single Element in a Sorted Array [M]
https://leetcode.com/problems/single-element-in-a-sorted-array/

/*Solution 1: 
  Using Binary Search.
*/

class Solution {
    public int singleNonDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            /*if mid value is not equal to left and right values then it means that's the single element. */
            if (mid - 1 >= left && mid + 1 <= right && nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) {
                return nums[mid];
                /*if mid is EVEN and if nums[mid] == nums[mid + 1] then it means the single element does not exist in left half. */
            } else if (mid % 2 == 0 && nums[mid] == nums[mid + 1]) {
                left = mid + 1;
                /*if mid is ODD and if nums[mid] == nums[mid - 1] then it means the single element does not exist in left half. */
            } else if (mid % 2 == 1 && nums[mid] == nums[mid - 1]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return nums[left];
    }
}

--
Time complexity:  O(log n), where n is number of elements in the array.
Space complexity: O(1).
--
Asked by:
--
