package proj;


import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MController {
	
	private MModel m_model;
	private MView m_view;
	
	MController(MModel model, MView view) {
		m_model = model;
		m_view = view;
		
		m_view.addKonekszynLisnetener(new KonekszynListener());
		m_view.addNokonekszynLisnetener(new NoKonekszynListener());
		m_view.addUsunLisnetener(new UsunListener());
		m_view.addUtworzLisnetener(new UtworzListener());
		m_view.addPokazLisnetener(new PokazListener());
		m_view.addWstawLisnetener(new WstawListener());

	}

	class KonekszynListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (!MModel.czyConn)
			{
				try {
					MModel.polacz();
				} catch (IOException e1) {
					
					e1.printStackTrace();
				}
				
				
				if (MModel.czyConn)
				{
					MView.setV();
				}
			
		}else System.out.println("alreadykonekszynbro");
		}
	}

	class NoKonekszynListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			m_model.reset();
		}
	}
	
	class UsunListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			String nazwa = MView.getDeleteFieldText();
	    	if (nazwa.length()==0)
	    	System.out.println("Podaj Nazwe");
	    	else 
	    	{
	    		if(MModel.czyConn)
	    		{
	    			try {
						Statement stat = MModel.conn.createStatement();
						stat.execute("DROP TABLE "+nazwa );
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
	    			
	    		}
	    		else System.out.println("Brak Polaczenia");
	    	}
			
		}
			
}
	
	class UtworzListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			String nazwa = MView.getCreateText();
        	if (nazwa.length()==0)
        	System.out.println("Podaj Nazwe");
        	else 
        	{
        		if(MModel.czyConn)
        		{
        			try {
						Statement stat = MModel.conn.createStatement();
						stat.execute("CREATE TABLE "+nazwa + "()");
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
        			
        		}
        		else System.out.println("Brak Polaczenia");
			
			
		}
	}
}
	
	class PokazListener implements ActionListener {
		private JComboBox<String> tableNames = new JComboBox<String>();
		private JComboBox<String> columnNames = new JComboBox<String>();
		private JButton GOButton = new JButton(" GO ");
		public void actionPerformed(ActionEvent e) {
			
			if(MModel.czyConn)
			{
				JFrame show = new JFrame();
				JPanel showPanel = new JPanel();
				try {
					getTableNames();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				tableNames.addActionListener(new
				         ActionListener()
				         {
				            public void actionPerformed(ActionEvent event)
				            {
				               try {
				            	   columnNames.removeAllItems();
								getColumnNames((String) tableNames.getSelectedItem());
							} catch (SQLException e) {
								e.printStackTrace();
							}
				            }
				         });
				GOButton.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent arg0) {
						if(columnNames!=null)
							showTable((String) tableNames.getSelectedItem(),
									(String) columnNames.getSelectedItem());
						
						
					}
				});
				
				showPanel.setLayout(new GridBagLayout());
				
				MView.addItem(showPanel, tableNames, 2, 0, 1, 1, GridBagConstraints.WEST);
				MView.addItem(showPanel, columnNames, 2, 1, 1, 1, GridBagConstraints.WEST);
				MView.addItem(showPanel, GOButton, 1, 2, 1, 1, GridBagConstraints.CENTER);
				MView.addItem(showPanel, new JLabel("Nazwa Tabeli :"), 0, 0, 1, 1, GridBagConstraints.EAST);
				MView.addItem(showPanel, new JLabel("Nazwa Kolumny:"), 0, 1, 1, 1, GridBagConstraints.EAST);
								
				show.add(showPanel);
				
				show.setSize(300,200);
				show.setLocation(600,350);
				show.setVisible(true);
				show.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				
				
			} else System.out.println("Brak Polaczenia");
			
			
		}


			protected void showTable(String table, String column) {
			Statement stat;
			try {
				if(column!="" && table!="")
				{
				stat = MModel.conn.createStatement();
				ResultSet rs = stat.executeQuery("SELECT " + column + " FROM " + table);
				while (rs.next()) System.out.println(rs.getString(column));
				}   
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
			
		}


			public void getTableNames() throws SQLException
			   {
				  tableNames.removeAllItems();
			      ResultSet mrs = MModel.meta.getTables(null, null, null, new String[] { "TABLE" });
			      while (mrs.next())
			    	  tableNames.addItem(mrs.getString(3));
			      mrs.close();
			   }
			
			public void getColumnNames(String table) throws SQLException
			   {
				if(table!=null)
				{
				Statement st = MModel.conn.createStatement();

	            ResultSet rs = st.executeQuery("select * from " + table );
	            ResultSetMetaData metaData = rs.getMetaData();

	            int rowCount = metaData.getColumnCount();

	            for (int i = 0; i < rowCount; i++) {
	                      
	                columnNames.addItem(metaData.getColumnName(i + 1));
	            }
				}
			   }
			
		}
	
	class WstawListener implements ActionListener {
			
			private String nazwa;
	    	
	    	private String[] Dane = {"char(20)", "char(200)", "integer", "date"};  
	    	
	    	private JComboBox<String> typDanych = new JComboBox<String>(Dane);

	    	
	    	
			private JButton dodajRekord = new JButton("Rekorduj"),
					         dodajKolumne = new JButton("Kolumnuj");
			

			private	JTextField rekordField = new JTextField(10),
								kolumnaField = new JTextField(10),
								 rekordKolumnaField = new JTextField(10);
				
			public void actionPerformed(ActionEvent e) {
				nazwa = MView.getUpdateFieldText();
	        	if (nazwa.length()==0)
	        	System.out.println("podaj nazwe baranie");
	        	else 
	        	{
	        		if(MModel.czyConn)
	        		{
	        			final JFrame createOkno = new JFrame();
	        			
	        			JPanel createPanel = new JPanel();
	        			createPanel.setLayout(new GridBagLayout());
	        			
	        			addCreateItems(createPanel);
	        			addCreateListeners();
	        			
	        			 createOkno.setSize(700, 200);
				         createOkno.setLocation(500,370);
				         createOkno.add(createPanel);
				         createOkno.setVisible(true);
		        		
	        		}
	        		else System.out.println("brak polaczenia");
	        	}
				
			}

			private void addCreateListeners() {
				dodajKolumne.addActionListener(new ActionListener() {
					

					private int temp;

					public void actionPerformed(ActionEvent e) {
					
						String kolumna = kolumnaField.getText();
						Statement stat;
						try {
							temp = typDanych.getSelectedIndex();
							System.out.println(temp);
							
							stat = MModel.conn.createStatement();
							stat.execute("ALTER TABLE "+ nazwa + " ADD " + kolumna + " " + Dane[temp] );
							
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
						
					}
				});
				
				dodajRekord.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
							
						String rekord = rekordField.getText();
						Statement stat;
						try {
							
							
							stat = MModel.conn.createStatement();
							stat.execute("INSERT INTO "+ nazwa +"(" +rekordKolumnaField.getText()+ ")" + " VALUES ('" + rekord + "') ");
							
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
						
						
					}
				});
				
			}

			private void addCreateItems(JPanel p) {
				
				MView.addItem(p,typDanych, 3, 0, 1, 1, GridBagConstraints.WEST);
    			
				
				MView.addItem(p, new JLabel("Dodaj kolumne o nazwie :"), 0, 0, 1, 1, GridBagConstraints.CENTER);
				MView.addItem(p, kolumnaField, 1, 0, 1, 1, GridBagConstraints.CENTER);
				MView.addItem(p, dodajKolumne, 2, 0, 1, 1, GridBagConstraints.CENTER);
    			
				MView.addItem(p, new JLabel("Dodaj rekord :"), 0, 1, 1, 1, GridBagConstraints.EAST);
				MView.addItem(p,rekordField, 1, 1, 1, 1, GridBagConstraints.EAST);
				MView.addItem(p, new JLabel("Do kolumny o nazwie  :"), 2, 1, 1, 1, GridBagConstraints.EAST);
				MView.addItem(p,rekordKolumnaField, 3, 1, 1, 1, GridBagConstraints.EAST);
				MView.addItem(p,dodajRekord, 4, 1, 1, 1, GridBagConstraints.WEST);
    			
			}
		};
		
}

