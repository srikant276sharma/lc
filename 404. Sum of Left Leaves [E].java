404. Sum of Left Leaves [E]
https://leetcode.com/problems/sum-of-left-leaves/

/* Solution 2: Using Queue.

TC: O(n), where n = number of nodes.
SC: O(n). 
*/

class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int result = 0;

        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur.left != null) {
                queue.add(cur.left);
                //if left node is a leaf node then add its value.
                if (cur.left.left == null && cur.left.right == null) {
                    result += cur.left.val;
                }
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }

        return result;
    }
}

/*Solution 1: 
  Using PreOrder Traversal.
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
    public int sumOfLeftLeaves(TreeNode root) {
        return helper(root);
    }

    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int sum = 0;
        /*Check if the current node has a left leaf node. */
        if (root.left != null && root.left.left == null && root.left.right == null) {
            sum += root.left.val;
        }
        sum += helper(root.left);
        sum += helper(root.right);
        return sum;
    }
}
