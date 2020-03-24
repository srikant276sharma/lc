217. Contains Duplicate [E]
https://leetcode.com/problems/contains-duplicate/

/*Solution 1.
 Using HashSet.
*/

class Solution {
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return false;
        }
        HashSet<Integer> seen = new HashSet<>();
        for (int i : nums) {
            if (!seen.add(i)) {
                return true;
            }
        }
        return false;
    }
}

--
Time Complexity: O(n), where n is number of elements in the array.
Space Complexity: O(n), where n is number of elements in the array.
--
Asked by: Google, Microsoft, Adobe.
--
