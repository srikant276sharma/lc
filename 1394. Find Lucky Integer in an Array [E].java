1394. Find Lucky Integer in an Array [E]
https://leetcode.com/problems/find-lucky-integer-in-an-array/

/*Solution 1.
 Using HashMap.
*/

class Solution {
    public int findLucky(int[] arr) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        /*To map Integer with their frequency. */
        for (int i : arr) {
            freqMap.put(i, freqMap.getOrDefault(i, 0) + 1);
        }
        
        int max = -1;
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            if (entry.getKey().equals(entry.getValue())) {
                max = entry.getKey();
            }
        }

        return max;
    }
}

--
Time complexity: O(n).
Space complexity: O(n), for storing integers in HashMap.
--
Asked by:
--
