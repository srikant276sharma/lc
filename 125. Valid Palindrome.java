125. Valid Palindrome
https://leetcode.com/problems/valid-palindrome/

--Solution: 1
1. At first, except alphanumeric characters remove all other characters.
2. Change the case to either lower case or upper case.
3. Use 2 pointer approach to check if it's a palindrome.
//

class Solution {
    public boolean isPalindrome(String s) {
        char[] ca = s.toCharArray();
        int j = 0;

        for (int i = 0; i < ca.length; i++) {
            if (Character.isLetterOrDigit(ca[i])) {
                ca[j++] = Character.toLowerCase(ca[i]);
            }
        }
        char[] ca2 = Arrays.copyOf(ca, j);

        for (int i = 0; i < ca2.length / 2; i++) {
            if (ca2[i] != ca2[ca2.length - 1- i]) {
                return false;
            }
        }
        return true;
    }
}
--
Runtime: 4 ms, faster than 82.52% of Java online submissions for Valid Palindrome.
Memory Usage: 37.3 MB, less than 100.00% of Java online submissions for Valid Palindrome.
--
