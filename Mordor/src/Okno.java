import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import org.dyno.visual.swing.layouts.Bilateral;
import org.dyno.visual.swing.layouts.Constraints;
import org.dyno.visual.swing.layouts.GroupLayout;


//VS4E -- DO NOT REMOVE THIS LINE!
public class Okno extends JFrame {

	private static final long serialVersionUID = 1L;
	private JDesktopPane jDesktopPane0;
	private static final String PREFERRED_LOOK_AND_FEEL = "javax.swing.plaf.metal.MetalLookAndFeel";
	public Okno() {
		initComponents();
	}

	private void initComponents() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/wolfie.png")));
		setLayout(new GroupLayout());
		add(getJDesktopPane0(), new Constraints(new Bilateral(0, 0, 0, 0), new Bilateral(0, 0, 0, 0)));
		setSize(892, 466);
	}

	private JDesktopPane getJDesktopPane0() {
		if (jDesktopPane0 == null) {
			jDesktopPane0 = new JDesktopPane();
			jDesktopPane0.setBackground(Color.red);
			jDesktopPane0.setDoubleBuffered(false);
		}
		return jDesktopPane0;
	}

	private static void installLnF() {
		try {
			String lnfClassname = PREFERRED_LOOK_AND_FEEL;
			if (lnfClassname == null)
				lnfClassname = UIManager.getCrossPlatformLookAndFeelClassName();
			UIManager.setLookAndFeel(lnfClassname);
		} catch (Exception e) {
			System.err.println("Cannot install " + PREFERRED_LOOK_AND_FEEL
					+ " on this platform:" + e.getMessage());
		}
	}

	/**
	 * Main entry of the class.
	 * Note: This class is only created so that you can easily preview the result at runtime.
	 * It is not expected to be managed by the designer.
	 * You can modify it as you like.
	 */
	public static void main(String[] args) {
		installLnF();
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Okno frame = new Okno();
				frame.setDefaultCloseOperation(Okno.EXIT_ON_CLOSE);
				frame.setTitle("Okno");
				frame.getContentPane().setPreferredSize(frame.getSize());
				frame.pack();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}
		});
	}

}
