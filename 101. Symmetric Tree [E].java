101. Symmetric Tree [E]
https://leetcode.com/problems/symmetric-tree/

/*
* What we are interested in?
* > Pair comparison.
* So the recursive function will take a pair of values.
* Then decide what pairs we need to compare.
*
* leftSub.left == rightSub.right AND
* leftSub.right == rightSub.left
* */

/* Solution 1: Using Recursion.

TC: O(n), where n is total nodes in the tree. Since, we visit each node once.
SC: O(n). O(log n) for a Balanced tree. O(n), worst case scenario. Because of recursive call stack.
*/

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSym(root.left, root.right);
    }

    private boolean isSym(TreeNode leftSub, TreeNode rightSub) {
        if (leftSub == null && rightSub == null) {
            return true;
        } else if (leftSub == null || rightSub == null) {
            return false;
        } else {
            return (leftSub.val == rightSub.val
                    && isSym(leftSub.left, rightSub.right)
                    && isSym(leftSub.right, rightSub.left));
        }
    }
}

/* Solution 2: Using Iteration.

TC: O(n), where n is total nodes in the tree. Since, we visit each node once.
SC: O(n). There is additional space required for the search queue.
*/

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);  //Remember.
        queue.add(root.right); //Remember.

        while (!queue.isEmpty()) {
            TreeNode leftSub = queue.poll();  //Remember.
            TreeNode rightSub = queue.poll(); //Remember.
            if (leftSub == null && rightSub == null) {
                continue; //Remember.
            } else if (leftSub == null || rightSub == null) {
                return false;
            } else if (leftSub.val != rightSub.val) {
                return false;
            }
            queue.add(leftSub.left);
            queue.add(rightSub.right);
            
            queue.add(leftSub.right);
            queue.add(rightSub.left);
        }

        return true;
    }
}

