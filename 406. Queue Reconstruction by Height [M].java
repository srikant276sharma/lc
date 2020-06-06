406. Queue Reconstruction by Height [M]
https://leetcode.com/problems/queue-reconstruction-by-height/

/* Solution 1: Using comparator and sorting.
Knowledge Center: https://www.youtube.com/watch?v=_DtZIPUt8jo&t=23s
Algorithm:
-Sort people:
 In the descending order by height.
 Among the guys of the same height, in the ascending order by k-values.
-Take guys one by one, and place them in the output array at the indexes equal to their k-values.
-Return output array.
TC: O(n^2). To sort people takes O(Nlog⁡N) time. 
For example, 
  if we have 5 elements in the array and need to insert an element in arr[0], 
  we need to shift all those 5 elements one position to the right. 
  In general, if we have n elements we need to shift all n elements. So, worst case time complexity will be O(n).
  As, there are n persons so total complexity will be n * O(n) = O(n^2).
SC: O(n). To keep the output.
Asked by:
*/

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        List<int[]> res = new ArrayList<>();
        //if heights are different then sort in decreasing order by height, if heights are same then sort in increasing order by k.
        Arrays.sort(people, (p1, p2) -> (p1[0] == p2[0]) ? p1[1] - p2[1] : p2[0] - p1[0]);

        for (int[] p : people) {
            //insert people at their kth index.
            res.add(p[1], p);
        }

        return res.toArray(new int[people.length][2]);
    }
}
