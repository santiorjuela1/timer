package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
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
import javax.swing.border.LineBorder;

import sounds.Beep;

public abstract class GeneralWindow extends JFrame implements ActionListener{
	// Attributes
	JButton goBack;
	JLabel titulo;
	ImageIcon leftArrow = new ImageIcon("left-white-arrow.png");
	JFrame mainFrame;
	Beep beep = Beep.getInstance();
	JLabel lblGetReady = new JLabel("GET READY!");	
	JLabel lblSecondsReady = new JLabel();

	GeneralWindow(JFrame frame){
		this.mainFrame = frame;
		initialize();
	}
	
	public void initialize(){
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setSize(750,750);
	this.setLocationRelativeTo(null);
	this.setLayout(null);
	this.getContentPane().setBackground(Color.black);
	this.setResizable(false);
	
	titulo = new JLabel();
	titulo.setForeground(Color.white);
	titulo.setFont(new Font("MV Boli", Font.BOLD, 50));
	titulo.setBounds(275,100,300,75);
	
	goBack = new JButton("<-");
	goBack.setBounds(10, 10, 75, 50);
	goBack.setFont(new Font("MV Boli", Font.BOLD, 40));
	goBack.setFocusable(false);
	goBack.setForeground(Color.white);
	goBack.setBackground(Color.black);
	goBack.setBorder(new LineBorder(Color.white));
	goBack.addActionListener(this);
	
	this.setFeaturesLabel(lblGetReady);
	this.lblGetReady.setBounds(275, 0, 200, 200);
	
	this.setFeaturesSpecialLabels(lblSecondsReady);
	this.lblSecondsReady.setBounds(350, 100, 200, 200);
	
	
	this.add(goBack);
	this.add(titulo);
	this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == goBack) {
			this.mainFrame.setVisible(true);
			this.dispose();
		}
		
	}
	
	public void setFeaturesLabel(JLabel label) {
		label.setFont(new Font("MV Boli", Font.BOLD, 30));
		label.setFocusable(false);
		label.setForeground(Color.white);
		//label.setBorder(new LineBorder(Color.black));
	}
	
	public void setFeaturesTextField (JTextField field) {
		field.setFont(new Font("MV Boli", Font.BOLD, 30));
		field.setForeground(Color.white);
		field.setBorder(new LineBorder(Color.white));
		field.setBackground(Color.black);
		field.setHorizontalAlignment(JTextField.CENTER);
		field.setEditable(true);
		field.setEnabled(true);
		field.getText();
	}
	
	public void setFeaturesButton(JButton button) {
		button.setFont(new Font("MV Boli", Font.BOLD, 30));
		button.setFocusable(false);
		button.setForeground(Color.white);
		button.setBorder(new LineBorder(Color.white));
		button.setBackground(Color.black);
		button.setHorizontalAlignment(JTextField.CENTER);
		button.addActionListener(this);
	}
	
	public void removeComponents() {
		Component[] components = getContentPane().getComponents();
        for (Component component : components) {
            if (component != this.goBack) {
                getContentPane().remove(component);
            }
        }
        getContentPane().setBackground(getContentPane().getBackground());
        repaint();
	}
	
	public void setFeaturesSpecialLabels(JLabel label) {
		label.setFont(new Font("MV Boli", Font.BOLD, 70));
		label.setFocusable(false);
		label.setForeground(Color.red);
	}
	
	public void gettingReadyTimer(JLabel label) {
		String valueLbl;
		for(Integer i = 9; i > 0; i--) {
			if (i < 4 && !beep.clip.isRunning()) {
		        beep.play();
		    }
			
			valueLbl = i.toString();
			label.setText(valueLbl);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		label.setText("");
	}
}
	
