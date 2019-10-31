package lehioa;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kontroladorea.Menukontroladorea;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import eredua.langilea;
import kontroladorea.Menukontroladorea;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

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
	private JTextField textField_ardura;
	private JTextField textField_dataOrdua;
	private JButton btnGorde;
	private JButton btnEzabatu;
	private JButton btnAtzera;
	private JComboBox comboBox;
	ArrayList<langilea> langileArr;
	langilea l1;

	private Menukontroladorea menukontroladorea;

	public Formularioa() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 376);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField_langKod = new JTextField();
		textField_langKod.setBounds(109, 11, 181, 20);
		contentPane.add(textField_langKod);
		textField_langKod.setColumns(10);

		lblLangKod = new JLabel("Langilearen kodea");
		lblLangKod.setBounds(10, 11, 89, 20);
		contentPane.add(lblLangKod);

		lblIzena = new JLabel("Izena");
		lblIzena.setBounds(10, 48, 27, 14);
		contentPane.add(lblIzena);

		textField_izena = new JTextField();
		textField_izena.setBounds(51, 45, 239, 20);
		contentPane.add(textField_izena);
		textField_izena.setColumns(10);

		lblAbizena = new JLabel("Abizena");
		lblAbizena.setBounds(10, 84, 39, 14);
		contentPane.add(lblAbizena);

		textField_abizena = new JTextField();
		textField_abizena.setBounds(61, 81, 229, 20);
		contentPane.add(textField_abizena);
		textField_abizena.setColumns(10);

		lblDeptKod = new JLabel("Departamentu kodea");
		lblDeptKod.setBounds(10, 122, 102, 14);
		contentPane.add(lblDeptKod);

		textField_deptKod = new JTextField();
		textField_deptKod.setBounds(122, 119, 168, 20);
		contentPane.add(textField_deptKod);
		textField_deptKod.setColumns(10);

		lblSoldata = new JLabel("Soldata");
		lblSoldata.setBounds(10, 157, 39, 14);
		contentPane.add(lblSoldata);

		textField_soldata = new JTextField();
		textField_soldata.setBounds(61, 154, 229, 20);
		contentPane.add(textField_soldata);
		textField_soldata.setColumns(10);

		lblNagusia = new JLabel("Nagusia");
		lblNagusia.setBounds(10, 191, 39, 14);
		contentPane.add(lblNagusia);

		textField_nagusia = new JTextField();
		textField_nagusia.setBounds(61, 188, 229, 20);
		contentPane.add(textField_nagusia);
		textField_nagusia.setColumns(10);

		lblArdura = new JLabel("Ardura");
		lblArdura.setBounds(10, 221, 33, 14);
		contentPane.add(lblArdura);

		textField_ardura = new JTextField();
		textField_ardura.setBounds(61, 219, 229, 20);
		contentPane.add(textField_ardura);
		textField_ardura.setColumns(10);

		lblDataOrdua = new JLabel("Data / Ordua");
		lblDataOrdua.setBounds(10, 257, 63, 14);
		contentPane.add(lblDataOrdua);

		textField_dataOrdua = new JTextField();
		textField_dataOrdua.setBounds(83, 254, 206, 17);
		contentPane.add(textField_dataOrdua);
		textField_dataOrdua.setColumns(10);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "INSERT", "UPDATE", "DELETE" }));
		comboBox.setBounds(300, 12, 124, 18);
		contentPane.add(comboBox);

		btnGorde = new JButton("GORDE");
		btnGorde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (comboBox.getSelectedItem().equals("UPDATE")) {
					textField_langKod.setEditable(false);
				}else if (comboBox.getSelectedItem().equals("DELETE")) {
					
				}
				
				int langKod = Integer.parseInt(textField_langKod.getText());
				int soldata = Integer.parseInt(textField_soldata.getText());
				int dept_noZenbkia = Integer.parseInt(textField_deptKod.getText());
				int nagusia = Integer.parseInt(textField_nagusia.getText());

				l1.setIzena(textField_izena.getText());
				l1.setAbizena(textField_abizena.getText());
				l1.setLangile_kod(langKod);
				l1.setSoldata(soldata);
				l1.setArdura(textField_ardura.getText());
				l1.setDept_nozenbakia(dept_noZenbkia);
				l1.setNagusia(nagusia);
				l1.setDataOrdua(textField_dataOrdua.getText());

				langileArr.add(l1);
				
				menukontroladorea.getData(langileArr);
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
				textField_ardura.setText(null);
				textField_dataOrdua.setText(null);

			}
		});
		btnEzabatu.setBounds(236, 303, 89, 23);
		contentPane.add(btnEzabatu);

		btnAtzera = new JButton("ATZERA");
		btnAtzera.setBounds(137, 303, 89, 23);
		contentPane.add(btnAtzera);

	}

	public void nireMenukontroladorea(Menukontroladorea menukontroladorea) {
		this.menukontroladorea = menukontroladorea;
	}
}
