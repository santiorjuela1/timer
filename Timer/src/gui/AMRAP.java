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
import javax.swing.SwingUtilities;

import sounds.Beep;
import threads.MyThread;

public class AMRAP extends GeneralWindow implements Runnable{
	
	JLabel lblFor = new JLabel("FOR");
	JLabel lblSeconds = new JLabel("SECONDS");
	JLabel lblTime = new JLabel();
	JLabel lblDone = new JLabel("DONE");
	JTextField tfMinutes = new JTextField();
	JButton btnStart = new JButton("START");
	String strMinutes;
	Thread actualizador = new Thread(this);
	//MyThread thread = new MyThread();
	

	public AMRAP(JFrame frame) {
		super(frame);
		this.setTitle("AMRAP");
		this.titulo.setText("AMRAP");
		
		// lblFor
		super.setFeaturesLabel(lblFor);
		this.lblFor.setBounds(200, 300, 150, 55);
		
		// lblMinutes
		super.setFeaturesLabel(lblSeconds);
		this.lblSeconds.setBounds(450, 300, 150, 55);
		
		// tfMinutes
		super.setFeaturesTextField(tfMinutes);
		this.tfMinutes.setBounds(285, 300, 150, 55);
		
		// btnStart
		super.setFeaturesButton(btnStart);
		this.btnStart.setBounds(285, 400, 150, 55);
		
		// lblTime
		this.lblDone.setBounds(300, 300, 250, 250);
		

		this.add(lblTime);
		this.add(lblFor);
		this.add(tfMinutes);
		this.add(lblSeconds);
		this.add(btnStart);
	}

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
			
			this.strMinutes = tfMinutes.getText();
			
			if(this.strMinutes.isEmpty()) {
				this.lblTime.setBounds(300, 500,200,55);
				this.lblTime.setText("INVALID");
			}
			else {
				
			// Desabilitamos el textfield y el boton
			this.tfMinutes.setEnabled(false);
			this.btnStart.setEnabled(false);
			
			super.removeComponents();
			
			this.add(super.lblSecondsReady);
			this.add(super.lblGetReady);
			

			// Ejecuto el metodo run
			actualizador.start();
			}
		}
	}

	@Override
	public void run() {
		
		super.gettingReadyTimer(super.lblSecondsReady);
		super.removeComponents();
		
		Integer segundos = Integer.parseInt(this.strMinutes);
		//Integer segundos =  intMinutos * 60
		
		while(segundos > 0) {
			
			super.setFeaturesLabel(lblTime);
			this.lblTime.setBounds(300, 100, 300, 300);
			this.lblTime.setSize(500,500);
			this.lblTime.setFont(new Font("MV Boli", Font.BOLD, 200));
			this.add(lblTime);

				
			this.strMinutes = segundos.toString();
			 SwingUtilities.invokeLater(() -> {
		            this.lblTime.setText(strMinutes);
		        });
           
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			segundos--;
			if(segundos <= 0) {
				 SwingUtilities.invokeLater(() -> {
					 this.lblTime.setBounds(200, 100, 300, 300);
					 this.lblTime.setFont(new Font("MV Boli", Font.BOLD, 100));
					 	this.lblTime.setText("DONE");
			        });
			}
			else if (segundos <= 3) {
		            try {
		                Beep beep = new Beep();
		                beep.play(); 
		            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
		                e.printStackTrace(); 
		            }
		        }
			}
		
		}
	}


	



