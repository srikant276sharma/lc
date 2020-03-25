1002. Find Common Characters [E]
https://leetcode.com/problems/find-common-characters/

/*Solution 1.
 Using 2 int[], commonChars, tempChars and ('ch' - 'a') technique.
 commonChars stores minimum common character count and tempChars stores current string character count.
*/

class Solution {
    public List<String> commonChars(String[] A) {
        List<String> result = new ArrayList<>();
        if (A == null || A.length == 0) {
            return result;
        }

        /*Starting with Max character count. */
        int[] commonChars = new int[26];
        Arrays.fill(commonChars, Integer.MAX_VALUE);

        int[] tempChars;
        for (String temp : A) {
            tempChars = new int[26];
            for (Character ch : temp.toCharArray()) {
                tempChars[ch - 'a']++;
            }

            /*Updating common minimum character count. */
            for (int i = 0; i < 26; i++) {
                commonChars[i] = Math.min(tempChars[i], commonChars[i]);
            }
        }

        /*Adding common characters to output list. */
        for (int i = 0; i < 26; i++) {
            while (commonChars[i] > 0) {
                result.add(Character.toString((char) (i + 'a')));
                commonChars[i]--;
            }
        }

        return result;
    }
}

--
Time Complexity: O(n), where n is no. of characters.
Space Complexity: O(n), where n is no. of characters.
--
Asked by:
--
