56. Merge Intervals [M]
https://leetcode.com/problems/merge-intervals/

/* Solution 1: Using Custom Sorting and Linked List.

TC: O(n log n), where n is the number of intervals.
SC: O(n).
*/

class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return intervals;
        }
        //Arrays.sort(intervals, ((a, b) -> (a[0] == b[0]) ? a[1] - b[1] : a[0] - b[0]));
        Arrays.sort(intervals, comp); //TC: O(n log n).
        LinkedList<int[]> merged = new LinkedList<>(); //SC: O(n).

        //TC: O(n).
        for (int[] interval : intervals) {
            // if the list of merged intervals is empty or if the current interval does not overlap with the previous, simply append it.
            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                merged.add(interval);
            } else {
                // otherwise, there is overlap, so we merge the current and previous intervals.
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }

        return merged.toArray(new int[merged.size()][2]);
    }

    public Comparator<int[]> comp = new Comparator<int[]>() {
        @Override
        public int compare(int[] i1, int[] i2) {
            return (i1[0] == i2[0]) ? (i1[1] - i2[1]) : (i1[0] - i2[0]);
        }
    };
}
