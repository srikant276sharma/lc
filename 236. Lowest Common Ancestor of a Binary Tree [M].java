236. Lowest Common Ancestor of a Binary Tree [M]
https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/

/* Solution 1:
Tushar: https://www.youtube.com/watch?v=13m9ZCB8gjw
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;

        if (root == p || root == q)
            return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        } else if (left == null && right == null) {
            return null;
        }

        return left != null ? left : right;
    }
}

--
Complexities: Considering n is number of nodes in the Binary tree.
Time: O(n).
Space: O(h), where h is height of Binary tree, because of recursive call stack.
--
Asked by: Facebook, Adobe, Microsoft, Amazon, Google.
--
