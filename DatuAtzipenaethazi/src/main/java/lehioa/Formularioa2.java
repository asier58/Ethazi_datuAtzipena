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
import javax.swing.JComboBox;

public class Formularioa2 extends JFrame {

	private JPanel contentPane;
	private JLabel lblLangKod;
	private JLabel lblIzena;
	private JLabel lblAbizena;
	private JLabel lblDeptKod;
	private JTextField textField_langKod;
	private JTextField textField_izena;
	private JTextField textField_abizena;
	private JTextField textField_deptKod;
	private JButton btnGorde;
	private JButton btnEzabatu;
	private JButton btnAtzera;
	private Menukontroladorea menukontroladorea;
	private JComboBox comboBox = new JComboBox();

	public Formularioa2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 376);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField_langKod = new JTextField();
		textField_langKod.setBounds(144, 11, 181, 20);
		contentPane.add(textField_langKod);
		textField_langKod.setColumns(10);
		
		lblLangKod = new JLabel("Departamentu Zenbakia:");
		lblLangKod.setBounds(10, 11, 124, 20);
		contentPane.add(lblLangKod);
		
		lblIzena = new JLabel("Izena:");
		lblIzena.setBounds(10, 48, 39, 14);
		contentPane.add(lblIzena);
		
		textField_izena = new JTextField();
		textField_izena.setBounds(144, 42, 181, 20);
		contentPane.add(textField_izena);
		textField_izena.setColumns(10);
		
		lblAbizena = new JLabel("Eraikina:");
		lblAbizena.setBounds(10, 84, 50, 14);
		contentPane.add(lblAbizena);
		
		textField_abizena = new JTextField();
		textField_abizena.setBounds(144, 81, 181, 20);
		contentPane.add(textField_abizena);
		textField_abizena.setColumns(10);
		
		lblDeptKod = new JLabel("Zentroa:");
		lblDeptKod.setBounds(10, 122, 102, 14);
		contentPane.add(lblDeptKod);
		
		textField_deptKod = new JTextField();
		textField_deptKod.setBounds(144, 119, 181, 20);
		contentPane.add(textField_deptKod);
		textField_deptKod.setColumns(10);
		
		btnGorde = new JButton("GORDE");
		btnGorde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String langKod = textField_langKod.getText();
				String izena = textField_izena.getText();
				String abizena = textField_abizena.getText();
				String deptKod = textField_deptKod.getText();
				
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
				
			}
		});
		btnEzabatu.setBounds(236, 303, 89, 23);
		contentPane.add(btnEzabatu);
		
		btnAtzera = new JButton("ATZERA");
		btnAtzera.setBounds(137, 303, 89, 23);
		contentPane.add(btnAtzera);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String operazioa = (String) comboBox.getSelectedItem();
				if(operazioa.equalsIgnoreCase("Txertatu")) {
					
					
				}
			}
		});
		
		
		comboBox.setBounds(32, 187, 80, 20);
		contentPane.add(comboBox);
		comboBox.addItem("Txertatu");
		comboBox.addItem("Ezabatu");
		comboBox.addItem("Aldatu");
		
	}
	public void nireMenukontroladorea(Menukontroladorea menukontroladorea) {
		this.menukontroladorea = menukontroladorea;
	}
}
