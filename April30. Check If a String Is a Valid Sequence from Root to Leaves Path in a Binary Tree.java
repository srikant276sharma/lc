April30. Check If a String Is a Valid Sequence from Root to Leaves Path in a Binary Tree.

/* Solution 1: Using Preorder traversal.
Knowledge Center: https://www.youtube.com/watch?v=23oR5ipWwk8

Time complexity: O(n), where n is number of nodes in the tree.
Space complexity: O(1).
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isValidSequence(TreeNode root, int[] arr) {
        if (root == null) {
            return arr.length == 0;
        }
        return isValid(root, arr, 0);
    }

    private boolean isValid(TreeNode root, int[] arr, int idx) {
        if (root.val != arr[idx]) {
            return false;
        }

        if (idx == arr.length - 1) {
            return root.left == null && root.right == null;
        }

        return (root.left != null && isValid(root.left, arr, idx + 1))
                || (root.right != null && isValid(root.right, arr, idx + 1));
    }
}
