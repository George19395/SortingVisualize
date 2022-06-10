package gui;

import java.awt.Component;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class PanelVisualizer extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	public PanelVisualizer() {
	
		this.setSize(new Dimension(500,500));
		this.setPreferredSize(new Dimension(500,500));
//		this.setLayout(new FlowLayout(FlowLayout.LEADING, 2, 1)); //reduce margin between components
		this.setAlignmentY(Component.TOP_ALIGNMENT);
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
//		this.setAlignmentY(this.TOP_ALIGNMENT);
		
//		this.setPreferredSize(new Dimension(300,300));
	}
	
	
	

}
