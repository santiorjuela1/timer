package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import sounds.Beep;

public class EMOM extends GeneralWindow implements Runnable{
	
	// JLABELS
	JLabel lblEvery = new JLabel("EVERY");
	JLabel lblMinutesW = new JLabel("MINUTES");
	JLabel lblAnd = new JLabel("AND");
	JLabel lblSecondsW = new JLabel("SECONDS");
	JLabel lblFor = new JLabel("FOR");
	JLabel lblRoundsW = new JLabel("ROUNDS");
	JLabel lblRest = new JLabel("REST");
	JLabel lblSecondsR = new JLabel("SECONDS");
	
	// TEXTFIELDS
	JTextField tfMinutesW = new JTextField("1");
	JTextField tfSecondsW = new JTextField("20");
	JTextField tfRoundsW = new JTextField("3");
	JTextField tfSecondsR= new JTextField("20");
	
	// BUTTON
	JButton btnStart = new JButton("START");
	
	String strMinutesW;
	String strSecondsW;
	String strRoundsW;
	String strSecondsR;
	
	Integer intMinutesW;
	Integer intSecondsW;
	Integer intRoundsW;
	Integer intSecondsR;
	Integer intTotalSeconds;
	
	JLabel lblSecondsDisplay = new JLabel();
	JLabel lblNumbersRoundsDisplay = new JLabel();
	
	JLabel lblWorkDisplay = new JLabel("WORK");
	JLabel lblRestDisplay = new JLabel("REST");
	JLabel lblRoundsDisplay = new JLabel();
	
	Thread actualizador = new Thread(this);

	public EMOM(JFrame frame){
		super(frame);
		this.setTitle("EMOW");
		titulo.setText("EMOW");
		
		// lblEvery
		super.setFeaturesLabel(lblEvery);
		lblEvery.setBounds(160, 200, 150, 55);
		
		// tfMinutes
		super.setFeaturesTextField(tfMinutesW);
		tfMinutesW.setBounds(285, 200, 150, 55);
		
		// lblMinutes
		super.setFeaturesLabel(lblMinutesW);
		lblMinutesW.setBounds(450, 200, 150, 55);
		
		// lblAnd
		super.setFeaturesLabel(lblAnd);
		lblAnd.setBounds(200, 300, 150, 55);
		
		// tfSeconds
		super.setFeaturesTextField(tfSecondsW);
		tfSecondsW.setBounds(285, 300, 150, 55);
		
		// lblSecondsW
		super.setFeaturesLabel(lblSecondsW);
		lblSecondsW.setBounds(450, 300, 150, 55);
		
		// lblFor
		super.setFeaturesLabel(lblFor);
		lblFor.setBounds(200, 400, 150, 55);
		
		// tfRounds
		super.setFeaturesTextField(tfRoundsW);
		tfRoundsW.setBounds(285, 400, 150, 55);
		
		// lblRounds
		super.setFeaturesLabel(lblRoundsW);
		lblRoundsW.setBounds(450, 400, 150, 55);
		
		// lblRest
		super.setFeaturesLabel(lblRest);
		lblRest.setBounds(175, 500, 150, 55);
		
		// tfSecondsRest
		super.setFeaturesTextField(tfSecondsR);
		tfSecondsR.setBounds(285, 500, 150, 55);
		
		// lblSecondsRest
		super.setFeaturesLabel(lblSecondsR);
		lblSecondsR.setBounds(450, 500, 150, 55);
		
		super.setFeaturesButton(btnStart);
		btnStart.setBounds(285, 600, 150, 55);
		
		super.setFeaturesLabel(lblRestDisplay);
		this.lblRestDisplay.setBounds(350,100, 150, 150);
		
		super.setFeaturesLabel(lblWorkDisplay);
		this.lblWorkDisplay.setBounds(350, 0, 150, 150);
		
		super.setFeaturesLabel(lblSecondsDisplay);
		this.lblSecondsDisplay.setBounds(350, 100, 150, 150);
		
	//	super.setFeaturesLabel(lblNumbersRoundsDisplay);
		//this.lblNumbersRoundsDisplay.setBounds(100, 100, 150, 150);
		
		super.setFeaturesSpecialLabels(lblRoundsDisplay);
		this.lblRoundsDisplay.setBounds(150, 100, 150, 150);
		
		this.add(lblEvery);
		this.add(tfMinutesW);
		this.add(lblMinutesW);
		this.add(lblAnd);
		this.add(tfSecondsW);
		this.add(lblSecondsW);
		this.add(lblFor);
		this.add(tfRoundsW);
		this.add(lblRoundsW);
		this.add(lblRest);
		this.add(tfSecondsR);
		this.add(lblSecondsR);
		this.add(btnStart);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		/*  In case user uses the goBack button the perform the superclass function*/
		if(e.getSource() == super.goBack) {
			super.actionPerformed(e);
			super.beep.clip.stop();
			actualizador.stop();
		}
		else if(e.getSource() == this.btnStart){
			
			this.assignValues();
			
			super.removeComponents();
			
			this.add(super.lblGetReady);
			this.add(super.lblSecondsReady);
			
			actualizador.start();
		}
	}


