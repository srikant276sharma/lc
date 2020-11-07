Matrix Chain Multiplication [M]

/* Solution 1: Type: MCM. Recursive.
https://www.geeksforgeeks.org/matrix-chain-multiplication-dp-8/

Aditya: https://www.youtube.com/watch?v=kMK148J9qEE&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=34

TC: TC of above naive recursive approach is exponential.
SC: 
*/

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        //int[] arr = new int[]{40, 20, 30, 10, 30}; //output: 26000.
        int[] arr = new int[]{10, 20, 30, 40, 30}; //output: 30000.
        //1. find i and j.
        int i = 1, j = arr.length - 1; //because Matrix(i) = arr[i - 1] * arr[i];
        System.out.println(main.matrixChainOrder(arr, i, j)); 
    }
    //Matrix Chain Multiplication.
    private static int matrixChainOrder(int[] arr, int i, int j) {
        //2. base condition.
        if (i >= j) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        //3. find k loop scheme.
        for (int k = i; k <= j - 1; k++) {
            //calculate cost of (AB), (CD) and (AB)(CD).
            int temp = matrixChainOrder(arr, i, k) + 
                       matrixChainOrder(arr, k + 1, j) +
                       (arr[i - 1] * arr[k] * arr[j]);
            //4. calculate min based on temp values.
            if (temp < min) {
                min = temp;
            }
        }
        return min;
    }
}

/* Solution 2: Type: MCM. Bottom Up.

Note: Memoization (Top Down) and Tabulation (Bottom Up).
https://www.geeksforgeeks.org/matrix-chain-multiplication-dp-8/

Aditya: https://www.youtube.com/watch?v=9uUVFNOT3_Y&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=35

TC: It has a same order complexity as tabulation (if tabulation is order of n it will be too, maybe slower by a constant factor) and NO, its not always 
slower, it really depends upon the problems, on how it gonna be as compared to tabulation. It might be slower (often this is the case) and it can be faster 
too (this can happen too). All that depends upon the number of sub-problems and how they are distibuted in the recurisve tree.

If all subproblems must be solved at least once, a bottom-up dynamic-programming algorithm usually outperforms a top-down memoized algorithm by a constant 
factor No overhead for recursion and less overhead for maintaining table

There are some problems for which the regular pattern of table accesses in the dynamic-programming algorithm can be exploited to reduce the time or space 
requirements even further 
If some subproblems in the subproblem space need not be solved at all, the memoized solution has the advantage of solving only those subproblems that are 
definitely required.
Hope thats clears your doubt.

SC: 
*/

public class Main {
    private static int[][] dp;
    
    public static void main(String[] args) {
        Main main = new Main();
        //int[] arr = new int[]{40, 20, 30, 10, 30}; //output: 26000.
        int[] arr = new int[]{10, 20, 30, 40, 30}; //output: 30000.
        int n = arr.length;
        dp = new int[n][n]; //consider j, while deciding dp size.
        //1. find i and j.        
        int i = 1, j = n - 1; //because Matrix(i) = arr[i - 1] * arr[i];
        System.out.println(main.matrixChainOrder(arr, i, j)); 
    }
    //Matrix Chain Multiplication.
    private static int matrixChainOrder(int[] arr, int i, int j) {
        //2. base condition.
        if (i >= j) {
            return 0;
        }
        //check dp for previous calculated value.
        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        int min = Integer.MAX_VALUE;
        //3. find k loop scheme.
        for (int k = i; k <= j - 1; k++) {
            //calculate cost of (AB), (CD) and (AB)(CD).
            int temp = matrixChainOrder(arr, i, k) + 
                       matrixChainOrder(arr, k + 1, j) +
                       (arr[i - 1] * arr[k] * arr[j]);
            //4. calculate min based on temp values.
            if (temp < min) {
                min = temp;
            }
        }
        return dp[i][j] = min;
    }
}
