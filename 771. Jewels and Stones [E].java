771. Jewels and Stones [E]
https://leetcode.com/problems/jewels-and-stones/

/* Solution 1: Using HashSet.
Kevin: https://www.youtube.com/watch?v=9Reqqk60Nv4

Time complexity: O(m + n), where m is length of J and n is length of S.
Space complexity: O(m), where m is length of J.
*/

class Solution {
    public int numJewelsInStones(String J, String S) {
        Set<Character> jewels = new HashSet<>();
        for (char c : J.toCharArray()) {
            jewels.add(c);
        }

        int jewelsCount = 0;
        for (char c : S.toCharArray()) {
            if (jewels.contains(c)) {
                jewelsCount++;
            }
        }

        return jewelsCount;
    }
}
