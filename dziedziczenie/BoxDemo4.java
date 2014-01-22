// Definicja prostej klasy z metodami i konstruktorami

// klasa nadrz�dna
class Box{
    private double width;
    private double height;
    private double depth;

    // konstruktor klonuj�cy
    Box(Box ob) {
	width  = ob.width; 
	height = ob.height; 
	depth  = ob.depth;
    }
    // konstruktor bez parametr�w
    Box() {
	width  = -1; 
	height = -1; 
	depth  = -1;
    }
    // konstruktor z jednym parametrem
    Box(int n) {
	width  = n; // tu konwersja int do double
	height = n; 
	depth  = n;
    }
    // konstruktor z parametrami
    Box(double w, double h, double d) {
	width  = w; 
	height = h; 
	depth  = d;
    }
    // metoda zmieniaj�ca zawarto�� obiektu
    // ale nie b�d�ca konstruktorem
    // nic nie zwraca, wi�c typ wynikowy to void
    void setDim(double w, double h, double d) {
	width  = w; 
	height = h; 
	depth  = d;
    }
    // metoda obliczaj�ca obj�to��
    double volume() {
	// tu metoda oddaje obi�to��
	return width * height * depth;
    }
    // reprezentacja napisowa obiektu Box
    public String toString() {
	return " Obj�to�� =\t" + this.volume();
    }
}

// klasa potomna
class BoxWeight extends Box {
    private double weight;

    // konstruktor klonuj�cy
    BoxWeight(BoxWeight ob) {
	super(ob);     // tu odwo�ujemy si� do konstruktora Box(Box ob)      
	weight  = ob.weight; 
    }
    // konstruktor bez parametr�w
    BoxWeight() {
	super();     // jw. - musimy przes�a� odp. liczb� parametr�w
	weight  = -1;
    }
    // konstruktor z dwoma parametremami
    BoxWeight(int n, double m) {
	super(n);    // tu wysu�amy tylko jeden parametr
	weight  = m; // a tu u�ywamy drugiego
    }
    // konstruktor z parametrami
    BoxWeight(double w, double h, double d, double m) {
	super(w, h, d);
	weight  = m; 
    }
    // metoda zmieniaj�ca zawarto�� obiektu
    void setDim(double w, double h, double d, double m) {
	super.setDim(w, h, d);
	weight  = m; 
    }
    // reprezentacja napisowa obiektu BoxWeight
    public String toString() {
	return super.toString() + "\n" +
	    " Waga     =\t" + weight;
    }

}  
// definicja klasy demonstruj�cej u�ycie klasy Box 
class BoxDemo4{
    public static void main (String args[]) {
	// utworzenie instancji klasy Box
	BoxWeight myBox1 = new BoxWeight();
	BoxWeight myBox2 = new BoxWeight(2, 3);
	BoxWeight myBox3 = new BoxWeight(3, 4, 5, 0.1234);
	BoxWeight myBox4 = new BoxWeight(myBox3);

	// wypisujemy obj�to�ci 
	System.out.println("myBox1: \n" + myBox1.toString());
	System.out.println("myBox2: \n" + myBox2.toString());
	System.out.println("myBox3: \n" + myBox3.toString());
	System.out.println("myBox4: \n" + myBox4.toString());

	// zmieniamy zawarto�� obiektu myBox1
	myBox1.setDim(2, 3, 2, 100.001);
	// raz jeszcze jego obj�to��
	System.out.println("myBox1: \n" + myBox1.toString());
    }
}
