1471. The k Strongest Values in an Array [M]
https://leetcode.com/problems/the-k-strongest-values-in-an-array/

/* Solution 1: Using MinHeap.

TC: O(n logn), because of sorting the input array.
SC: O(k), to keep k elements in Heap and in output array.

Asked by:
*/

class Solution {
    public int[] getStrongest(int[] arr, int k) {
        Arrays.sort(arr); //TC: O(n logn)
        int m = arr[(arr.length - 1) / 2];

        //SC: O(k)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) ->
                Math.abs(a - m) == Math.abs(b - m)
                        ? a - b
                        : Math.abs(a - m) - Math.abs(b - m));
        //TC: O(n logk)
        for (int i : arr) {
            minHeap.add(i);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        int[] res = new int[k];
        int i = 0;
        while (!minHeap.isEmpty()) {
            res[i++] = minHeap.poll();
        }

        return res;
    }
}

/* Solution 12: Using MaxHeap.

TC: O(n logn), because of sorting the input array.
SC: O(n), to keep n elements in Heap.
*/

class Solution {
    public int[] getStrongest(int[] arr, int k) {
        Arrays.sort(arr); //TC: O(n log n)
        int m = arr[(arr.length - 1) / 2];

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) ->
                Math.abs(a - m) == Math.abs(b - m)
                        ? b - a
                        : Math.abs(b - m) - Math.abs(a - m));
        //TC: O(n log n), SC: O(n)
        for (int i : arr) {
            maxHeap.add(i);
        }

        //SC: O(k)
        int[] res = new int[k];
        int i = 0;
        while (i < k && !maxHeap.isEmpty()) {
            res[i++] = maxHeap.poll();
        }

        return res;
    }
}
