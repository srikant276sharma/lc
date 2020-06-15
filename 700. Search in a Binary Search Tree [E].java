700. Search in a Binary Search Tree [E]
https://leetcode.com/problems/search-in-a-binary-search-tree/

/* Solution 1: Using Iteration.
KC: https://www.youtube.com/watch?v=_E8JssPY1N4

TC: O(H), where H is the height of tree. That results in O(log⁡N) in the average case, and O(N) in the worst case.
SC: O(1).

Asked by:
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode node = root;

        while (node != null) {
            if (val == node.val) {
                return node;
            } else if (val < node.val) {
                node = node.left;
            } else {
                node = node.right;
            }
        }

        return node;
    }
}

/* Solution 2: Using Recursion.

TC: O(H), where H is the height of tree. That results in O(log⁡N) in the average case, and O(N) in the worst case.
SC: O(H) to keep the recursion stack, i.e. O(log⁡N) in the average case, and O(N) in the worst case.
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
