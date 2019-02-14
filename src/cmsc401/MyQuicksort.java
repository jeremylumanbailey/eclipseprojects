package cmsc401;

import java.util.*;

public class MyQuicksort {
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
	    if (input.hasNextLine()) {
	        String line = input.nextLine();
	        String[] arr = line.split("\\s+");
	        int[] vals = new int[arr.length];
	        for (int i = 0; i < arr.length; i++) {
	            vals[i] = Integer.parseInt(arr[i]);
	        }
	        
	        //vals= {5, 4, 3, 2, 1,}
		quickSort(vals, 0, vals.length-1);
		
		System.out.println(Arrays.toString(vals));
		
	    }
	}
	
	public static void quickSort(int arr[], int begin, int end) {
	    if (begin < end) {
	        int partitionIndex = partition(arr, begin, end);
	 
	        quickSort(arr, begin, partitionIndex-1);
	        quickSort(arr, partitionIndex+1, end);
	    }
	}
	
	private static int partition(int arr[], int begin, int end) {
	    int pivot = arr[end];
	    int i = (begin-1);
	 
	    for (int j = begin; j < end; j++) {
	        if (arr[j] <= pivot) {
	            i++;
	 
	            int swapTemp = arr[i];
	            arr[i] = arr[j];
	            arr[j] = swapTemp;
	        }
	    }
	 
	    int swapTemp = arr[i+1];
	    arr[i+1] = arr[end];
	    arr[end] = swapTemp;
	 
	    return i+1;
	}
}

//@author Jeremy Bailey

/*   
You are asked to implement a quicksort program named MyQuicksort that satisfies the following requirements: 
	1. Your sorting algorithm must be quicksort.
	
	2. Your quicksort algorithm will always pick the left most element to be the pivot and use
	the divide and conquer methodology to sort the array.
	
	3. Your program will take a sequence of integers separated by spaces from terminal as the
	input array.
	
	4. It will print the sorted array number separated by spaces.
	
	5. Your program shall not exceed 50 lines.
	
	6. For example
	>java MyQuicksort 5 10 7 101 42 1 21 9998 -65
	-65 1 5 7 10 21 42 101 9998
*/


