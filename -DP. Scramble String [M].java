Scramble String [M]

/* Solution 1: Type: MCM. Recursive.
https://www.interviewbit.com/problems/scramble-string/

Note: Memoization (Top Down) and Tabulation (Bottom Up).
Aditya: https://www.youtube.com/watch?v=SqA0o-DGmEw&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=41

TC: 
SC: 
*/

public class GFG {
    public static void main(String[] args) {
        String a = "great", b = "rgeat"; //output: true.
        //String a = "phqtrnilf", b = "ilthnqrpf"; //output: false.
        //helper function.
        boolean result = isScramble(a, b);
        System.out.println(result);
    }

    private static boolean isScramble(String a, String b) {
        //2. base case.
        if (a.equals(b)) {
            return true;
        }
        if (a.length() <= 1) { //1. empty strings, 2. if string length is 1, then they are different.
            return false;
        }
        boolean flag = false;
        //3. k loop scheme.
        int n = a.length(); //at this point, we can pick either a's length or b's length.
        for (int i = 1; i <= n - 1; i++) {
            if (isScramble(a.substring(0, i), b.substring(n - i)) && isScramble(a.substring(i), b.substring(0, n - i)) //swapped case.
                    || isScramble(a.substring(0, i), b.substring(0, i)) && isScramble(a.substring(i), b.substring(i))) { //not swapped case.
                flag = true;
                break;
            }
        }
        return flag;
    }
}
