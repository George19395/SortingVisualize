package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import algorithms.BubbleSort;
import algorithms.SelectionSort;
import general.Algorithms;
import general.Main;


public class VisualizerGUI {

	JFrame frame;
	PanelVisualizer panel;
	JButton[] buttons;
	
	BubbleSort b;
	Thread t ;
	SelectionSort s;
	
	String[] optionsToChoose = {"SelectionSort", "BubbleSort", "None of the listed"};
//	JComboBox<String> solve;
	boolean isActive = false;

	/*
	 * Constructor
	 */
	public VisualizerGUI() {
		frame = new JFrame("Visualizer");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setMinimumSize(new Dimension(800,600));
		frame.setMaximumSize(new Dimension(800,600));
		frame.setResizable(false);

		panel = new PanelVisualizer();

		int[] arr =Main.generateArray(100);

		initialiseButtonsArray(arr,panel);
		//initialise all sorting threads
		b = new BubbleSort(panel,buttons);
		s = new SelectionSort(panel,buttons);

		//initialise the Thread with custom algorithm thread
		//this will be overwritten by User selection
		t= new Thread(s);


		GUI(arr);

	}

	/*
	 * Initialises the Button array from the normal array
	 */
	public void initialiseButtonsArray(int[] arr,JPanel panel) {
		int scaleFactor =5;
		buttons =new JButton[arr.length];
		for(int i=0;i<arr.length;i++) {
			JButton b2 = new JButton(arr[i]+"");
			b2.setPreferredSize(new Dimension(5,arr[i]*scaleFactor));
			b2.setMinimumSize(new Dimension(5,arr[i]*scaleFactor));
			b2.setMaximumSize(new Dimension(5,arr[i]*scaleFactor));
			//			b2.setAlignmentX(b2.RIGHT_ALIGNMENT);
			//			b2.setLayout(new BoxLayout(b2, BoxLayout.Y_AXIS));
			b2.setAlignmentY(Component.TOP_ALIGNMENT);
			buttons[i]=b2;
		}
	}


