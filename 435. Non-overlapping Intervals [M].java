435. Non-overlapping Intervals [M]
https://leetcode.com/problems/non-overlapping-intervals/

/* Solution 1: Using Custom Sorting.
KC: https://www.youtube.com/watch?v=BW7LeuJIMhE

TC: O(NlogN), where n is the number of intervals.
SC: O(1).
*/

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length < 2) {
            return 0;
        }

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]); //sort based on first element of interval.
        int count = 0, lastIncluded = 0;

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < intervals[lastIncluded][1]) { //Overlap.
                count++;
                if (intervals[i][1] < intervals[lastIncluded][1]) {
                    lastIncluded = i;
                }
            } else {
                lastIncluded = i;
            }
        }
        return count;
    }
}
