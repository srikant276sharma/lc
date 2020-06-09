347. Top K Frequent Elements [M]
https://leetcode.com/problems/top-k-frequent-elements/

/* Solution 3: Using MinHeap.

TC: O(n log k) where n is the no. of distinct elements in the array and k is the top element count.
 Each integer is processed in O(log k) time, which is the time to add or to remove the minimum element from the heap.
 Therefore, if there are n integers in the input, the TC to process all of them is O(n log k).
SC: O(k) to store k distinct elements.

Asked by:
*/

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //map to store number frequency.
        Map<Integer, Integer> numFrequency = new HashMap<>();

        //TC: O(n), SC: O(n)
        for (int i : nums) {
            numFrequency.put(i, numFrequency.getOrDefault(i, 0) + 1);
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>((n1, n2) -> numFrequency.get(n1) - numFrequency.get(n2));
        //TC: O(n log k), SC: O(k)
        for (int num : numFrequency.keySet()) {
            minHeap.add(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        //SC: O(k)
        int[] res = new int[k];
        int i = 0;
        //TC: O(k log k)
        while (!minHeap.isEmpty()) {
            res[i++] = minHeap.poll();
        }

        return res;
    }
}

/*Solution 1: Using Min-heap. Return type: List.
*/

class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> freqCount = new HashMap<>();
        for (Integer num : nums) {
            freqCount.put(num, freqCount.getOrDefault(num, 0) + 1);
        }

        // min-heap:
/*        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(freqCount.get(o1), freqCount.get(o2));
            }
        });*/

        //PriorityQueue<Integer> minHeap = new PriorityQueue<>(k, (o1, o2) -> Integer.compare(freqCount.get(o1), freqCount.get(o2)));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((n1, n2) -> freqCount.get(n1) - freqCount.get(n2));
        //PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.comparingInt(freqCount::get));

        for (Integer key : freqCount.keySet()) {
            minHeap.add(key);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

	//Because of min-heap, orderedList will have elements in reverse order of frequency.
        List<Integer> orderedList = new ArrayList<>(minHeap);
        Collections.reverse(orderedList);
        return orderedList;
        //return new ArrayList<>(minHeap);
    }
}

/*Solution 2: Using Max-heap. Return type: List.
*/

class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> intCount = new HashMap<>();

        for (Integer i : nums) {
            intCount.put(i, intCount.getOrDefault(i, 0) + 1);
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> intCount.get(b) - intCount.get(a));
        maxHeap.addAll(intCount.keySet());

        if (!maxHeap.isEmpty()) {
            for (int i = 0; i < k; i++) {
                result.add(maxHeap.poll());
            }
        }

        return result;
    }
}
