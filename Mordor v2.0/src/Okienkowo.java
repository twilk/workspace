import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JTable;

import java.awt.Color;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.Font;


public class Okienkowo {
	static Statement stmt = null;
	static Connection conn = null;
		
	public static JFrame frame;
	public static JTable table;
	public static JComboBox comboBox;
	public static JScrollPane scrollPane;
	public static JButton btnNewButton;
	public static JButton btnNewButton_1;
	public static JButton btnZmien;
	public static JButton btnPokazZaznaczone;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Okienkowo window = new Okienkowo();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Okienkowo() {

		initialize();
	}

	private void initialize() {
		
		
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Tomasz\\workspace\\Mordor v2.0\\Wolf track.png"));
		frame.setBounds(100, 100, 1001, 499);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JDesktopPane desktopPane = new JDesktopPane(){
			 ImageIcon icon = new ImageIcon("C:\\Users\\Tomasz\\workspace\\Mordor v2.0\\HelloPattern.jpg");
			    Image image = icon.getImage();

			    Image newimage = image.getScaledInstance(1500, 1000, Image.SCALE_SMOOTH);

			    @Override
			    protected void paintComponent(Graphics g)
			    {
			        super.paintComponent(g);
			        g.drawImage(newimage, 0, 0, this);
			    }
		};
		desktopPane.setBackground(Color.LIGHT_GRAY);
		
		
		
		
		frame.getContentPane().add(desktopPane, BorderLayout.CENTER);
		
		JButton btnPocz = new JButton("Po\u0142\u0105cz");
		btnPocz.setBackground(Color.DARK_GRAY);
		btnPocz.setForeground(Color.WHITE);
		btnPocz.setFont(new Font("Buxton Sketch", Font.PLAIN, 13));
		
		btnPocz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//laczenie z baz¹
				try {
					try {
						conn = getConnection();
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					JOptionPane.showMessageDialog(frame,"Polaczenie z baza danych dziala");
				} catch (SQLException | IOException e) {
					e.printStackTrace();
				}
				//laczenie z baz¹
				//uzupelnianie combobox'a
				Controller.uzupelnijCombo();
				
				//uzupelnianie combobox'a
				
				
				
			}
		});
		btnPocz.setBounds(10, 420, 100, 30);
		desktopPane.add(btnPocz);
		
		comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Controller.uzupelnijTabelke();
			}
		});
		comboBox.setMaximumRowCount(15);
		comboBox.setBounds(775, 11, 200, 50);
		desktopPane.add(comboBox);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 755, 398);
		desktopPane.add(scrollPane);
		
		table = new JTable();
		table.setSelectionBackground(Color.white);
		table.setBackground(Color.gray);
		scrollPane.setViewportView(table);
		
		btnNewButton = new JButton("Usun");
		btnNewButton.setBackground(Color.DARK_GRAY);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Buxton Sketch", Font.PLAIN, 13));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Controller.usunRekord();
			}
		});
		btnNewButton.setBounds(886, 305, 89, 23);
		desktopPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Dodaj");
		btnNewButton_1.setBackground(Color.DARK_GRAY);
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Buxton Sketch", Font.PLAIN, 13));
		final JDialog jdialog = new JDialog();
		jdialog.setBounds(100, 100, 400, 200);
		btnNewButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Controller.Dodawanie();
			}
			
		});
		btnNewButton_1.setBounds(886, 271, 89, 23);
		desktopPane.add(btnNewButton_1);
		
		btnZmien = new JButton("Zmien");
		btnZmien.setBackground(Color.DARK_GRAY);
		btnZmien.setForeground(Color.WHITE);
		btnZmien.setFont(new Font("Buxton Sketch", Font.PLAIN, 13));
		btnZmien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Controller.Zmiana();
				}
		});
		btnZmien.setBounds(886, 339, 89, 23);
		desktopPane.add(btnZmien);
		
		btnPokazZaznaczone = new JButton("Pokaz zaznaczony rekord");
		btnPokazZaznaczone.setBackground(Color.DARK_GRAY);
		btnPokazZaznaczone.setForeground(Color.WHITE);
		btnPokazZaznaczone.setFont(new Font("Buxton Sketch", Font.PLAIN, 13));
		btnPokazZaznaczone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Controller.Pokazanie();
			}	
		});
		btnPokazZaznaczone.setBounds(120, 420, 153, 30);
		desktopPane.add(btnPokazZaznaczone);
	}

	public static DefaultTableModel buildTableModel(ResultSet rs) throws SQLException { 
		ResultSetMetaData metaData = rs.getMetaData(); 
		// names of columns 
		Vector<String> columnNames = new Vector<String>(); 
		int columnCount = metaData.getColumnCount(); 
		for (int column = 1; column <= columnCount; column++) { 
			columnNames.add(metaData.getColumnName(column)); 
			} 
		// data of the table 
		Vector<Vector<Object>> data = new Vector<Vector<Object>>(); 
		while (rs.next()) { 
			Vector<Object> vector = new Vector<Object>(); 
			for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) { 
				vector.add(rs.getObject(columnIndex)); 
				} 
			data.add(vector); 
			} return new DefaultTableModel(data, columnNames); 
		}
	
	public JComboBox<String> comboBox() throws SQLException
	{
	    


	    comboBox.setBounds(130,30,190,30);
	    comboBox.setSelectedIndex(0);
	    comboBox.setMaximumRowCount(5);
	    return comboBox;
	}
	
	public static Connection getConnection() 
			throws SQLException, IOException, ClassNotFoundException
	{ 
		Properties props = new Properties(); 
		FileInputStream in = new FileInputStream("database.properties"); 
		props.load(in); 
		in.close(); 
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
		} catch (Exception e){
			e.printStackTrace();
		}
		
		
		String drivers = props.getProperty("jdbc.drivers"); 
		if (drivers != null) 
			System.setProperty("jdbc.drivers", drivers); 
		String url = props.getProperty("jdbc.url"); 
		String user = props.getProperty("jdbc.user"); 
		String password = props.getProperty("jdbc.password");
		
		//jdbc:sqlserver://HOSP_SQL1.company.com;user=name;password=abcdefg;database=Test"
		System.out.println("Masakra: \nURL: " +url+"\nUsername: "+user+"\nPassword: "+password);
		return 	DriverManager.getConnection(url+user+password); 
		
	}
	}
