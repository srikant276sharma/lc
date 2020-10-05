1288. Remove Covered Intervals [M]
https://leetcode.com/problems/remove-covered-intervals/

/* Solution 1: Using Custom Sorting.
Rachit: https://www.youtube.com/watch?v=Xf_NAgZzILU

TC: O(n logn) where n is the length of input array.
SC: O(1).
*/

class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, comparator);

        int maxEnd = 0, result = intervals.length;
        
        for (int[] interval : intervals) {
            //need to check if current interval is already contained.
            int curEnd = interval[1];
            if (curEnd <= maxEnd) {
                result--; //throw away the current interval.
            }
            maxEnd = Math.max(maxEnd, curEnd);
        }
        return result;
    }

    public Comparator<int[]> comparator = new Comparator<int[]>() {
        @Override
        public int compare(int[] i1, int[] i2) {
            if (i1[0] == i2[0]) {
                return i2[1] - i1[1]; //if first elements are same then sort in descending order.
            }
            return i1[0] - i2[0]; //sort in ascending order.
        }
    };
}
