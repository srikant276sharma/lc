/*
Solution 1: Using Hash Table.

TC: O(n).
SC: O(n).
*/

class Solution {
    public int largestUniqueNumber(int[] A) {
        //input check.
        if (A == null || A.length == 0) {
            return -1;
        }
        //map to hold num and it's frequency.
        Map<Integer, Integer> freq = new HashMap<>();
        
        for (int num : A) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        
        int res = -1;
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (entry.getValue() == 1) {
                res = Math.max(res, entry.getKey());
            }
        }
        return res;
    }
}
