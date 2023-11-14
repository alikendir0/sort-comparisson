
public class QuickSort {
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static int medianOfThree(int[] arr, int low, int high) {
        int mid = (low + high) / 2;
        if (arr[low] > arr[high])
            swap(arr, low, high);
        if (arr[high] > arr[mid])
            swap(arr, high, mid);
        if (arr[low] > arr[high])
            swap(arr, low, high);
        return arr[high];
    }

    static int partition(int[] arr, int low, int high) {

        int pivot = medianOfThree(arr, low, high);

        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {

            if (arr[j] < pivot) {

                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {

            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    static void quickSorting(int[] arr, int low, int high) {
        long startTime = System.currentTimeMillis();
        quickSort(arr, low, high);
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("Quick Sort: Array size: " + arr.length + ", Time elapsed: " + duration);
    }
}
