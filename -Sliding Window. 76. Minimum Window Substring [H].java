76. Minimum Window Substring
https://leetcode.com/problems/minimum-window-substring/

/*
Amell: https://www.youtube.com/watch?v=0GOyCIJ2ajQ

TC: O(m + n), where m and n are the length of s and t.
SC: O(m + n).
*/

class Solution {
    public String minWindow(String s, String t) {
        //input validation.
        if (s == null || t == null) {
            return "";
        }
        String res = "";
        int left = 0, minLen = Integer.MAX_VALUE;
        int count = 0; //count of chars that are in t.
        int[] charCount = new int[128]; //7 bit ASCII characters.

        for (char c : t.toCharArray()) {
            charCount[c]++;
        }
        //sliding window.
        for (int right = 0; right < s.length(); right++) {
            //+ve means the char is present in t.
            if (--charCount[s.charAt(right)] >= 0) {
                count++; 
            }
            while (count == t.length()) { //cur window contains all chars of t.
                if (minLen > right - left + 1) { //adding 1.
                    minLen = right - left + 1;
                    res = s.substring(left, right + 1);
                }

                // >0 means the char is present in t.
                if (++charCount[s.charAt(left)] > 0) {
                    count--; //discarding the char at left so reducing count.
                }
                left++; //reduce window size by moving the left pointer.
            }
        }
        return res;
    }
}
