938. Range Sum of BST
https://leetcode.com/problems/range-sum-of-bst/

/*
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
Inorder traversal of BST returns elements in increasing order.
While traversal, add all those elements which fall in between L and R.
*/

class Solution {
    public int rangeSumBST(TreeNode root, int L, int R) {
        int sum = 0;
        Stack<TreeNode> stack = new Stack<>();

        while (true) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                if (stack.isEmpty()) {
                    break;
                }
                root = stack.pop();
                /*Node processing.*/
                if (L <= root.val) {
                    sum += root.val;
                    if (R == root.val) {
                        break;
                    }
                }
                root = root.right;
            }
        }
        return sum;
    }
}
--
/*Solution 2: Iterative approach. 
BFS
*/

class Solution {
    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            root = queue.poll();
            if (root.val >= L && root.val <= R) {
                sum += root.val;
            }
            if (root.val > L && root.left != null) {
                queue.add(root.left);
            }
            if (root.val < R && root.right != null) {
                queue.add(root.right);
            }
        }
        return sum;
    }
}

--
Complexity Analysis:
Time complexity : O(n) where n is the no. of nodes.
Space complexity : It depends on the size of stack. In worst case, size of stack will be the height of Binary tree. 
O(h) where h is the height of Binary tree.
--
Asked by: Amazon, Facebook, Microsoft and Apple.
--
