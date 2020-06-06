268. Missing Number [E]
https://leetcode.com/problems/missing-number/

/* Solution 1: Using Gauss' Formula: ∑i=0 n ​i = n(n+1)/2​.
Algorithm:
We can compute the sum of nums in linear time, 
and by Gauss' formula, we can compute the sum of the first n natural numbers in constant time. 
Therefore, the number that is missing is simply the result of Gauss' formula minus the sum of nums, as nums consists of the first n natural numbers minus some number.

TC: O(n). Although Gauss' formula can be computed in O(1) time, summing nums costs us O(n) time, so the algorithm is overall linear.
SC: O(1). This approach only pushes a few integers around, so it has constant memory usage.

Asked by: Amazon, Google
*/

class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int expectedSum = n * (n + 1) / 2;
        int inputSum = 0;

        for (int num : nums) {
            inputSum += num;
        }

        return expectedSum - inputSum;
    }
}


/** Solution 2: Using Bit Manipulation.
Because we know that nums contains n numbers and that it is missing exactly one number on the range [0..n−1], 
we know that n definitely replaces the missing number in nums. 
Therefore, if we initialize an integer to n and XOR it with every index and value, we will be left with the missing number.

TC: O(n). Assuming that XOR is a constant-time operation, this algorithm does constant work on n iterations, so the runtime is overall linear.
SC: O(1). This algorithm allocates only constant additional space.
*/

class Solution {
    public int missingNumber(int[] nums) {
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missing ^= i ^ nums[i];
        }
        return missing;
    }
}
