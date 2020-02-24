257. Binary Tree Paths
https://leetcode.com/problems/binary-tree-paths/

/*
*/

/*Solution 1.
1. Inorder traversal of Binary tree: NLR.
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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        helper(root, "", paths);
        return paths;
    }

    private void helper(TreeNode root, String path, List<String> paths) {
        if (root == null) {
            return;
        }
        /*Node processing.*/
        path += root.val;
        if (root.left == null && root.right == null) {
            paths.add(path);
            return;
        }
        helper(root.left, path + "->", paths);
        helper(root.right, path + "->", paths);
    }
}

--
Time complexity: O(n) where n is the no. of nodes.
Space complexity: O(h) where h is the hight of Binary tree.
--
Asked by: Amazon, Facebook.
--
