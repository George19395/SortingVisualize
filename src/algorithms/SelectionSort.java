package algorithms;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;

public class SelectionSort implements Runnable {

	JPanel panel;
	JButton[] arr;

	/*
	 * Implementation of Selection Sort Algorithm
	 * @ pass integer array as argument
	 * O(n2) time complexity (double for loop).
	 * O(1) space complexity as 1 new variable temp for storing created
	 */
	public SelectionSort(int arr[]) {
		sort(arr);
	}


	public SelectionSort(JPanel panel,JButton[] arr2) {
		this.panel = panel;
		this.arr=arr2;
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

	@Override
	public void run() {
		// TODO Auto-generated method stub
		// get the array size.
		// get the array size.
		int size = arr.length;

		//loop from first element till n-1
		for(int i=0; i<size-1;i++) {
			int minIndex = i;
			int minIndexPosition = panel.getComponentZOrder(arr[i]);
	
			//loop through and find the minimum value index
			for(int j=i+1;j<size;j++) {
				int first = Integer.parseInt(arr[j].getText());
				int second = Integer.parseInt(arr[minIndex].getText());
//				arr[j].setBackground(Color.red);
//				arr[minIndex].setBackground(Color.red);
				arr[minIndex].setBackground(Color.red);
				if(first<second) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					arr[minIndex].setBackground(Color.WHITE);
					arr[j].setBackground(Color.WHITE);
					
					minIndex=j;

					minIndexPosition =panel.getComponentZOrder(arr[j]);
				}
				
			}
			
			//get the value of minimum index value
			int indexMin = minIndexPosition;
			int  indexI= panel.getComponentZOrder(arr[i]);
			
			panel.setComponentZOrder(arr[minIndex], indexI);
			panel.setComponentZOrder(arr[i],indexMin);
			panel.revalidate();
			//swap the order of the 2 values
			JButton temp = arr[minIndex];
			arr[minIndex]=arr[i];
			arr[i]=temp;
			
			arr[i].setBackground(Color.GREEN);
			
			
		}

	}
	
	

}
