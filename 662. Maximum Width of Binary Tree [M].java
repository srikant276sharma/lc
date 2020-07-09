662. Maximum Width of Binary Tree [M]
https://leetcode.com/problems/maximum-width-of-binary-tree/

/* Solution 1: Using BFS. 
Storing TreeNode and Index as a pair in the Queue.
For any level of the tree, max width is the difference between startIndex and endIndex, plus 1.

KC: https://www.youtube.com/watch?v=le-ZZSQRebw&t=95s

TC: O(n), where n is the number of nodes in the tree. As we are visiting each node of the tree.
SC: O(n), because of queue.
*/

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.add(new Pair(root, 0)); //starting with 0 based index.
        int maxWidth = 0;

        while (!queue.isEmpty()) {
            int levelSize = queue.size(), startIndex = queue.peek().getValue();
            Pair<TreeNode, Integer> pair = null;
            TreeNode treeNode = null;

            for (int i = 0; i < levelSize; i++) {
                pair = queue.poll();
                treeNode = pair.getKey();
                if (treeNode.left != null) {
                    queue.add(new Pair(treeNode.left, 2 * pair.getValue() + 1)); //left child index = 2 * parent index + 1.
                }
                if (treeNode.right != null) {
                    queue.add(new Pair(treeNode.right, 2 * pair.getValue() + 2)); //right child index = 2 * parent index + 2.
                }
            }

            int endIndex = pair.getValue();
            maxWidth = Math.max(maxWidth, endIndex - startIndex + 1);
        }

        return maxWidth;
    }
}
