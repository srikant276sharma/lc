Merge Sort.
--
import java.util.Arrays;

public class MergeSort {
    public static void main(String args[]) {
        int[] arr = new int[]{1, 5, 100, 2000, -1, 4, 7};

        int lb = 0;
        int ub = arr.length - 1;
        int[] tmp = new int[arr.length];
        mergeSort(arr, lb, ub, tmp);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr, int lb, int ub, int[] tmp) {
        if (lb < ub) {
            // Divide.
            int mid = lb + (ub - lb) / 2;
            mergeSort(arr, lb, mid, tmp);
            mergeSort(arr, mid + 1, ub, tmp);
            merge(arr, lb, mid, ub, tmp);
        }
    }

    private static void merge(int[] arr, int lb, int mid, int ub, int[] tmp) {
        int i = lb,
                j = mid + 1,
                k = lb;
        int size = ub - lb + 1;

        while (i <= mid && j <= ub) {
            if (arr[i] <= arr[j]) {
                tmp[k] = arr[i];
                i++;
            } else {
                tmp[k] = arr[j];
                j++;
            }
            k++;
        }
        //
        while (i <= mid) {
            tmp[k] = arr[i];
            i++;
            k++;
        }
        //
        while (j <= ub) {
            tmp[k] = arr[j];
            k++;
            j++;
        }
        System.arraycopy(tmp, lb, arr, lb, size);
    }

}
--
Time complexity: Best, Avg, Worst: O(n log n).
Space complexity: Worst: O(n).
--
