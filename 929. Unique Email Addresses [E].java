929. Unique Email Addresses [E]
https://leetcode.com/problems/unique-email-addresses/

/*Solution 1.
 Using HashSet.
*/

/*Time complexities:
* https://github.com/nkatre/TimeComplexityOfPredefinedMethodsInJava/blob/master/String%2C%20StringBuilder%20and%20StringBuffer%20class%20methods
* indexOf()     : O(m*n), where n and m are the length of the search string and pattern respectively ~ O(1*n) ~ O(n)
* toCharArray() : O(N), where N is the number of characters in the string, because each character must be copied into the output.
* substring()   : O(N), it copies all the characters into a new String.
* toString()    : O(N).
*
* */

class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> uniqueEmailSet = new HashSet<>();
        StringBuilder sb;
        int domainIndex;

        for (String email : emails) {
            sb = new StringBuilder();
            domainIndex = email.indexOf('@');
            /*Replace all '.' with '' and stop at first '+' or '@' */
            for (char c : email.toCharArray()) {
                if (c == '.') {
                    continue;
                } else if (c == '+' || c == '@') {
                    break;
                }
                sb.append(c);
            }
            sb.append(email.substring(domainIndex));
            uniqueEmailSet.add(sb.toString());
        }

        return uniqueEmailSet.size();
    }
}

--
Time complexity:  O(C), where C is the total content of emails.
Space complexity: O(C).
--
Asked by: Google, Amazom, Adobe.
--
