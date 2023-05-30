package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TABATA extends JFrame implements ActionListener{
	
	JButton goBack;
	JFrame mainFrame;
	JLabel titulo;
	ImageIcon leftArrow = new ImageIcon("left-arrow-java.png");
	
	public TABATA(JFrame frame) {
		
		this.mainFrame = frame;
		initialize();
		
	}
	
	public void initialize() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(750,750);
		this.setLocationRelativeTo(null);
		this.setTitle("TABATA");
		this.setLayout(null);
		this.getContentPane().setBackground(Color.black);
		this.setResizable(false);
		
		titulo = new JLabel("TABATA");
		titulo.setForeground(Color.white);
		titulo.setFont(new Font("MV Boli", Font.BOLD, 50));
		titulo.setBounds(235,15,300,200);
		
		goBack = new JButton();
		goBack.setIcon(leftArrow);
		goBack.setBounds(10, 10, 50, 50);
		goBack.addActionListener(this);
		
		this.add(goBack);
		this.add(titulo);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if(e.getSource() == goBack) {
			this.mainFrame.setVisible(true);
			this.dispose();

		}
		
	}

}
