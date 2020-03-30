404. Sum of Left Leaves [E]
https://leetcode.com/problems/sum-of-left-leaves/

/*Solution 1: 
  Using PreOrder Traversal.
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        return helper(root);
    }

    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int sum = 0;
        /*Check if the current node has a left leaf node. */
        if (root.left != null && root.left.left == null && root.left.right == null) {
            sum += root.left.val;
        }
        sum += helper(root.left);
        sum += helper(root.right);
        return sum;
    }
}

--
Time complexity:  O(n), where n is number of nodes in the Tree.
Space complexity: O(n).
--
Asked by: Bloomberg, Facebook.
--
