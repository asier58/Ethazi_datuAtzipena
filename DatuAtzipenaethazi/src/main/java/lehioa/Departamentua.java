package lehioa;

import java.awt.BorderLayout;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.apache.log4j.Logger;

import eredua.departamentua;
import kontroladorea.Menukontroladorea;
import kontroladorea.Nagusia;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;

public class Departamentua extends JFrame {

	private JPanel contentPane;
	private Menukontroladorea menukontroladorea;
	private JTextField textField;
	private String fitxategi;
	private String formatua;
	private JComboBox comboBox;
	public static Logger logger = Logger.getLogger(Departamentua.class);
<<<<<<< Upstream, based on branch 'master' of https://github.com/asier58/Ethazi_datuAtzipena.git
	private JLabel lblNewLabel;
=======

>>>>>>> ac2480d Datu baserako konexioa FINAL
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Enplegatua frame = new Enplegatua();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Departamentua() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 616, 410);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton departamentuberri = new JButton("Departamentua sartu");
		departamentuberri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menukontroladorea.departamentuaPantailara();
			}
		});
		departamentuberri.setBounds(117, 53, 381, 47);
		contentPane.add(departamentuberri);

		JButton departamentuaikusi = new JButton("Departamentua ikusi");
		departamentuaikusi.setBounds(117, 159, 381, 47);
		contentPane.add(departamentuaikusi);

		JButton fitxategiaKargatu = new JButton("Fitxategia Kargatu");
		fitxategiaKargatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewLabel.setVisible(false);
				formatua=(String)comboBox.getSelectedItem();
				fitxategi =textField.getText();
				logger.info("Parametruak hartu dira: "+fitxategi+" "+formatua);
				menukontroladorea.parametroakHartu(fitxategi,formatua);
			}
		});
		fitxategiaKargatu.setBounds(410, 265, 151, 47);
		contentPane.add(fitxategiaKargatu);

		textField = new JTextField();
		textField.setBounds(164, 278, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
<<<<<<< Upstream, based on branch 'master' of https://github.com/asier58/Ethazi_datuAtzipena.git
		
		 comboBox = new JComboBox();
=======

		JComboBox comboBox = new JComboBox();
>>>>>>> ac2480d Datu baserako konexioa FINAL
		comboBox.setBounds(289, 278, 86, 20);
		contentPane.add(comboBox);

		JLabel lblFitxategiarenIzena = new JLabel("Fitxategiaren Izena:");
		lblFitxategiarenIzena.setBounds(40, 281, 114, 14);
		contentPane.add(lblFitxategiarenIzena);
<<<<<<< Upstream, based on branch 'master' of https://github.com/asier58/Ethazi_datuAtzipena.git
		
		lblNewLabel = new JLabel("Fitxategia ez da existitzen");
		lblNewLabel.setBounds(65, 333, 308, 14);
		contentPane.add(lblNewLabel);
		lblNewLabel.setVisible(false);
		
		ArrayList<String> fitxategiMota = new  ArrayList();
=======
		ArrayList<String> fitxategiMota = new ArrayList();
>>>>>>> ac2480d Datu baserako konexioa FINAL
		fitxategiMota.add(".Csv");
		fitxategiMota.add(".Xml");
		fitxategiMota.add(".Txt");
		int cont = 0;
		for (int i = 0; i < fitxategiMota.size(); i++) {
			if (cont == 0) {
				comboBox.addItem("");
				cont++;
			}
			comboBox.addItem(fitxategiMota.get(i));

		}
		logger.info("Departamentu Pantailan sartu da");
	}

	public void nireMenukontroladorea(Menukontroladorea menukontroladorea) {
		this.menukontroladorea = menukontroladorea;
	}

	public void erroreaAtera() {
		lblNewLabel.setVisible(true);
		
	}


}
