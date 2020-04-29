124. Binary Tree Maximum Path Sum [H]
https://leetcode.com/problems/binary-tree-maximum-path-sum/

/* Solution 1: Using Postorder traversal.
https://leetcode.com/problems/binary-tree-maximum-path-sum/discuss/39875/Elegant-Java-solution

Explanation:
The dfs() function goes from the bottom of the tree to the top, it's in post-order manner.

At every node, we need to make a decision, if the sum comes from the left path larger than the right path, 
we pick the left path and plus the current node's value, this recursion goes all the way up to the root node.

Time complexity: O(n), where n is number of nodes in the tree.
Space complexity: O(h), where h is height of the tree.
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int maxPthSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxPthSum;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = Math.max(dfs(node.left), 0); //Dealing with -ve values.
        int right = Math.max(dfs(node.right), 0);
        maxPthSum = Math.max(maxPthSum, node.val + left + right); //While calculating Max, it considers node, left and right values.

        return node.val + Math.max(left, right); //Returns "Current node's value + Max between left and right branch".
    }
}
