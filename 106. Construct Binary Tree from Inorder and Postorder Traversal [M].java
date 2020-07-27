106. Construct Binary Tree from Inorder and Postorder Traversal [M]
https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/

/*Solution 1: Using Recursion and Map.
KC: https://www.youtube.com/watch?v=bw0o6v1lQYs

TC: O(n), where n is the length of input array.
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
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int len = inorder.length;
        if (len == 0) {
            return null;
        }
        for (int i = 0; i < len; i++) {
            map.put(inorder[i], i); //map will be used to find root index in inorder data.
        }
        return helper(0, len, postorder, 0, len);
    }

    private TreeNode helper(int iSt, int iEnd, int[] postorder, int pSt, int pEnd) {
        if (iSt >= iEnd || pSt >= pEnd) {
            return null;
        }

        int rootVal = postorder[pEnd - 1];
        TreeNode root = new TreeNode(rootVal);
        int diff = map.get(rootVal) - iSt; //distance between root index and start index in inorder.

        root.left = helper(iSt, iSt + diff, postorder, pSt, pSt + diff);
        root.right = helper(iSt + diff + 1, iEnd, postorder, pSt + diff, pEnd - 1);
        return root;
    }
}
