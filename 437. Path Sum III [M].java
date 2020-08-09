437. Path Sum III [M]
https://leetcode.com/problems/path-sum-iii/

/* Solution 1:

TC: O(n), where n is a number of nodes. During preorder traversal, each node is visited once.
SC: O(n), up to O(n) to keep the hashmap of prefix sums, where n is a number of nodes.
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
    int k = 0, count = 0;
    HashMap<Integer, Integer> map = new HashMap<>();

    public int pathSum(TreeNode root, int sum) {
        k = sum;
        preorder(root, 0);
        return count;
    }

    private void preorder(TreeNode node, int currentSum) {
        if (node == null) {
            return;
        }
        currentSum += node.val; // current prefix sum.
        if (currentSum == k) { // here is the sum we're looking for.
            count++;
        }
        // number of times the curr_sum − k has occured already.
        if (map.containsKey(currentSum - k)) {
            count += map.get(currentSum - k);
        }
        // add the current sum into hashmap to use it during the child nodes processing.
        map.put(currentSum, map.getOrDefault(currentSum, 0) + 1);
        preorder(node.left, currentSum); // process left subtree.
        preorder(node.right, currentSum); // process right subtree.
        // remove the current sum from the hashmap in order not to use it during the parallel subtree processing.
        map.put(currentSum, map.get(currentSum) - 1);
    }
}
