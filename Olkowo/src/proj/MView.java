package proj;


import java.awt.*;

import javax.swing.*;

import java.awt.event.*;

class MView extends JFrame {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static JTextField createField = new JTextField(10);

	private static JTextField updateField = new JTextField(10);

	private static JTextField selectField = new JTextField(10);

	private static JTextField deleteField = new JTextField(10);

	private JButton Utworz = new JButton("Utworz"), 
					   Wstaw = new JButton("Wstaw"),
					    Pokaz = new JButton("Pokaz"),
					     Usun = new JButton("Usun"),
					      konekszyn = new JButton("Polacz z Baza danych"),
					       nokonekszyn = new JButton("Zakoncz Polaczenie");
	
	final static JFrame OKokno = new JFrame();


	MView(MModel model) {

	
	    Toolkit zestaw = Toolkit.getDefaultToolkit();
	    Dimension rozmiarEkranu = zestaw.getScreenSize();
	    int wysEkranu = rozmiarEkranu.height;
	    int szerEkranu = rozmiarEkranu.width;


	    setSize(szerEkranu / 2, wysEkranu / 3);
	    setLocation((szerEkranu / 2) - (szerEkranu / 4)  , (wysEkranu / 2) - (wysEkranu / 6)  );

	    
	    JPanel mainpanel = new JPanel();
	    mainpanel.setLayout(new GridBagLayout());
	    
	    addStuff(mainpanel);
	    
	    this.add(mainpanel);
	    
	    
		this.setTitle("Prosty Program Do komunikacji z BD");
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		stworzOKokno();
	}

	public void stworzOKokno(){
	
		
    JPanel paanel = new JPanel();
    JButton OK = new JButton("OK");
    paanel.setLayout(new GridBagLayout());
    
    addItem(paanel, new JLabel("Polaczylem sie z baza danych"), 0, 0, 1, 1, GridBagConstraints.CENTER);
    addItem(paanel, OK, 0, 1, 1, 1, GridBagConstraints.CENTER);
    
    OK.addActionListener(new ActionListener() {
		
		
		public void actionPerformed(ActionEvent ev) {
			OKokno.dispose();
		}
    });
    
    OKokno.setSize(300, 200);
    OKokno.setLocation(600,350);
    OKokno.add(paanel);
    OKokno.setDefaultCloseOperation(HIDE_ON_CLOSE);
    setnoV();
    
}
	public static void setnoV() {
		OKokno.setVisible(false);
		
	}

	public static void setV() {
		OKokno.setVisible(true);
	}

	private void addStuff(JPanel panel1) {
			  
		  	addItem(panel1, konekszyn, 0, 0, 1, 1, GridBagConstraints.CENTER);
		    addItem(panel1, nokonekszyn, 0, 1, 1, 1, GridBagConstraints.CENTER);
		    
		    addItem(panel1, new JLabel("Utworz Tabele o nazwie :"), 1, 0, 1, 1, GridBagConstraints.EAST);
		    addItem(panel1, new JLabel("Wstaw do Tabeli o nazwie :"), 1, 1, 1, 1, GridBagConstraints.EAST);
		    addItem(panel1, new JLabel("Pokaz Wszystkie Tabele :"), 1, 2, 1, 1, GridBagConstraints.EAST);
		    addItem(panel1, new JLabel("Usun Tabele o nazwie :"), 1, 3, 1, 1, GridBagConstraints.EAST);

		    addItem(panel1, createField, 2, 0, 1, 1, GridBagConstraints.WEST);
		    addItem(panel1, updateField, 2, 1, 1, 1, GridBagConstraints.WEST);
		    addItem(panel1, Pokaz, 2, 2, 1, 1, GridBagConstraints.CENTER);
		    addItem(panel1, deleteField, 2, 3, 1, 1, GridBagConstraints.WEST);
		    
		    addItem(panel1, Utworz, 3, 0, 1, 1, GridBagConstraints.WEST);
		    addItem(panel1, Wstaw, 3, 1, 1, 1, GridBagConstraints.WEST);
		    addItem(panel1, Usun, 3, 3, 1, 1, GridBagConstraints.WEST);
		
	}
	
	static void addItem(JPanel p, JComponent c, int x, int y, int width, int height, int align) {
	    GridBagConstraints gc = new GridBagConstraints();
	    gc.gridx = x;
	    gc.gridy = y;
	    gc.gridwidth = width;
	    gc.gridheight = height;
	    gc.weightx = 100.0;
	    gc.weighty = 100.0;
	    gc.insets = new Insets(5, 5, 5, 5);
	    gc.anchor = align;
	    gc.fill = GridBagConstraints.NONE;
	    p.add(c, gc);
	  }
	
	
	void addKonekszynLisnetener(ActionListener al){
		konekszyn.addActionListener(al);
	}
	
	void addNokonekszynLisnetener(ActionListener al){
		nokonekszyn.addActionListener(al);
	}
	
	void addUtworzLisnetener(ActionListener al){
		Utworz.addActionListener(al);
	}
	
	void addWstawLisnetener(ActionListener al){
		Wstaw.addActionListener(al);
	}
	
	void addPokazLisnetener(ActionListener al){
		Pokaz.addActionListener(al);
	}
	
	void addUsunLisnetener(ActionListener al){
		Usun.addActionListener(al);
	}

	public static String getCreateText() {
		return createField.getText();
	}

	public static String getDeleteFieldText() {
		
		return deleteField.getText();
	}

	public static String getUpdateFieldText() {
		
		return updateField.getText();
	}
	
	public static String getSelectFieldText() {
		// TODO Auto-generated method stub
		return selectField.getText();
	}
}

	
	/*

	void reset() {
		m_totalTf.setText(INITIAL_VALUE);
	}

	String getUserInput() {
		return m_userInputTf.getText();
	}

	void setTotal(String newTotal) {
		m_totalTf.setText(newTotal);
	}

	void showError(String errMessage) {
		JOptionPane.showMessageDialog(this, errMessage);
	}

*/