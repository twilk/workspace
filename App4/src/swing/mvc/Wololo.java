package swing.mvc;

	import java.sql.DriverManager;
	import java.sql.Connection;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	 
	public class Wololo {
	 
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

