import java.util.*;

class test{

    static int getMax(int arr[], int n)
    {
        int mx = arr[0];
        for (int i = 1; i < n; i++)
            if (arr[i] > mx)
                mx = arr[i];
        return mx;
    }
 
    static void countSort(int arr[], int n, int exp)
    {
        int output[] = new int[n];
        int i;
        int count[] = new int[10];
        Arrays.fill(count, 0);

        for (i = 0; i < n; i++)
            count[(arr[i] / exp) % 10]++;

        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];
 
        for (i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }
        
        for (i = 0; i < n; i++)
            arr[i] = output[i];
    }
 
    static void radixsort(int arr[], int n){
        long startTime = System.currentTimeMillis();

        int m = getMax(arr, n);
 
        for (int exp = 1; m / exp > 0; exp *= 10){
            countSort(arr, n, exp);
        }

        long endTime = System.currentTimeMillis();
	    long duration = endTime - startTime;
        System.out.println("Radix Sort: Array size: " + n + ", Time elapsed: " + duration);    
    }
 
    static int[] generateRandomArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = (int) Math.random();
        }

        return array;
    }

    // A utility function to swap two elements
    static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
 
    // This function takes last element as pivot,
    // places the pivot element at its correct position
    // in sorted array, and places all smaller to left
    // of pivot and all greater elements to right of pivot
    static int partition(int[] arr, int low, int high)
    {
        // Choosing the pivot
        int pivot = arr[high];
 
        // Index of smaller element and indicates
        // the right position of pivot found so far
        int i = (low - 1);
 
        for (int j = low; j <= high - 1; j++) {
 
            // If current element is smaller than the pivot
            if (arr[j] < pivot) {
 
                // Increment index of smaller element
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }
 
    // The main function that implements QuickSort
    // arr[] --> Array to be sorted,
    // low --> Starting index,
    // high --> Ending index
    static void quickSort(int[] arr, int low, int high){
        if (low < high) {
 
            // pi is partitioning index, arr[p]
            // is now at right place
            int pi = partition(arr, low, high);
 
            // Separately sort elements before
            // partition and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
    public static void main(String[] args){
        int[] sizes = {1000, 10000, 100000, 1000000};
		
	        for (int size : sizes) {
	            int[] arr = generateRandomArray(size);
                int n=arr.length;
	            radixsort(arr, n);
	        }

        int[] sizes2 = {10000};
		
	        for (int size : sizes2) {
                long startTime = System.currentTimeMillis();
	            int[] arr = generateRandomArray(size);
                int n=arr.length;
	            quickSort(arr, 0,n-1);
                long endTime = System.currentTimeMillis();
	            long duration = endTime - startTime;
                System.out.println("Quick Sort: Array size: " + n + ", Time elapsed: " + duration);   
	        }    
    }
  }