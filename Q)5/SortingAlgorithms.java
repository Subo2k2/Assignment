public class SortingAlgorithms {

    static void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    static void merge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1, n2 = r - m;
        int[] L = new int[n1], R = new int[n2];
        for (int i = 0; i < n1; i++) L[i] = arr[l + i];
        for (int j = 0; j < n2; j++) R[j] = arr[m + 1 + j];
        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) arr[k++] = L[i++];
            else arr[k++] = R[j++];
        }
        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }

    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }
        }
        int t = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = t;
        return i + 1;
    }

    public static void main(String[] args) {
        int[] arr1 = {5, 1, 4, 2, 8};
        int[] arr2 = arr1.clone();

        mergeSort(arr1, 0, arr1.length - 1);
        System.out.print("Merge Sort: ");
        for (int x : arr1) System.out.print(x + " ");
        System.out.println();

        quickSort(arr2, 0, arr2.length - 1);
        System.out.print("Quick Sort: ");
        for (int x : arr2) System.out.print(x + " ");
        System.out.println();

        // - Merge Sort:
        //  - Time: O(n log n) always
        //  - Space: O(n) auxiliary
        //  - Stable, not in-place
        // - Quick Sort:
        //  - Time: O(n log n) avg, O(n²) worst
        //  - Space: O(log n) (recursion stack)
        //  - In-place, not stable
    }
}