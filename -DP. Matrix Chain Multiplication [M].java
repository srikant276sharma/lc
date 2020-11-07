Matrix Chain Multiplication [M]

/* Solution 1: Type: MCM. Recursive.

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
