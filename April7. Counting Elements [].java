April7. Counting Elements []
https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/528/week-1/3289/

/* Solution 1:
Using HashSet.
*/

class Solution {
    public int countElements(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        HashSet<Integer> numSet = new HashSet<>();
        for (int i : arr) {
            numSet.add(i);
        }
        /*Count elements. */
        int count = 0;
        for (int i : arr) {
            if (numSet.contains(i + 1)) {
                count++;
            }
        }

        return count;
    }
}

--
Time Complexity: O(n), where n is number of elements in the array.
Space Complexity: O(n), where n is number of elements in the array.
--
Asked by:
--
