package swing.project;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Kontroler{
    private final Widok widok;
    private final Model model;
    Kontroler(Widok w, Model m){
        this.widok = w;
        this.model = m;
        widok.Okno();
        ustawGuziki();
        System.out.println("Kontroler initialized");
    }
    void ustawGuziki(){
        this.widok.dodaj.addActionListener(Dodaj);
        this.widok.usun.addActionListener(Usun);
        this.widok.zmien.addActionListener(Zmien);
        this.widok.zmien2.addActionListener(Zmien2);
        this.widok.pokaz.addActionListener(Pokaz);
        this.widok.wczytaj.addActionListener(Wczytaj);
        this.widok.zapisz.addActionListener(Zapisz);
        this.widok.dodaj2.addActionListener(Dodaj2);
        this.widok.czysc.addActionListener(Czysc);
        this.widok.wyjdz.addActionListener(Wyjdz);
        System.out.println("Nasluchiwanie guzikow initialized.");
    }
    

    ActionListener Dodaj = new ActionListener(){
        @Override
	public void actionPerformed(ActionEvent e){
            widok.pokazDodaj();
            System.out.println(model.getBaza().osoby.size());
            
	}
    };
    
    ActionListener Czysc = new ActionListener(){
        @Override
	public void actionPerformed(ActionEvent e){
            widok.CzyscPola(widok.tF);
            System.out.println("Pola wyczyszczone!");
            
	}
    };
    
    ActionListener Wyjdz = new ActionListener(){
        @Override
       public void actionPerformed(ActionEvent e){
            Container frame = widok.wyjdz.getParent();
            do 
                frame = frame.getParent(); 
            while (!(frame instanceof JFrame));                                      
            ((JFrame) frame).dispose();
        }
    };
    
    ActionListener Dodaj2 = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            
            if(widok.tF[0].getText().isEmpty() == true){
                JOptionPane.showMessageDialog(widok.okno, "Wprowadz imie!");
            } else if(widok.tF[1].getText().isEmpty() == true){
                JOptionPane.showMessageDialog(widok.okno, "Wprowadz nazwisko!");                
            } else if(widok.tF[2].getText().isEmpty() == true || model.isInteger(widok.tF[2].getText()) != true ){
                JOptionPane.showMessageDialog(widok.okno, "Wprowadz poprawnie wiek!");
            } else if(model.isMail(widok.tF[3].getText()) != true || widok.tF[3].getText().isEmpty() == true) {
                JOptionPane.showMessageDialog(widok.okno, "Wprowadz poprawnie e-mail!");
            } else {
                System.out.println("Dodano nową osobę.");
                model.dodaj(new Osoba(widok.tF[0].getText(), widok.tF[1].getText(), Integer.parseInt(widok.tF[2].getText()), widok.tF[3].getText()));
                JOptionPane.showMessageDialog(widok.okno, "Dodano \nImie: " + widok.tF[0].getText() + "\nNazwisko: " + widok.tF[1].getText() + "\nWiek: " + widok.tF[2].getText() + "\nE-mail: " + widok.tF[3].getText() + " \ndo bazy!");
                widok.pokazTabele();
            }
        }
    };
    
     ActionListener Usun = new ActionListener(){
        @Override
	public void actionPerformed(ActionEvent e){
            if(widok.tabela.getSelectedRow() != -1){
                System.out.println(widok.tabela.getSelectedRow());
            //model.usun(new Osoba(widok.tF[0].getText(), widok.tF[1].getText(), Integer.parseInt(widok.tF[2].getText()), widok.tF[3].getText()));
                model.usun(model.getBaza().osoby.remove(widok.tabela.getSelectedRow()));
                widok.pokazTabele();
            } else {
                JOptionPane.showMessageDialog(widok.okno, "Nie wybrano elementu do usunięcia.");
            }
	}
    };
        
    ActionListener Zmien = new ActionListener(){
        @Override
	public void actionPerformed(ActionEvent e){
            if(widok.tabela.getSelectedRow() == -1){
                JOptionPane.showMessageDialog(widok.okno, "Nie wybrano wiersza.");
            } else if(model.getBaza().osoby.size() > 0){
                System.out.println(widok.tabela.getSelectedRow());
                widok.pokazZmien();
                widok.PokaPola(widok.zF);
            } else {
                JOptionPane.showMessageDialog(widok.okno, "Nie można zmienić, brak elementów.");
            }
	}
    };
    
    ActionListener Zmien2 = new ActionListener(){
        @Override
	public void actionPerformed(ActionEvent e){
           Osoba stara = model.getBaza().osoby.get(widok.tabela.getSelectedRow());
            if(widok.zF[0].getText().isEmpty() == true){
                JOptionPane.showMessageDialog(widok.okno, "Wprowadz imie!");
            } else if(widok.zF[1].getText().isEmpty() == true){
                JOptionPane.showMessageDialog(widok.okno, "Wprowadz nazwisko!");                
            } else if(widok.zF[2].getText().isEmpty() == true || model.isInteger(widok.zF[2].getText()) != true ){
                JOptionPane.showMessageDialog(widok.okno, "Wprowadz poprawnie wiek!");
            } else if(model.isMail(widok.zF[3].getText()) != true || widok.zF[3].getText().isEmpty() == true) {
                JOptionPane.showMessageDialog(widok.okno, "Wprowadz poprawnie e-mail!");
            } else {
                System.out.println("Zaktualizowano osobę.");
                stara.setImie(widok.zF[0].getText());
                stara.setNazwisko(widok.zF[1].getText());
                stara.setWiek(Integer.parseInt(widok.zF[2].getText()));
                stara.setMail(widok.zF[3].getText());
                //model.dodaj(new Osoba(widok.zF[0].getText(), widok.zF[1].getText(), Integer.parseInt(widok.zF[2].getText()), widok.zF[3].getText()));
                JOptionPane.showMessageDialog(widok.okno, "Zaktualizowano: \nImie: " + widok.zF[0].getText() + "\nNazwisko: " + widok.zF[1].getText() + "\nWiek: " + widok.zF[2].getText() + "\nE-mail: " + widok.zF[3].getText() + " \nw bazie.");
                widok.pokazTabele();
            }
	}
    };
            
    ActionListener Pokaz = new ActionListener(){
        @Override
	public void actionPerformed(ActionEvent e){
            widok.pokazTabele();
            model.wyswietl();
	}
    };
    
    ActionListener Zapisz = new ActionListener(){
        @Override
	public void actionPerformed(ActionEvent e){
            if(model.getBaza().osoby.size() > 0){
                model.zapisz();
                JOptionPane.showMessageDialog(widok.okno, "Zapisano pomyślnie " + model.getBaza().osoby.size() + " elementów!");
            } else {
                JOptionPane.showMessageDialog(widok.okno, "Nie zapisano, bo brak elementów.");
            }
	}
    };
    
    ActionListener Wczytaj = new ActionListener(){
        @Override
	public void actionPerformed(ActionEvent e){
            model.wczytaj();
            JOptionPane.showMessageDialog(widok.okno, "Wczytano pomyślnie "  + model.baza1.osoby.size() + " elementów!");            
            widok.pokazTabele();
            
	}
    };
}
