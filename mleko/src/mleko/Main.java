package mleko;

class Pracownik {
	String imie;
	private String nazwisko;
	
	
	
	public Pracownik(String imie, String nazwisko) {
		this.imie = imie;
		this.nazwisko = nazwisko;
		ILOSC++;
	}
	/*
	public String toString() {
		return imie + " " + nazwisko;
	}*/



	public static int ILOSC = 0;
	public final static int liczba = 0;
}


public class Main {
	public static void main(String[] args) {
		Pracownik pracownik1 = new Pracownik("Jan", "Kowalski");
		Pracownik pracownik2 = new Pracownik("Jan", "Nowak");
		//pracownik2.ILOSC++;
		String tekst = "(" + pracownik1 + ")";
		System.out.println(tekst);
		//System.out.println(pracownik2.ILOSC);
	}
}
