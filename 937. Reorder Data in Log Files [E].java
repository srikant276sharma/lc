937. Reorder Data in Log Files [E]
https://leetcode.com/problems/reorder-data-in-log-files/

/* Solution 1: Using Custom Sorting.

TC: O(n logn), where n is length of input array logs.
SC: O(n).

Asked by: Amazon, Apple.
*/

class Solution {
    public String[] reorderLogFiles(String[] logs) {
        if (logs == null || logs.length == 0) {
            return null;
        }
        List<String> letterLogs = new ArrayList<>();
        List<String> digitLogs = new ArrayList<>();

        for (String log : logs) {
            if (Character.isDigit(log.charAt(log.length() - 1))) {
                digitLogs.add(log);
            } else {
                letterLogs.add(log);
            }
        }
        letterLogs.sort(letterComparator);
        letterLogs.addAll(digitLogs);

        String[] res = new String[logs.length];
        int index = 0;
        for (String log : letterLogs) {
            res[index++] = log;
        }

        return res;
    }

    private Comparator<String> letterComparator = new Comparator<String>() {
        @Override
        public int compare(String s1, String s2) {
            String l1 = s1.substring(s1.indexOf(" ") + 1);
            String l2 = s2.substring(s2.indexOf(" ") + 1);
            return (l1.equals(l2)) ? s1.compareTo(s2) : l1.compareTo(l2);
        }
    };
}
