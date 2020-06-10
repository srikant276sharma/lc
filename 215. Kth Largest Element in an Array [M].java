215. Kth Largest Element in an Array [M]
https://leetcode.com/problems/kth-largest-element-in-an-array/

/*Solution 1: Using Min-heap.

TC: O(n log k) where n is no. of elements in the array and k is size of Min-heap.
 Each element is processed in O(log k) time, which is the time to add or to remove the minimum element from the heap.
 Therefore, if there are n elements in the input, the TC to process all of them is O(n log k).

SC: O(k) to store k elements in the Min-heap.

Asked by: Google.
*/

class Solution {
    public int findKthLargest(int[] nums, int k) {
        /*Min-Heap.*/
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        //PriorityQueue<Integer> minHeap = new PriorityQueue<>((n1, n2) -> n1 - n2);
        //PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.comparingInt(n -> n));
        for (Integer num : nums) {
            if (minHeap.size() == k && num < minHeap.peek()) {
                continue;
            }
            minHeap.add(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        return minHeap.peek();
    }
}
