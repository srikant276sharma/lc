383. Ransom Note [E]
https://leetcode.com/problems/ransom-note/

/* Solution 1: Using HashMap.
Kevin: https://www.youtube.com/watch?v=gWqbmAS3uxg

Time complexity: O(m + n), where m is length of ransomNote and n is length of magazine.
Space complexity: O(n), where n is length of magazine, because of using map.
*/

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> magCharCounts = new HashMap<>();
        for (char c : magazine.toCharArray()) {
            magCharCounts.put(c, magCharCounts.getOrDefault(c, 0) + 1);
        }

        for (char c : ransomNote.toCharArray()) {
            if (!magCharCounts.containsKey(c) || magCharCounts.get(c) == 0) {
                return false;
            }
            magCharCounts.put(c, magCharCounts.get(c) - 1);
        }

        return true;
    }
}

--
Asked by: Microsoft.
