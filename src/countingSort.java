import java.util.*;
public class countingSort {
	public static void main(String[] args) {
		char[] arr = {'g', 'e', 'e', 'k', 's', 'f', 'o', 
                'r', 'g', 'e', 'e', 'k', 's'
                }; 
		countSort(arr);
		System.out.println("The sorted array is " + " " + Arrays.toString(arr));
	}
	
	public static void countSort(char[] arr) {
		int n = arr.length;
		char output[] = new char[arr.length];
		//Since we know that there are 256 characters we create a count array 
		
		char[] count = new char[256];
		for(int i=0; i<256; i++) {
			//Intialize the count array with 0
			count[i] = 0;
		}
		
		for(int i=0; i<n; i++) {
			++count[arr[i]]; 
		}
		
		//Now filling in the blank spaces in the count array so that they can be mapped with the real output array
		for(int i=1; i<255; i++) {
			count[i] += count[i-1];
		}
		
		// Build the output character array to make it stable we traverse from the end
		// This count array will have the locations where the results have to be placed in the o/p array
		// whereas the input array denotes the value to be placed.  As the values are placed in the o/p array 
		// gradually the value stored in count array is decremented by 1.
		for(int i=n-1; i>=0; i--) {
			output[count[arr[i]] - 1] = arr[i];
			--count[arr[i]];
		}
		
		arr = output.clone();
		System.out.println(Arrays.toString(arr));
		
	}
}
