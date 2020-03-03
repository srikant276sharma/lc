451. Sort Characters By Frequency
https://leetcode.com/problems/sort-characters-by-frequency/

/*Solution 1.
*/

class Solution {
    public String frequencySort(String s) {
        StringBuilder result = new StringBuilder();
        if (s == null || s.length() == 0) {
            return result.toString();
        }

        Map<Character, Integer> charCount = new HashMap<>();
        for (Character c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> charCount.get(b) - charCount.get(a));
        maxHeap.addAll(charCount.keySet());

        while (!maxHeap.isEmpty()) {
            char current = maxHeap.poll();
            for (int i = 0; i < charCount.get(current); i++) {
                result.append(current);
            }
        }
        return result.toString();
    }
}

--
Time complexity: O(nlogn) where n is the no. of characters in the string.
Space complexity: O(n) where n is the no. of characters in the string.
--
Asked by: Google, LinkedIn, Microsoft, Uber and Bloomberg.
--
