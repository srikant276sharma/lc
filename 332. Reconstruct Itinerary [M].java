332. Reconstruct Itinerary [M]
https://leetcode.com/problems/reconstruct-itinerary/

/* Solution 1: Using Graph: Adjacency Map, Priority Queue and Linked List.
KC: https://www.youtube.com/watch?v=j31ZOupyrAs

TC: 
SC: 
*/

class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> adjacencyMap = new HashMap<>(); //Using PriorityQueue to get airports in lexicographically sorted order.

        for (List<String> ticket : tickets) {
            adjacencyMap.putIfAbsent(ticket.get(0), new PriorityQueue<>()); //Remember: putIfAbsent.
            adjacencyMap.get(ticket.get(0)).add(ticket.get(1));
        }

        LinkedList<String> result = new LinkedList<>(); //Using LinkedList so that after recursion, we can add the airport at the front of the list.
        dfs(adjacencyMap, result, "JFK");
        return result;
    }

    private void dfs(Map<String, PriorityQueue<String>> adjacencyMap, LinkedList<String> result, String airport) {
        PriorityQueue<String> adjAirports = adjacencyMap.get(airport);

        while (adjAirports != null && !adjAirports.isEmpty()) {
            String adjAirport = adjAirports.poll(); //deleting the visited airport from adjacency map.
            dfs(adjacencyMap, result, adjAirport);
        }
        result.addFirst(airport); //after recursion, adding the airport at the front of the list.
    }
}
