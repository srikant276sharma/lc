1356. Sort Integers by The Number of 1 Bits [E]
https://leetcode.com/problems/sort-integers-by-the-number-of-1-bits/

/* Solution 1:
Input: arr = [0,1,2,3,4,5,6,7,8]
Output: [0,1,2,4,8,3,5,6,7]

Explantion: [0] is the only integer with 0 bits.
            [1,2,4,8] all have 1 bit.
            [3,5,6] have 2 bits.
            [7] has 3 bits.
The sorted array by bits is [0,1,2,4,8,3,5,6,7]
*/

class Solution {
    public int[] sortByBits(int[] arr) {
        return Arrays.stream(arr)   //IntStream
                .boxed()            //Stream<Integer>
                .sorted((a, b) -> Integer.bitCount(a) == Integer.bitCount(b) ? (a - b) : (Integer.bitCount(a) - Integer.bitCount(b)))
                .mapToInt(Integer::intValue) //IntStream
                .toArray();
    }
}

--
Complexities:
Time: O(n).
Space: O(1), we are not using any extra space.
--
Asked by:
--
