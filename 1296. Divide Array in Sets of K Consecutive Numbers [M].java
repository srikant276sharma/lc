1296. Divide Array in Sets of K Consecutive Numbers [M]
https://leetcode.com/problems/divide-array-in-sets-of-k-consecutive-numbers/
https://leetcode.com/problems/divide-array-in-sets-of-k-consecutive-numbers/discuss/458270/Java-TreeMap-solution-faster-than-100

/*Solution 1.
 Using TreeMap.
 - First, we put all the numbers in TreeMap. 
 - We get the first key (Let's say c) of the map. Then we traverse from the first key(c) to c + k - 1 and count minus 1, respectively.
 - If any one of numbers from c to c + k - 1 is not in the map, we return false. 
 - Then we traverse from the (first key) to the (first key + k - 1) again and again until the map is empty.
*/

class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0 || nums.length % k != 0) {
            return false;
        }

        TreeMap<Integer, Integer> freqMap = new TreeMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        int firstKey;
        while (freqMap.size() > 0) {
            firstKey = freqMap.firstKey();
            for (int i = firstKey; i < k + firstKey; i++) {
                /*Consecutive check. */
                if (!freqMap.containsKey(i)) {
                    return false;
                } else {
                    freqMap.put(i, freqMap.get(i) - 1);
                    if (freqMap.get(i) == 0) {
                        freqMap.remove(i);
                    }
                }
            }
        }

        return true;
    }
}

--
Time Complexity: O(n log n), for putting all elements into TreeMap (where n is number of elements in the array).
Space Complexity: O(n), for putting n elements into TreeMap.
--
Asked by: Google.
--
