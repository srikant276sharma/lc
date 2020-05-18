567. Permutation in String [M]
https://leetcode.com/problems/permutation-in-string/

/* Solution 1: Using int[] to store char count and Sliding window approach.
               Decrease the count of processed window character and increase the count of new window character.
https://leetcode.com/problems/find-all-anagrams-in-a-string/discuss/637057/Super-simple

Time Complexity: O(n).
Space Complexity: O(1).

Similar: 438. Find All Anagrams in a String [M]
*/

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s2.isEmpty() || s2.length() < s1.length()) {
            return false;
        }
        int s1Len = s1.length(), s2Len = s2.length();
        int[] s1CharCount = new int[26];
        int[] s2CharCount = new int[26];

        for (int i = 0; i < s1Len; i++) {
            s1CharCount[s1.charAt(i) - 'a']++; //Initially increase the count for each character.
            s2CharCount[s2.charAt(i) - 'a']++;
        }

        for (int i = s1Len; i < s2Len; i++) {
            if (Arrays.equals(s1CharCount, s2CharCount)) {
                return true;
            }
            s2CharCount[s2.charAt(i - s1Len) - 'a']--; //Decrease the count of processed window character.
            s2CharCount[s2.charAt(i) - 'a']++;         //Increase the count of new window character.
        }
        //Last anagram position processing.
        if (Arrays.equals(s1CharCount, s2CharCount)) {
            return true;
        }

        return false;
    }
}
