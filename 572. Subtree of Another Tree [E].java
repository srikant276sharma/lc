572. Subtree of Another Tree [E]
https://leetcode.com/problems/subtree-of-another-tree/

/* Solution 1:
Kevin: https://www.youtube.com/watch?v=HdMs2Fl_I-Q&t=310s
*/

class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null)
            return false;
        else if (isSameTree(s, t))
            return true;
        else
            return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private boolean isSameTree(TreeNode s, TreeNode t) {
        if (s == null || t == null)
            return s == null && t == null;
        else if (s.val == t.val)
            return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
        else
            return false;
    }
}

--
Complexities: Considering m is the number of nodes in 's' and n is the number of nodes in 't'.
Time: O(m * n), because for every single node in s, we are gonna make n comparisons at max.
Space: O(Min(m, n)), the limiting factor of how deep our recursion goes is gonna be which ever tree has less nodes.
--
Asked by: Amazon, Microsoft.
--
