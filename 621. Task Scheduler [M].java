621. Task Scheduler [M]
https://leetcode.com/problems/task-scheduler/

/*Solution 1: Using Greedy approach.

TC: O(Ntotal), where Ntotal is a number of tasks to execute. 
This time is needed to iterate over the input array tasks and compute the array frequencies. 
Array frequencies contains 26 elements, and hence all operations with it takes constant time.

SC: O(1), to keep the array frequencies of 26 elements.
*/

class Solution {
    public int leastInterval(char[] tasks, int n) {
        //frequencies of the tasks.
        int[] freq = new int[26];
        for (char t : tasks) {
            freq[t - 'A']++;
        }

        Arrays.sort(freq);
        //max frequency.
        int maxFreq = freq[25];
        int idleTime = (maxFreq - 1) * n; //number of idle slots * n.

        for (int i = freq.length - 2; i >= 0 && idleTime > 0; i--) {
            idleTime -= Math.min(maxFreq - 1, freq[i]); //'maxFreq - 1' is idle slot count.
        }

        return tasks.length + Math.max(0, idleTime);
    }
}
