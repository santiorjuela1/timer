package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Clock extends GeneralWindow{
	
	// Attributes
	JLabel lblTime = new JLabel();
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
	LocalDateTime currentTime = LocalDateTime.now();
	String time;
	
	
	Clock(JFrame mainFrame){
		super(mainFrame);
		this.setTitle("Clock");
		titulo.setText("Clock");
		
		super.setFeaturesLabel(lblTime);
		lblTime.setFont(new Font("MV Boli", Font.BOLD, 40));
		lblTime.setBounds(125, 50, 500, 500);		
		
		currentTime();
		this.add(lblTime);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// Doing/invoking the method of the superclass so it takes care 
		super.actionPerformed(e);
	}
	
	public void currentTime() {
		//while(true) {
			this.time = dtf.format(currentTime);
			this.lblTime.setText(time);
		/*	try {
				Thread.sleep(1000);
				
			} catch (InterruptedException e){
				e.printStackTrace();
			}*/
		}
	}

