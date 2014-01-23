import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class CelsiusToFahrenheit extends JFrame implements ActionListener
{
	JLabel lCelsius, lFahrenheit;
	JTextField tCelsius, tFahrenheit;
	JButton bKonwertuj;
	double tempFahrenheit, tempCelsius;
	
	public CelsiusToFahrenheit()
	{

		
		setSize(400,300);
		setTitle("BazoDanowaJavaProjekt");
		setLayout(null);
		
		lCelsius = new JLabel("Imiê");
		lCelsius.setBounds(20, 20, 150, 20);
		add(lCelsius);
		
		tCelsius = new JTextField("");
		tCelsius.setBounds(170, 20, 150, 20);
		add(tCelsius);

		lFahrenheit = new JLabel("Nazwisko");
		lFahrenheit.setBounds(20, 70, 150, 20);
		add(lFahrenheit);
				
		tFahrenheit = new JTextField("");
		tFahrenheit.setBounds(170, 70, 150, 20);
		add(tFahrenheit);
		
		bKonwertuj = new JButton("Dodaj");
		bKonwertuj.setBounds(100, 100, 150, 20);
		add(bKonwertuj);
		bKonwertuj.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		tempCelsius=Double.parseDouble(tCelsius.getText());
		tempFahrenheit= 32+ (9.0/5.0)*tempCelsius;
		tFahrenheit.setText(String.valueOf(tempFahrenheit));
		
	}
	
	
	public static void main(String[] args)
	{
		CelsiusToFahrenheit appka = new CelsiusToFahrenheit();
		appka.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		appka.setVisible(true);
	}
}
