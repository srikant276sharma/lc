700. Search in a Binary Search Tree
https://leetcode.com/problems/search-in-a-binary-search-tree/

--Solution 1:
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
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (val == root.val) {
            return root;
        }
        if (val < root.val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }
}

--
Time Complexity: O(log(n))
Space Complexity: ?.
--
Runtime: 0 ms, faster than 100.00% of Java online submissions for Search in a Binary Search Tree.
Memory Usage: 42 MB, less than 8.89% of Java online submissions for Search in a Binary Search Tree.
--
