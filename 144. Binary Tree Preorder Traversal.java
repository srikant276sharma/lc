144. Binary Tree Preorder Traversal
https://leetcode.com/problems/binary-tree-preorder-traversal/

/*
Preorder traversal: NLR.
*/

/*Solution 1: Recursive approach. */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    private void helper(TreeNode root, List<Integer> res) {
        if (root != null) {
            res.add(root.val);
            helper(root.left, res);
            helper(root.right, res);
        }
    }
}

/*Solution 2: Iterative approach. 
break; is very critical.
root has to be null and stack has to be empty to break out of the while loop.
*/

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (true) {
            if (root != null) {
                res.add(root.val);
                stack.push(root); /*stack will help while processing right node. */
                root = root.left;
            } else {
                if (stack.isEmpty()) {
                    break;
                }
                root = stack.pop(); /*process the node before going to right node. */
                root = root.right;
            }
        }
        return res;
    }
}

--
Complexity Analysis:
Time complexity : O(n) where n is the no. of nodes.
Space complexity : It depends on the size of stack. In worst case, size of stack will be the height of Binary tree. 
O(h) where h is the height of Binary tree.
--
