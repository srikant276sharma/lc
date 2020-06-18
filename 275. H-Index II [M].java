275. H-Index II [M]
https://leetcode.com/problems/h-index-ii/

/* Solution 1: Using Binary Search.

TC: O(logN), where N is the length of input array.
SC: O(1).

Asked by:
*/

class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int mid, left = 0, right = n - 1;

        while (left <= right) {
            mid = left + (right - left) / 2;
            if (citations[mid] == n - mid) { //it means 'n - mid' papers have citations[mid] citations.
                return n - mid;
            } else if (citations[mid] < n - mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return n - left;
    }
}
