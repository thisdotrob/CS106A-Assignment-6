/*
 * File: NameSurfer.java
 * ---------------------
 * When it is finished, this program will implements the viewer for
 * the baby-name database described in the assignment handout.
 */

import acm.program.*;
import java.awt.event.*;
import javax.swing.*;


public class NameSurfer extends Program implements NameSurferConstants {

	/* Method: init() */
	/**
	 * This method has the responsibility for reading in the data base
	 * and initializing the interactors at the top of the window.
	 */
	public void init() {
	    // You fill this in, along with any helper methods //
		addControlBar();
		namesDataBase = new NameSurferDataBase("names-data.txt");
		graph = new NameSurferGraph();
		add(graph);
	}
	
	/* Method: addControlBar() */
	/** 
	 * Adds the control bar to the top of the window, containing the "name" label, 
	 * the text field and two buttons ("Graph" and "Clear"), and starts the listeners. 
	 */
	private void addControlBar() {
		tF = new JTextField(30);
		tF.setActionCommand("Graph");
		JButton graphBut = new JButton("Graph");
		JButton clearBut = new JButton("Clear");
		
		add(new JLabel("Name"),NORTH);
		add(tF, NORTH);
		add(graphBut, NORTH);
		add(clearBut, NORTH);
		
		tF.addActionListener(this);
		addActionListeners();		
	}

	/* Method: actionPerformed(e) */
	/**
	 * This class is responsible for detecting when the buttons are
	 * clicked, so you will have to define a method to respond to
	 * button actions.
	 */
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if(cmd.equals("Graph")) {
			String name = tF.getText();
			NameSurferEntry entry = namesDataBase.findEntry(name);
			if(entry != null) {
				graph.addEntry(entry);
				graph.update();
			}
		}
		else if(cmd.equals("Clear")) {
			graph.clear();
			graph.update();			
		}
		
	}
	
	// Instance variables
	private JTextField tF;
	private NameSurferDataBase namesDataBase;
	private NameSurferGraph graph;
}
