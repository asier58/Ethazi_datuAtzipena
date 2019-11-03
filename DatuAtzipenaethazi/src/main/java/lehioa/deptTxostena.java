package lehioa;

import java.awt.BorderLayout;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;

import kontroladorea.Menukontroladorea;


import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class deptTxostena extends JFrame {
	
	private JPanel contentPane;
	private Menukontroladorea menukontroladorea;
	private JScrollPane scrollPane;
	private ArrayList<eredua.departamentua> zerrenda =  new ArrayList<eredua.departamentua>();
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					deptTxostena frame = new deptTxostena();
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
	public deptTxostena() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(37, 62, 908, 427);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.getTableHeader().setReorderingAllowed(false) ;

		
		
		
		scrollPane.setViewportView(table);
	}
	public void nireMenukontroladorea(Menukontroladorea menukontroladorea) {
		this.menukontroladorea = menukontroladorea;
	}
public void filtroapart() {
		
		String[]columnas= {
				"m2","solairua", "ostatu_id", "izena", "herria", "helbidea", "postaKod", "ostatu_mota", "gela_kopuru", "erreserba_kopuru","ospea","komun_kop","prezioa"
			};
		DefaultTableModel t1= new DefaultTableModel(){

		    public boolean isCellEditable(int rowIndex,int columnIndex){return false;}

		};

		table.setModel(t1);


		t1.addColumn("dept_no");
		t1.addColumn("izena");
		t1.addColumn("eraikina");
		t1.addColumn("zentroa");
		


		for (eredua.departamentua e:zerrenda) {
					columnas[0]=Integer.toString(e.getDept_no());
					columnas[1]=e.getIzena();
					columnas[2]=e.getEraikina();
					columnas[3]=e.getZentroa();
					
					t1.addRow(columnas);	
			}	

	}
public void gordeTxostena(ArrayList<eredua.departamentua> arr) {
	zerrenda=arr;
}


}
