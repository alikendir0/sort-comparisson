import java.util.*;

class test {
    public static void main(String[] args) {
        int[] sizes = { 1000, 10000, 100000, 1000000 };

        for (int size : sizes) {
            int[] arr = generateRandomArray(size);
            int n = arr.length;
            RadixSort.radixsort(arr, n);
        }

        int[] sizes2 = { 1000, 10000, 100000, 1000000 };
        for (int size : sizes2) {
            int[] arr = generateRandomArray(size);
            QuickSort.quickSorting(arr, 0, size - 1);
        }

        int[] sizes3 = { 1000, 10000, 100000, 1000000 };
        for (int size : sizes3) {
            int[] arr = generateRandomArray(size);
            InsertionSort.insertionSort(arr);
        }

        // worst possible case for radix sort with 1.000.000 long array
        // done by maximizing the digits, changed int values to long values
        long[] arr = testRadixSort.RadixSortArray(1000000, 19);
        testRadixSort.radixsort(arr, arr.length);

        // worst possible case for insertion sort 1.000.000 long array
        // done by firstly sorting an array and then reversing it, after that feeding
        // it to the insertion sort
        int[] reversedArr = generateRandomArray(1000000);
        RadixSort.radixsort(reversedArr, reversedArr.length);
        reverse(reversedArr, 1000000);
        InsertionSort.insertionSort(reversedArr);

        // worst possible case for quick sort 1.000.000 long array
        // done by firstly sorting the array and then feeding it to quicksort
        // could have achieved similr results by reversing a sorted array or
        // sorting a array that consists of only one number
        int[] reversedArr2 = generateRandomArray(1000000);
        RadixSort.radixsort(reversedArr2, reversedArr2.length);
        QuickSort.quickSorting(reversedArr2, 0, 1000000 - 1);
    }

    static int[] generateRandomArray(int size) {
        Random r1 = new Random();
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = r1.nextInt(10000);
        }
        return array;
    }

    static void reverse(int arr[], int n) {
        for (int i = 0; i < n / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[n - i - 1];
            arr[n - i - 1] = temp;
        }
        System.out.println("Array has been reversed.");
    }

    static void reverseLong(long arr[], int n) {
        for (int i = 0; i < n / 2; i++) {
            long temp = arr[i];
            arr[i] = arr[n - i - 1];
            arr[n - i - 1] = temp;
        }
        System.out.println("Array has been reversed.");
    }

    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");

        System.out.println();
    }

}