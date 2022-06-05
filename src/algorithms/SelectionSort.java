package algorithms;

public class SelectionSort {
	
	/*
	 * Implementation of Selection Sort Algorithm
	 * @ pass integer array as argument
	 * O(n2) time complexity (double for loop).
	 * O(1) space complexity as 1 new variable temp for storing created
	 */
	
	public SelectionSort(int arr[]) {
		sort(arr);
	}

	private void sort(int arr[]) {
		
		// get the array size.
		int size = arr.length;
		
		//loop from first element till n-1
		for(int i=0; i<size-1;i++) {
			int minIndex = i;
			//loop through and find the minimum value index
			for(int j=i+1;j<size;j++) {
				if(arr[j]<arr[minIndex]) {
					minIndex=j;
				}
			}
			//get the value of minimum index value
			int temp = arr[minIndex];
			//swap the order of the 2 values
			arr[minIndex]=arr[i];
			arr[i]=temp;
		}
		
		
	}

}
