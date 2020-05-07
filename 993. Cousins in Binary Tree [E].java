993. Cousins in Binary Tree [E]
https://leetcode.com/problems/cousins-in-binary-tree/

/* Solution 1: Using Breadth First Search.

Time complexity: O(n), where n is the number of nodes in the tree.
Space complexity: O(n), where n is the number of nodes in the tree.

Asked by:

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
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) {
            return false;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int count = 0, levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                //If x and y exist at the same level, then count will be 2.
                if (node.val == x || node.val == y) {
                    count++;
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                //Check if x and y have same Parent.
                if (node.left != null && node.right != null
                        && ((node.left.val == x && node.right.val == y) || (node.left.val == y && node.right.val == x))) {
                    return false;
                }
            }

            if (count == 2) {
                return true;
            }
        }

        return false;
    }
}
