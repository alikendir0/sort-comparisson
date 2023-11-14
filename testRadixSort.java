import java.util.Arrays;
import java.util.Random;

public class testRadixSort {
  static long getMax(long arr[], int n) {
    long mx = arr[0];
    for (int i = 1; i < n; i++)
      if (arr[i] > mx)
        mx = arr[i];
    return mx;
  }

  static void countSort(long arr[], int n, long exp) {
    long output[] = new long[n];
    int i;
    int count[] = new int[10];
    Arrays.fill(count, 0);

    for (i = 0; i < n; i++)
      count[(int) ((arr[i] / exp) % 10)]++;

    for (i = 1; i < 10; i++)
      count[i] += count[i - 1];

    for (i = n - 1; i >= 0; i--) {
      output[count[(int) ((arr[i] / exp) % 10)] - 1] = arr[i];
      count[(int) ((arr[i] / exp) % 10)]--;
    }

    for (i = 0; i < n; i++)
      arr[i] = output[i];
  }

  static void radixsort(long arr[], int n) {
    long m = getMax(arr, n);

    long startTime = System.currentTimeMillis();
    for (long exp = 1; m / exp > 0; exp *= 10)
      countSort(arr, n, exp);
    long endTime = System.currentTimeMillis();
    long duration = endTime - startTime;
    System.out.println("Radix Sort: Array size: " + n + ", Time elapsed: " + duration);
  }

  static long[] RadixSortArray(int size, int digits) {
    int arraySize = size;
    int maxDigits = digits;
    Random rand = new Random();
    long[] arr = new long[arraySize];

    long maxNum = (long) Math.pow(10, maxDigits);
    for (int i = 0; i < arraySize; i++) {
      long num = Math.abs(rand.nextLong() % maxNum);
      arr[i] = num;
    }
    return arr;
  }
}
