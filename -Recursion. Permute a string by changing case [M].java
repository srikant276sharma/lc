Permute a string by changing case [M]

/* Solution 1: Type: Recursion: IP-OP method.
https://www.geeksforgeeks.org/permute-string-changing-case/
https://leetcode.com/problems/letter-case-permutation/

Aditya: https://www.youtube.com/watch?v=J2Er5XceU_I&list=PL_z_8CaSLPWeT1ffjiImo0sYTcnLzo-wY&index=15

TC: O(n).
SC: O(n).
*/

import java.util.*;

public class MyClass {
    public static void main(String args[]) {
        String ip = "ABC", op = "";
        List<String> res = new ArrayList<>();
        
        solve(ip, op, res);

        for (String s : res) {
            System.out.print(s + " ");
        }
        System.out.print("\n");
    }
    //Permute a string by changing case.
    //Input : ab
    //Output : AB Ab ab aB

    //Input : ABC
    //Output : abc Abc aBc ABc abC AbC aBC ABC
    
    private static void solve(String ip, String op, List<String> res) {
        //base case.
        if (ip.length() == 0) {
            res.add(op);
            return;
        }
        //ip-op method.
        String op1 = op;
        String op2 = op;
        op1 += Character.toLowerCase(ip.charAt(0));
        op2 += Character.toUpperCase(ip.charAt(0));
        
        ip = ip.substring(1); //minimizing input size by removing first char.
        
        //process other characters.
        solve(ip, op1, res);
        solve(ip, op2, res);
    }
}
