5454. Least Number of Unique Integers after K Removals [M]
https://leetcode.com/problems/least-number-of-unique-integers-after-k-removals/

/* Solution 1: Using Map and MinHeap.

TC: O(N logN), where N = no. of elements in input array.
SC: O(N), to store frequency count.

Asked by:
*/

class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        //goal: remove k least frequent elements and then return the count of left unique elements.
        Map<Integer, Integer> freqCount = new HashMap<>();
        for (int i : arr) {
            freqCount.put(i, freqCount.getOrDefault(i, 0) + 1); //calculate frequency of each element.
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> freqCount.get(a) - freqCount.get(b));
        minHeap.addAll(freqCount.keySet()); //all elements are sorted according to their frequency.

        for (int i = 0; i < k; i++) {
            int leastFreqNum = minHeap.peek();
            if (freqCount.get(leastFreqNum) == 1) { //after decrementing count will get 0, so remove from map and minHeap.
                freqCount.remove(leastFreqNum);
                minHeap.poll();
            } else {
                freqCount.put(leastFreqNum, freqCount.get(leastFreqNum) - 1); //decrement count of least frequent element by 1.
            }
        }

        return freqCount.size(); //freqCount has least unique elements.
    }
}

/* Solution 2: Using Map, Sorting and Set.

TC: O(N logN), where N = no. of elements in input array.
SC: O(N), to store frequency count.
*/

class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> freqCount = new HashMap<>();
        for (int a : arr) {
            freqCount.put(a, freqCount.getOrDefault(a, 0) + 1);
        }
        arr = Arrays.stream(arr)
                .boxed()
                .sorted((a, b) -> (freqCount.get(a).equals(freqCount.get(b))) ? (a - b) : freqCount.get(a) - freqCount.get(b))
                .mapToInt(Integer::intValue)
                .toArray();
                
        Set<Integer> result = new HashSet<>();
        for (int i = k; i < arr.length; i++) {
            result.add(arr[i]);
        }

        return result.size();
    }
}
