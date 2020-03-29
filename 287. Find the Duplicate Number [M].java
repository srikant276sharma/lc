287. Find the Duplicate Number [M]
https://leetcode.com/problems/find-the-duplicate-number/

/*Solution 1: Using Floyd's Cycle Detection Algorithm.
- Intersection might not be the correct answer.
  Example: [2, 5, 9, 6, 9, 3, 8, 9, 7, 1], here 7 is the intersecting value.
  
  Only the entry of the loop means that there are at least 2 pointers pointing to it.
- The solution works because the input range is constrained to [1, n].
  If it is [0, n] then it won't work
  Example: [2, 3, 0, 3, 3] => 2->0->2->0... Duplicate number 3 will never be reached.
*/

class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        /*Check if cycle exists or not, find the intersecting value of the two runners. */
        do {
            slow = nums[slow]; /*1 element at a time. */
            fast = nums[nums[fast]]; /*2 elements at a time. */
        } while (slow != fast);

        /*Find the beginning of above cycle, that would be the duplicate number. */
        int ptr1 = nums[0]; /*Start from Head value. */
        int ptr2 = slow; /*Start from intersecting value. */
        while (ptr1 != ptr2) {
            ptr1 = nums[ptr1]; /*1 element at a time. */
            ptr2 = nums[ptr2]; /*1 element at a time. */
        }

        return ptr1;
    }
}

--
Time complexity:  O(n) where n is the number of elements in the array.
Space complexity: O(1).
--
Asked by: Amazom, VMWare, Riverbed.
--
