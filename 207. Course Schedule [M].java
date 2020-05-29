207. Course Schedule [M]
https://leetcode.com/problems/course-schedule/

/* Solution 1: Using Adjacency List and dfs.
Knowledge Center: https://www.youtube.com/watch?v=iaaObeAEgxI

Time complexity: O(n).
Space complexity: O(n).

Asked by:
*/

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] adjacencyList = new ArrayList[numCourses];

        for (int i = 0; i < numCourses; i++) {
            adjacencyList[i] = new ArrayList<>();
        }
        for (int[] prerequisite : prerequisites) {
            adjacencyList[prerequisite[0]].add(prerequisite[1]); //making adjacency list.
        }

        int[] visited = new int[numCourses]; //0: Unvisited, 1: Being Visited, 2: Explored.

        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0 && !dfs(adjacencyList, visited, i)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(ArrayList<Integer>[] adjacencyList, int[] visited, int i) {
        if (visited[i] == 1) {
            return false; //there is a back edge pointing to a node which is being visited '1' that means there is a cycle.
        } else if (visited[i] == 2) {
            return true; //if node is already explored then there is no need to explore it's adjacent nodes.
        }
        visited[i] = 1; //mark current node as being visited.
        //explore all adjacent nodes.
        for (int adjNode : adjacencyList[i]) {
            if (!dfs(adjacencyList, visited, adjNode)) {
                return false;
            }
        }

        visited[i] = 2; //after exploring all adjacent nodes mark the node as Explored.
        return true;
    }
}
