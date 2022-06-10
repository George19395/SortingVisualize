package algorithms;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;

public class BubbleSort implements Runnable{
	
	JPanel panel;
	JButton[] arr;
	public BubbleSort(JPanel panel,JButton[] arr2) {
		this.panel = panel;
		this.arr=arr2;
	}
	
//	biggest element will go the end every iteration so every time we loop through length-1 of previous time
	public BubbleSort(int[] arr) {
		sort(arr);
		
	}
	
	
	/*
	 * O(n^2) time complexity which can be improved if array stops when no swaps in inner for loop
	 * O(1) space complexity
	 */
	private void sort(int[] arr) {
		
		int length = arr.length;
		
		for(int i=0;i<length-1;i++) { // loop through all elements until second to last one since on inner loop we go to i+1(if we go to last it will cause index out of bounds)
			for(int j=0;j<length-1-i;j++) { // we start from element next of i and every time we check 1 element less
				if(arr[j]>arr[j+1]) {
					int temp = arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
				
				
			}
		}
	}
	


	@Override
	public void run() {
		int length =arr.length;
		for(int i=0;i<length-1;i++) { // loop through all elements until second to last one since on inner loop we go to i+1(if we go to last it will cause index out of bounds)
			for(int j=0;j<length-1-i;j++) { // we start from element next of i and every time we check 1 element less
				int first = Integer.parseInt(arr[j].getText());
				int second = Integer.parseInt(arr[j+1].getText());
				
				
				if(first>second) {
					arr[j].setBackground(Color.red);
					arr[j+1].setBackground(Color.red);
					JButton temp = arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
					
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					arr[j].setBackground(Color.WHITE);
					arr[j+1].setBackground(Color.WHITE);
					
					int indexJ = panel.getComponentZOrder(arr[j]);
//					System.out.println(indexJ);
					int indexJ1 = panel.getComponentZOrder(arr[j+1]);
//					System.out.println(indexJ1);
					
					panel.setComponentZOrder(arr[j], indexJ1);
					panel.setComponentZOrder(arr[j+1], indexJ);
					panel.revalidate(); // this updates the panel to show the changes // panel.repaint() doesn work
					
					
					
					
				}
				
				
			}
		}
		
	}

}
