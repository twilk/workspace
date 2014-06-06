import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class Controller {
	private Model m_model;
	private View v_view;
	private int liczba=0;
	
	Controller(Model model, View view){
		
		m_model=model;
               
		v_view=view;

		view.okbtnListener(new okbtnListener());
		view.probaListener(new probaListener());
		view.wyslijListener(new wyslijListener());
		view.imieListener(new imieListener());
	}


	class okbtnListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try{
			}
			
			catch (Exception e2) {
				v_view.showError("Error: '" + e2.getMessage() + "'");
			}
		}
	}
	
	class probaListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			try{
				int wynik;
				
				wynik = m_model.porownaj(v_view.probaAdd());				
				//System.out.println("wynik porownania : " + wynik);		
				liczba++;
		
				if(wynik==0){
					v_view.okno2();					
					System.out.println("Proby: " + liczba);	
				}
				else if(wynik<0){
					JOptionPane.showMessageDialog(v_view, "Za wysoka");
				}
				else{
					JOptionPane.showMessageDialog(v_view, "Za niska");
				}
			}
			catch (Exception e2) {
				v_view.showError("Error: '" + e2.getMessage() + "'");
			}
		}
	}
	
	class wyslijListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			try{
				//System.out.println("wcisnieto klawisz wyslij");
			}
			catch (Exception e2) {
				v_view.showError("Error: '" + e2.getMessage() + "'");
			}
			}
	}
		
	class imieListener implements ActionListener{
		private int tmp;

		public void actionPerformed(ActionEvent e) {
			
				if(v_view.imieAdd().length()<3){
					JOptionPane.showMessageDialog(v_view, "Imie min 3 znaki.");
				}
				else {try{
                tmp = m_model.odczyt();
				//System.out.println("imie " + v_view.imieAdd());
				m_model.imie=v_view.imieAdd();
				m_model.zapis(liczba,m_model.imie);
				

				//System.out.println("TMP = " + tmp);		
				
				JOptionPane.showMessageDialog(v_view,"Wynik " +  v_view.imieAdd() + " zapisany.");
				}
				catch (Exception e2) {
					v_view.showError("Error: '" + e2.getMessage() + "'");
					}
				}
				}
	}
	
}
