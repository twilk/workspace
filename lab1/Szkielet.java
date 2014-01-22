class KlasaA {
    double d;
    boolean logiczna;
    void metA(){
	/* zmienna lokalna metody metA(), jej zasieg to cialo tej metody */
	int j = 5;
	System.out.println("Metoda metA() z klasy A");
	System.out.println("Wartosc zmiennej lokalnej j: " + j);
    }
    boolean wartosc(){
	System.out.println("Metoda wartosc() z klasy A");
	return logiczna;
    }
}

class KlasaB {
    int i;
    int wartosc(){
	return i;
    }
}


public class Szkielet{
    public static void main(String[] args){
	
	/* Blad kompilacji - je�eli chcemy odwo�a� si� do pola logiczna z KlasaA
	   musimy najpierw stworzyc obiekt tej klasy */
	
	//   logiczna = false;

	/* Utowrzenie obiektu klasy KlasaA */
	KlasaA ka = new KlasaA();

	/* Teraz mo�na przypisa� warto�� polom klasy */
	ka.logiczna = false;

	/* zmienna lokalna istnieje tylko w metodzie main */
	boolean lokalna = ka.wartosc();

	ka.metA();
	ka.wartosc();
    }
}
