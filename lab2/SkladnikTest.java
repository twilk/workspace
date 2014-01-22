/** Klasa testujaca zachowanie skladnikow
 */
public class SkladnikTest{
    public static void main(String [] args) {
	Skladnik s1 = new Skladnik(5);
	Skladnik s2 = new Skladnik(7);

	System.out.println("s1       = " + s1.get_x());
	System.out.println("s2       = " + s2.get_x());
	s1.dodaj(s2);
        System.out.println("s1 + s2  = " + s1);

	// teraz zmieniamy zawartosci skladnikow
	s1.set_x(13);
	s2.set_x(44);

	System.out.println("s1       = " + s1); // tu polegamy na metodzie toString
	System.out.println("s2       = " + s2); // tu tez
	s1.dodaj(s2);
        System.out.println("s1 + s2  = " + s1);
    }
}
