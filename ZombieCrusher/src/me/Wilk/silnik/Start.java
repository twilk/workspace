package me.Wilk.silnik;

public class Start {

	public static Ramka ramka = new Ramka();
	public static Petla petla = new Petla();
	public static Kanwas kanwas = new Kanwas();
	public static Gra gra = new Gra();
	
	
	
	public static void main(String[] args){
		ramka.add(kanwas);
		petla.start();
	}
	
}
