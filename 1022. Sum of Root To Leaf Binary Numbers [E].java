1022. Sum of Root To Leaf Binary Numbers [E]
https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/

/* Solution 1: Using Preorder traversal.

TC: O(N), where N is number of nodes in tree.
SC: O(H), because of recursive call stack.
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
  int sum = 0;
  
  public int sumRootToLeaf(TreeNode root) {
    preorder(root, 0);
    return sum;
  }

  private void preorder(TreeNode node, int cur) {
    if (node == null) {
      return;
    }
    //add current node's value.
    cur = (cur << 1) + node.val;
    //if leaf node, then update sum.
    if (node.left == null && node.right == null) {
      sum += cur;
    }
    
    preorder(node.left, cur);
    preorder(node.right, cur);
  }
}
