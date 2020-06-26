129. Sum Root to Leaf Numbers [M]
https://leetcode.com/problems/sum-root-to-leaf-numbers/

/* Solution 1: Using Preorder traversal.

TC: O(N), where N is number of nodes in the tree.
SC: O(H), where H is the height of tree. Due to recursive call stack.
*/

class Solution {
    int totalSum = 0;

    public int sumNumbers(TreeNode root) {
        preorder(root, 0);
        return totalSum;
    }

    private void preorder(TreeNode node, int curSum) {
        if (node == null) {
            return;
        }
        curSum = curSum * 10 + node.val;

        //Leaf node, then add curSum to totalSum.
        if (node.left == null && node.right == null) {
            totalSum += curSum;
        }
        preorder(node.left, curSum);
        preorder(node.right, curSum);
    }
}
