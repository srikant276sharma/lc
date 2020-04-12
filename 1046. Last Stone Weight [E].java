1046. Last Stone Weight [E]
https://leetcode.com/problems/last-stone-weight/

/* Solution 1:
Using MaxHeap.
Kevin: https://www.youtube.com/watch?v=fBPS7PtPtaE&t=55s
*/

class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((n1, n2) -> n2 - n1);
        for (int stone : stones) {
            maxHeap.add(stone);
        }

        while (maxHeap.size() > 1) {
            int heaviest = maxHeap.remove();
            int secHeaviest = maxHeap.remove();
            if (heaviest != secHeaviest) {
                maxHeap.add(heaviest - secHeaviest);
            }
        }

        return maxHeap.isEmpty() ? 0 : maxHeap.remove();
    }
}

--
Time Complexity: O(N logN), where N is number of elements in the array.
Space Complexity: O(N), to store N elements in the Heap.
--
Asked by: Amazon.
--
