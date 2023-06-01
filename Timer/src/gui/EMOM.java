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

public class EMOM extends GeneralWindow implements Runnable{
	
	JLabel lblEvery = new JLabel("EVERY");
	JLabel lblMinutes = new JLabel("MINUTES");
	JLabel lblAnd = new JLabel("AND");
	JLabel lblSeconds = new JLabel("SECONDS");
	JLabel lblFor = new JLabel("FOR");
	JLabel lblRounds = new JLabel("ROUNDS");
	JLabel lblRest = new JLabel("REST");
	JLabel lblSecondsRest = new JLabel("SECONDS");
	JTextField tfMinutes = new JTextField("");
	JTextField tfSeconds = new JTextField("");
	JTextField tfRounds = new JTextField("");
	JTextField tfSecondsRest = new JTextField("");
	JButton btnStart = new JButton("START");
	
	Thread actualizador = new Thread();

	public EMOM(JFrame frame){
		super(frame);
		this.setTitle("EMOM");
		titulo.setText("EMOM");
		
		// lblEvery
		super.setFeaturesLabel(lblEvery);
		lblEvery.setBounds(160, 200, 150, 55);
		
		// tfMinutes
		super.setFeaturesTextField(tfMinutes);
		tfMinutes.setBounds(285, 200, 150, 55);
		
		// lblMinutes
		super.setFeaturesLabel(lblMinutes);
		lblMinutes.setBounds(450, 200, 150, 55);
		
		// lblAnd
		super.setFeaturesLabel(lblAnd);
		lblAnd.setBounds(200, 300, 150, 55);
		
		// tfSeconds
		super.setFeaturesTextField(tfSeconds);
		tfSeconds.setBounds(285, 300, 150, 55);
		
		// lblSeconds
		super.setFeaturesLabel(lblSeconds);
		lblSeconds.setBounds(450, 300, 150, 55);
		
		// lblFor
		super.setFeaturesLabel(lblFor);
		lblFor.setBounds(200, 400, 150, 55);
		
		// tfRounds
		super.setFeaturesTextField(tfRounds);
		tfRounds.setBounds(285, 400, 150, 55);
		
		// lblRounds
		super.setFeaturesLabel(lblRounds);
		lblRounds.setBounds(450, 400, 150, 55);
		
		// lblRest
		super.setFeaturesLabel(lblRest);
		lblRest.setBounds(175, 500, 150, 55);
		
		// tfSecondsRest
		super.setFeaturesTextField(tfSecondsRest);
		tfSecondsRest.setBounds(285, 500, 150, 55);
		
		// lblSecondsRest
		super.setFeaturesLabel(lblSecondsRest);
		lblSecondsRest.setBounds(450, 500, 150, 55);
		
		super.setFeaturesButton(btnStart);
		btnStart.setBounds(285, 600, 150, 55);
		
		this.add(lblEvery);
		this.add(tfMinutes);
		this.add(lblMinutes);
		this.add(lblAnd);
		this.add(tfSeconds);
		this.add(lblSeconds);
		this.add(lblFor);
		this.add(tfRounds);
		this.add(lblRounds);
		this.add(lblRest);
		this.add(tfSecondsRest);
		this.add(lblSecondsRest);
		this.add(btnStart);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// Doing/invoking the method of the superclass so it takes care 
		if(e.getSource() == super.goBack) {
			super.actionPerformed(e);
		}
		else if(e.getSource() == this.btnStart){
			System.out.println("hola mundo");
		}
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

		
}


