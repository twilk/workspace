package swing.project;

import java.awt.*;
import javax.swing.*;


public class Widok extends JFrame{
    JButton dodaj;
    JButton dodaj2;
    JButton czysc;
    JButton usun;
    JButton zmien;
    JButton zmien2;
    JButton pokaz;
    JButton zapisz;
    JButton wczytaj;
    JButton wyjdz;
    
    private JLabel guziki;
    private JScrollPane srodekTabela;
    private JPanel srodekDodaj;
    private JLabel srodekUsun;
    private JPanel srodekZmien;  
    
    JTable tabela;
    JLabel start;
    
    JLabel[] pola = {new JLabel("Imie"),
                     new JLabel("Nazwisko"),
                     new JLabel("Wiek"),
                     new JLabel("E-mail")};
    JLabel[] pola2 = {new JLabel("Imie"),
                     new JLabel("Nazwisko"),
                     new JLabel("Wiek"),
                     new JLabel("E-mail")};
    
    JTextField[] tF;
    JTextField[] zF;
    
    JFrame okno;
    private final Model model;
    
    Widok(Model m){
        this.model = m;
        System.out.println("Widok initialized");
    }
    
    public void Okno(){
        okno   = new JFrame();
        guziki = dodajGuziki();
        srodekTabela = srodekTabela();
        srodekDodaj  = srodekDodaj();
        srodekUsun   = srodekUsun();
        srodekZmien  = srodekZmien();

        
        
        
        initialize(okno);
        
    }
    
    void initialize(JFrame o){
        o.setSize(550, 550);
        o.setResizable(true);
        o.setVisible(true);
        o.setTitle("Database Manager");    
        o.setDefaultCloseOperation(EXIT_ON_CLOSE);
        o.setLayout(new BorderLayout());
        o.setBackground(Color.WHITE);
        o.add(guziki, BorderLayout.PAGE_END);
        ImageIcon img = new ImageIcon("src/swing/project/thecat.jpg");
        start = new JLabel();
        start.setIcon(img);
        o.add(start);
    }
    public void pokazTabele(){
        okno.remove(start);
        okno.remove(srodekDodaj);
        okno.remove(srodekZmien);
        okno.remove(srodekUsun);
        okno.remove(srodekTabela);                
        okno.add(srodekTabela, BorderLayout.CENTER);
        okno.revalidate();
        okno.repaint();
    }
    public void pokazDodaj(){
        
        okno.remove(srodekTabela);
        okno.remove(srodekZmien);
        okno.remove(srodekUsun);               
        okno.add(srodekDodaj);
        okno.revalidate();
        okno.repaint();
    }
    
    public void pokazUsun(){
        okno.remove(srodekTabela);
        okno.remove(srodekDodaj);
        okno.remove(srodekZmien);

        
        okno.add(srodekUsun);
        okno.revalidate();
        okno.repaint();
    }
    public void pokazZmien(){
        okno.remove(srodekTabela);
        okno.remove(srodekDodaj);
        okno.remove(srodekUsun);
        okno.remove(srodekZmien);
                
        okno.add(srodekZmien);
        okno.revalidate();
        okno.repaint();
    }
    
    
    public JScrollPane srodekTabela(){
       TableM modelik = new TableM(model.getBaza().osoby);
       tabela = new JTable(modelik);
       
       tabela.setPreferredScrollableViewportSize(new Dimension(500, 500));
       tabela.setFillsViewportHeight(true);
       modelik.fireTableDataChanged();
       
       tabela.setModel(modelik);
       JScrollPane scroll = new JScrollPane(tabela);
       scroll.setOpaque(true);
      
       return scroll;
    }

