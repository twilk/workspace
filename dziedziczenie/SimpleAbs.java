// Posta demonstracja u�ycia klasy abstrakcyjnej

abstract class A {
    // definicja klasy abstrakcyjnej 
    // tylko nag��wek, bez cia�a
    abstract void callMe();

    // zwyk�e, tj. w pe�ni zdefiniowane metody 
    // s� tak�e dozwowlone w klasach abstrakcyjnych
    void callMeToo() {
	System.out.println("\nMetoda zdefiniowana w klasie abstrakcyjnej A\n");
    }
}

class B extends A {
    // definiujemy callMe(), 
    // wymagane by tworzy� instancje klasy B
    void callMe() {
	System.out.println("\nImplementacja metody callMe z klasy B\n");
    }
}

// klasa testuj�ca
class AbstractDemo {
    public static void main(String args[]) {
	B b = new B();
	
	b.callMe();    // tu wywo�anie kodu z B
	b.callMeToo(); // tu wywo�anie kodu z A
    }
}
