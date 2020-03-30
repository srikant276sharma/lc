100. Same Tree [E]
https://leetcode.com/problems/same-tree/
Kevin: https://www.youtube.com/watch?v=sheA4rbbDlQ

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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        } else if (p.val != q.val) {
            return false;
        } else {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }
}

--
Time complexity:  O(n), where n is number of nodes in the Tree.
Space complexity: O(n).
--
Asked by: Google, Amazon, Apple.
--
