230. Kth Smallest Element in a BST
https://leetcode.com/problems/kth-smallest-element-in-a-bst/

/*
Inorder traversal: LNR.
*/

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

/*Solution 1: Iterative approach. 
*/

class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        int visitedCounter = 0;
        while (true) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                if (stack.isEmpty()) {
                    break;
                }
                root = stack.pop();
                visitedCounter++;
                if (visitedCounter == k) {
                    return root.val;
                }
                root = root.right;
            }
        }
        return 0;
    }
}

--
Complexity Analysis:
Time complexity : O(n) where n is the no. of nodes.
Space complexity : It depends on the size of stack. In worst case, size of stack will be the height of Binary tree. 
O(h) where h is the height of Binary tree.
--
Runtime: 0 ms, faster than 100.00% of Java online submissions for Kth Smallest Element in a BST.
Memory Usage: 41.2 MB, less than 5.51% of Java online submissions for Kth Smallest Element in a BST.
--
Asked by: Facebook, Uber, Microsoft, Oracle, TripleByte.
--
