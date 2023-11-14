public class InsertionSort {
  static void insertionSort(int arr[]) {
    long startTime = System.currentTimeMillis();

    int n = arr.length;
    for (int i = 1; i < n; ++i) {
      int key = arr[i];
      int j = i - 1;

      while (j >= 0 && arr[j] > key) {
        arr[j + 1] = arr[j];
        j = j - 1;
      }
      arr[j + 1] = key;
    }
    long endTime = System.currentTimeMillis();
    long duration = endTime - startTime;
    System.out.println("Insertion Sort: Array size: " + arr.length + ", Time elapsed: " + duration);
  }
}