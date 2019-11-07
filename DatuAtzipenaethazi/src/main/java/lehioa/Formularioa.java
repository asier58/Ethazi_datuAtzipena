package lehioa;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.apache.log4j.Logger;

import eredua.langilea;
import kontroladorea.Menukontroladorea;

public class Formularioa extends JFrame {

	private JPanel contentPane;
	private JLabel lblLangKod;
	private JLabel lblIzena;
	private JLabel lblAbizena;
	private JLabel lblDeptKod;
	private JLabel lblSoldata;
	private JLabel lblNagusia;
	private JLabel lblArdura;
	private JLabel lblDataOrdua;
	private JTextField textField_langKod;
	private JTextField textField_izena;
	private JTextField textField_abizena;
	private JTextField textField_deptKod;
	private JTextField textField_soldata;
	private JTextField textField_nagusia;
	private JButton btnGorde;
	private JButton btnEzabatu;
	private JButton btnAtzera;
	private JComboBox comboBox;
	private ArrayList<langilea> langileArr = new ArrayList<langilea>();
	private langilea l1;
	private String data = null;
	private String ordua = null;
	private Date date = new Date();
	private JComboBox comboBox_ardura;
	
	public static Logger logger = Logger.getLogger(Menua.class);

	private Menukontroladorea menukontroladorea;

