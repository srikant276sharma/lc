145. Binary Tree Postorder Traversal
https://leetcode.com/problems/binary-tree-postorder-traversal/

/*
Postorder traversal: LRN.
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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    private void helper(TreeNode root, List<Integer> res) {
        if (root != null) {
            helper(root.left, res);
            helper(root.right, res);
            res.add(root.val);
        }
    }
}

/*Solution 2: Iterative approach. 
*/

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        Set<TreeNode> visited = new HashSet<>();
        stack.push(root);
        
        while (!stack.isEmpty()) {
            TreeNode cur = stack.peek();
            if (cur.left != null && !visited.contains(cur.left)) {
                stack.push(cur.left);
            } else if (cur.right != null && !visited.contains(cur.right)) {
                stack.push(cur.right);
            } else {
                visited.add(cur);
                res.add(stack.pop().val);
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
