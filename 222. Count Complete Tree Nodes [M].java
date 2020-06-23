222. Count Complete Tree Nodes [M]
https://leetcode.com/problems/count-complete-tree-nodes/

/* Solution 1: Using BFS.

TC: O(n), where n is the number of nodes in the tree.
SC: O(h), where h is the height of the tree.
*/

class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int count = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            count++;
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }

        return count;
    }
}

/* Solution 2: Using (Total nodes = 2^Height of Complete Binary Tree - 1).

TC: O(n), where n is the number of nodes in the tree.
SC: O(1).
*/

class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftH = 0, rightH = 0;
        //calculate left hight.
        TreeNode cur = root;
        while (cur != null) {
            leftH++;
            cur = cur.left;
        }
        //calculate right hight.
        cur = root;
        while (cur != null) {
            rightH++;
            cur = cur.right;
        }

        if (leftH == rightH) {
            return (1 << leftH) - 1; //total nodes = 2^leftH - 1.
        }

        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
