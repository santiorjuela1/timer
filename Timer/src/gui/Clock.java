package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class Clock extends GeneralWindow implements Runnable{
	
	// Attributes
	JLabel lblTime = new JLabel();
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
	TimeUnit time = TimeUnit.SECONDS;
	Long timeToSleep = 1L;
	String strTime;
	
	
	
	Clock(JFrame mainFrame){
		super(mainFrame);
		this.setTitle("Clock");
		titulo.setText("Clock");
		
		super.setFeaturesLabel(lblTime);
		lblTime.setFont(new Font("MV Boli", Font.BOLD, 40));
		lblTime.setBounds(125, 50, 500, 500);		
		
	
		this.add(lblTime);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// Doing/invoking the method of the superclass so it takes care 
		super.actionPerformed(e);
	}
	
	@Override
	public void run() {
		while(true) {
			LocalDateTime currentTime = LocalDateTime.now();
			this.strTime = dtf.format(currentTime);
			SwingUtilities.invokeLater(() -> {
                this.lblTime.setText(strTime);
            });
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		
	}


	}	


