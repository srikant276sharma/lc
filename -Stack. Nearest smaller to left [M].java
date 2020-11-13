Nearest smaller to left [M]

/* Solution 1: Type: Stack.
Aditya: https://www.youtube.com/watch?v=85LWui3FlVk&list=PL_z_8CaSLPWdeOezg68SKkeLN4-T_jNHd&index=4

TC: O(n).
SC: O(n).
*/

class GFG {
    public static void main (String[] args) {
        int[] nums = new int[]{4, 5, 2, 10, 8};
        System.out.println(Arrays.toString(nearestSmallerToLeft(nums))); //output: [-1, 4, -1, 2, 2]
    }
    //Nearest Smaller to Left.
    private static int[] nearestSmallerToLeft(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            if (stack.isEmpty()) { //if stack is empty, set -1.
                res[i] = -1;
            } else if (stack.peek() < nums[i]) { //if peek < cur element, set peek.
                res[i] = stack.peek();
            } else { //pop until either stack becomes empty or peek < cur element.
                while (stack.size() > 0 && stack.peek() >= nums[i]) {
                    stack.pop();
                }
                res[i] = stack.isEmpty() ? -1 : stack.peek();
            }
            stack.push(nums[i]); //push cur element into stack.
        }
        return res;
    }
}
