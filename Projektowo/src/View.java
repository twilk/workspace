import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;


class View extends JFrame {
	private static final long serialVersionUID = 1L;
	
	//wszystko co niezbedne :)
	private JTextField proba = new JTextField(2);
	private JTextField imie = new JTextField(20);
	private JButton wyslij = new JButton("Wyslij"); 
	private JButton okbtn = new JButton("OK");
	private JButton zagraj = new JButton("Zagraj");
	JPanel content = new JPanel();				
	
	private JLabel etykieta;
	private JLabel etykieta2;
	private static final int ROZMIAR = 20;
	
public View(Model model){
	
	Toolkit zestaw = Toolkit.getDefaultToolkit();
    Dimension rozmiarEkranu = zestaw.getScreenSize();
    int wysEkranu = rozmiarEkranu.height;
    int szerEkranu = rozmiarEkranu.width;

    // ustawianie szerokosci i wysokosci glownego okna
    setSize(szerEkranu / 3, wysEkranu / 6);
    // ustawianie pozycji glownego okna
    setLocation(szerEkranu / 3, wysEkranu / 3);
    // okresl ikone i tytul ramki
    setTitle("Guess what...");
    // standardowa reakcja na zamkniecie programu
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container powZawartosci = getContentPane();
    // dolacz etykiete z tekstem
    etykieta = new JLabel("(0-99)");
    //etykieta.setFont(new Font("Arial", Font.PLAIN,ROZMIAR));
    powZawartosci.add(etykieta,BorderLayout.NORTH);
    content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
    content.add(etykieta);
    content.add(proba);
    JPanel btnpanel = new JPanel();
    btnpanel.add(okbtn);
    content.add(btnpanel);
    content.setBackground(Color.white);
    btnpanel.setBackground(Color.white);
    
    this.setContentPane(content);
    this.pack();
	}

//nas�uchiwanie
//listener od przycisku ok
void okbtnListener(ActionListener ok){
	okbtn.addActionListener(ok); 
	}
//listener od pola do wpisania
void probaListener(ActionListener numer){
	okbtn.addActionListener(numer); 
	}

String probaAdd() {
	//System.out.println("wyciagam liczbe z pola tekstowego");
	return proba.getText();
	}


//drugie okienko w przypadku odgadni�cia
void okno2(){
	Toolkit zestaw = Toolkit.getDefaultToolkit();
    Dimension rozmiarEkranu = zestaw.getScreenSize();
    int wysEkranu = rozmiarEkranu.height;
    int szerEkranu = rozmiarEkranu.width;
	
    //System.out.println("Uruchamianie 2. okienka");
    //czyszczenie panelu 
    content.removeAll(); 
    //testy
    setTitle("WYGRANA!");
    // ustawianie szerokosci i wysokosci glownego okna
    setSize(szerEkranu / 3, wysEkranu / 3);
    // ustawianie pozycji glownego okna
    setLocation(szerEkranu / 3, wysEkranu / 3);
    //standardowa reakcja na zamkniecie programu
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    Container powZawartosci = getContentPane();
    // dolacz etykiete z tekstem
    etykieta = new JLabel("Gratuluje! Zgadles!");
    etykieta.setFont(new Font("Arial", Font.PLAIN,ROZMIAR));
    powZawartosci.add(etykieta,BorderLayout.NORTH);
 
    etykieta2 = new JLabel("Podaj nick");
    etykieta2.setFont(new Font("Arial", Font.PLAIN,ROZMIAR-5));
    powZawartosci.add(etykieta,BorderLayout.NORTH);
    
    content.add(etykieta);
    content.add(etykieta2);
    content.add(imie);
    JPanel btnpane = new JPanel();
    content.add(btnpane);
    btnpane.add(wyslij);
    btnpane.add(zagraj);
    content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
    content.setBackground(Color.white);
    btnpane.setBackground(Color.white);
    
    this.setContentPane(content);
    this.pack();
	}

// listener od przocisku wyslij
void wyslijListener(ActionListener send){
	wyslij.addActionListener(send);
	}
void zagrajListener(ActionListener send){
	content.removeAll();
	etykieta2.removeAll();

}

//listener od pola imie
void imieListener(ActionListener name){
	wyslij.addActionListener(name); 
	}
//wyciaganie imienia z pola tekstowego
String imieAdd() {
	//System.out.println("wyciagam imie z pola tekstowego");
	return imie.getText();
	}


void showError(String errMessage) {
	JOptionPane.showMessageDialog(this, errMessage, "Błąd krytyczny",JOptionPane.ERROR_MESSAGE);
}
}
