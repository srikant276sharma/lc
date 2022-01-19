class solve {
    public static long[] nextLargerElement(long[] arr, int n) {
        long[] res = new long[n];
        Stack<Long> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            if (stack.isEmpty()) { //stack is empty.
                res[i] = -1;
            } else if (stack.peek() > arr[i]) { //stack top is > cur element.
                res[i] = stack.peek();
            } else { //stack top is <= cur element.
                while (stack.size() > 0 && stack.peek() <= arr[i]) {
                    stack.pop();
                }
                if (stack.size() == 0) {
                    res[i] = -1;
                } else {
                    res[i] = stack.peek();
                }
            }
            //push cur element into stack.
            stack.push(arr[i]);
        }
        return res;
    }
}
