210. Course Schedule II [M]
https://leetcode.com/problems/course-schedule-ii/

/*Solution 1: Using Graph, Adjacency List, DFS.
KC: https://www.youtube.com/watch?v=_BGK0kpE4oE

TC: O(n), where n is number of courses.
SC: O(n).
*/

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] adjList = new ArrayList[numCourses];

        for (int i = 0; i < numCourses; i++) {
            adjList[i] = new ArrayList<>();
        }

        //making adjacency list.
        for (int[] pre : prerequisites) {
            adjList[pre[1]].add(pre[0]);
        }

        int[] visited = new int[numCourses]; //0: not visited, 1: being visited, 2: visited.
        List<Integer> order = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0 && hasCycle(adjList, visited, order, i)) {
                return new int[0]; //empty array.
            }
        }

        Collections.reverse(order);
        return order.stream().mapToInt(Integer::intValue).toArray();
    }

    private boolean hasCycle(List<Integer>[] adjList, int[] visited, List<Integer> order, int course) {
        if (visited[course] == 1) {
            return true; //there is a back edge pointing to a node which is being visited '1' that means there is a cycle.
        } else if (visited[course] == 2) {
            return false; //if node is already explored then there is no need to explore it's adjacent nodes.
        }

        visited[course] = 1; //mark current node as being visited.
        //explore all adjacent nodes.
        for (int adj : adjList[course]) {
            if (hasCycle(adjList, visited, order, adj)) {
                return true;
            }
        }

        visited[course] = 2; //after exploring all adjacent nodes mark the node as Visited.
        order.add(course); //add the visited order. Remember to reverse it.
        return false;
    }
}
