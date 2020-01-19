101. Symmetric Tree
https://leetcode.com/problems/symmetric-tree/

--Solution: 1 : 
/*
* What we are interested in?
* > Pair comparison.
* So the recursive function will take a pair of values.
* Then decide what pairs we need to compare.
*
* leftSub.left == rightSub.right AND
* leftSub.right == rightSub.left
* */


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
    public boolean isSymmetric(TreeNode root) {
        return (root == null || (symCheck(root.left, root.right)));
    }

    private boolean symCheck(TreeNode leftSub, TreeNode rightSub) {
        if (leftSub == null && rightSub == null) {
            return true;
        } else if (leftSub == null || rightSub == null) {
            return false;
        }
        return (leftSub.val == rightSub.val
                && symCheck(leftSub.left, rightSub.right)
                && symCheck(leftSub.right, rightSub.left));
    }
}

--
Runtime: 0 ms, faster than 100.00% of Java online submissions for Symmetric Tree.
Memory Usage: 40.4 MB, less than 5.44% of Java online submissions for Symmetric Tree.
--
Complexity Analysis
Time complexity : O(n). 
Because we traverse the entire input tree once, the total run time is O(n), where nnn is the total number of nodes in the tree.

Space complexity : The number of recursive calls is bound by the height of the tree. 
In the worst case, the tree is linear and the height is in O(n). 
Therefore, space complexity due to recursive calls on the stack is O(n) in the worst case. 
--
