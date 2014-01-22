package swing.project;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import javax.swing.JTable;


public class Model {
    private Baza baza;
    Baza baza1;
    Model(){
        System.out.println("Model initialized.");
        baza = new Baza();
    }
    public Baza getBaza(){
        return baza;
    }
    public void dodaj(Osoba o){
        baza.dodaj(o);
        System.out.println("dodajemy");
    };
    public void usun(Osoba o){
        baza.usun(o);
        System.out.println("usuwamy");
    };
    public void zmien(Osoba s, Osoba n){
        baza.zamien(s, n);
        System.out.println("Zmieniamy.");
    };
    public void wyswietl(){
        baza.showAll();
        System.out.println("Pokazujemy tabele " + baza.osoby.size() + " elementów.");
    };

    public void pokazOsobe(Osoba o){
        System.out.println("Imie: " + o.imie + " Nazwisko: " + o.nazwisko);
    }
    public int getRows(){
        return baza.osoby.size();
    }
    public boolean isMail(String str){
        String at  = "@";
        String dot = ".";        
        if(str.contains(at) && str.contains(dot)){
            return true;
        }
        return false;
    }
    public boolean isInteger(String str) {
	if (str == null) {
		return false;
	}
	int length = str.length();
	if (length == 0) {
		return false;
	}
	int i = 0;
	if (str.charAt(0) == '-') {
		if (length == 1) {
			return false;
		}
		i = 1;
	}
	for (; i < length; i++) {
		char c = str.charAt(i);
		if (c <= '/' || c >= ':') {
			return false;
		}
	}
	return true;
}
    
    public void zapisz(){
        XStream xstream = new XStream(new StaxDriver());
        xstream.processAnnotations(new Class[] { Baza.class, Osoba.class });
        try{
            FileOutputStream k = new FileOutputStream("src/swing/project/database.xml");
            xstream.toXML(baza, k);
        } catch(FileNotFoundException e){
            System.out.println("ERROR");
        }
        
        
        System.out.println("zapisano " + baza.pobierzIlosc());
    }

    public void wczytaj(){
        XStream xstream = new XStream(new StaxDriver());
        xstream.processAnnotations(new Class[] { Baza.class, Osoba.class });
        try{
            FileInputStream k = new FileInputStream("src/swing/project/database.xml");
            baza1 = (Baza)xstream.fromXML(k);
            try{
                baza.refresh(baza1);
            }catch(Exception e){
               
            }
            
        } catch(FileNotFoundException e){
            e.printStackTrace();
        }
        System.out.println("Wczytano! " + baza.pobierzIlosc());
    }
}
