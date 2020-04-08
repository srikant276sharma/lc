1090. Largest Values From Labels [M]
https://leetcode.com/problems/largest-values-from-labels/
Kevin: https://www.youtube.com/watch?v=84xibeO_lqk&t=633s

/* Solution 1:
Using Custom Class, MaxHeap and HashMap.
*/

class Solution {
    public int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {
        /*List to hold value and label pair. */
        List<Item> items = new ArrayList<>();
        for (int i = 0; i < labels.length; i++) {
            items.add(new Item(values[i], labels[i]));
        }

        /*MaxHeap. */
        PriorityQueue<Item> maxHeap = new PriorityQueue<>((Item a, Item b) -> b.value - a.value);
        maxHeap.addAll(items);

        int largestVal = 0;
        Map<Integer, Integer> labelCountMap = new HashMap<>();
        /*map to store label and label count. */
        while (!maxHeap.isEmpty() && num_wanted > 0) {
            Item current = maxHeap.poll();
            labelCountMap.put(current.label, labelCountMap.getOrDefault(current.label, 0) + 1);
            /*Check label count limit. Because of MaxHeap, it will return largest value. */
            if (labelCountMap.get(current.label) <= use_limit) {
                largestVal += current.value;
                num_wanted--;
            }
        }

        return largestVal;
    }

    /*To hold value and label pair. */
    class Item {
        int value;
        int label;

        public Item(int value, int label) {
            this.value = value;
            this.label = label;
        }
    }
}

--
Time Complexity: O(n log n), where n is number of Items.
Space Complexity: O(n), where n is number of Items.
--
Asked by: Google.
--
