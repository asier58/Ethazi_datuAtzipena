package lehioa;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ComboBoxModel;
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
	private JTextField textField_izena;
	private JTextField textField_abizena;
	private JTextField textField_deptKod;
	private JTextField textField_soldata;
	private JTextField textField_nagusia;
	private JTextField textField_ardura;
	private JButton btnGorde;
	private JButton btnEzabatu;
	private JButton btnAtzera;
	private JComboBox comboBox_aukera;
	private String data = null;
	private String ordua = null;
	private Date date = new Date();
	private int cont = 0;	
	private JComboBox comboBox_ardura;
	private JComboBox comboBox_kodea;
	public static JLabel lblNewLabel;
	
	ArrayList<langilea> langileArr = new ArrayList<langilea>();
	langilea l1;
	public static Logger logger = Logger.getLogger(Menua.class);

	private Menukontroladorea menukontroladorea;
	private ArrayList<String> langKod = new ArrayList<String>();
	private ArrayList<Integer> langKodInteger = new ArrayList<Integer>();
	

	public Formularioa() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 616, 410);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblLangKod = new JLabel("Langilearen kodea");
		lblLangKod.setBounds(10, 11, 129, 20);
		contentPane.add(lblLangKod);

		lblIzena = new JLabel("Izena");
		lblIzena.setBounds(10, 48, 102, 14);
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
		textField_izena.setBounds(163, 45, 239, 20);
		contentPane.add(textField_izena);
		textField_izena.setColumns(10);

		lblAbizena = new JLabel("Abizena");
		lblAbizena.setBounds(10, 84, 102, 14);
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
		textField_abizena.setBounds(163, 76, 229, 20);
		contentPane.add(textField_abizena);
		textField_abizena.setColumns(10);

		lblDeptKod = new JLabel("Departamentu kodea");
		lblDeptKod.setBounds(10, 122, 129, 14);
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
		textField_deptKod.setBounds(163, 119, 168, 20);
		contentPane.add(textField_deptKod);
		textField_deptKod.setColumns(10);

		lblSoldata = new JLabel("Soldata");
		lblSoldata.setBounds(10, 157, 102, 14);
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
		textField_soldata.setBounds(163, 154, 229, 20);
		contentPane.add(textField_soldata);
		textField_soldata.setColumns(10);

		lblNagusia = new JLabel("Nagusia");
		lblNagusia.setBounds(10, 191, 102, 14);
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
		textField_nagusia.setBounds(163, 188, 229, 20);
		contentPane.add(textField_nagusia);
		textField_nagusia.setColumns(10);

		lblArdura = new JLabel("Ardura");
		lblArdura.setBounds(10, 221, 102, 14);
		contentPane.add(lblArdura);
		
		comboBox_ardura = new JComboBox();
		comboBox_ardura.setModel(new DefaultComboBoxModel(new String[] {"Zuzendari", "Ikasketa burua", "Irakaslea", "Bedela"}));
		comboBox_ardura.setBounds(163, 219, 239, 23);
		contentPane.add(comboBox_ardura);

		comboBox_kodea = new JComboBox();
		
		for(int i = 0; i < langKod.size(); i++){
			
			if(cont == 0) {
				comboBox_kodea.addItem("");
				cont++;
			}
			
		}
		
		comboBox_kodea.setBounds(163, 11, 181, 20);
		contentPane.add(comboBox_kodea);

		comboBox_aukera = new JComboBox();
		comboBox_aukera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBox_aukera.getSelectedItem().equals("Aldatu")) {
					
					comboBox_kodea.setEnabled(true);
					comboBox_kodea.setEditable(true);
					
					textField_izena.setEnabled(true);
					textField_abizena.setEnabled(true);
					textField_deptKod.setEnabled(true);
					textField_nagusia.setEnabled(true);
					textField_soldata.setEnabled(true);
					comboBox_ardura.setEnabled(true);
					
					textField_izena.setEditable(true);
					textField_abizena.setEditable(true);
					comboBox_ardura.setEditable(true);
					textField_deptKod.setEditable(true);
					textField_nagusia.setEditable(true);
					textField_soldata.setEditable(true);

				} else if (comboBox_aukera.getSelectedItem().equals("Ezabatu")) {
					comboBox_kodea.setEnabled(true);
					comboBox_kodea.setEditable(true);

					textField_izena.setEnabled(false);
					textField_abizena.setEnabled(false);
					textField_deptKod.setEnabled(false);
					textField_nagusia.setEnabled(false);
					textField_soldata.setEnabled(false);
					comboBox_ardura.setEnabled(false);
					
					textField_izena.setEditable(false);
					textField_abizena.setEditable(false);
					comboBox_ardura.setEditable(false);
					textField_deptKod.setEditable(false);
					textField_nagusia.setEditable(false);
					textField_soldata.setEditable(false);
				} else if (comboBox_aukera.getSelectedItem().equals("Txertatu")) {
					
					textField_izena.setEnabled(true);
					textField_abizena.setEnabled(true);
					textField_deptKod.setEnabled(true);
					textField_nagusia.setEnabled(true);
					textField_soldata.setEnabled(true);
					comboBox_ardura.setEnabled(true);
					
					textField_izena.setEditable(true);
					textField_abizena.setEditable(true);
					comboBox_ardura.setEditable(true);
					textField_deptKod.setEditable(true);
					textField_nagusia.setEditable(true);
					textField_soldata.setEditable(true);
					
					while (comboBox_kodea.getSelectedItem().equals(menukontroladorea.returnKodea())) {
						System.out.println("Kodea ez da existitzen!");
					}
			}
		}
		});
		comboBox_aukera.setModel(new DefaultComboBoxModel(new String[] { "Txertatu", "Ezabatu", "Aldatu" }));
		comboBox_aukera.setBounds(12, 304, 115, 21);
		contentPane.add(comboBox_aukera);

		btnGorde = new JButton("GORDE");
		btnGorde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DateFormat hourFormat = new SimpleDateFormat("HH:mm");
				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				data = dateFormat.format(date).toString();
				ordua = hourFormat.format(date).toString();
				Date date = new Date();
				DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
				if (menukontroladorea.getArduraZuz(l1).equals("Zuzendari")) {
					logger.info("Ardura hori badago artuta.");
					lblNewLabel.setText("Ardura hori badago artuta.");
				} else if (menukontroladorea.getArduraIB(l1).equals("Ikasketa Burua")) {
					logger.info("Ardura hori badago artuta.");
					lblNewLabel.setText("Ardura hori badago artuta.");
				} else {
					if (comboBox_aukera.getSelectedItem().equals("Txertatu")) {
						int langKod = menukontroladorea.maxEmpleKod();
						int soldata = Integer.parseInt(textField_soldata.getText());
						int dept_noZenbkia = Integer.parseInt(textField_deptKod.getText());
						int nagusia = Integer.parseInt(textField_nagusia.getText());
						l1 = new langilea(langKod, dept_noZenbkia, soldata, textField_izena.getText(),
								textField_abizena.getText(), nagusia, (String) comboBox_ardura.getSelectedItem(),
								ordua + ", " + data);

						menukontroladorea.getData(l1);

					} else if (comboBox_aukera.getSelectedItem().equals("Aldatu")) {
						int langKod = Integer.parseInt((String) comboBox_kodea.getSelectedItem());
						int soldata = Integer.parseInt(textField_soldata.getText());
						int dept_noZenbkia = Integer.parseInt(textField_deptKod.getText());
						int nagusia = Integer.parseInt(textField_nagusia.getText());

						l1 = new langilea(langKod, dept_noZenbkia, soldata, textField_izena.getText(),
								textField_abizena.getText(), nagusia, (String) comboBox_ardura.getSelectedItem(),
								ordua + ", " + data);

						menukontroladorea.enplegatuaBerritu(l1);

					} else if (comboBox_aukera.getSelectedItem().equals("Ezabatu")) {

						int langKod = Integer.parseInt((String) comboBox_kodea.getSelectedItem());

						l1 = new langilea(langKod, 0, 0, null, null, 0, null, null);

						menukontroladorea.enplegatuaEzabatu(l1);
					}
			}
		}
		});
		btnGorde.setBounds(335, 303, 89, 23);
		contentPane.add(btnGorde);

		btnEzabatu = new JButton("EZABATU");
		btnEzabatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_izena.setText(null);
				textField_abizena.setText(null);
				textField_deptKod.setText(null);
				textField_soldata.setText(null);
				textField_nagusia.setText(null);
				textField_ardura.setText(null);

			}
		});
		btnEzabatu.setBounds(236, 303, 89, 23);
		contentPane.add(btnEzabatu);

		btnAtzera = new JButton("ATZERA");
		btnAtzera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {		
				menukontroladorea.langilePantailara();
				
			}
		});
		
		btnAtzera.setBounds(137, 303, 89, 23);
		contentPane.add(btnAtzera);
		
		 lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(149, 268, 388, 14);
		contentPane.add(lblNewLabel);
		lblNewLabel.setText("");
	}
		
	public void kargatuAL(ArrayList <Integer> kodeak){
		for (int n = 0; n < kodeak.size(); n++) {
			String kodeStr;
			kodeStr = Integer.toString(kodeak.get(n));
			langKod.add(kodeStr);
			comboBox_kodea.addItem(kodeStr);
		}
		
	}
	
	public void blokeatuKodea() {
		this.comboBox_kodea.setEditable(false);
		this.comboBox_kodea.setEnabled(false);
	}

	public void nireMenukontroladorea(Menukontroladorea menukontroladorea) {
		this.menukontroladorea = menukontroladorea;
	}
	public static void operazioa() {
		lblNewLabel.setVisible(true);
		lblNewLabel.setText("Langile operazioa ondo atera da.");
		
	}
	public static void txertatuErrorea() {
		lblNewLabel.setVisible(true);
		lblNewLabel.setText("Langile ezin izan da txertatu edo aldatu, kontsultatu log.");
		
	}
	public static void ezabatuLangile() {
		lblNewLabel.setVisible(true);
		lblNewLabel.setText("Langile ezin izan da ezabatu edo aldatu, kontsultatu log.");
		
	}
	public void departamentuaEzdaexistitzen() {
		lblNewLabel.setVisible(true);
		lblNewLabel.setText("Departmentua ez da existitzen");
		
	}
}