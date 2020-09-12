167. Two Sum II - Input array is sorted [E]
https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/

/* Solution 1: Using 2 pointers.

TC: O(N), where N is length of input array.
SC: O(1).
*/

class Solution {
  public int[] twoSum(int[] numbers, int target) {
    int low = 0, high = numbers.length - 1;
    
    while (low < high) {
      int sum = numbers[low] + numbers[high];
        
      if (sum == target) {
        return new int[]{low + 1, high + 1};
      } else if (sum < target) {
        low++;
      } else {
        high--;
      }
    }
    
    return new int[2];
  }
}
