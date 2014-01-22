/** Klasa reprezentujaca skladnik dodawania
 */
public class Skladnik{
    /** Wartosc skladnika */
    private int x;
    
    /** Specjalna metoda bedaca konstruktorem klasy.
        Umozliwia inicjalizowanie obiektu skladnika 
        podczas jego tworzenia
    */
    Skladnik(int i){
	x = i;
    }
    
    /** Metoda umozliwiajaca zmiane wartosci skladnika
     */
    void set_x(int i){
	x = i;
    }
    /** Metoda umozliwiajaca pobranie wartosci skladnika
     */
    int get_x(){
	return x;
    }
    /** Metoda umozliwiajaca dodawanie skladnika parametru do aktualnego
     */
    void dodaj(Skladnik s){
	x += s.get_x();
    }
    /** Zamiana obiektu na String
     */
    public String toString(){
	return ""+x;
    }
}
