package swing.mvc;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.KeyStroke;


public class Widok extends JFrame implements ActionListener
{
	JMenuBar menuBar;
	JMenu menuPlik, menuNarzedzia, menuPomoc;
	JMenuItem mWczytaj, mPokaz, mDodaj, mUsun,mZapisz, mWyjscie,mAutor,mOpcje;
	JCheckBoxMenuItem chZmien;
	
	
	Toolkit zestaw = Toolkit.getDefaultToolkit(); 
	Dimension rozmiarEkranu = zestaw.getScreenSize(); 
	int wysEkranu = rozmiarEkranu.height; 
	int szerEkranu = rozmiarEkranu.width;
	
	private static int DEFAULT_WYS = 800;
	private static int DEFAULT_SZER = 600;
	
	
	public Widok()
	{
		setTitle("Projektowo");
		setSize(DEFAULT_WYS,DEFAULT_SZER);
		setResizable(false);
		setLocation((szerEkranu-DEFAULT_WYS)/2,(wysEkranu-DEFAULT_SZER)/2);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		
		menuBar = new JMenuBar();
		
		menuPlik = new JMenu ("Plik");
			mWczytaj = new JMenuItem("Wczytaj", 'W');
			mPokaz = new JMenuItem("Pokaz", 'P');
			mZapisz = new JMenuItem("Zapisz");
				mZapisz.setAccelerator(KeyStroke.getKeyStroke("ctrl S"));
			mWyjscie = new JMenuItem("Wyjscie");
				mWyjscie.addActionListener(this);
				mWyjscie.setAccelerator(KeyStroke.getKeyStroke("ctrl X"));
			
			menuPlik.add(mWczytaj);
			menuPlik.add(mPokaz);
			menuPlik.add(mZapisz);
				menuPlik.addSeparator();
			menuPlik.add(mWyjscie);
					
			
		menuNarzedzia = new JMenu ("Narzedzia");
			mDodaj = new JMenuItem("Dodaj",'D');
			chZmien = new JCheckBoxMenuItem("Zmien");
				chZmien.addActionListener(this);
			mUsun  = new JMenuItem("Usun",'U');
				mUsun.setEnabled(false);
			mOpcje = new JMenuItem("Opcje",'O');
				mOpcje.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						JFrame opcjeFrame = new JFrame();
							opcjeFrame.setSize(400,80);
							opcjeFrame.setTitle("Wybierz rozdzielczosc okna glownego:");
							opcjeFrame.setResizable(true);
							opcjeFrame.setLocation((szerEkranu-300)/2,(wysEkranu-200)/2);
							opcjeFrame.setVisible(true);
							
						JPanel opcjeContent = new JPanel();
								
							//opcjeFrame.add(lWymiary);

						  String wymiary[] = {"800x600","400x300","1024x768"};
							final JComboBox cWymiary = new JComboBox(wymiary);
							
							cWymiary.addActionListener(new ActionListener() {
								
								@Override
								public void actionPerformed(ActionEvent e) {

									zmienOkno(cWymiary.getSelectedIndex());
								}

								private void zmienOkno(int selectedIndex) {
									if (selectedIndex == 0)
									{	
										DEFAULT_WYS = 800;
										DEFAULT_SZER = 600;
										
										setSize(DEFAULT_WYS,DEFAULT_SZER);
										setResizable(false);
										setLocation((szerEkranu-DEFAULT_WYS)/2,(wysEkranu-DEFAULT_SZER)/2);
									}
									if (selectedIndex == 1)
									{
										DEFAULT_WYS = 400;
										DEFAULT_SZER = 300;
										
										setSize(DEFAULT_WYS,DEFAULT_SZER);
										setResizable(false);
										setLocation((szerEkranu-DEFAULT_WYS)/2,(wysEkranu-DEFAULT_SZER)/2);
													
									}
									if (selectedIndex == 2)
									{
										DEFAULT_WYS = 1024;
										DEFAULT_SZER = 768;
										
										setSize(DEFAULT_WYS,DEFAULT_SZER);
										setResizable(false);
										setLocation((szerEkranu-DEFAULT_WYS)/2,(wysEkranu-DEFAULT_SZER)/2);
										
									}
									
									
								}
							});
							cWymiary.setVisible(true);
							opcjeFrame.add(cWymiary);
					}
				});
						
						
						
			menuNarzedzia.add(mDodaj);
			menuNarzedzia.add(chZmien);
			menuNarzedzia.add(mUsun);
			menuNarzedzia.add(mOpcje);
		
			
			
		menuPomoc = new JMenu ("Pomoc");
			mAutor = new JMenuItem("Autor",'A');
				mAutor.addActionListener(this);
			
			menuPomoc.add(mAutor);
	
		setJMenuBar(menuBar);
		menuBar.add(menuPlik);
		menuBar.add(menuNarzedzia);
			menuBar.add(Box.createHorizontalGlue());
		menuBar.add(menuPomoc);
	}
	
	
    
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object z = e.getSource();
		if (z == mWyjscie)
			{
			int odp = JOptionPane.showConfirmDialog(null, "Czy na pewno wyjœæ ?","Potwierdzenie",JOptionPane.YES_NO_OPTION);
				if(odp==JOptionPane.YES_OPTION){ JOptionPane.showMessageDialog(null, "Do zobaczenia.");	dispose(); }
				else if (odp==JOptionPane.NO_OPTION) JOptionPane.showMessageDialog(null, "W porz¹dku :)");
				else if (odp==JOptionPane.CLOSED_OPTION) JOptionPane.showMessageDialog(null, " Czemu tak ? ","UWAZAJ",JOptionPane.WARNING_MESSAGE);
			}
		if (z==chZmien)
		{
			if(chZmien.isSelected())
			{
				//tu jakaœ akcja dla Zmien.zaznaczone
			}else if(!chZmien.isSelected())
				{
				//tu jakaœ akcja dla Zmien.niezaznaczone
				}
		}
		if (z==mAutor)	JOptionPane.showMessageDialog(this, "Tomasz Wilk\n nr indeksu 215549");
// -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==-=-=-=-=-
		//Create a split pane with the two scroll panes in it.
		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		splitPane.setOneTouchExpandable(true);
		splitPane.setDividerLocation(150);

		//Provide minimum sizes for the two components in the split pane
		Dimension minimumSize = new Dimension(100, 50);
//		listScrollPane.setMinimumSize(minimumSize);
//		pictureScrollPane.setMinimumSize(minimumSize);
	}
	
	public static void main(String[] args)
	{
		  Widok widok= new Widok();
		  widok.setVisible(true);
		  
	}
	
    
}

