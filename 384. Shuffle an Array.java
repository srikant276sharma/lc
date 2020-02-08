384. Shuffle an Array
https://leetcode.com/problems/shuffle-an-array/

--Solution 1:
/**
Algorithm:
1. Loop through the array. For each element at index i, swap it with a random element in interval [0, i] inclusive.
2. This swap ensures randomness in 2 ways:
     That each element in the array from [0, i] has an equal chance of being the ith element.
     That the original ith element has an equal chance of being anywhere in the array in [0, i].
3. At each iteration of our for loop, the array from [0, i] has elements in random order.
*/
--
class Solution {
    int[] arr;
    int[] orig;
    Random random;

    public Solution(int[] nums) {
        if (nums == null) {
            throw new IllegalArgumentException();
        }
        arr = nums;
        orig = nums.clone();
        random = new Random();
    }

    /* Resets the array to its original configuration and return it. */
    public int[] reset() {
        return orig;
    }

    /* Returns a random shuffling of the array. */
    public int[] shuffle() {
        /* Fisher-Yates shuffle algorithm.*/
        for (int i = 1; i < arr.length; i++) {
            /* the upper bound is (exclusive) so adding 1. */
            int randomIdx = random.nextInt(i + 1);
            swap(i, randomIdx);
        }
        return arr;
    }

    private void swap(int i, int randomIdx) {
        if (i != randomIdx) {
            int temp = arr[i];
            arr[i] = arr[randomIdx];
            arr[randomIdx] = temp;
        }
    }
}
--
Time Complexity: O(n).
Space Complexity: O(n) to store our original array.
--
