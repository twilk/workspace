package swing.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.ListSelectionModel;


public class Widok extends JFrame
{
	
	JMenuBar menuBar;
	JMenu menuPlik, menuNarzedzia, menuPomoc;
	JMenuItem mWczytaj, mPokaz, mDodaj, mUsun,mZapisz, mWyjscie,mAutor,mOpcje;
	JCheckBoxMenuItem chZmien;
	
	String[] Dane = new String[10];
	public static String wymiary[] = {"800x600","400x300","1024x768"};
	public static JComboBox cWymiary = new JComboBox(wymiary);
	JFrame opcjeFrame = new JFrame();
	JLabel lLewy = new JLabel();
	JLabel lPrawy = new JLabel();
	
	Toolkit zestaw = Toolkit.getDefaultToolkit(); 
	Dimension rozmiarEkranu = zestaw.getScreenSize(); 
	int wysEkranu = rozmiarEkranu.height; 
	int szerEkranu = rozmiarEkranu.width;
	
	public static int DEFAULT_WYS = 800;
	public static int DEFAULT_SZER = 600;
	public static int zmiana=0;
	
	JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, 
			new JScrollPane(lLewy),new JScrollPane(lPrawy));

	public static JTextField[] pola = {
			new JTextField("nazwa"),
            new JTextField("ilosc"),
            new JTextField("cena"),
            new JTextField("gwarancja"),
            new JTextField("spec")};
	
	public Widok(Model model)
	{
		zaladujMenu();
		setTitle("Projektowo");
		setSize(DEFAULT_WYS,DEFAULT_SZER);
		setResizable(false);
		setLocation((szerEkranu-DEFAULT_WYS)/2,(wysEkranu-DEFAULT_SZER)/2);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(splitPane);
			splitPane.setDividerLocation(DEFAULT_SZER/3);
		//this.setLayout(new GridBagLayout());
		//setLayout(null);
			lLewy.setLayout(new GridBagLayout());
			GridBagConstraints lGBC = new GridBagConstraints();
			
	        //lLewy.add(null, new ImageIcon("src/swing/mvc/Images.3gif"));
			lLewy.add(new JButton("The useless button"),lGBC);
			
			lPrawy.setLayout(new GridBagLayout());
			GridBagConstraints pGBC = new GridBagConstraints();
			
			
			if(zmiana==1){
			pGBC.gridy = 0;
			for (int i=0; i<5; i++)
			{
				pGBC.gridx = i;
			pola[i].setEditable(false);
			lPrawy.add( pola[i], pGBC);
			}
			
			for (int i=0; i<5; i++)
			{
				for (int j=0; j<7; j++){
					pGBC.gridx = 0;
					pGBC.gridy = j+1;
					if (i==0) lPrawy.add(new JTextField(Model.magazyn[j]), pGBC);
				}
				for (int j=0; j<7; j++){
					pGBC.gridx = 1;
					pGBC.gridy = j+1;
					if (i==0) lPrawy.add(new JTextField(Model.sztuk[j]), pGBC);
				}
				for (int j=0; j<7; j++){
					pGBC.gridx = 2;
					pGBC.gridy = j+1;
					if (i==0) lPrawy.add(new JTextField(Model.cena[j]), pGBC);
				}
				for (int j=0; j<7; j++){
					pGBC.gridx = 3;
					pGBC.gridy = j+1;
					if (i==0) lPrawy.add(new JTextField(Model.gwarancja[j]), pGBC);
				}
				for (int j=0; j<7; j++){
				
					pGBC.gridx = 4;
					pGBC.gridy = j+1;
					if (i==0) lPrawy.add(new JTextField(Model.spec[j]), pGBC);
				}
			
			}
			
	}
			if(zmiana==0){
				pGBC.gridy = 0;
				for (int i=0; i<5; i++)
				{
					pGBC.gridx = i;
				pola[i].setEditable(false);
				lPrawy.add( pola[i], pGBC);
				}
				
				for (int i=0; i<5; i++)
				{
					for (int j=0; j<7; j++){
						pGBC.gridx = 0;
						pGBC.gridy = j+1;
						if (i==0) lPrawy.add(new JTextField(Model.magazyn[j]), pGBC);
					}
					for (int j=0; j<7; j++){
						pGBC.gridx = 1;
						pGBC.gridy = j+1;
						if (i==0) lPrawy.add(new JTextField(Model.sztuk[j]), pGBC);
					}
					for (int j=0; j<7; j++){
						pGBC.gridx = 2;
						pGBC.gridy = j+1;
						if (i==0) lPrawy.add(new JTextField(Model.cena[j]), pGBC);
					}
					for (int j=0; j<7; j++){
						pGBC.gridx = 3;
						pGBC.gridy = j+1;
						if (i==0) lPrawy.add(new JTextField(Model.gwarancja[j]), pGBC);
					}
					for (int j=0; j<7; j++){
						pGBC.gridx = 4;
						pGBC.gridy = j+1;
						if (i==0) lPrawy.add(new JTextField(Model.spec[j]), pGBC);
					}
				
				};
			}
	}


	void zaladujMenu(){
		menuBar = new JMenuBar();
		
		menuPlik = new JMenu ("Plik");
			mWczytaj = new JMenuItem("Wczytaj", 'W');
			mPokaz = new JMenuItem("Pokaz", 'P');
			mZapisz = new JMenuItem("Zapisz");
				mZapisz.setAccelerator(KeyStroke.getKeyStroke("ctrl S"));
			mWyjscie = new JMenuItem("Wyjscie");
				mWyjscie.setAccelerator(KeyStroke.getKeyStroke("ctrl X"));
			
			menuPlik.add(mWczytaj);
			menuPlik.add(mPokaz);
			menuPlik.add(mZapisz);
				menuPlik.addSeparator();
			menuPlik.add(mWyjscie);
					
			
		menuNarzedzia = new JMenu ("Narzedzia");
			mDodaj = new JMenuItem("Dodaj",'D');
			chZmien = new JCheckBoxMenuItem("Zmien");
			mUsun  = new JMenuItem("Usun",'U');
				mUsun.setEnabled(false);
			mOpcje = new JMenuItem("Opcje",'O');
				opcjeFrame.setSize(400,80);
				opcjeFrame.setTitle("Wybierz rozdzielczosc okna glownego");
				opcjeFrame.setResizable(false);
				opcjeFrame.setLocation((szerEkranu-400)/2,(wysEkranu-80)/2);
				opcjeFrame.add(cWymiary);
						
						
			menuNarzedzia.add(mDodaj);
			menuNarzedzia.add(chZmien);
			menuNarzedzia.add(mUsun);
				menuNarzedzia.addSeparator();
			menuNarzedzia.add(mOpcje);
		
			
			
		menuPomoc = new JMenu ("Pomoc");
			mAutor = new JMenuItem("Autor",'A');
			
			menuPomoc.add(mAutor);
	
		setJMenuBar(menuBar);
		menuBar.add(menuPlik);
		menuBar.add(menuNarzedzia);
			menuBar.add(Box.createHorizontalGlue());
		menuBar.add(menuPomoc);
	}
	
	

}