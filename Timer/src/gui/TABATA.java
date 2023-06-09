package gui;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import sounds.Beep;

public class TABATA extends GeneralWindow implements Runnable{
	
	// Attributes
	
	// Labels
	private	JLabel lblFor = new JLabel("FOR");
	private	JLabel lblRounds = new JLabel("ROUNDS");
	private	JLabel lblWork = new JLabel("WORK");
	private	JLabel lblSecondsWork = new JLabel("SECONDS");
	private	JLabel lblRest = new JLabel("REST");
	private	JLabel lblSecondsRest = new JLabel("SECONDS");
	private JLabel lblInvalid = new JLabel();
		
	private	JLabel lblRoundsDisplay = new JLabel();
	private	JLabel lblWorkDisplay = new JLabel();
	private	JLabel lblSecondsRestDisplay = new JLabel();
	
	// TextFields
	private	JTextField tfRounds = new JTextField("10");
	private	JTextField tfSecondsWork = new JTextField("20");
	private	JTextField tfSecondsRest = new JTextField("10");
		
	// Buttons 
	private	JButton btnStart = new JButton("START");
		
	private	String strRounds;
	private	String strSecondsWork;
	private	String strSecondsRest;
		
	private	Integer intRounds;
	private	Integer intSecondsWork;
	private	Integer intSecondsRest;
		
	private	Thread actualizador = new Thread(this);
		
	private	Beep beep;
	
	
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
		
		// lblInvalid
		super.setFeaturesLabel(lblInvalid);
		lblInvalid.setBounds(285, 650, 150, 55);
		
		// lblRoundDisplay
		super.setFeaturesSpecialLabels(lblRoundsDisplay);
		this.lblRoundsDisplay.setBounds(150, 100, 150, 150);
		
		// lblSecondsWorkDisplay
		super.setFeaturesSpecialLabels(lblWorkDisplay);
		this.lblWorkDisplay.setBounds(350, 100, 150, 150);
		
		// lblRoundDisplay
		super.setFeaturesSpecialLabels(lblSecondsRestDisplay);
		this.lblSecondsRestDisplay.setBounds(350, 100, 150, 150);
		
		this.add(lblInvalid);
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
	

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		
		try {
			beep = new Beep();
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
			e1.printStackTrace();
		}
		
		// Doing/invoking the method of the superclass so it takes care 
		if(e.getSource() == super.goBack) {
			super.actionPerformed(e);
				beep.clip.stop();
				actualizador.stop();
		}
		else if(e.getSource() == this.btnStart) {
			/* We get the values from the textFields */
			this.strRounds = this.tfRounds.getText();
			this.strSecondsRest = this.tfSecondsRest.getText();
			this.strSecondsWork = this.tfSecondsWork.getText();
			
			if(this.strRounds.isBlank() || this.strSecondsRest.isBlank() || this.strSecondsWork.isBlank()) {
				this.lblInvalid.setText("INVALID");
			}
			else {
				/* We get the values from the textFields */
				assignValues();
	
				/* We remove all of the components */
				super.removeComponents();
				
				/* We add the labels related to the getready */
				this.add(super.lblSecondsReady);
				this.add(super.lblGetReady);	
				
				/* we start the run method */
				actualizador.start();
			}
		}
	}


	@Override
	public void run() {
		
		
		super.gettingReadyTimer(super.lblSecondsReady);
		super.removeComponents();
		
		
		this.add(lblRoundsDisplay);
		this.add(lblWorkDisplay);
		this.add(lblSecondsRestDisplay);
		
		for(Integer i = 1; i <= this.intRounds; i++) {
			
			this.strRounds = i.toString();
			this.lblRoundsDisplay.setText(strRounds);
			
			// INNER LOOP SECONDS OF WORK
			for(Integer j = this.intSecondsWork; j > 0; j--) {
				this.lblWork.setText("WORK");
				this.add(lblWork);
				this.lblWork.setBounds(330, 0, 150, 150);
				
				if(j < 4) {	
					try {
						beep = new Beep();
						beep.play();
					} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
						e.printStackTrace();
					}
				}
					
				/* Assigning seconds to the label*/ 
				this.strSecondsWork = j.toString();
	            this.lblWorkDisplay.setText(strSecondsWork);
	           
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}	
			}
			/* Setting the lblWork and lblWork display to empty */
			this.lblWork.setText("");
			this.lblWorkDisplay.setText("");
			// INNER LOOP FOR REST
			for(Integer k = this.intSecondsRest; k > 0; k--) {
				/* Setting the features of the labels above the seconds*/
				this.lblRest.setText("REST");
				this.lblRest.setBounds(350, 0, 150, 150);
				this.add(lblRest);
				
				/* Setting the sounds when the lable is lower than 4 */
				if(k < 4) {
					try {
						beep = new Beep();
						beep.play();
					} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
						e.printStackTrace();
					}
				}
				
				/* Display of the seconds of rest */ 
				this.strSecondsRest = k.toString();
		        this.lblSecondsRestDisplay.setText(strSecondsRest);
		           
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}	
			}
			/* We set these to empty so that the next round can be displayed */ 
			 this.lblSecondsRestDisplay.setText("");
			 this.lblRest.setText("");
			 
			 if(i == this.intRounds) {
					super.removeComponents();
					JLabel lblDone = new JLabel("DONE");
					lblDone.setBounds(210, 200, 300,300);
					lblDone.setFont(new Font("MV Boli", Font.BOLD, 100));
					this.add(lblDone);
				}
		}
}
	
	public void assignValues() {		
		this.intRounds = Integer.parseInt(strRounds);
		this.intSecondsRest = Integer.parseInt(strSecondsRest);
		this.intSecondsWork = Integer.parseInt(strSecondsWork);
		
		this.lblRoundsDisplay.setText(strRounds);
		this.lblWorkDisplay.setText(strSecondsWork);
	}

}
