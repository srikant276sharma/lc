137. Single Number II [M]
https://leetcode.com/problems/single-number-ii/

/* Solution 1: Using HashMap.

TC: O(n), where n is the number of elements in the input array.
SC: O(n).
*/

class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> numCount = new HashMap<>();

        for (int i : nums) {
            numCount.put(i, numCount.getOrDefault(i, 0) + 1);
        }

        for (int key : numCount.keySet()) {
            if (numCount.get(key) == 1) {
                return key;
            }
        }
        return -1;
    }
}

/* Solution 1: Using Bit manipulation, XOR, AND and NOT.

TC: O(n), where n is the number of elements in the input array.
SC: O(1).
*/

class Solution {
  public int singleNumber(int[] nums) {
    int seenOnce = 0, seenTwice = 0;

    for (int num : nums) {
      // first appearence: 
      // add num to seen_once 
      // don't add to seen_twice because of presence in seen_once

      // second appearance: 
      // remove num from seen_once 
      // add num to seen_twice

      // third appearance: 
      // don't add to seen_once because of presence in seen_twice
      // remove num from seen_twice
      seenOnce = ~seenTwice & (seenOnce ^ num);
      seenTwice = ~seenOnce & (seenTwice ^ num);
    }

    return seenOnce;
  }
}
