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
	        
		quickSort(intArray, 0, intArray.length-1);
		
		System.out.println(Arrays.toString(intArray)); }}

	public static void quickSort(int array[], int first, int last) {
	    if (first < last) { 
	    							
	        int partIndex = part(array, first, last);
	        quickSort(array, first, partIndex-1);
	        quickSort(array, partIndex+1, last); }}
								
	private static int part(int array[], int first, int last) {
	    
		int pivot=array[first];
		int p1=first+1;
		int i,temp;
		
		for(i=first+1;i<=last;i++) 
		{
			if(array[i]<pivot) {
				if(i!=p1)
				{
					temp=array[p1];
					array[p1]=array[i];
					array[i]=temp;
				}	p1++;
			} }
				array[first]=array[p1-1];
				array[p1-1]=pivot;
		
		return p1-1;
	     } }