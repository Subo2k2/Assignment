public class SearchingAlgorithms {

    static int binarySearchIter(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == target) return mid;
            if (arr[mid] < target) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    static int binarySearchRec(int[] arr, int low, int high, int target) {
        if (low > high) return -1;
        int mid = (low + high) / 2;
        if (arr[mid] == target) return mid;
        if (arr[mid] < target)
            return binarySearchRec(arr, mid + 1, high, target);
        else
            return binarySearchRec(arr, low, mid - 1, target);
    }

    static int linearSearchRec(int[] arr, int idx, int target) {
        if (idx >= arr.length) return -1;
        if (arr[idx] == target) return idx;
        return linearSearchRec(arr, idx + 1, target);
    }

    static int findMinRec(int[] arr, int n) {
        if (n == 1) return arr[0];
        return Math.min(arr[n - 1], findMinRec(arr, n - 1));
    }

    static int findMaxRec(int[] arr, int n) {
        if (n == 1) return arr[0];
        return Math.max(arr[n - 1], findMaxRec(arr, n - 1));
    }

    public static void main(String[] args) {
        int[] arr = {3, 8, 12, 20, 25, 30};

        System.out.println("Binary Search (Iterative) for 20: index " + binarySearchIter(arr, 20));
        System.out.println("Binary Search (Recursive) for 25: index " + binarySearchRec(arr, 0, arr.length - 1, 25));
        System.out.println("Linear Search (Recursive) for 12: index " + linearSearchRec(arr, 0, 12));

        System.out.println("Min (Rec): " + findMinRec(arr, arr.length));
        System.out.println("Max (Rec): " + findMaxRec(arr, arr.length));

        /*
        📌 Why sorted? Binary search relies on comparing mid-value to eliminate half.
        📊 Time/Space:
          - Iterative BS: O(log n) time, O(1) space
          - Recursive BS: O(log n) time, O(log n) space (call stack)
          - Recursive Linear: O(n) time, O(n) space
        */
    }
}