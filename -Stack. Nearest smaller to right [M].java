Nearest smaller to right [M]

/* Solution 1: Type: Stack.
Aditya: https://www.youtube.com/watch?v=nc1AYFyvOR4&list=PL_z_8CaSLPWdeOezg68SKkeLN4-T_jNHd&index=5

TC: O(n).
SC: O(n).
*/

class GFG {
    public static void main (String[] args) {
        int[] nums = new int[]{4, 8, 5, 2, 25};
        System.out.println(Arrays.toString(nearestSmallerToRight(nums))); //output: [2, 5, 2, -1, -1]
    }
    //Nearest Smaller to Right.
    private static int[] nearestSmallerToRight(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        //traverse from right to left.
        for (int i = n - 1; i >= 0; i--) {
            if (stack.isEmpty()) { //if stack is empty, set -1.
                res[i] = -1;
            } else if (stack.peek() < nums[i]) { //if peek < cur element, set peek.
                res[i] = stack.peek();
            } else {
                //pop until either stack becomes empty or peek < cur element.
                while (stack.size() > 0 && stack.peek() >= nums[i]) {
                    stack.pop();
                }
                res[i] = stack.isEmpty() ? -1 : stack.peek();
            }
            stack.push(nums[i]); //push cur element to stack.
        }
        return res;
    }
}
