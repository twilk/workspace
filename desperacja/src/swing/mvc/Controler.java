package swing.mvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;



public class Controler {
	private final Widok widok;
    private final Model model;
    Controler(Widok w, Model m){
        this.widok = w;
        this.model = m;
        ustawAkcje();
        System.out.println("Kontroler dziala");
    }
    
    void ustawAkcje(){
        this.widok.mWyjscie.addActionListener(Wyjscie);
    //    this.widok.mWczytaj.addActionListener(Wczytaj);
    //    this.widok.mPokaz.addActionListener(Pokaz);
    //    this.widok.mZapisz.addActionListener(Zapisz);
    //    this.widok.mDodaj.addActionListener(Dodaj);
          this.widok.chZmien.addActionListener(Zmien);
          this.widok.mOpcje.addActionListener(Opcje);
    //    this.widok.mAutor.addActionListener(Autor);
          this.widok.cWymiary.addActionListener(Wymiary);
    }
    
    ActionListener Wyjscie = new ActionListener(){
        @Override
       public void actionPerformed(ActionEvent e){
        	int odp = JOptionPane.showConfirmDialog(null, "Czy na pewno wyjœæ ?","Potwierdzenie",JOptionPane.YES_NO_OPTION);
			if(odp==JOptionPane.YES_OPTION){ JOptionPane.showMessageDialog(null, "Do zobaczenia.");	widok.dispose(); }
			else if (odp==JOptionPane.NO_OPTION) JOptionPane.showMessageDialog(null, "W porz¹dku :)");
			else if (odp==JOptionPane.CLOSED_OPTION) JOptionPane.showMessageDialog(null, " Czemu tak ? ","UWAZAJ",JOptionPane.WARNING_MESSAGE);
        }
    };    

    ActionListener Zmien = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(widok.chZmien.isSelected())
			{
				//tu akcja dla Zmien.zaznaczone
			}else if(!widok.chZmien.isSelected())
				{
				//tu akcja dla Zmien.niezaznaczone
				}
		}
	};
	
	ActionListener Opcje = new ActionListener() {
				
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			widok.opcjeFrame.setVisible(true);
		}		
	};
	
	ActionListener Wymiary = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			zmienOkno(widok.cWymiary.getSelectedIndex());
			
			widok.setSize(Widok.DEFAULT_WYS,Widok.DEFAULT_SZER);
			widok.setResizable(false);
			widok.setLocation((widok.szerEkranu-Widok.DEFAULT_WYS)/2,(widok.wysEkranu-Widok.DEFAULT_SZER)/2);
		
		}

		private void zmienOkno(int selectedIndex) {
			if ( selectedIndex == 0)
			{	
				Widok.DEFAULT_WYS = 800;
				Widok.DEFAULT_SZER = 600;
			}
			if (selectedIndex == 1)
			{
				Widok.DEFAULT_WYS = 400;
				Widok.DEFAULT_SZER = 300;				
			}
			if (selectedIndex == 2)
			{
				Widok.DEFAULT_WYS = 1024;
				Widok.DEFAULT_SZER = 768;
			}



		}	

	};
}

/*	public class WymiaryLisnener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			zmienOkno(t_widok.cWymiary.getSelectedIndex());
		}
		private void zmienOkno(int selectedIndex) {
			if (selectedIndex == 0)
			{	
				Widok.DEFAULT_WYS = 800;
				Widok.DEFAULT_SZER = 600;
				
				t_widok.setSize(Widok.DEFAULT_WYS,Widok.DEFAULT_SZER);
				t_widok.setResizable(false);
				t_widok.setLocation((t_widok.szerEkranu-Widok.DEFAULT_WYS)/2,(t_widok.wysEkranu-Widok.DEFAULT_SZER)/2);
			}
			if (selectedIndex == 1)
			{
				Widok.DEFAULT_WYS = 400;
				Widok.DEFAULT_SZER = 300;
				
				t_widok.setSize(Widok.DEFAULT_WYS,Widok.DEFAULT_SZER);
				t_widok.setResizable(false);
				t_widok.setLocation((t_widok.szerEkranu-Widok.DEFAULT_WYS)/2,(t_widok.wysEkranu-Widok.DEFAULT_SZER)/2);
							
			}
			if (selectedIndex == 2)
			{
				Widok.DEFAULT_WYS = 1024;
				Widok.DEFAULT_SZER = 768;
				
				t_widok.setSize(Widok.DEFAULT_WYS,Widok.DEFAULT_SZER);
				t_widok.setResizable(false);
				t_widok.setLocation((t_widok.szerEkranu-Widok.DEFAULT_WYS)/2,(t_widok.wysEkranu-Widok.DEFAULT_SZER)/2);
				
			}

			t_widok.cWymiary.setVisible(true);
			t_widok.opcjeFrame.add(t_widok.cWymiary);
		}
			
	}
		
	ActionListener ZmianaListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			Object z = e.getSource();
			if (z == t_widok.chZmien){
				
			}
				
		}
	};

	
	ActionListener Autor = new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Object z = e.getSource();
			if (z == t_widok.mAutor){
				
	}
		
	}
		private void Autor() {
			JOptionPane.showMessageDialog(t_widok, this, "Tomasz Wilk\n nr indeksu 215549", 0);
		}
};
	

	Widok t_widok ;
	public  Controler(Widok widok, Model model) {
		t_widok = widok;
		widok.addcWymiaryListener(new WymiaryLisnener());
	
	}
	
	
}
*/