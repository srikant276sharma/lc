409. Longest Palindrome [E]
https://leetcode.com/problems/longest-palindrome/

/* Solution 1: Using Set.

TC: O(n), where n is the length of input string.
SC: O(n).
*/

/**
 * Algo: 
 * 1. if char appears for the first time then add the char to set.
 * 2. if char appears for the second time then remove it from the set as two same characters will be part of palindrome.
 * 3. after iteration, if set is empty that means the string is an even length palindrome so simply return the string length.
 * 4. if set is not empty then all these chars have only one occurrence so pick any one of them, string length - set size + 1 (Odd length palindrome).
 * */

class Solution {
    public int longestPalindrome(String s) {
        Set<Character> charSet = new HashSet<>();

        for (char c : s.toCharArray()) {
            if (charSet.contains(c)) {
                charSet.remove(c);
            } else {
                charSet.add(c);
            }
        }

        int m = s.length(), n = charSet.size();
        return (n == 0) ? m : m - n + 1;
    }
}
