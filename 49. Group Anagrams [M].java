49. Group Anagrams [M]
https://leetcode.com/problems/group-anagrams/
Kevin: https://www.youtube.com/watch?v=ptgykfAEax8

/* Solution 1:
Using String sorting and map.
*/

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> groupedAnagrams = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        char[] characters;
        String sorted;

        for (String current : strs) {
            characters = current.toCharArray();
            Arrays.sort(characters);
            sorted = new String(characters);

            if (!map.containsKey(sorted)) {
                map.put(sorted, new ArrayList<>());
            }
            map.get(sorted).add(current);
        }

        groupedAnagrams.addAll(map.values());
        return groupedAnagrams;
    }
}

--
Time Complexity: O(NKlog⁡K), where N is the length of strs, and K is the maximum length of a string in strs. 
                 The outer loop has complexity O(N) as we iterate through each string. 
                 Then, we sort each string in O(Klog⁡K) time.
Space Complexity: O(NK), the total information content stored in map.
--

/* Solution 2:
Using int[] array to store character count and map.
*/

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) {
            return new ArrayList<>();
        }

        int[] charFreqArr = new int[26];
        StringBuilder sb;
        Map<String, List<String>> map = new HashMap<>();

        //TC: O(N), N is number of Strings.
        for (String str : strs) {
            //TC: O(K), K is max length of a String.
            //for "abbccc", charFreqArr will have values like, 12300000000000000000000000 */
            for (char c : str.toCharArray()) {
                charFreqArr[c - 'a']++;
            }

            sb = new StringBuilder();
            //TC: O(26).
            for (int i : charFreqArr) {
                sb.append(i);
            }
            //for "abbccc", key will be like, 12300000000000000000000000 */
            String key = sb.toString();
            //for "abbccc", map will have values like,          12300000000000000000000000 : abbccc */
            //for "abbc" and "bbac", map will have values like, 12100000000000000000000000 : abbc, bbac */
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str); //SC: O(N * K).
            //TC: O(26).
            Arrays.fill(charFreqArr, 0);
        }

        return new ArrayList<>(map.values());
    }
}

--
Time Complexity: O(NK), where N is the length of strs, and K is the maximum length of a string in strs. 
                 Counting each string is linear in the size of the string, and we count every string.
Space Complexity: O(NK), the total information content stored in ans.
--
Asked by: Amazon, Google, Uber, Facebook, Bloomberg, Golaman Sachs, Yahoo, Microsoft, Apple, Walmart Labs, Twilio, Affirm.
--
