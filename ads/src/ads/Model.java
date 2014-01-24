package ads;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class Model {
	public static void main(String[] args){
	
//	reset();
	}
/*
    private static void reset() {
	Connection conn = null;
	
	try {
		conn = getConnection();
	} catch (SQLException | IOException e) {
		e.printStackTrace();
	}
	
}
*/
/**
 * CREATE TABLE MAGAZYN(Nazwa char(20), Ilosc int, Cena int, Gwarancja varchar(15),Spec text);
insert into MAGAZYN values ('Pistolet'	,20	,1200	,'Wieczysta'	,'Pistolet którym mo¿na zrobiæ krzywdê'),
('Tarcza'	,2	,50	,'Brak'		,'Prawdopodobnie s³u¿y do obrony, ale ...'),
('Wiedza'	,0	,1	,'Wieczysta'	,'Coœ, przydatnego.. chyba..'),
('Komputer'	,20	,200	,'36 miesiêcy'	,'Superszybki. Po prostu.'),
('Internet'	,999	,30	,'1 dzieñ'	,'Wujek Google, Ciocia Wikipedia i reszta weso³ej rodziny'),
('Sen'		,0	,1	,'Brak'		,'Zalecane stosowaæ 6-8 godzin. Raz dziennie.'),
('Java'		,1	,200	,'Wieczysta'	,'TAK!');

SELECT * FROM MAGAZYN;
 */

	public static Connection getConnection() 
			throws SQLException, IOException { 
		Properties props = new Properties(); 
		FileInputStream in = new FileInputStream("C:/Users/Wilczyy/workspace/desperacja/src/swing/mvc/database.properties"); 
		props.load(in); 
		in.close(); 
		String drivers = props.getProperty("jdbc.drivers"); 
		if (drivers != null) 
			System.setProperty("jdbc.drivers", drivers); 
		String url = props.getProperty("jdbc.url"); 
		String username = props.getProperty("jdbc.username"); 
		String password = props.getProperty("jdbc.password"); 
		return 	DriverManager.getConnection(url, username, password); }
}