17. Letter Combinations of a Phone Number [M]
https://leetcode.com/problems/letter-combinations-of-a-phone-number/

/* Solution 1: Using Backtracking.
Amell: https://www.youtube.com/watch?v=6tRoYAHSNsA

Time complexity: O(3^N * 4^M) where N is the number of digits in the input that maps to 3 letters (e.g. 2, 3, 4, 5, 6, 8) 
                 and M is the number of digits in the input that maps to 4 letters (e.g. 7, 9), 
                 and N + M is the total number digits in the input.
Space complexity: O(3^N * 4^M) since one has to keep 3^N * 4^M solutions.
*/

class Solution {
    //Digit to letters mapping.
    public final String[] digitToLetters = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return list;
        }

        helper(digits, 0, "", list);
        return list;
    }

    private void helper(String digits, int digitIndex, String combination, List<String> list) {
        //Check whether current combination length is equal to input digits length.
        if (digits.length() == digitIndex) {
            list.add(combination);
            return;
        }

        int digit = digits.charAt(digitIndex) - '0'; //Get the current digit.
        String letters = digitToLetters[digit]; //Get letters based on the digitToLetters mapping.

        for (char letter : letters.toCharArray()) {
            //For each current digit letter, explore all letters of next digit.
            helper(digits, digitIndex + 1, combination + letter, list);
        }
    }
}
