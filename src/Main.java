import algorithms.SelectionSort;

public class Main {
	
	
	// Prints the array
    void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
	
	public static void main(String[] args) {
		int arr[] = {64,25,12,22,11};
		Main m= new Main();
		SelectionSort ss = new SelectionSort(arr);
		m.printArray(arr);
	}

}