	/*
	 * GUI built 
	 */
	public void GUI(int arr[]) {

		panel.setBackground(Color.GRAY);
		panel.add(Box.createRigidArea(new Dimension(120, 0))); // padding at start of page 

		for(int i=0;i<buttons.length;i++) {
			panel.add(buttons[i]);
			//			panel.add(Box.createRigidArea(new Dimension(2,0))); // to add space between objects but creates extra object
			//			int index = panel.getComponentZOrder(b2); // get position of specifc object
		}

		// GRIDBAGLAYOUT FOR ALL COMPONNETS
		JPanel mainPanel = new JPanel(new GridBagLayout());
		GridBagConstraints gridBagConstraints = new GridBagConstraints();

		gridBagConstraints.weighty = 1; // space between columns
		gridBagConstraints.weightx = 1;// space between rows
		gridBagConstraints.anchor = GridBagConstraints.NORTH;

		//add label to top of main panel
		JLabel topLabel = new JLabel("Sorting Visualizer", JLabel.CENTER);
		topLabel.setOpaque(true);
		topLabel.setBackground(Color.BLACK);
		topLabel.setForeground(Color.WHITE);
		topLabel.setFont(new Font("Helvetica", Font.PLAIN, 18));
		gridBagConstraints.gridx = 0; // what row it starts from
		gridBagConstraints.gridy = 0; // what column it starts from
		gridBagConstraints.gridwidth = 2;//number of columns it takes
		gridBagConstraints.weighty = 0.05;
		gridBagConstraints.fill = GridBagConstraints.BOTH; //resize to fit screen
		mainPanel.add(topLabel,gridBagConstraints);

		//add grid panel
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.gridwidth = 2;
		gridBagConstraints.weighty = 1;
		gridBagConstraints.fill = GridBagConstraints.BOTH;
		gridBagConstraints.anchor = GridBagConstraints.NORTH;
		mainPanel.add(panel, gridBagConstraints); 

		//add Combobox with options
		JComboBox<String> solve = new JComboBox<>(optionsToChoose);
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.gridwidth = 1;
		gridBagConstraints.weighty = 0.05; // the weight of the button y dimension in this case want it weigh smaller than midPanel
		//				gridBagConstraints.insets=new Insets(0,0,0,10); //top left bottom right
		gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints.anchor = GridBagConstraints.PAGE_END;
		mainPanel.add(solve, gridBagConstraints);	

		// Reset button
		JButton submit=new JButton("Start");
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.gridwidth = 1;
		gridBagConstraints.weighty = 0.05;
		//				gridBagConstraints.insets=new Insets(0,10,0,10); //top left bottom right
		gridBagConstraints.fill = GridBagConstraints.HORIZONTAL; //doesnt fill to top since we anchored to the PAGE_END
		gridBagConstraints.anchor = GridBagConstraints.PAGE_END;
		mainPanel.add(submit, gridBagConstraints); 
		submit.addActionListener(e -> buttonPressed(solve)); 

		//add STOP-Continue button
		JButton reset=new JButton("Pause/Continue");
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 3;
		gridBagConstraints.gridwidth = 1;
		gridBagConstraints.weighty = 0.05; // the weight of the button y dimension in this case want it weigh smaller than midPanel
//		gridBagConstraints.insets=new Insets(0,10,10,10); //top left bottom right
		gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints.anchor = GridBagConstraints.PAGE_END;
		mainPanel.add(reset, gridBagConstraints);
		reset.addActionListener(e -> stopContinue());

		//Generate new Array and redraw Panel
		//TO_DO
		//1. Generate new array
		//2. Empty panel
		//3. call GUI method 
		//4. call button array filler
		JButton newPuzzle=new JButton("newPuzzle");
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 3;
		gridBagConstraints.gridwidth = 1;
		gridBagConstraints.weighty = 0.05; // the weight of the button y dimension in this case want it weigh smaller than midPanel
//		gridBagConstraints.insets=new Insets(0,0,10,10); //top left bottom right
		gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints.anchor = GridBagConstraints.PAGE_END;
		mainPanel.add(newPuzzle, gridBagConstraints); 
		newPuzzle.addActionListener(e -> newArray(mainPanel));
		newPuzzle.setEnabled(true); // buggie need to fix
			

		//		panel.add(Box.createRigidArea(new Dimension(50, 0)));

		frame.add(mainPanel);
		frame.setVisible(true);
		frame.pack();

	}

	void newArray(JPanel mainPanel) {
		// TODO Auto-generated method stub
		t.stop();
		
		mainPanel.removeAll();
		panel.removeAll();
//		panel = new PanelVisualizer(10);

		panel = new PanelVisualizer();

		int[] arr =Main.generateArray(100);

		initialiseButtonsArray(arr,panel);
		//initialise all sorting threads
		b = new BubbleSort(panel,buttons);
		s = new SelectionSort(panel,buttons);

		//initialise the Thread with custom algorithm thread
		//this will be overwritten by User selection
		


		GUI(arr);
//		t= new Thread(s);

		
		panel.repaint();
		panel.revalidate();
		
	}

	/*
	 * ActionListener for start button pressed.
	 */
	@SuppressWarnings("deprecation")
	void buttonPressed(JComboBox<String> solve) {
		if(t.isAlive()) {
			
			System.out.println(t.getName());
			t.stop();
			//			t.interrupt();
		}
		if(solve.getSelectedItem().equals(Algorithms.BubbleSort.toString())) {
			t= new Thread(b);
			System.out.println("BUBBLESORT");
		}
		else if(solve.getSelectedItem().equals(Algorithms.SelectionSort.toString())) {
			
			t=new Thread(s);
			System.out.println("SelectionSort");
		}
		else {
			System.out.println("NULL");
		}
		isActive=true;
		t.start();

	}
	
	void stopContinue() {
		if(!isActive) {
			t.resume();
			isActive=true;
		}
		else if(t.currentThread().isAlive()) {
			t.suspend();
			isActive=false;
		}
		
	}

}