	@Override
	public void run() {
		/* We start the getting ready window */
		super.gettingReadyTimer(super.lblSecondsReady);
		/* Once it is done, we remove all components */
		super.removeComponents();
		
		
		this.add(lblRoundsDisplay);
		this.add(lblNumbersRoundsDisplay);
		this.add(lblWorkDisplay);
		this.add(lblSecondsDisplay);

		for(Integer i = 1; i <= this.intRoundsW; i++) {
			
			this.strRoundsW = i.toString();
			this.lblRoundsDisplay.setText(strRoundsW);
			
			for(Integer j = this.intTotalSeconds; j > 0; j--) {
				
				/* Setting the label that says "work"*/
				this.lblWorkDisplay.setText("WORK");
				this.add(lblWorkDisplay);
				this.lblWorkDisplay.setBounds(350, 0, 150, 150);
				
				if(j < 4) {	
					beep.play();
				}
				
				this.strSecondsW = j.toString();
				this.lblSecondsDisplay.setText(strSecondsW);
				
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			this.lblWorkDisplay.setText("");
			this.lblSecondsDisplay.setText("");
			
			for(Integer k = this.intSecondsR; k > 0; k--) {
				/* Setting the labels that say "REST"*/
				this.lblRestDisplay.setText("REST");
				this.lblRestDisplay.setBounds(350, 0, 150, 150);
				this.add(lblRestDisplay);
				
				if(k < 4) {	
					beep.play();
				}
				
				/* Display the seconds of rest */
				this.strSecondsR = k.toString();
				this.lblSecondsDisplay.setText(strSecondsR);
				
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			this.lblRestDisplay.setText("");
			this.lblRestDisplay.setText("");
			
			if(i == this.intRoundsW) {
				super.removeComponents();
				JLabel lblDone = new JLabel("DONE");
				lblDone.setBounds(210, 200, 300,300);
				lblDone.setFont(new Font("MV Boli", Font.BOLD, 100));
				this.add(lblDone);
				}
			}
			
		}
		
		
	
	
	public void assignValues() {
		this.strRoundsW = this.tfRoundsW.getText();
		this.strMinutesW = this.tfMinutesW.getText();
		this.strSecondsW = this.tfSecondsW.getText();
		this.strSecondsR = this.tfSecondsR.getText();
		
		
		this.intRoundsW = Integer.parseInt(strRoundsW);
		this.intMinutesW = Integer.parseInt(strMinutesW);
		this.intSecondsW = Integer.parseInt(strSecondsW);
		this.intSecondsR = Integer.parseInt(strSecondsR); 
		this.intTotalSeconds = this.intMinutesW * 60 + this.intSecondsW;
		
		this.lblNumbersRoundsDisplay.setText(strRoundsW);
		this.lblSecondsDisplay.setText(this.intTotalSeconds.toString());
	}

		
}


