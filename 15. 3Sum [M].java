15. 3Sum [M]
https://leetcode.com/problems/3sum/

/* Solution 1: Using 2 Pointers approach.

TC: O(n^2), where n is the length of input array.
SC: O(n).
*/

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>(); //SC: O(n/3) ~ O(n).
        if (nums == null || nums.length == 0) {
            return result;
        }
        int len = nums.length;
        Arrays.sort(nums); //TC: O(n log n)
        //TC: O(n^2)
        for (int i = 0; i < len; i++) {
            int left = i + 1, right = len - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    //If next value is same then skip it.
                    int leftVal = nums[left];
                    while (left < right && leftVal == nums[left]) {
                        left++;
                    }

                    //If next value is same then skip it.
                    int rightVal = nums[right];
                    while (right > left && rightVal == nums[right]) {
                        right--;
                    }
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }

            //If next value is same then skip it.
            while (i + 1 < len && nums[i] == nums[i + 1]) {
                i++;
            }
        }

        return result;
    }
}
