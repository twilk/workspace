package swing.mvc;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class Model {
	
	public static Connection conn = null;
	Model() {
		reset();
	}
public void reset() {
	try {
		conn = getConnection();
		System.out.println("Polaczenie z baza danych dziala");
	} catch (SQLException | IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

	public static Connection getConnection() 
			throws SQLException, IOException 
	{ 
		Properties props = new Properties(); 
		FileInputStream in = new FileInputStream("database.properties"); 
		props.load(in); 
		in.close(); 
		
		try {
			Class.forName("org.postgresql.Driver").newInstance();
		} catch (Exception e){
			e.printStackTrace();
		}
		
		
		String drivers = props.getProperty("jdbc.drivers"); 
		if (drivers != null) 
			System.setProperty("jdbc.drivers", drivers); 
		String url = props.getProperty("jdbc.url"); 
		String username = props.getProperty("jdbc.username"); 
		String password = props.getProperty("jdbc.password");
		System.out.println("Masakra: " +url+" "+username+" "+password+" "+drivers);
		return 	DriverManager.getConnection(url, username, password); 
		
	}
}