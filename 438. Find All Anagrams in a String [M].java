438. Find All Anagrams in a String [M]
https://leetcode.com/problems/find-all-anagrams-in-a-string/

/* Solution 1: Using int[] to store char count and Sliding window approach.
               Decrement the count of processed window character and increment the count of new window character.
https://leetcode.com/problems/find-all-anagrams-in-a-string/discuss/637057/Super-simple

Time Complexity: O(n).
Space Complexity: O(1).
*/

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> anagramPositions = new ArrayList<>();
        if (s.length() < p.length()) {
            return anagramPositions;
        }

        int sLen = s.length(), pLen = p.length();
        int[] sCharCounts = new int[26];
        int[] pCharCounts = new int[26];

        for (int i = 0; i < pLen; i++) {
            sCharCounts[s.charAt(i) - 'a']++; //Increment the count of each character in s.
            pCharCounts[p.charAt(i) - 'a']++; //Increment the count of each character in p.
        }

        for (int i = pLen; i < sLen; i++) {
            if (Arrays.equals(pCharCounts, sCharCounts)) {
                anagramPositions.add(i - pLen);
            }
            sCharCounts[s.charAt(i - pLen) - 'a']--; //Decrement the count of processed window character. 'cba' e >> c 'bae'
            sCharCounts[s.charAt(i) - 'a']++;        //Increment the count of new window character.
        }
        //Last anagram position processing.
        if (Arrays.equals(pCharCounts, sCharCounts)) {
            anagramPositions.add(sLen - pLen);
        }

        return anagramPositions;
    }
}
