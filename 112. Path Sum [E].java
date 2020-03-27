112. Path Sum [E]
https://leetcode.com/problems/path-sum/
Tushar: https://www.youtube.com/watch?v=Jg4E4KZstFE&list=WL&index=28

/*Solution 1.
 Using Recursion (Pre-Order traversal).
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
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
            /*Leaf node check. */
        } else if (root.left == null && root.right == null && root.val == sum) {
            return true;
        }

        if (hasPathSum(root.left, sum - root.val)) {
            return true;
        }
        if (hasPathSum(root.right, sum - root.val)) {
            return true;
        }

        return false;
    }
}

--
Time Complexity: O(N), where N is no. of nodes in the Tree.
Space Complexity: O(N), where N is no. of nodes in the Tree.
--
Asked by: Amazon.
--
