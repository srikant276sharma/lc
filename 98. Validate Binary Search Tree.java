98. Validate Binary Search Tree
https://leetcode.com/problems/validate-binary-search-tree/

--Solution: 1 : 
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
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode node, long min, long max) {
        if (node == null) {
            return true;
        } else if (node.val <= min || node.val >= max) {
            return false;
        }
        return isValidBST(node.left, min, node.val) && isValidBST(node.right, node.val, max);
    }
}
--
Runtime: 0 ms, faster than 100.00% of Java online submissions for Validate Binary Search Tree.
Memory Usage: 44.9 MB, less than 5.58% of Java online submissions for Validate Binary Search Tree.
--
Time Complexity: O(n)
Space Complexity: O(log n) if balanced tree. O(n) if not balanced.

--Solution 2: InOrder Traversal of BST returns sorted elements.

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
    ArrayList<Integer> valList = new ArrayList();

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        helper(root);
        if (valList.size() > 1) {
            for (int i = 1; i < valList.size(); i++) {
                if (valList.get(i - 1) >= valList.get(i)) {
                    return false;
                }
            }
        }
        return true;
    }

    /*InOrder Traversal of BST returns sorted elements.*/
    public void helper(TreeNode node) {
        if (node == null) {
            return;
        }
        helper(node.left);
        valList.add(node.val);
        helper(node.right);
    }
}
--
Runtime: 1 ms, faster than 32.65% of Java online submissions for Validate Binary Search Tree.
Memory Usage: 47.4 MB, less than 5.58% of Java online submissions for Validate Binary Search Tree.
--
