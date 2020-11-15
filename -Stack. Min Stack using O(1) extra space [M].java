Min Stack using O(1) extra space [M]

/* Solution 1: Type: Stack.
https://practice.geeksforgeeks.org/problems/get-minimum-element-from-stack/1#

Aditya: https://www.youtube.com/watch?v=ZvaRHYYI0-4&list=PL_z_8CaSLPWdeOezg68SKkeLN4-T_jNHd&index=11

TC: O(1).
SC: O(1).
*/

class GfG {
    int minEle = 0;
    Stack<Integer> s = new Stack<>();

    /*returns min element from stack*/
    int getMin() {
        return (s.size() == 0) ? -1 : minEle;
    }
    
    /*returns poped element from stack*/
    int pop() {
        if (s.size() == 0) {
            return -1;
        } else if (s.peek() >= minEle) { //s.peek() = 7, minEle = 3
            return s.pop();
        } else { //s.peek() = 1, minEle = 3
            int popped = minEle;
            minEle = 2 * minEle - s.pop(); //set new ME using 2*ME - s.peek().
            return popped;
        }
    }

    /*push element x into the stack*/
    void push(int x) {
        if (s.size() == 0) { //x = 5 and stack is empty.
            s.push(x);
            minEle = x;
        } else if (x >= minEle) { //x = 7, minEle = 5
            s.push(x);
        } else { //x = 3, minEle = 5
            s.push(2 * x - minEle); //push a special value using, 2x - ME.
            minEle = x; //set new ME.
        }
    }
}
