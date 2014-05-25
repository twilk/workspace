import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
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
import java.sql.SQLException;
import java.util.Properties;
import javax.swing.JComboBox;


public class Okienkowo {
	
	static Connection conn = null;
		
	private JFrame frame;
	private JTable table;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the application.
	 */
	public Okienkowo() {
		/**
		 * 		kod :)
		 */
		
		/**
		 *		koniec kodu :( 
		 */
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Tomasz\\workspace\\Mordor v2.0\\Wolf track.png"));
		frame.setBounds(100, 100, 800, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(desktopPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setBounds(10, 11, 500, 300);
		desktopPane.add(table);
		
		JButton btnPocz = new JButton("Po\u0142\u0105cz");
		
		btnPocz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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
				
			}
		});
		btnPocz.setBounds(10, 420, 100, 30);
		desktopPane.add(btnPocz);
		
		comboBox = new JComboBox();
		comboBox.setMaximumRowCount(15);
		comboBox.setBounds(574, 11, 200, 50);
		desktopPane.add(comboBox);
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
