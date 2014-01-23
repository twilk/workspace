package proj;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;


public class MModel {
	
	
	public static boolean czyConn = false;
	public static Connection conn = null;
	public static DatabaseMetaData meta;
	public static ResultSet rs;
	
	MModel() {
		reset();
	}

	public void reset() {
		if(czyConn==true)
		{
			zakonczPolaczenie();
		} else System.out.println("Brak Polaczenia");
	}

	private void zakonczPolaczenie() {
		try {
			conn.close();
			czyConn = false;
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
	}
	
static void polacz() throws IOException
	{
		if(!czyConn)
		{
			try {
				conn = getConnection();
				meta = conn.getMetaData();
				czyConn = true;
				MView.setV();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		} else System.out.println("Juz Istnieje Polaczenie");
	}
	
	
	 public static Connection getConnection()
		      throws SQLException, IOException
		   {  
		      Properties props = new Properties();
		      FileInputStream in = new FileInputStream("C:/Users/Rotu/Desktop/eclipse/Workspace/ProjektMVC+CRUDbd/src/proj/database.properties");
		      props.load(in);
		      in.close();

		      String drivers = props.getProperty("jdbc.drivers");
		      if (drivers != null)
		         System.setProperty("jdbc.drivers", drivers);
		      String url = props.getProperty("jdbc.url");
		      String username = props.getProperty("jdbc.username");
		      String password = props.getProperty("jdbc.password");

		      return DriverManager.getConnection(url, username, password);
		   }



}
