14. Longest Common Prefix
https://leetcode.com/problems/longest-common-prefix/

--Solution: 1

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";
        String lcp = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(lcp) != 0) {
                lcp = lcp.substring(0, lcp.length() - 1);
            }
        }
        return lcp;
    }
}
--
Runtime: 0 ms, faster than 100.00% of Java online submissions for Longest Common Prefix.
Memory Usage: 37.8 MB, less than 80.70% of Java online submissions for Longest Common Prefix.

--Solution: 2

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";
        boolean isMatchFound = true;
        String res = "";

        int commonLen = strs[0].length();
        boolean isCommonLenSet = false;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < commonLen && isMatchFound; i++) {
            char ch = ' ';
            for (String str : strs) {
                if (str.isEmpty())
                    return "";

                if (!isCommonLenSet) {
                    if (commonLen > str.length())
                        commonLen = str.length();
                }
                if (ch == ' ')
                    ch = str.charAt(i);
                else {
                    if (ch != str.charAt(i)) {
                        isMatchFound = false;
                        break;
                    }
                }
            }
            isCommonLenSet = true;
            if (isMatchFound)
                sb.append(ch);
        }
        res = sb.toString();
        return res;
    }
}
--
