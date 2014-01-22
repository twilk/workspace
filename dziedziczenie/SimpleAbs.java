// Posta demonstracja u¿ycia klasy abstrakcyjnej

abstract class A {
    // definicja klasy abstrakcyjnej 
    // tylko nag³ówek, bez cia³a
    abstract void callMe();

    // zwyk³e, tj. w pe³ni zdefiniowane metody 
    // s± tak¿e dozwowlone w klasach abstrakcyjnych
    void callMeToo() {
	System.out.println("\nMetoda zdefiniowana w klasie abstrakcyjnej A\n");
    }
}

class B extends A {
    // definiujemy callMe(), 
    // wymagane by tworzyæ instancje klasy B
    void callMe() {
	System.out.println("\nImplementacja metody callMe z klasy B\n");
    }
}

// klasa testuj±ca
class AbstractDemo {
    public static void main(String args[]) {
	B b = new B();
	
	b.callMe();    // tu wywo³anie kodu z B
	b.callMeToo(); // tu wywo³anie kodu z A
    }
}
