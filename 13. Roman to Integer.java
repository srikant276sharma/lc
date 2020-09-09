13. Roman to Integer
https://leetcode.com/problems/roman-to-integer/

--Solution 1:
/**
Assumption:
We assume input is a valid Roman numeral. 
For example, we assume we will not get IM as a Roman numeral (since I cannot be placed immediately before M)

Algorithm:
1. Create a Map<Character, Integer> that maps Roman Numeral Characters to their values.
2. Initialize a running sum to 0.
3. Loop through all characters of the array.
   - if current character's value is greater than previous character's value, add current character's value and minus 2 * previous character's value.
   - else, add current character's value to sum.
*/
--
class Solution {
    public int romanToInt(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        HashMap<Character, Integer> charMap = new HashMap<>();
        charMap.put('I', 1);
        charMap.put('V', 5);
        charMap.put('X', 10);
        charMap.put('L', 50);
        charMap.put('C', 100);
        charMap.put('D', 500);
        charMap.put('M', 1000);

        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i > 0 && charMap.get(s.charAt(i)) > charMap.get(s.charAt(i - 1))) {
                result -= 2 * (charMap.get(s.charAt(i - 1)));
            }
            result += charMap.get(s.charAt(i));
        }
        return result;
    }
}
--
Time Complexity: O(N).
Space Complexity: O(1).
--
