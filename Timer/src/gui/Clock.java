package gui;

import java.awt.Color;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Clock extends JFrame{
	
	// Attributes
	private JLabel lblTime;
	LocalTime currentTime =  LocalTime.now();
	JFrame menuFrame = new JFrame();
	SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm:ss a");
	int count = 0;
	ImageIcon leftArrow = new ImageIcon("left-arrow.png");
	
	Clock(JFrame mainFrame){
		
		this.menuFrame = mainFrame;
		initialize();
	}
	
	private void initialize() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(750,750);
		this.setLocationRelativeTo(null);
		this.setTitle("Clock");
		this.setLayout(null);
		this.getContentPane().setBackground(Color.black);
		this.setResizable(false);
		
		lblTime = new JLabel();
		lblTime.setForeground(Color.white);
		lblTime.setBounds(235,350,350, 300);
		lblTime.setFont(new Font("MV Boli", Font.BOLD, 50));
		//lblTime.setHorizontalAlignment(SwingConstants.CENTER);
		//lblTime.setVerticalAlignment(SwingConstants.CENTER);
		//settingLocalTime();
		
		this.add(lblTime);
		this.setVisible(true);
		
	}
	
	/*public void settingLocalTime() {
		while(count < 100) {
			String textCurrentTime = timeFormat.format(Calendar.getInstance().getTime());
			this.lblTime.setText(textCurrentTime);
			
			try {
				Thread.sleep(1000);
			}	
			catch (InterruptedException e) {
				e.printStackTrace();
			}
			count++;
		}
	}*/
	
	public void removePastFrame() {
		this.menuFrame.dispose();
	}

}
