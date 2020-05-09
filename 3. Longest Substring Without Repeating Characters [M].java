3. Longest Substring Without Repeating Characters [M]
https://leetcode.com/problems/longest-substring-without-repeating-characters/

/* Solution 1: Using HashSet as a Sliding Window and 2 pointers.
https://leetcode.com/problems/longest-substring-without-repeating-characters/discuss/1812/Share-my-Java-solution-using-HashSet

Time complexity: O(2n) = O(n). In the worst case, each character will be visited twice by left and right.
Space complexity: O(k), where k is size of the Set.

Asked by:
*/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0, max = 0;
        HashSet<Character> charSet = new HashSet<>(); //Using HashSet as a Sliding Window.

        while (right < s.length()) {
            if (!charSet.contains(s.charAt(right))) {
                charSet.add(s.charAt(right++));
                max = Math.max(max, charSet.size()); //(right - left) ~ charSet.size().
            } else {
                charSet.remove(s.charAt(left++)); //It will keep on deleting until it deletes the repeated character.
            }
        }

        return max;
    }
}
