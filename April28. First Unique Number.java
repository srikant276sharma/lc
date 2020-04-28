April28. First Unique Number.

/* Solution 1: Using Map and Queue.
- Map is used to maintain num and its count.
- Queue is used to hold unique nums.

Tech dose: https://www.youtube.com/watch?v=x_m69OeOHN8
Knowledge Center: https://www.youtube.com/watch?v=eky43Oe8qLI

Time complexity: O(n).
Space complexity: O(n).
*/

class FirstUnique {
    Map<Integer, Integer> numCount;
    Queue<Integer> queue;

    public FirstUnique(int[] nums) {
        numCount = new HashMap<>();
        queue = new LinkedList<>();

        for (int num : nums) {
            numCount.put(num, numCount.getOrDefault(num, 0) + 1); //To maintain num count.
            if (numCount.get(num) == 1) {
                queue.add(num); //queue will always contain unique elements, and from map, we'll get its element count.
            }
        }
    }

    public int showFirstUnique() {
        while (!queue.isEmpty() && numCount.get(queue.peek()) > 1) {
            queue.poll();
        }

        if (queue.isEmpty()) {
            return -1;
        } else {
            return queue.peek();
        }
    }

    public void add(int value) {
        numCount.put(value, numCount.getOrDefault(value, 0) + 1);
        if (numCount.get(value) == 1) {
            queue.add(value);
        }
    }
}

/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */
