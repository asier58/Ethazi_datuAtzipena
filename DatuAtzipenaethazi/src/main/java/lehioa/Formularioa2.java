package lehioa;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import eredua.departamentua;
import kontroladorea.Menukontroladorea;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;

public class Formularioa2 extends JFrame {

	private JPanel contentPane;
	private JLabel lblLangKod;
	private JLabel lblIzena;
	private JLabel lblAbizena;
	private JLabel lblDeptKod;
	private JTextField textField_depKod;
	private JTextField textField_izena;
	private JTextField textField_eraikina;
	private JButton btnGorde;
	private JButton btnEzabatu;
	private JButton btnAtzera;
	private Menukontroladorea menukontroladorea;
	private JComboBox comboBox = new JComboBox();
	private JLabel lblNewLabel;
	private JComboBox comboBox_1 =new JComboBox();;
	private String zentroa="";

	public Formularioa2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 376);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField_depKod = new JTextField();
		textField_depKod.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char a =e.getKeyChar();
				if (!Character.isDigit(a)){
				e.consume();
				}
			}
		});
		textField_depKod.setBounds(144, 11, 181, 20);
		contentPane.add(textField_depKod);
		textField_depKod.setColumns(10);
		
		lblLangKod = new JLabel("Departamentu Zenbakia:");
		lblLangKod.setBounds(10, 11, 124, 20);
		contentPane.add(lblLangKod);
		
		lblIzena = new JLabel("Izena:");
		lblIzena.setBounds(10, 48, 39, 14);
		contentPane.add(lblIzena);
		
		textField_izena = new JTextField();
		textField_izena.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
			char a =e.getKeyChar();
			if (( ((int)a>=33 && (int)a<=64))||((int)a>=91 && (int)a<=96)|| ((int)a>=123 && (int)a<=223)){
				e.consume();}
				
			}
		});
		textField_izena.setBounds(144, 42, 181, 20);
		contentPane.add(textField_izena);
		textField_izena.setColumns(10);
		
		lblAbizena = new JLabel("Eraikina:");
		lblAbizena.setBounds(10, 84, 50, 14);
		contentPane.add(lblAbizena);
		
		textField_eraikina = new JTextField();
		textField_eraikina.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char a =e.getKeyChar();
				if (!Character.isDigit(a)){
				e.consume();
				}
			}
		});
		textField_eraikina.setBounds(144, 81, 181, 20);
		contentPane.add(textField_eraikina);
		textField_eraikina.setColumns(10);
		
		lblDeptKod = new JLabel("Zentroa:");
		lblDeptKod.setBounds(10, 122, 102, 14);
		contentPane.add(lblDeptKod);
		
		btnGorde = new JButton("GORDE");
		btnGorde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewLabel.setVisible(false);
				String operazioa = (String) comboBox.getSelectedItem();
				if(operazioa.equalsIgnoreCase("txertatu")) {
					if(!textField_izena.getText().equalsIgnoreCase("") && !textField_eraikina.getText().equalsIgnoreCase("") && !zentroa.equalsIgnoreCase("")) {
						departamentua Departamentua = new departamentua(0,textField_izena.getText(),textField_eraikina.getText(),zentroa);
						menukontroladorea.txertatuDepatamentua(Departamentua);
					}
					else {
						lblNewLabel.setVisible(true);
						lblNewLabel.setText("Parametroak falta dira");
					}
					
				}
				if(operazioa.equalsIgnoreCase("ezabatu")) {
					if(!textField_depKod.getText().equalsIgnoreCase("")) {
						departamentua Departamentua = new departamentua(Integer.parseInt(textField_depKod.getText()),null,null,null);
						menukontroladorea.ezabatuDepatamentua(Departamentua);
					}
					else {
						lblNewLabel.setVisible(true);
						lblNewLabel.setText("Parametroak falta dira");
					}
					
				}
				if(operazioa.equalsIgnoreCase("aldatu")) {
					if(!textField_depKod.getText().equalsIgnoreCase("") && !textField_izena.getText().equalsIgnoreCase("") && !textField_eraikina.getText().equalsIgnoreCase("") && !zentroa.equalsIgnoreCase("")) {
						departamentua Departamentua = new departamentua(Integer.parseInt(textField_depKod.getText()),textField_izena.getText(),textField_eraikina.getText(),zentroa);
						menukontroladorea.aldatuDepartamentu(Departamentua);
					}
					else {
						lblNewLabel.setVisible(true);
						lblNewLabel.setText("Parametroak falta dira");
					}
					
				}
				
				
			}
		});
		btnGorde.setBounds(335, 303, 89, 23);
		contentPane.add(btnGorde);
		
		btnEzabatu = new JButton("EZABATU");
		btnEzabatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_depKod.setText(null);
				textField_izena.setText(null);
				textField_eraikina.setText(null);
				comboBox_1.setSelectedIndex(0);
				
				
			}
		});
		btnEzabatu.setBounds(236, 303, 89, 23);
		contentPane.add(btnEzabatu);
		
		btnAtzera = new JButton("ATZERA");
		btnAtzera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menukontroladorea.formulario2tikDepartamentura();
			}
		});
		btnAtzera.setBounds(137, 303, 89, 23);
		contentPane.add(btnAtzera);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String operazioa = (String) comboBox.getSelectedItem();
				if(operazioa.equalsIgnoreCase("txertatu")) {
					textField_depKod.setEnabled(false);
					comboBox_1.setEnabled(true);
					textField_eraikina.setEditable(true);
					textField_izena.setEditable(true);
					
					
				}
				if(operazioa.equalsIgnoreCase("ezabatu")) {
					textField_depKod.setEnabled(true);
					textField_eraikina.setEditable(false);
					textField_izena.setEditable(false);
					comboBox_1.setEnabled(false);
					
					
				}
				if(operazioa.equalsIgnoreCase("aldatu")) {
					textField_depKod.setEnabled(true);
					textField_eraikina.setEditable(true);
					textField_izena.setEditable(true);
					comboBox_1.setEnabled(true);
					
				}
			}
		});
		
		
		comboBox.setBounds(32, 187, 80, 20);
		contentPane.add(comboBox);
		comboBox.addItem("Txertatu");
		comboBox.addItem("Ezabatu");
		comboBox.addItem("Aldatu");
		
		lblNewLabel = new JLabel("Departamentua ez da existitzen");
		lblNewLabel.setBounds(139, 235, 256, 14);
		contentPane.add(lblNewLabel);
		lblNewLabel.setVisible(false);
		
		
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				zentroa = (String) comboBox_1.getSelectedItem();
			}
		});
		comboBox_1.setBounds(144, 119, 124, 20);
		contentPane.add(comboBox_1);
		comboBox_1.addItem("");
		comboBox_1.addItem("Elorrieta");
		comboBox_1.addItem("Errekamari");
		
		
	}
	public void nireMenukontroladorea(Menukontroladorea menukontroladorea) {
		this.menukontroladorea = menukontroladorea;
	}
	public void errorea() {
		lblNewLabel.setVisible(true);
	}
	public void ezdago() {
		lblNewLabel.setVisible(true);
		lblNewLabel.setText("Departamentua ez da existitzen");
		
	}
	public void operazioa() {
		lblNewLabel.setVisible(true);
		lblNewLabel.setText("Departamentua operazioa ondo atera da.");
		
	}
	public void txertatuErrorea() {
		lblNewLabel.setVisible(true);
		lblNewLabel.setText("Departamentua ezin izan da txertatu, kontsultatu log.");
		
	}
}
