package swing.mvc;

public class Main { 
	public static void main(String[] args) 
	{

		Model model       = new Model();
		Widok widok = new Widok(model);  
		widok.setVisible(true);
		Controler controler = new Controler(widok, model);
    }
    
}
