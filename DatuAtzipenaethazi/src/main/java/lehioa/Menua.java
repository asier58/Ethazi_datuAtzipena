package lehioa;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.apache.log4j.Logger;

import kontroladorea.Menukontroladorea;
import kontroladorea.Nagusia;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menua extends JFrame {
	public static Logger logger = Logger.getLogger(Menua.class);
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
		setBounds(100, 100, 616, 410);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton departamentua = new JButton("Departamentua");
		departamentua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menukontroladorea.departamentuaPantailara();
			}
		});
		departamentua.setBounds(117, 53, 381, 47);
		contentPane.add(departamentua);

		JButton enplegatua = new JButton("Enplegatua");
		enplegatua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				menukontroladorea.langilePantailara();
			}
		});
		enplegatua.setBounds(117, 159, 381, 47);
		contentPane.add(enplegatua);

		JButton txostena = new JButton("Txostena");
		txostena.setBounds(117, 267, 381, 47);
		contentPane.add(txostena);
		logger.info("Menu Pantailan sartu da");
	}

	public void nireMenukontroladorea(Menukontroladorea menukontroladorea) {
		this.menukontroladorea = menukontroladorea;
	}
}
