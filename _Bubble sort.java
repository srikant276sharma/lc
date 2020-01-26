Bubble sort.
--
import java.util.Arrays;

public class BubbleSort {
    public static void main(String args[]) {
        int[] numbers = new int[]{1, -40, 4, 5, 8, 3, 4, 1, 4, 5, 100, -12};
        bubbleSort(numbers);
        System.out.println(Arrays.toString(numbers));
    }

    private static void bubbleSort(int[] arr) {
        boolean isSorted = false;
        int lastUnsorted = arr.length - 1;

        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < lastUnsorted; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                    isSorted = false;
                }
            }
            lastUnsorted--;
        }
    }

    private static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
--
Time complexity: Best O(n), Avg O(n^2), Worst O(n^2).
Space complexity: Worst O(1).
--
Output:
[-40, -12, 1, 1, 3, 4, 4, 4, 5, 5, 8, 100]
--
