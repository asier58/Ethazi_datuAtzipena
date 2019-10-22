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
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;

public class Departamentua extends JFrame {

	private JPanel contentPane;
	private Menukontroladorea menukontroladorea;
	private JTextField textField;
	public static Logger logger = Logger.getLogger(Departamentua.class);

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
		fitxategiaKargatu.setBounds(410, 265, 151, 47);
		contentPane.add(fitxategiaKargatu);

		textField = new JTextField();
		textField.setBounds(164, 278, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(289, 278, 86, 20);
		contentPane.add(comboBox);

		JLabel lblFitxategiarenIzena = new JLabel("Fitxategiaren Izena:");
		lblFitxategiarenIzena.setBounds(40, 281, 114, 14);
		contentPane.add(lblFitxategiarenIzena);
		ArrayList<String> fitxategiMota = new ArrayList();
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
}
