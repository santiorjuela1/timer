package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TABATA extends GeneralWindow{
	
	public TABATA(JFrame frame) {
		super(frame);
		this.setTitle("TABATA");
		titulo.setText("TABATA");
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// Doing/invoking the method of the superclass so it takes care 
		super.actionPerformed(e);
	}

}
