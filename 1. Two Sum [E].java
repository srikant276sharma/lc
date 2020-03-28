1. Two Sum [E]
https://leetcode.com/problems/two-sum/
Kevin: https://www.youtube.com/watch?v=Aql6zHkONek

/*Solution 1.
 Using HashMap.
*/

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> indexMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (indexMap.containsKey(complement)) {
                result[0] = indexMap.get(complement);
                result[1] = i;
                return result;
            } else {
                indexMap.put(nums[i], i);
            }
        }
        return result;
    }
}

--
Time complexity: O(n). We traverse the list containing n elements only once. Each look up in the table costs only O(1) time.
Space complexity: O(n). The extra space required depends on the number of items stored in the hash table, which stores at most n elements.
--
Asked by: Facebook, Google, Amazon, Airbnb, Microsoft, Uber, LinkedIn, Apple, Bloomberg, Microsoft, Alibaba, Adobe, and more.
--
