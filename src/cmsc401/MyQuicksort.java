package cmsc401;

import java.util.*;

public class MyQuicksort {
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
	    if (input.hasNextLine()) {
	        String userInput = input.nextLine();
	        String[] array = userInput.split("\\s+");
	        int[] intArray = new int[array.length];
	        for (int i = 0; i < array.length; i++) {
	            intArray[i] = Integer.parseInt(array[i]);
	        }
	        System.out.println(intArray.length-1);
		quickSort(intArray, 0, intArray.length-1);
		
		System.out.println(Arrays.toString(intArray)); }}
	//array[] = 5, 1, 3 first = 0   last = 2
	public static void quickSort(int array[], int first, int last) {
	    if (first < last) { //true
	    							
	        int partIndex = part(array, first, last);
	        quickSort(array, first, partIndex-1);
	        quickSort(array, partIndex+1, last); }}
								
	private static int part(int array[], int first, int last) {
	    int pivot = array[last];
	    int i = (first-1);
	    
	    for (int j = first; j < last; j++) {
	        if (array[j] <= pivot) {
	            i++;
	            int swapTemp = array[i];
	            array[i] = array[j];
	            array[j] = swapTemp; }}
	    int swapTemp = array[i+1];
	    array[i+1] = array[last];
	    array[last] = swapTemp;
	 
	    return i+1; } }


/*

private static int part(int array[], int first, int last) {
int pivot = array[last];
int i = (first-1);
for (int j = first; j < last; j++) {
    if (array[j] <= pivot) {
        i++;
        int swapTemp = array[i];
        array[i] = array[j];
        array[j] = swapTemp; }}
int swapTemp = array[i+1];
array[i+1] = array[last];
array[last] = swapTemp;

*/