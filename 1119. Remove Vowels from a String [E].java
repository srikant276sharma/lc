1119. Remove Vowels from a String [E]
https://leetcode.com/problems/remove-vowels-from-a-string/

/*
Company: Amazon.

Given a string s, remove the vowels 'a', 'e', 'i', 'o' and 'u' from it, and return the new string.

Example 1:
Input: "leetcodeisacommunityofcoders"
Output: "ltcdscmmntyfrcdrs"

Example 2:
Input: "aeiou"
Output: ""
*/

/*Solution 1:
TC: O(n) where n is the number of Characters.
SC: O(n).
*/

class Solution {
    public String removeVowels(String s) {
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        StringBuilder result = new StringBuilder();
        for (Character c : s.toCharArray()) {
            if (!vowels.contains(c)) {
                result.append(c);
            }
        }
        return result.toString();
    }
}
