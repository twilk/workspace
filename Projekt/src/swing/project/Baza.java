package swing.project;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import java.util.ArrayList;
import java.util.List;
@XStreamAlias("osoby")
public class Baza {
    @XStreamImplicit(itemFieldName = "Osoba")
    List<Osoba> osoby = new ArrayList<Osoba>();
    
    Baza(){
        System.out.println("Baza initialized.");
    }
    
    public void dodaj(Osoba o){
        osoby.add(o);
        System.out.println("Osoba dodana");
    }
    
    public void usun(Osoba o){
        osoby.remove(o);
    }
    public void showAll(){
        for(int i = 0; i < osoby.size(); i++){
            System.out.println(osoby.get(i).getImie());
        }
    }
    public void refresh(Baza b){
        for(int i = 0; i < b.osoby.size(); i++){
            osoby.add(b.osoby.get(i));
        }
    }
    
    public void zamien(Osoba s, Osoba n){
        int i;
        for(i = 0; i < osoby.size(); i++){
            if(osoby.get(i) == s){
                osoby.set(i, n);
            }
        }
    }
    public int pobierzIlosc(){
        
        return osoby.size();
    }
    
}
