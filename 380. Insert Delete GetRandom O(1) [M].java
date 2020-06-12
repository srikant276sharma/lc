380. Insert Delete GetRandom O(1) [M]
https://leetcode.com/problems/insert-delete-getrandom-o1/

/* Solution 1: Using ArrayList and HashMap.
Knowledge Center: https://www.youtube.com/watch?v=hT43xpai5s0

TC: GetRandom is always O(1). 
    Insert and Delete both have O(1) average time complexity, 
    and O(N) in the worst-case scenario when the operation exceeds the capacity of currently allocated array/hashmap and invokes space reallocation.
SC: O(N), to store N elements.

Asked by: 
*/

class RandomizedSet {

    List<Integer> nums;
    Map<Integer, Integer> numPositions;

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {
        nums = new ArrayList<>();
        numPositions = new HashMap<>();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (numPositions.containsKey(val)) {
            return false;
        }
        nums.add(val);
        numPositions.put(val, nums.size() - 1);
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (!numPositions.containsKey(val)) {
            return false;
        }
        //move the last element at the same index from where val is getting deleted.
        int valIndex = numPositions.get(val);
        int lastNum = nums.get(nums.size() - 1);
        int lastNumIndex = numPositions.get(lastNum);

        nums.set(valIndex, lastNum);
        numPositions.put(lastNum, valIndex);
        //make adjustment for the last element.
        nums.remove(lastNumIndex);
        numPositions.remove(val);
        return true;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        return nums.get((int) (Math.random() * nums.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
