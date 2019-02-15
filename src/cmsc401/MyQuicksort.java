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
		quickSort(vals, 0, vals.length-1);
		
		System.out.println(Arrays.toString(vals)); }}
	
	public static void quickSort(int arr[], int begin, int end) {
	    if (begin < end) {
	        int partitionIndex = partition(arr, begin, end);
	        quickSort(arr, begin, partitionIndex-1);
	        quickSort(arr, partitionIndex+1, end); }}
	
	private static int partition(int arr[], int begin, int end) {
	    int pivot = arr[end];
	    int i = (begin-1);
	    for (int j = begin; j < end; j++) {
	        if (arr[j] <= pivot) {
	            i++;
	            int swapTemp = arr[i];
	            arr[i] = arr[j];
	            arr[j] = swapTemp; }}
	    int swapTemp = arr[i+1];
	    arr[i+1] = arr[end];
	    arr[end] = swapTemp;
	 
	    return i+1; } }