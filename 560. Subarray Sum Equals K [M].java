560. Subarray Sum Equals K [M]
https://leetcode.com/problems/subarray-sum-equals-k/

/* Solution 1: Using HashMap.
Knowledge Center: https://www.youtube.com/watch?v=YkacnIOt2jM&t=21s
*/

class Solution {
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        //To hold 'CurrentSum - K' : Count
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0, currentSum = 0; //currentSum is the total sum till current index.

        for (int n : nums) {
            currentSum += n;
            if (currentSum == k)
                count++;

            //After removing 'currentSum - k' prefix subarrays, k subarrays can be formed.
            if (map.containsKey(currentSum - k))
                count += map.get(currentSum - k);

            //Store currentSum and it's count.
            map.put(currentSum, map.getOrDefault(currentSum, 0) + 1);
        }

        return count;
    }
}

--
Complexities:
Time: O(n), The entire nums array is traversed only once.
Space: O(n), Hashmap map can contain upto n distinct entries in the worst case.
--
Asked by:
--
