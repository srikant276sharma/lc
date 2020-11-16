658. Find K Closest Elements [M]

/* Solution 1: Type: Max Heap.
https://leetcode.com/problems/find-k-closest-elements/

Aditya: https://www.youtube.com/watch?v=J8yLD-x7fBI&list=PL_z_8CaSLPWdtY9W22VjnPxG30CXNZpI9&index=5

TC: O(n logk).
SC: O(k).
*/

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        //if abs diff is same for 2 keys then moving larger value (b[1] - a[1]) up so that it can be polled.
        PriorityQueue<int[]> maxH = new PriorityQueue<>((a, b) -> a[0] == b[0] ? b[1] - a[1] : b[0] - a[0]);
        
        for (int num : arr) { //TC: O(n).
            //add abs diff and num.
            maxH.add(new int[]{Math.abs(x - num), num}); //TC: O(n logk), SC: O(k).
            if (maxH.size() > k) {
                maxH.poll();
            }
        }
        
        List<Integer> res = new ArrayList<>(); //SC: O(k).
        while (maxH.size() > 0) { //TC: O(k).
            int[] polled = maxH.poll();
            res.add(polled[1]); //add value not abs diff.
        }
        Collections.sort(res); //sort list in ascending order. TC: O(k logk).
        return res;
    }
}
