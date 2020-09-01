949. Largest Time for Given Digits [E]
https://leetcode.com/problems/largest-time-for-given-digits/

/* Solution 1:
KC: https://www.youtube.com/watch?v=sn6r0ZV_2y4

TC: O(64) ~ O(1).
SC: O(1).
*/

class Solution {
  public String largestTimeFromDigits(int[] A) {
    String result = "";
    
    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 4; j++) {
        for (int k = 0; k < 4; k++) {
          if (i == j || j == k || k == i) { //process each digit only once.
            continue;
          }
          String hh = "" + A[i] + A[j];
          String mm = "" + A[k] + A[6 - i - j - k];
          String time = hh + ":" + mm;
          if (hh.compareTo("24") < 0 && mm.compareTo("60") < 0 && time.compareTo(result) > 0) {
            result = time;
          }
        }
      }
    }
    
    return result;
  }
}
