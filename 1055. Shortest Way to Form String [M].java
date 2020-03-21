1055. Shortest Way to Form String [M]
https://leetcode.com/problems/shortest-way-to-form-string/
https://www.youtube.com/watch?v=evesA3gr9BE

/*Solution 1.
By checking Target character in Source.
*/

class Solution {
    public int shortestWay(String source, String target) {
        int tIndex = 0, tStartIndex = 0, subsequenceCount = 0;

        while (tIndex < target.length()) {
            tStartIndex = tIndex;
            /*Check Target character in Source. */
            for (int i = 0; i < source.length(); i++) {
                if (target.charAt(tIndex) == source.charAt(i)) {
                    tIndex++;
                }
            }
            /*If both are equal that means the Target character is not present in Source. */
            if (tStartIndex == tIndex) {
                return -1;
            }
            /*Subsequence count. */
            subsequenceCount++;
        }

        return subsequenceCount;
    }
}

--
Time Complexity: O(N * M), where N is number of characters in Source and M is number of characters in Target.
Space Complexity: O(1).
--
Asked by: Google.
--
