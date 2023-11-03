class test{
    public static void main(String[] args){
        int[] sizes = {1000, 10000, 100000, 1000000};
		
	    for (int size : sizes) {
	            int[] arr = generateRandomArray(size);
                int n=arr.length;
	            RadixSort.radixsort(arr, n);
	    }

        int[] sizes2 = {1000,10000,10000};
	    for (int size : sizes2) {
	            int[] arr = generateRandomArray(size);
                int n=arr.length;
	            QuickSort.quickSorting(arr, 0,n-1);
	    }    

        int[] sizes3 = {1000, 10000, 100000, 1000000};
	    for (int size : sizes3) {
	            int[] arr = generateRandomArray(size);
	            InsertionSort.insertionSort(arr);
	    }


        int[] reversedArr = generateRandomArray(1000000);
        InsertionSort.insertionSort(reversedArr);
        reverse(reversedArr, 1000000);
        InsertionSort.insertionSort(reversedArr);
    }

    static int[] generateRandomArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = (int) (Math.random()*10000);
        }
        return array;
    }

    static void reverse(int arr[], int n) { 
        for(int i=0;i<n/2;i++){
            int temp=arr[i];
            arr[i]=arr[n-i-1];
            arr[n-i-1]=temp;
          }
        System.out.println("Array has been reversed.");  
    } 

  static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
 
        System.out.println();
    }
}