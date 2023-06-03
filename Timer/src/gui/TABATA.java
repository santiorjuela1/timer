package gui;

import java.awt.Color;
import java.awt.Component;
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
import javax.swing.SwingUtilities;

import sounds.Beep;

public class TABATA extends GeneralWindow implements Runnable{
	
	// Attributes
	
	// Labels
	JLabel lblFor = new JLabel("FOR");
	JLabel lblRounds = new JLabel("ROUNDS");
	JLabel lblWork = new JLabel("WORK");
	JLabel lblSecondsWork = new JLabel("SECONDS");
	JLabel lblRest = new JLabel("REST");
	JLabel lblSecondsRest = new JLabel("SECONDS");
	
	JLabel lblRoundsDisplay = new JLabel();
	JLabel lblWorkDisplay = new JLabel();
	JLabel lblSecondsRestDisplay = new JLabel();
	
	// TextFields
	JTextField tfRounds = new JTextField("10");
	JTextField tfSecondsWork = new JTextField("20");
	JTextField tfSecondsRest = new JTextField("10");
	
	// Buttons 
	JButton btnStart = new JButton("START");
	
	String strRounds;
	String strSecondsWork;
	String strSecondsRest;
	
	Integer intRounds;
	Integer intSecondsWork;
	Integer intSecondsRest;
	
	Thread actualizador = new Thread(this);
	
	Beep beep;
	
	
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
		
		// lblRoundDisplay
		super.setFeaturesSpecialLabels(lblRoundsDisplay);
		this.lblRoundsDisplay.setBounds(150, 100, 150, 150);
		
		// lblSecondsWorkDisplay
		super.setFeaturesSpecialLabels(lblWorkDisplay);
		this.lblWorkDisplay.setBounds(350, 100, 150, 150);
		
		// lblRoundDisplay
		super.setFeaturesSpecialLabels(lblSecondsRestDisplay);
		this.lblSecondsRestDisplay.setBounds(350, 100, 150, 150);
		
		
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
			// TODO Auto-generated catch block
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
			AssignValues();

			/* We remove all of the components */
			super.removeComponents();
			
			/* We add the labels related to the getready */
			this.add(super.lblSecondsReady);
			this.add(super.lblGetReady);	
			
			/* we start the run method */
			actualizador.start();
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
				this.lblWork.setBounds(350, 0, 150, 150);
				
				if(j < 4 && j != 0) {	
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
					Thread.sleep(100);
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
				if(k < 4 && k != 0) {
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
					Thread.sleep(100);
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
	
	public void AssignValues() {
		this.strRounds = this.tfRounds.getText();
		this.strSecondsRest = this.tfSecondsRest.getText();
		this.strSecondsWork = this.tfSecondsWork.getText();
		
		this.intRounds = Integer.parseInt(strRounds);
		this.intSecondsRest = Integer.parseInt(strSecondsRest);
		this.intSecondsWork = Integer.parseInt(strSecondsWork);
		
		this.lblRoundsDisplay.setText(strRounds);
		this.lblWorkDisplay.setText(strSecondsWork);
	}

}
