199. Binary Tree Right Side View [M]
https://leetcode.com/problems/binary-tree-right-side-view/

/* Solution 1: Using BFS.
Amell: https://www.youtube.com/watch?v=ARhIumRrgYM

TC: O(N), where N = number of nodes in the tree.
SC: O(H), H = height of the tree, because of recursive call stack.
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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        //input check.
        if (root == null) {
            return res;
        }
        //level order traversal + while processing any node, process right child first then left child.
        Queue<TreeNode> queue = new LinkedList<>();
        //add initial node.
        queue.add(root);
        
        while (!queue.isEmpty()) {
            res.add(queue.peek().val);
            //child processing.
            int levelSize = queue.size();
            
            for (int i = 0; i < levelSize; i++) {
                TreeNode cur = queue.poll();
                //process right child first and then left child.
                if (cur.right != null) {
                    queue.add(cur.right);
                }
                if (cur.left != null) {
                    queue.add(cur.left);
                }
            }
        }
        return res;
    }
}

