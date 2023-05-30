package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

public abstract class GeneralWindow extends JFrame implements ActionListener{
	// Attributes
	JButton goBack;
	JLabel titulo;
	ImageIcon leftArrow = new ImageIcon("left-white-arrow.png");
	JFrame mainFrame;

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
	goBack.setBorder(new LineBorder(Color.black));
	goBack.addActionListener(this);
	
	
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
}
	
