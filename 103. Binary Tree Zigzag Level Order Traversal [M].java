103. Binary Tree Zigzag Level Order Traversal [M]
https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/

/* Solution 1: Using 2 Stacks. One for left to right processing and the other one for right to left processing.
Amell: https://www.youtube.com/watch?v=smjr2ow6oKc
Tushar: https://www.youtube.com/watch?v=vjt5Y6-1KsQ
Vivekanand: https://www.youtube.com/watch?v=YsLko6sSKh8

TC: O(n).
SC: O(n).
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack1 = new Stack<>(); //left to right processing.
        Stack<TreeNode> stack2 = new Stack<>(); //right to left processing.
        stack1.push(root);
        List<Integer> levelList = new ArrayList<>(); //level list.
        TreeNode node;

        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                node = stack1.pop();
                levelList.add(node.val); //process node.
                //first process left and then right so that in the next level, right can come first.
                if (node.left != null) {
                    stack2.push(node.left);
                }
                if (node.right != null) {
                    stack2.push(node.right);
                }
            }
            if (!levelList.isEmpty()) {
                res.add(new ArrayList<>(levelList));
                levelList.clear();
            }

            while (!stack2.isEmpty()) {
                node = stack2.pop();
                levelList.add(node.val); //process node.
                //first process right and then left so that in the next level, left can come first.
                if (node.right != null) {
                    stack1.push(node.right);
                }
                if (node.left != null) {
                    stack1.push(node.left);
                }
            }
            if (!levelList.isEmpty()) {
                res.add(new ArrayList<>(levelList));
                levelList.clear();
            }
        }

        return res;
    }
}
