Binary Search: Recursive solution.

--
public class BinarySearchRecursion {

    public int binarySearch(int[] inputArr, int f) {
        int low = 0;
        int high = inputArr.length - 1;
        return binarySearch(inputArr, f, low, high);
    }

    private int binarySearch(int[] inputArr, int f, int low, int high) {
        //Base condition.
        if (low > high) {
            return -1;
        }
        int mid = low + (high - low) / 2;
        if (f == inputArr[mid]) {
            return mid; //Base condition.
        } else if (f < inputArr[mid]) {
            return binarySearch(inputArr, f, low, mid - 1);
        } else {
            return binarySearch(inputArr, f, mid + 1, high);
        }
    }

    public static void main(String[] args) {
        BinarySearchRecursion binarySearchRecursion = new BinarySearchRecursion();
        int[] inputArr = new int[]{2, 6, 13, 21, 36, 47, 63, 81, 97};
        System.out.println(binarySearchRecursion.binarySearch(inputArr, 81));
    }
}
--
Time complexity: O(log n)
