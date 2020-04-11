543. Diameter of Binary Tree [E]
https://leetcode.com/problems/diameter-of-binary-tree/

/* Solution 1:
 * At any node, Height is Maximum of (Left and Right subtree's height) + 1,
 * and Diameter is Sum of (Left and Right subtree's height).
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
    public int diameterOfBinaryTree(TreeNode root) {
        int[] maxDiameter = new int[1];
        height(root, maxDiameter);
        return maxDiameter[0];
    }

    public int height(TreeNode node, int[] maxDiameter) {
        if (node == null) {
            return 0;
        }
        int lh = height(node.left, maxDiameter);
        int rh = height(node.right, maxDiameter);
        maxDiameter[0] = Math.max(maxDiameter[0], lh + rh); /*Diameter: Sum of (Left and Right subtree's height). */
        return Math.max(lh, rh) + 1; /*Height: Max of (Left and Right subtree's height) + 1. */
    }
}

--
Time Complexity: O(N), We visit every node once, where N is number of nodes in the tree.
Space Complexity: O(N), the size of our implicit call stack during our depth-first search.
--

/* Solution 2:
Using Height and Diameter Recursive approach.
Coding Ninja: 
O(N*H): https://www.youtube.com/watch?v=rrXAISjtbAA
O(N): https://www.youtube.com/watch?v=fuPqnDs1HMw
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
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int option1 = height(root.left) + height(root.right); /*Height of Left subtree + Height of Right subtree. */
        int option2 = diameterOfBinaryTree(root.left); /*Diameter of Left subtree. */
        int option3 = diameterOfBinaryTree(root.right); /*Diameter of Right subtree. */

        return Math.max(option1, Math.max(option2, option3)); /*Max of all 3 options. */
    }

    /*Height of tree. */
    private int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int lh = height(node.left);
        int rh = height(node.right);
        return Math.max(lh, rh) + 1;
    }
}

--
Time Complexity: O(N * H), where N is number of nodes in the tree and H is height of tree.
Space Complexity: O(N).
--
Asked by:
--
