public class RecursionProblems {

    static int factorial(int n) {
        if (n == 0 || n == 1) return 1;
        return n * factorial(n - 1);
    }

    static int fib(int n) {
        if (n <= 1) return n;
        return fib(n - 1) + fib(n - 2);
    }

    static int sumArr(int[] arr, int n) {
        if (n <= 0) return 0;
        return arr[n - 1] + sumArr(arr, n - 1);
    }

    static boolean isSorted(int[] arr, int n) {
        if (n <= 1) return true;
        if (arr[n - 2] > arr[n - 1]) return false;
        return isSorted(arr, n - 1);
    }

    static int findMin(int[] arr, int n) {
        if (n == 1) return arr[0];
        return Math.min(arr[n - 1], findMin(arr, n - 1));
    }

    static int findMax(int[] arr, int n) {
        if (n == 1) return arr[0];
        return Math.max(arr[n - 1], findMax(arr, n - 1));
    }

    public static void main(String[] args) {
        System.out.println("Factorial of 5: " + factorial(5));

        System.out.println("Fibonacci(6): " + fib(6)); 

        int[] arr1 = {2, 4, 6, 8};
        System.out.println("Sum of array: " + sumArr(arr1, arr1.length)); 

        int[] arr2 = {3, 5, 7, 9};
        System.out.println("Is {3,5,7,9} sorted? " + isSorted(arr2, arr2.length)); 

        System.out.println("Min: " + findMin(arr1, arr1.length)); 
        System.out.println("Max: " + findMax(arr1, arr1.length)); 
        // Base vs Recursive:
        // - factorial: base n<=1, recursive n*fact(n-1)
        // - fib: base n<=1, recursive fib(n-1)+fib(n-2)
        // - sum: base n<=0, recursive arr[n-1] + sum(...)
        // - sorted: base n<=1, recursive check last pair + rest
    }
}