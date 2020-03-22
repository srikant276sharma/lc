1389. Create Target Array in the Given Order [E]
https://leetcode.com/problems/create-target-array-in-the-given-order/

/*Solution 1.
*/

class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        /*Use List to add element at any particular index. */
        List<Integer> targetList = new ArrayList<>();

        for (int n = 0; n < nums.length; n++) {
            targetList.add(index[n], nums[n]);
        }

        /*Transfer List values to Array. */
        int[] target = new int[nums.length];

        for (int i = 0; i < targetList.size(); i++) {
            target[i] = targetList.get(i);
        }
        return target;
        //return targetList.stream().mapToInt(i -> i).toArray();
    }
}

--
Time Complexity: O(N), where N is number of elements in nums.
Space Complexity: O(N) where N is number of elements in nums.
--
Asked by:
--
