155. Min Stack [E]
https://leetcode.com/problems/min-stack/

--Solution 1:
/**
Assumptions:
Since problem statement isn't clear on what to do when our stack is empty, we have to make the following assumptions:
1. top() will never be called on an empty stack
2. getMin() will never be called on an empty stack
*/
--
class MinStack {
    Stack<Integer> primary, minStack;

    /* initialize your data structure here. */
    public MinStack() {
        primary = new Stack<>();
        minStack = new Stack<>();
    }

    /* Always push onto primary. If it's a minimum, also push it onto minStack. */
    public void push(int x) {
        primary.push(x);
        /* <= will handle duplicate min entry. */
        if (minStack.isEmpty() || x <= getMin()) {
            minStack.push(x);
        }
    }

    /* Pop off primary. If we popped a minimum, we remove it from minStack also. */
    public void pop() {
        int x = primary.pop();
        if (x == getMin()) {
            minStack.pop();
        }
    }

    public int top() {
        return primary.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

--
Time Complexity: O(1) for push(), pop(), top(), and getMin().
Space Complexity: O(n) to store n Integers.
--
