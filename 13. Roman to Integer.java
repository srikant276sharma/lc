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
        int res = 0;
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        for (int i = 0; i < s.length(); i++) {
            if (i > 0 && map.get(s.charAt(i)) > map.get(s.charAt(i - 1))) {
                res += map.get(s.charAt(i)) - 2 * (map.get(s.charAt(i - 1)));
            } else {
                res += map.get(s.charAt(i));
            }
        }
        return res;
    }
}
--
Time Complexity: O(N).
Space Complexity: O(1).
--