	public Formularioa() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 376);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField_langKod = new JTextField();
		textField_langKod.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char a = e.getKeyChar();
				if (!Character.isDigit(a)) {
					e.consume();
				}
			}
		});
		textField_langKod.setBounds(177, 11, 181, 20);
		contentPane.add(textField_langKod);
		textField_langKod.setColumns(10);

		lblLangKod = new JLabel("Langilearen kodea");
		lblLangKod.setBounds(10, 11, 89, 20);
		contentPane.add(lblLangKod);

		lblIzena = new JLabel("Izena");
		lblIzena.setBounds(10, 48, 27, 14);
		contentPane.add(lblIzena);

		textField_izena = new JTextField();
		textField_izena.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char a = e.getKeyChar();
				if ((((int) a >= 33 && (int) a <= 64)) || ((int) a >= 91 && (int) a <= 96)
						|| ((int) a >= 123 && (int) a <= 223)) {
					e.consume();
				}

			}
		});
		textField_izena.setBounds(119, 45, 239, 20);
		contentPane.add(textField_izena);
		textField_izena.setColumns(10);

		lblAbizena = new JLabel("Abizena");
		lblAbizena.setBounds(10, 84, 39, 14);
		contentPane.add(lblAbizena);

		textField_abizena = new JTextField();
		textField_abizena.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char a = e.getKeyChar();
				if ((((int) a >= 33 && (int) a <= 64)) || ((int) a >= 91 && (int) a <= 96)
						|| ((int) a >= 123 && (int) a <= 223)) {
					e.consume();
				}

			}
		});
		textField_abizena.setBounds(127, 81, 229, 20);
		contentPane.add(textField_abizena);
		textField_abizena.setColumns(10);

		lblDeptKod = new JLabel("Departamentu kodea");
		lblDeptKod.setBounds(10, 122, 102, 14);
		contentPane.add(lblDeptKod);

		textField_deptKod = new JTextField();
		textField_deptKod.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char a = e.getKeyChar();
				if (!Character.isDigit(a)) {
					e.consume();
				}
			}
		});
		textField_deptKod.setBounds(188, 119, 168, 20);
		contentPane.add(textField_deptKod);
		textField_deptKod.setColumns(10);

		lblSoldata = new JLabel("Soldata");
		lblSoldata.setBounds(10, 157, 39, 14);
		contentPane.add(lblSoldata);

		textField_soldata = new JTextField();
		textField_soldata.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char a = e.getKeyChar();
				if (!Character.isDigit(a) && a != ',') {
					e.consume();
				}
			}
		});
		textField_soldata.setBounds(127, 154, 229, 20);
		contentPane.add(textField_soldata);
		textField_soldata.setColumns(10);

		lblNagusia = new JLabel("Nagusia");
		lblNagusia.setBounds(10, 191, 39, 14);
		contentPane.add(lblNagusia);

		textField_nagusia = new JTextField();
		textField_nagusia.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char a = e.getKeyChar();
				if (!Character.isDigit(a)) {
					e.consume();
				}
			}
		});
		textField_nagusia.setBounds(127, 188, 229, 20);
		contentPane.add(textField_nagusia);
		textField_nagusia.setColumns(10);

		lblArdura = new JLabel("Ardura");
		lblArdura.setBounds(10, 221, 33, 14);
		contentPane.add(lblArdura);

		comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBox.getSelectedItem().equals("Aldatu")) {
					textField_langKod.setEditable(false);
					textField_langKod.setEnabled(false);

					textField_izena.setEditable(true);
					textField_abizena.setEditable(true);
					comboBox_ardura.setEditable(true);
					comboBox_ardura.setEnabled(true);
					textField_deptKod.setEditable(true);
					textField_nagusia.setEditable(true);
					textField_soldata.setEditable(true);
					textField_izena.setEnabled(true);
					textField_abizena.setEnabled(true);
					textField_deptKod.setEnabled(true);
					textField_nagusia.setEnabled(true);
					textField_soldata.setEnabled(true);
				} else if (comboBox.getSelectedItem().equals("Ezabatu")) {
					textField_langKod.setEditable(true);
					textField_langKod.setEnabled(true);

					textField_izena.setEditable(false);
					textField_abizena.setEditable(false);
					textField_deptKod.setEditable(false);
					textField_nagusia.setEditable(false);
					textField_soldata.setEditable(false);
					textField_izena.setEnabled(false);
					comboBox_ardura.setEditable(false);
					comboBox_ardura.setEnabled(false);
					textField_abizena.setEnabled(false);
					textField_deptKod.setEnabled(false);
					textField_nagusia.setEnabled(false);
					textField_soldata.setEnabled(false);
				} else if (comboBox.getSelectedItem().equals("Txertatu")) {
					textField_langKod.setEnabled(true);
					comboBox_ardura.setEditable(true);
					comboBox_ardura.setEnabled(true);
					textField_izena.setEditable(true);
					textField_abizena.setEditable(true);
					textField_deptKod.setEditable(true);
					textField_nagusia.setEditable(true);
					textField_soldata.setEditable(true);
				}
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Txertatu", "Ezabatu", "Aldatu" }));
		comboBox.setBounds(10, 305, 115, 18);
		contentPane.add(comboBox);

		btnGorde = new JButton("GORDE");
		btnGorde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DateFormat hourFormat = new SimpleDateFormat("HH:mm");
				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				data = dateFormat.format(date).toString();
				ordua = hourFormat.format(date).toString();
				
				int langKod = Integer.parseInt(textField_langKod.getText());
				int soldata = Integer.parseInt(textField_soldata.getText());
				int dept_noZenbkia = Integer.parseInt(textField_deptKod.getText());
				int nagusia = Integer.parseInt(textField_nagusia.getText());

				l1 = new langilea(langKod, dept_noZenbkia, soldata, textField_izena.getText(),
						textField_abizena.getText(), nagusia, (String) comboBox.getSelectedItem(),
						ordua + ", " + data);

				if(!menukontroladorea.getArdura(l1).equals(null)) {
					JOptionPane.showMessageDialog(null, "Kodea ez da existitzen", "InfoBox",
							JOptionPane.INFORMATION_MESSAGE);
				}
				if (comboBox.getSelectedItem().equals("Txertatu")) {
					menukontroladorea.getData(l1);
				} else if (comboBox.getSelectedItem().equals("Aldatu")) {
					menukontroladorea.enplegatuaBerritu(l1);
				} else if (comboBox.getSelectedItem().equals("Ezabatu")) {
					menukontroladorea.enplegatuaEzabatu(l1);
				}
			}
		});
		btnGorde.setBounds(335, 303, 89, 23);
		contentPane.add(btnGorde);

		btnEzabatu = new JButton("EZABATU");
		btnEzabatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_langKod.setText(null);
				textField_izena.setText(null);
				textField_abizena.setText(null);
				textField_deptKod.setText(null);
				textField_soldata.setText(null);
				textField_nagusia.setText(null);

			}
		});
		btnEzabatu.setBounds(236, 303, 89, 23);
		contentPane.add(btnEzabatu);

		btnAtzera = new JButton("ATZERA");
		btnAtzera.setBounds(137, 303, 89, 23);
		contentPane.add(btnAtzera);
		
		comboBox_ardura = new JComboBox();
		comboBox_ardura.setModel(new DefaultComboBoxModel(new String[] {"", "Irakasle", "Irakasketa Burua", "Zuzedari", "Eskolazain"}));
		comboBox_ardura.setBounds(153, 218, 205, 20);
		contentPane.add(comboBox_ardura);

	}

	public void nireMenukontroladorea(Menukontroladorea menukontroladorea) {
		this.menukontroladorea = menukontroladorea;
	}
}
