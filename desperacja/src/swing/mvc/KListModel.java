package swing.mvc;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.AbstractListModel;

final class KListModel extends AbstractListModel {

	  static Calendar kalend = new GregorianCalendar();

	  static String[] nazwaDnia = {  "niedziela", "poniedzia≥ek", "wtorek",
	                                 "úroda", "czwartek", "piπtek", "sobota" };

	  static String[] nazwaMies = { "stycznia", "lutego", "marca", "kwietnia",
	                           "maja", "czerwca", "lipca", "sierpnia",
	                           "wrzeúnia", "paüdziernika", "listopada", "grudnia"
	                         };
	  static int[] ldni = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	  int rok;
	  int mies;

	  KListModel(int rok, int mies) {
	     this.rok = rok;
	     this.mies = mies - 1;
	  }

	  public Object getElementAt(int i) {
	    kalend.set(rok, mies, i+1);
	    int indDnia = kalend.get(Calendar.DAY_OF_WEEK) - 1;
	    return (i+1) + "  "+ nazwaMies[mies] + " " + nazwaDnia[indDnia];
	  }

	  public int getSize() {
	     return ldni[mies];
	  }

	}
