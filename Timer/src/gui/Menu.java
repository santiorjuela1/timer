package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class Menu extends JFrame implements ActionListener{

	private JButton btnAMRAP;
	private JButton btnClock;
	private JButton btnTABATA;
	private JButton btnEMOW;

	/**
	 * Create the application.
	 */
	public Menu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(750,750);
		this.setLocationRelativeTo(null);
		this.setTitle("Timer");
		this.setLayout(null);
		this.getContentPane().setBackground(Color.black);
		this.setResizable(false);
		
		btnClock = new JButton("Clock");
		btnClock.setBounds(235, 75, 250, 100);
		settingButtonsFeatures(btnClock);
		
		btnAMRAP = new JButton("AMRAP");
		btnAMRAP.setBounds(235, 225, 250, 100);
		settingButtonsFeatures(btnAMRAP);
		
		btnTABATA = new JButton("TABATA");
		btnTABATA.setBounds(235, 375, 250, 100);
		settingButtonsFeatures(btnTABATA);
		
		btnEMOW = new JButton("EMOW");
		btnEMOW.setBounds(235, 525, 250, 100);
		settingButtonsFeatures(btnEMOW);
		

		this.add(btnAMRAP);
		this.add(btnClock);
		this.add(btnTABATA);
		this.add(btnEMOW);
		
		this.setVisible(true);
	}
	
	private void settingButtonsFeatures(JButton button) {
		button.setFont(new Font("MV Boli", Font.BOLD, 30));
		button.setForeground(Color.white);
		button.addActionListener(this);
		button.setFocusable(false);
		button.setHorizontalAlignment(JTextField.CENTER);
		button.setBackground(Color.black);
		button.setBorder(new LineBorder(Color.white, 5));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnClock) {
			Clock clock = new Clock(this);
			
			Thread hiloActualizador = new Thread(clock);
			hiloActualizador.start();
		}
		else if(e.getSource() == btnTABATA) {
			TABATA tabataWindow = new TABATA(this);
			
			//Thread hizoActualizador = new Thread(tabataWindow);
			
		}
		else if(e.getSource() == btnAMRAP) {
			AMRAP amrapWindow = new AMRAP(this);
			
			//Thread hiloActualizador = new Thread(amrapWindow);
			//hiloActualizador.start();
		}
		else if(e.getSource() == btnEMOW) {
			EMOM emowWindow = new EMOM(this);
		}
		
	}

}
