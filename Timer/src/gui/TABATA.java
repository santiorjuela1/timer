package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class TABATA extends GeneralWindow implements Runnable{
	
	// Attributes
	
	// Labels
	JLabel lblFor = new JLabel("FOR");
	JLabel lblRounds = new JLabel("ROUNDS");
	JLabel lblWork = new JLabel("WORK");
	JLabel lblSecondsWork = new JLabel("SECONDS");
	JLabel lblRest = new JLabel("REST");
	JLabel lblSecondsRest = new JLabel("SECONDS");
	
	// TextFields
	JTextField tfRounds = new JTextField("10");
	JTextField tfSecondsWork = new JTextField("20");
	JTextField tfSecondsRest = new JTextField("10");
	
	// Buttons 
	JButton btnStart = new JButton("START");
	
	
	public TABATA(JFrame frame) {
		super(frame);
		this.setTitle("TABATA");
		titulo.setText("TABATA");
		
		// lblFor
		super.setFeaturesLabel(lblFor);
		lblFor.setBounds(200, 250, 100, 55);
		
		// lblRounds
		super.setFeaturesLabel(lblRounds);
		lblRounds.setBounds(450, 250, 150, 55);
		
		// lblWork
		super.setFeaturesLabel(lblWork);
		lblWork.setBounds(175, 350, 150, 55);
		
		// lblSeconds
		super.setFeaturesLabel(lblSecondsWork);
		lblSecondsWork.setBounds(450, 350, 150, 55);
		
		// lblRest
		super.setFeaturesLabel(lblRest);
		lblRest.setBounds(175, 450, 150, 55);
		
		// lblSecondsRest
		super.setFeaturesLabel(lblSecondsRest);
		lblSecondsRest.setBounds(450, 450, 150, 55);
		
		// tfSecondsRest
		super.setFeaturesTextField(tfSecondsRest);
		tfSecondsRest.setBounds(285, 450, 150, 55);
		
		// tfSecondsWork
		super.setFeaturesTextField(tfSecondsWork);
		tfSecondsWork.setBounds(285, 350, 150, 55);
		
		// tfRounds
		super.setFeaturesTextField(tfRounds);
		tfRounds.setBounds(285, 250, 150, 55);
		
		// btnStart
		super.setFeaturesButton(btnStart);
		btnStart.setBounds(285,550, 150, 55);
		
		this.add(btnStart);
		this.add(lblSecondsRest);
		this.add(tfSecondsRest);
		this.add(lblRest);
		this.add(tfSecondsWork);
		this.add(lblSecondsWork);
		this.add(lblWork);
		this.add(tfRounds);
		this.add(lblRounds);
		this.add(lblFor);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// Doing/invoking the method of the superclass so it takes care 
		super.actionPerformed(e);
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
