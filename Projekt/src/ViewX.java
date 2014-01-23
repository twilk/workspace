import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class ViewX extends JFrame implements ActionListener
{
	JButton bPodajDate,bWyjscie;
	JLabel lWyswietlDate;
	
	public ViewX()
	{
		setSize(300,400);
		setTitle("Projekt Tomasz Wilk");
		setLayout(null);
		
		bPodajDate = new JButton("Podaj datê");
		bPodajDate.setBounds(50, 750, 100, 20);
		add(bPodajDate);
		bPodajDate.addActionListener(this);
		
		bWyjscie = new JButton("Wyjœcie");
		bWyjscie.setBounds(150, 750, 100, 20);
		add(bWyjscie);
		bWyjscie.addActionListener(this);
		
		lWyswietlDate = new JLabel("Data:");
		lWyswietlDate.setBounds(50, 100, 250, 20);
		lWyswietlDate.setForeground(new Color(20,90,20));
		lWyswietlDate.setFont(new Font("SansSerif",Font.BOLD, 16));
		add(lWyswietlDate);
	}
	
	public static void main(String[] args)
	{
		ViewX okno= new ViewX();
		okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		okno.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		Object source = e.getSource(); 
		if(source==bPodajDate)
		{
			//System.out.println(new Date());
			lWyswietlDate.setText(new Date().toString());
		}
		else if(source==bWyjscie)
		{
			dispose();
		}
		
	}
	
	
	
}
