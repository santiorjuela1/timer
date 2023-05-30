package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class AMRAP extends GeneralWindow{
	

	public AMRAP(JFrame frame) {
		super(frame);
		this.setTitle("AMRAP");
		titulo.setText("AMRAP");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// Doing/invoking the method of the superclass so it takes care 
		super.actionPerformed(e);
	}
	

}

