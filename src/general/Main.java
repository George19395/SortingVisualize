package general;

import gui.VisualizerGUI;

public class Main {
	
	
	// Prints the array
    @SuppressWarnings("unused")
	private void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
	
    public static int[] generateArray(int n) {
    	int min =5;
    	int max=80;
    	int[] arr =new int[n];
    	for(int i=0;i<n;i++) {
    		arr[i]=(int) Math.floor(Math.random() *(max-min+1)+min);
    	}
    	return arr;
    }
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		VisualizerGUI gui = new VisualizerGUI();

	}

}
