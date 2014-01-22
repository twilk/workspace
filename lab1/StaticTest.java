class A {
    double d = 5.0;
    static int j = 7;
    static void metA(){
	System.out.println("Metoda statyczna metA() z klasy A");
	System.out.println("Uwaga ! Nie mam dostepu do skladowych, ktore nie sa statyczne !");
	System.out.println("Wartosc sk³adowej j: " + j);
	/* Zle, nie mam dostepu do zmiennej instancyjnej */
	// System.out.println(" Wartosc skladowej d: " + d);
    }
    void wartosc(){
	System.out.println("Metoda instancyjna (niestatyczna)  wartosc() z klasy A");
	System.out.println("Mam dostep do wszystkich skladowych");
	System.out.println("Wartosc sk³adowej j: " + j);
	System.out.println("Wartosc sk³adowej d: " + d);

    }
}

public class StaticTest{
    public static void main(String[] args){
	

	/* Ok, j jest statyczna */
	A.j = 8;
 
	/* Zle, d jest instancyjna*/
	// A.d = 3.0;

	/* Ok, metA() jest statyczna */
	A.metA();
	
	/* Zle, wartosc() jest instancyjna */
	// A.wartosc();
	
	A a = new A();
	/* Teraz Ok, mamy instancje klasy A */
	a.d = 4.0;
	a.wartosc();
    }
}
