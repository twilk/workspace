package swing.mvc;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


public class Model {
	
	ResultSet rs;
	public boolean czyConn = false;
	public static String[] magazyn = new String[20];
	public static String[] sztuk = new String[20];
	public static String[] cena = new String[20];
	public static String[] gwarancja = new String[20];
	public static String[] spec = new String[20];
	public static Connection conn = null;
	
	Model() throws ClassNotFoundException {
		polacz();
		try {
			getStuff();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public void polacz() throws ClassNotFoundException {
	try {
		conn = getConnection();
		System.out.println("Polaczenie z baza danych dziala");
	} catch (SQLException | IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

public void getStuff() throws SQLException{
	Statement stat = null;
	stat = conn.createStatement();
	ResultSet rs = stat.executeQuery("SELECT * FROM MAGAZYN");
	int i=0;
	while (rs.next()){
		magazyn[i] = new String();
		magazyn[i] = rs.getString(1);
		System.out.print(rs.getString(1)+ "\n");
		sztuk[i] = new String();
		sztuk[i] = Integer.toString(rs.getInt(2));
		System.out.print(rs.getInt(2)+ "\n");
		cena[i] = new String();
		cena[i] = Integer.toString(rs.getInt(3));
		System.out.print(rs.getInt(3)+ "\n");
		gwarancja[i] = new String();
		gwarancja[i] = rs.getString(4);
		System.out.print(rs.getString(4)+ "\n");
		spec[i] = new String();
		spec[i] = rs.getString(5);
		System.out.print(rs.getString(5)+ "\n");
		i++;
	}
	
	
	
}
/*	
public class Main {
	 
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");	
		Connection conn = DriverManager.getConnection("jdbc:sqlserver://HOSP_SQL1.company.com;user=name;password=abcdefg;database=Test");
		System.out.println("test");
		Statement sta = conn.createStatement();
		String Sql = "select * from testing_table";
		ResultSet rs = sta.executeQuery(Sql);
		while (rs.next()) {
			System.out.println(rs.getString("txt_title"));
		}
	}
}
*/


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
		String username = props.getProperty("jdbc.username"); 
		String password = props.getProperty("jdbc.password");
		String database = props.getProperty("jdbc.database");
		
		//jdbc:sqlserver://HOSP_SQL1.company.com;user=name;password=abcdefg;database=Test"
		System.out.println("Masakra: \nURL: " +url+"\nUsername: "+username+"\nPassword: "+password+"\nDriver: "+drivers);
		return 	DriverManager.getConnection(url, username, password); 
		
	}
}