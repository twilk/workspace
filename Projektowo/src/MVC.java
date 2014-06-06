
public class MVC {
	
	public static void main(String[] args) {

		Model model = new Model();
                model.set();
		//int test=model.porownaj("50");
		//System.out.println("Test returna wykonywany jest sztucznie w mainie MVC.java");
		//System.out.println("test returna (-1 jesli 50 to za malo, 1 jesli za duzo, 0 jesli rowne)   " + test);
		View view = new View(model);
		/*Controller controller =*/ new Controller(model, view);

		view.setVisible(true);
		
	}
}