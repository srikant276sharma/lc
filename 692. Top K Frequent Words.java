692. Top K Frequent Words
https://leetcode.com/problems/top-k-frequent-words/

/*Solution 1.
Using Min-heap.
*/

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> freqCount = new HashMap<>();
        for (String word : words) {
            freqCount.put(word, freqCount.getOrDefault(word, 0) + 1);
        }

        /*MinHeap*/
        PriorityQueue<String> minHeap = new PriorityQueue<>((w1, w2) -> freqCount.get(w1).equals(freqCount.get(w2))
                ? w2.compareTo(w1)
                : freqCount.get(w1) - freqCount.get(w2));
        for (String word : freqCount.keySet()) {
            minHeap.add(word);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        List<String> result = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            result.add(minHeap.poll());
        }
        /*In case of minHeap, reverse the output. */
        Collections.reverse(result);
        return result;
    }
}

--
Time complexity: O(n log k) where n is the no. of distinct elements in the array and k is the top element count.
 Each String is processed in O(log k) time, which is the time to add or to remove the minimum element from the heap.
 Therefore, if there are n distinct Strings in the input, the TC to process all of them is O(n log k).

Space complexity: O(n) to store n distinct elements in the map.
--
Asked by: .
--
