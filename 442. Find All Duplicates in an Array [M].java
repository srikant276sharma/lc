442. Find All Duplicates in an Array [M]
https://leetcode.com/problems/find-all-duplicates-in-an-array/

/* Solution 1:
KC: https://www.youtube.com/watch?v=8ci8WfQ6cns

TC: O(N) where N is the length of array.
SC: O(1), without any extra space.
*/

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();

        for (int n : nums) {
            n = Math.abs(n);
            if (nums[n - 1] > 0) {
                nums[n - 1] *= -1;
            } else {
                res.add(n);
            }
        }
        return res;
    }
}
