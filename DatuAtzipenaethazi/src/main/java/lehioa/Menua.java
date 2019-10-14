package lehioa;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kontroladorea.Menukontroladorea;
import javax.swing.JButton;

public class Menua extends JFrame {

	private JPanel contentPane;
	private Menukontroladorea menukontroladorea;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public Menua() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(10, 45, 229, 72);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(56, 146, 317, 90);
		contentPane.add(btnNewButton_1);
	}
	
	
	public void nireMenukontroladorea(Menukontroladorea menukontroladorea) {
		this.menukontroladorea = menukontroladorea;
	}

}
