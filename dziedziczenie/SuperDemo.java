// Przyk³ad u¿ycia super do ods³aniania nazw

class A {
    int i; 
}

class B extends A {
    int i; // to i przykrywa i z klasy A

    // konstruktor
    B(int a, int b) {
	super.i = a; // odwo³ania do i w A
	i = b;
    }
    // reprezentacja napisowa
    public String toString() {
	return " A.i =\t" + super.i + " B.i =\t" + i;
    }
}

class SuperDemo {
    public static void main (String args[]) {
	B obB = new B(1, 2);
	
	System.out.println(obB.toString());
    }    
} 
