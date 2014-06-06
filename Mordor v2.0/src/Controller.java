import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.JOptionPane;


public class Controller {

	public static void Dodawanie() {
		ResultSet rs=null;
			String dane="";
			dane = ("INSERT INTO "+Okienkowo.comboBox.getSelectedItem().toString()+
					" VALUES( ");
			for(int i=1;i<Okienkowo.table.getColumnCount();i++){
			dane += ("'"+JOptionPane.showInputDialog(Okienkowo.frame,"Aktualnie dodajesz "+Okienkowo.comboBox.getSelectedItem().toString()+"\n"+Okienkowo.table.getColumnName(i))+"'");
			if(i<Okienkowo.table.getColumnCount()-1){
				dane+=(" , ");
			}
			if(i==Okienkowo.table.getColumnCount()-1){
				dane+=(" );");
			}
			
			}
			JOptionPane.showMessageDialog(Okienkowo.frame,dane);
			try {
				Okienkowo.stmt.executeUpdate(dane);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				rs = Okienkowo.stmt.executeQuery("select * from " + Okienkowo.comboBox.getSelectedItem().toString());
				Okienkowo.table.setModel(Okienkowo.buildTableModel(rs));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		
		}
	}

	public static void Zmiana() {
		// TODO Auto-generated method stub
		ResultSet rs = null;
		try {
			rs =Okienkowo.stmt.executeQuery("select * from "+ Okienkowo.comboBox.getSelectedItem().toString());
			//table.setModel(buildTableModel(rs));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				for (int j=0; j<Okienkowo.table.getRowCount(); j++)
				{
					String dane="";
					try {
						for (int p=1;p<Okienkowo.table.getColumnCount(); p ++)
						{
							if(Okienkowo.table.getValueAt(j, p)!=null){
								dane = ("UPDATE "+Okienkowo.comboBox.getSelectedItem().toString()+
								" SET "+Okienkowo.table.getColumnName(p)+" = '"+Okienkowo.table.getValueAt(j, p) 
								+ "' WHERE id_" + Okienkowo.comboBox.getSelectedItem().toString() + " = " + Okienkowo.table.getValueAt(j, 0));
								Okienkowo.stmt.executeUpdate(dane);
							}
						
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				JOptionPane.showMessageDialog(Okienkowo.frame,"Zmieniono");
	}

	public static void Pokazanie() {
		// TODO Auto-generated method stub
		for (int i=0; i<Okienkowo.table.getSelectedRowCount(); i++)
		{
			String dane="";
				for (int j=0; j<Okienkowo.table.getColumnCount(); j++)
				{
					dane += Okienkowo.table.getColumnName(j)+": "
				+Okienkowo.table.getValueAt(Okienkowo.table.getSelectedRows()[i],j )+"\n";
				}
			JOptionPane.showMessageDialog(Okienkowo.frame,dane);
		}
	}
		
	protected static void usunRekord(){
		int dialogresult =JOptionPane.showConfirmDialog(null,"Usuwanie",null,JOptionPane.YES_NO_OPTION);
				if (dialogresult == JOptionPane.YES_OPTION)
				{
		ResultSet rs = null;
		try {
			Okienkowo.stmt = Okienkowo.conn.createStatement();
			
			for (int i=0; i<Okienkowo.table.getSelectedRowCount(); i++)
			{
				JOptionPane.showMessageDialog(Okienkowo.frame,"Usuwam rekord o id: "+Okienkowo.table.getValueAt(Okienkowo.table.getSelectedRows()[i], 0));
				Okienkowo.stmt.executeUpdate("delete from "+Okienkowo.comboBox.getSelectedItem().toString()+" where id_"+Okienkowo.comboBox.getSelectedItem().toString()+" = "+Okienkowo.table.getValueAt(Okienkowo.table.getSelectedRows()[i], 0));
			}
			

	    // It creates and displays the table
	    rs = Okienkowo.stmt.executeQuery("select * from " + Okienkowo.comboBox.getSelectedItem().toString());
	    Okienkowo.table.setModel(Okienkowo.buildTableModel(rs));

	    // Closes the Connection
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Okienkowo.table.validate();
			}
	}
	
	protected static void uzupelnijTabelke(){
	    ResultSet rs = null;
		try {
			Okienkowo.stmt = Okienkowo.conn.createStatement();
			rs = Okienkowo.stmt.executeQuery("select * from "+Okienkowo.comboBox.getSelectedItem().toString());
			//JOptionPane.showMessageDialog(frame,"select * from "+comboBox.getSelectedItem().toString());

	    // It creates and displays the table
			Okienkowo.table.setModel(Okienkowo.buildTableModel(rs));

	    // Closes the Connection
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected static void uzupelnijCombo(){
		
		ResultSet rs = null;
		try {
			rs = Okienkowo.conn.getMetaData().getTables(null, null, "%",new String[] {"TABLE"});

		ResultSetMetaData meta = null;
		
		meta = (ResultSetMetaData) rs.getMetaData();
		
		int columns = meta.getColumnCount();
			while(rs.next())
			{

			        String table_names = rs.getString("TABLE_NAME");
			        Okienkowo.comboBox.addItem(table_names);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null,e);
		}

	}

}
