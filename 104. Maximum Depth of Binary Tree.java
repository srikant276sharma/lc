104. Maximum Depth of Binary Tree
https://leetcode.com/problems/maximum-depth-of-binary-tree/

--Solution: 1 : Post Order Traversal approach.
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
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftH = maxDepth(root.left);
            int rightH = maxDepth(root.right);
            return Math.max(leftH, rightH) + 1;
        }
    }
}
--
Runtime: 0 ms, faster than 100.00% of Java online submissions for Maximum Depth of Binary Tree.
Memory Usage: 43.3 MB, less than 5.38% of Java online submissions for Maximum Depth of Binary Tree.
--
