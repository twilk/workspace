
	import java.io.FileInputStream;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.swing.JFrame;

	
	public class Wololo {
		static Connection conn = null;
		Wololo() throws ClassNotFoundException {
		polacz();
		}
		
		public static void polacz() throws ClassNotFoundException {
			try {
				conn = getConnection();
				System.out.println("Polaczenie z baza danych dziala");
			} catch (SQLException | IOException e) {
				e.printStackTrace();
			}
			
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
		public static void getStuff() throws SQLException{
			Statement stat = null;
			stat = conn.createStatement();
			ResultSet rs = stat.executeQuery("SELECT * FROM pracownik");
			
			while (rs.next()){
				System.out.print(rs.getString("imie")+ "\n");
			}
			
			
			
		}
		

		public static void main(String[] args) throws SQLException, ClassNotFoundException {
			Wololo.polacz();
			getStuff();
//			Okno();
		}


	}

