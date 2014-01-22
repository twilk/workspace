package swing.project;

public class Main {
    public static void main(String[] args) {
        Model model       = new Model();
        Widok widok       = new Widok(model);
        Kontroler kontroler = new Kontroler(widok, model);
        
    }
    
}
