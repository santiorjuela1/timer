package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Clock extends GeneralWindow{
	
	// Attributes
	
	Clock(JFrame mainFrame){
		super(mainFrame);
		this.setTitle("Clock");
		titulo.setText("Clock");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// Doing/invoking the method of the superclass so it takes care 
		super.actionPerformed(e);
	}
}
