Binary Search: Iterative approach.

//
public class BinarySearchIterative {

    public int binarySearch(int[] inputArr, int f) {
        int low = 0;
        int high = inputArr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (f == inputArr[mid]) {
                return mid;
            } else if (f < inputArr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        BinarySearchIterative binarySearchIterative = new BinarySearchIterative();
        int[] inputArr = new int[]{2, 6, 13, 21, 36, 47, 63, 81, 97};
        System.out.println(binarySearchIterative.binarySearch(inputArr, 6));
    }
}
--
Time complexity: O(log n)
