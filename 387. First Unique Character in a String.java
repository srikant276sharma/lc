387. First Unique Character in a String
https://leetcode.com/problems/first-unique-character-in-a-string/

//Solution: 1

class Solution {
    public int firstUniqChar(String s) {
        int[] charCount = new int[26];

        for (char c : s.toCharArray()) {
            charCount[c - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (charCount[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}

//Solution: 2
class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        /* map: To store character and the character count. */
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        /* To get index of first unique character. */
        for (int i = 0; i < s.length(); i++) {
            if (1 == map.get(s.charAt(i))) {
                return i;
            }
        }
        return -1;
    }
}
--
Complexity Analysis
Time complexity : O(N) since we go through the string of length N two times.
Space complexity : O(N) since we have to keep a hash map with N elements.
--
