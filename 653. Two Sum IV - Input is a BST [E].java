653. Two Sum IV - Input is a BST [E]
https://leetcode.com/problems/two-sum-iv-input-is-a-bst/

/* Solution 1: Using BFS and Queue.

TC: O(N), We need to traverse over the whole tree once in the worst case. Here, N refers to the number of nodes in the given tree.
SC: O(N), The size of the set can grow atmost upto N.

Asked by:
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
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }

        Set<Integer> nums = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (nums.contains(k - node.val)) {
                return true;
            } else {
                nums.add(node.val);
            }
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }

        return false;
    }
}
