1110. Delete Nodes And Return Forest [M]
https://leetcode.com/problems/delete-nodes-and-return-forest/

/* Solution 1: Using DFS.
Amell: https://www.youtube.com/watch?v=PZJj8pHz54M

TC: O(N + M), where N = number of nodes in the tree, M = length of to_delete array.
SC: O(N + H), H = height of the tree, because of recursive call stack.
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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        
        Set<Integer> toDelete = new HashSet<>();
        for (int d : to_delete) {
            toDelete.add(d);
        }
        
        removeNodes(root, toDelete, res);
        if (!toDelete.contains(root.val)) {
            res.add(root); //after post order traversal, if applicable add the root.
        }
        
        return res;
    }
    
    private TreeNode removeNodes(TreeNode root, Set<Integer> toDelete, List<TreeNode> res) {
        //base case.
        if (root == null) {
            return null;
        }
        
        root.left = removeNodes(root.left, toDelete, res);
        root.right = removeNodes(root.right, toDelete, res);
        
        if (toDelete.contains(root.val)) {
            if (root.left != null) {
                res.add(root.left);
            }
            if (root.right != null) {
                res.add(root.right);
            }
            
            return null;
        }
        return root;
    }
}
