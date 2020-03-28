1. Two Sum [E]
https://leetcode.com/problems/two-sum/

/*
Solution: 1
*/
class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }
}
--
Complexity Analysis:
Time complexity: O(n^2). For each element, we try to find its complement by looping through the rest of array which takes O(n) time. 
                         Therefore, the time complexity is O(n^2).
Space complexity : O(1).

/*
Solution: 2
*/
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> indexMap = new HashMap<>();
        int complement = 0;
        for (int i = 0; i < nums.length; i++) {
            complement = target - nums[i];

            if (indexMap.containsKey(complement)) {
                return new int[]{indexMap.get(complement), i};
            } else {
                indexMap.put(nums[i], i);
            }
        }
        return new int[0];
    }
}
--
Complexity Analysis:
Time complexity: O(n). We traverse the list containing n elements only once. Each look up in the table costs only O(1) time.
Space complexity: O(n). The extra space required depends on the number of items stored in the hash table, which stores at most n elements.
--
