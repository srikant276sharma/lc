102. Binary Tree Level Order Traversal
https://leetcode.com/problems/binary-tree-level-order-traversal/

--Solution: 1 : 
/* The video to explain this code is here: https://www.youtube.com/watch?v=gcR28Hc2TNQ */

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        /* The list to hold the level by level layers of the tree */
        List<List<Integer>> levelsList = new ArrayList<>();
        /* Our queue to enforce a traversal in a breadth-first manner */
        Queue<TreeNode> queue = new LinkedList<>();
        /* Add the root node to start the breadth first search */
        queue.offer(root);
        /* We will continue the breadth first search as long as there are nodes to process.
           We do not need a hashtable to track nodes already visited since a tree is an acyclic connected graph.
           Each iteration will process a layer of the tree. */
        while (!queue.isEmpty()) {
            /* The list to hold all the node's values in the layer we are about to process */
            List<Integer> currentLayer = new ArrayList<>();
            /* We will get the size of the layer in the queue that we need to process so that we know how many nodes our for loop needs to process */
            int layerSize = queue.size();

            for (int i = 0; i < layerSize; i++) {
                /* Remove the nodes so that we can process it */
                TreeNode currentNode = queue.poll();
                /* Add the node's value to the current layer list */
                currentLayer.add(currentNode.val);
                /* If this node has a left add it to be processed for the next layer */
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                /* If this node has a right add it to be processed for the next layer */
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
            /* Notice how currentLayer is a new list on each iteration of the while loop. We do not need to worry about deep copying anything here. */
            levelsList.add(currentLayer);
        }
        return levelsList;
    }
}

--
Runtime: 1 ms, faster than 76.91% of Java online submissions for Binary Tree Level Order Traversal.
Memory Usage: 42.6 MB, less than 5.33% of Java online submissions for Binary Tree Level Order Traversal.
--
Time Complexity: O(n).
Space Complexity: O(n).
--
