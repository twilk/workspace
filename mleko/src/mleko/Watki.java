package mleko;

class Suma extends Thread {
	static int suma = 0;
	int nr;
	static int ilosc = 1;
	
	public Suma() {
		start();
		nr = ilosc;
		ilosc++;
	}
	
	public  void run() {
		suma += nr;
	}
}


class Watek extends Thread {
	
	boolean flaga = true;
	int i = 0;
	
	public Watek() {
		super("Watek 1");
		start();
	}
	
	public void run() {
		while(flaga) {
			System.out.println("Watek: "  + getName());
			i++;
			if (i == 10) flaga = false;
			try {
				Thread.sleep(250);
			} catch (InterruptedException e) {
			}
		}
	}
}

class Watek2 implements Runnable {
	boolean flaga = true;
	int i = 0;
	
	@Override
	public void run() {
		while(flaga) {
			System.out.println("Watek");
			i++;
			if (i == 10) flaga = false;
			try {
				Thread.sleep(250);
			} catch (InterruptedException e) {
			}
		}
	}
	
}

public class Watki {
	public static void main(String[] args) {
		Suma[] tablica = new Suma[20];
		for(int i = 0; i < 20; i++) {
			tablica[i] = new Suma();
		}
		
		for(int i = 0; i < 20; i++) {
			try {
				tablica[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(Suma.suma);
	}
}
