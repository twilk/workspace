// Figury geometryczne raz jeszcze 
// z zastosowaniem klas abstrakcyjnych
abstract class Figura {
    double dim1, dim2;

    Figura(double a, double b) {
	dim1 = a;
	dim2 = b;
    }
    // pole jest teraz metod� abstrakcyjn�
    abstract double pole();

}

class Prostokat extends Figura {

    Prostokat(double a, double b) {
	super(a, b);
    }
    
    // ukonkretniamy metod� pole 
    double pole() {
	System.out.println("Pole prostok�ta");
	return dim1 * dim2;
    }
}

class Trojkat extends Figura {

    Trojkat(double a, double b) {
	super(a, b);
    }
    
    // ukonkretniamy metod� pole
    double pole() {
	System.out.println("Pole tr�jk�ta");
	return dim1 * dim2 / 2;
    }
}

// Klasa testuj�ca
class FiguryDemo {
    public static void main (String args[]) {
	// Poni�sza linia spowoduje b��d: instancja klasy abstrakcyjnej
	// Figura    f = new Figura(10, 10);
	Prostokat p = new Prostokat(5, 4);
	Trojkat   t = new Trojkat(5, 4);
	// Mo�emy za to deklarowa� zmienne referencyjne klas abstrakcyjnych
	// poniewa� nie powoduje to tworzenia obiektu
	Figura figRef;

	figRef = p;   // prostok�t
	System.out.println("Pole = " + figRef.pole());

	figRef = t;   // tr�jkat
	System.out.println("Pole = " + figRef.pole());
    }
} 
