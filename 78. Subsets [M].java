78. Subsets [M]
https://leetcode.com/problems/subsets/

/* Solution 1: Using Backtracking.
GoodTecher: https://www.youtube.com/watch?v=VdnvmfzA1pw&t=10s

Time complexity: O(N × 2^N) to generate all subsets and then copy them into output list.
Space complexity: O(N × 2^N) to keep all the subsets of length N, since each of N elements could be present or absent.

Asked by: Amazon, Facebook, Google, Apple, Uber, Microsoft, Bloomberg, Adobe, Yahoo, Goldman Sachs, and Walmart Labs.
*/

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }

        List<Integer> subset = new ArrayList<>();
        generateAllSubsets(nums, 0, subset, res);
        return res;
    }

    private void generateAllSubsets(int[] nums, int index, List<Integer> subset, List<List<Integer>> res) {
        res.add(new ArrayList<>(subset)); //Note: Create a new list.

        for (int i = index; i < nums.length; i++) {
            subset.add(nums[i]); //Add the current element.
            generateAllSubsets(nums, i + 1, subset, res); //Recurse for the next element processing.
            subset.remove(subset.size() - 1); //After processing remove the last element.
        }
    }
}
