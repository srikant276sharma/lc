111. Minimum Depth of Binary Tree [E]
https://leetcode.com/problems/minimum-depth-of-binary-tree/

/* Solution 1:
Using Postorder traversal.
IDeserve: https://www.youtube.com/watch?v=hmWhJyz5kqc
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
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else if (root.left == null && root.right == null) {
            return 1;
        }

        int leftH = (root.left != null) ? minDepth(root.left) : Integer.MAX_VALUE;
        int rightH = (root.right != null) ? minDepth(root.right) : Integer.MAX_VALUE;
        return Math.min(leftH, rightH) + 1;
    }
}

--
Time Complexity: O(n), where n is number of nodes in the tree.
Space Complexity: O(n).
--
Asked by: Amazon, Facebook.
--