    public JPanel srodekDodaj(){

       JPanel oknoDodaj   = new JPanel();
       JPanel oknoGlowne  = new JPanel();
       tF                 = new JTextField[4];
       oknoDodaj.setLayout(new GridLayout(7, 10, 10, 50));

       dodaj2 = new JButton("Dodaj!");
       czysc  = new JButton("Wyczysc pola.");
       
            oknoDodaj.add(pola[0]);
            tF[0] = new JTextField(15);
            pola[0].setLabelFor(tF[0]);
            
            oknoDodaj.add(tF[0]);
            //pola JLabel, tF textfield        
            
            oknoDodaj.add(pola[1]);
            tF[1] = new JTextField(10);
            pola[1].setLabelFor(tF[1]);
            oknoDodaj.add(tF[1]);
            
            
            
            oknoDodaj.add(pola[2]);
            tF[2] = new JTextField(10);
            pola[2].setLabelFor(tF[2]);
            oknoDodaj.add(tF[2]);
            
            
            
            oknoDodaj.add(pola[3]);
            tF[3] = new JTextField(10);
            pola[3].setLabelFor(tF[3]);
            oknoDodaj.add(tF[3]);
         

            
            
            
       oknoDodaj.add(dodaj2,     BorderLayout.PAGE_END);
       oknoDodaj.add(czysc,      BorderLayout.PAGE_END);

       oknoGlowne.add(oknoDodaj, BorderLayout.CENTER);
       
       return oknoGlowne;
       //return oknoDodaj;
    }
    
    public void CzyscPola(JTextField[] s){
        s[0].setText("");
        s[1].setText("");
        s[2].setText("");
        s[3].setText("");
    }
    
    public void PokaPola(JTextField[] s){
        s[0].setText(model.getBaza().osoby.get(tabela.getSelectedRow()).getImie());
        s[1].setText(model.getBaza().osoby.get(tabela.getSelectedRow()).getNazwisko());
        s[2].setText(Integer.toString(model.getBaza().osoby.get(tabela.getSelectedRow()).getWiek()));
        s[3].setText(model.getBaza().osoby.get(tabela.getSelectedRow()).getMail());
    }
        
        
    public JLabel srodekUsun(){
       JLabel s = new JLabel();
       s.setBackground(Color.BLACK);
       s.setPreferredSize(new Dimension(200, 200));
       
     
       s.setOpaque(true);
       return s;
    }

    public JPanel srodekZmien(){
        JPanel oknoGlowne = new JPanel();
        JPanel oknoZmien  = new JPanel();
        zmien2            = new JButton("Zmien!");
        zF                = new JTextField[4];
        oknoZmien.setLayout(new GridLayout(7, 10, 10, 50));
        
    
        
            oknoZmien.add(pola2[0]);
            zF[0] = new JTextField(15);
            pola2[0].setLabelFor(zF[0]);
            
            zF[0].setText("imie");
            oknoZmien.add(zF[0]);
            //pola JLabel, tF textfield        
            
            oknoZmien.add(pola2[1]);
            zF[1] = new JTextField(10);
            pola2[1].setLabelFor(zF[1]);
            zF[1].setText("nazwisko");
            oknoZmien.add(zF[1]);
                   
            oknoZmien.add(pola2[2]);
            zF[2] = new JTextField(10);
            pola2[2].setLabelFor(zF[2]);
            zF[2].setText("wiek");
            oknoZmien.add(zF[2]);
            
            oknoZmien.add(pola2[3]);
            zF[3] = new JTextField(10);
            pola2[3].setLabelFor(zF[3]);
            zF[3].setText("email");
            oknoZmien.add(zF[3]);
        
        oknoZmien.add(zmien2);
        oknoGlowne.add(oknoZmien);
            
        return oknoGlowne;
    }
    
    
    public JLabel dodajGuziki(){
        JLabel r = new JLabel();
        r.setLayout(new FlowLayout());
        dodaj   = new JButton("Dodaj");
        usun    = new JButton("Usun");
        zmien   = new JButton("Zmien");
        pokaz   = new JButton("Pokaz"); 
        zapisz  = new JButton("Zapisz");
        wczytaj = new JButton("Wczytaj");
        wyjdz   = new JButton("Wyjdz");
        
        r.add(wczytaj);
        r.add(pokaz);
        r.add(dodaj);
        r.add(usun);
        r.add(zmien);
        r.add(zapisz);
        r.add(wyjdz);
        
        r.setPreferredSize(new Dimension(500, 40));
        r.setBackground(new Color(248, 213, 131));
        r.setOpaque(true);
        return r;
    };

    
}
