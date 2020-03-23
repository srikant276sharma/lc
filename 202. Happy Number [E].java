202. Happy Number [E]
https://leetcode.com/problems/happy-number/

/*Solution 1.
Using HashSet.
https://www.youtube.com/watch?v=gW4hSbRoQoY
*/

class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> seen = new HashSet<>();
        int current, sum;

        while (n != 1) {
            current = n;
            sum = 0;
            while (current != 0) {
                sum += (current % 10) * (current % 10);
                current /= 10;
            }

            if (seen.contains(sum)) {
                return false;
            } else {
                seen.add(sum);
                n = sum;
            }
        }

        return true;
    }
}

--
Time Complexity: O(N), where N is number of iterated elements.
Space Complexity: O(N) where N is number of elements in HashSet.
--

/*Solution 2.
Using Linked List concept.
https://www.youtube.com/watch?v=yrdX4z7mIxo
*/

class Solution {
    public boolean isHappy(int n) {
        int slow = n, fast = n;

        do {
            slow = squaredSum(slow);
            fast = squaredSum(fast);
            fast = squaredSum(fast);
        } while (slow != fast); /*when slow == fast, then there is a cycle. */

        return slow == 1;
    }

    private int squaredSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += (n % 10) * (n % 10);
            n /= 10;
        }
        return sum;
    }
}

--
Time Complexity: O(N), where N is number of iterated elements.
Space Complexity: O(1).
--
Asked by: Google, Facebook, Apple, JPMorgan, VMWare, Nutanix.
--
