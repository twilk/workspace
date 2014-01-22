package swing.project;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("Osoba")
public class Osoba {
    public String imie;
    public String nazwisko;
    public int wiek;
    public String eMail;
    
    
    Osoba(String i, String n, int w, String e){
        imie = i;
        nazwisko = n;
        wiek = w;
        eMail = e;
    }
    
    public int getWiek(){
        return this.wiek;
    }
    public String getImie(){
        return this.imie;
    }
    
    public String getNazwisko(){
        return this.nazwisko;
    }
    
    public String getMail(){
        return this.eMail;
    }
    
    public void setImie(String i){
        this.imie = i;
    }
    
    public void setNazwisko(String i){
        this.nazwisko = i;
    }
    
    public void setWiek(int i){
        this.wiek = i;
    }
    
    public void setMail(String i){
        this.eMail = i;
    }
    
}
