Nearest greater to left [M]

/* Solution 1: Type: Stack.
Aditya: https://www.youtube.com/watch?v=T5s96ynzArg&list=PL_z_8CaSLPWdeOezg68SKkeLN4-T_jNHd&index=3

TC: O(n).
SC: O(n).
*/

class GFG {
    public static void main (String[] args) {
        int[] nums = new int[]{1, 10, 5, 13, 6};
        System.out.println(Arrays.toString(nearestGreaterToLeft(nums))); //output: [-1, -1, 10, -1, 13]
    }

    private static int[] nearestGreaterToLeft(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            if (stack.isEmpty()) {
                res[i] = -1;
            } else if (stack.peek() > nums[i]) {
                res[i] = stack.peek();
            } else {
                while (stack.size() > 0 && stack.peek() <= nums[i]) {
                    stack.pop();
                }
                res[i] = stack.isEmpty() ? -1 : stack.peek();
            }
            stack.push(nums[i]);
        }
        return res;
    }
}
