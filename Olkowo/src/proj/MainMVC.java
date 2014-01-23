package proj;
import proj.MModel;
import proj.MView;
import proj.MController;

public class MainMVC {
	// ... Create model, view, and controller. They are
	// created once here and passed to the parts that
	// need them so there is only one copy of each.
	public static void main(String[] args) {

		MModel model = new MModel();
		MView view = new MView(model);
		new MController(model, view);

		view.setVisible(true);
	}
}