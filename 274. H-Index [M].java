274. H-Index [M]
https://leetcode.com/problems/h-index/

/* Solution 1:

TC: O(nlog n), where n is the length of array.
SC: O(1).
*/

class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        //Binary Search approach.
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

/*        //Linear approach.
        int n = citations.length, i;
        for (i = 1; i <= n; i++) {
            if (citations[n - i] < i) {
                break;
            }
        }
        return i - 1;*/
    }
}
