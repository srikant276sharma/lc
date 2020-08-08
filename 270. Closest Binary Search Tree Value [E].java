270. Closest Binary Search Tree Value [E]
https://leetcode.com/problems/closest-binary-search-tree-value/

/* Solution 1:

TC: O(H), since here one goes from root down to a leaf.
SC: O(1), without any extra space.
*/

class Solution {
    public int closestValue(TreeNode root, double target) {
        int closest = root.val;

        while (root != null) {
            closest = Math.abs(root.val - target) < Math.abs(closest - target) ? root.val : closest;
            root = (target < root.val) ? root.left : root.right;
        }
        return closest;
    }
}
