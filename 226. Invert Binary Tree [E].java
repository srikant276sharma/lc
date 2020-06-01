226. Invert Binary Tree [E]
https://leetcode.com/problems/invert-binary-tree/

/* Solution 1: Using Recursion. For each node, swap left and right nodes. 

Time complexity: O(n), Since each node in the tree is visited only once, the time complexity is O(n), 
                 where n is the number of nodes in the tree. We cannot do better than that, since at the very least we have to visit each node to invert it.
Space complexity: O(h), Because of recursion, O(h) function calls will be placed on the stack in the worst case, 
                  where h is the height of the tree. Because h∈O(n), the space complexity is O(n).

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
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}

/*Solution 2: Using BFS. 

TC: Since each node in the tree is visited only once, the time complexity is O(n), where n is the number of nodes in the tree.
SC: O(n), since in the worst case, the queue will contain all nodes in one level of the binary tree. 
    For a full binary tree, the leaf level has ⌈n/2⌉ = O(n) leaves.
*/

class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            TreeNode temp = current.left;
            current.left = current.right;
            current.right = temp;

            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }

        return root;
    }
}
