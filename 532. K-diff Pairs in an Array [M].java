532. K-diff Pairs in an Array [M]
https://leetcode.com/problems/k-diff-pairs-in-an-array/

/* Solution 1: Using HashMap.
Rachit: https://www.youtube.com/watch?v=82lIFedHpKI&t=666s

TC: O(n) where n is the length of input array.
SC: O(n).
*/

class Solution {
    public int findPairs(int[] nums, int k) {
        HashMap<Integer, Integer> numFreq = new HashMap<>();
        
        for (int num : nums) {
            numFreq.put(num, numFreq.getOrDefault(num, 0) + 1);
        }
        int res = 0;
        
        //iterating on unique numbers of the array.
        for (int key : numFreq.keySet()) {
            //check (key + k) exists in the map or not.
            if (k == 0 ? numFreq.get(key) >= 2 : numFreq.containsKey(key + k) && numFreq.get(key + k) >= 1) {
                res++;
            }
        }
        return res;
    }
}
