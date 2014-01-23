
package swing.project;

import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TableM extends AbstractTableModel {
    private List<Osoba> al;
    TableM(List<Osoba> o){
        al = o;
    }
    
    @Override
    public int getRowCount() {
        return al.size();     
    }

    @Override
    public int getColumnCount() {
        return 4; // soon to be fixed to by dynamic
    }

    @Override
    public String getColumnName(int column) {
        String name = "??";
        switch (column) {
            case 0:
                name = "Imie";
                break;
            case 1:
                name = "Nazwisko";
                break;
            case 2:
                name = "Wiek";
                break;
            case 3:
                name = "E-mail";
                break;
        }
        return name;
    }
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        Class type = String.class;
        switch (columnIndex) {
            case 0:
            case 1:
            case 2:
                type = Integer.class;
                break;
        }
        return type;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Osoba o = al.get(rowIndex);
        Object value = null;
        switch (columnIndex) {
            case 0:
                value = o.getImie();
                break;
            case 1:
                value = o.getNazwisko();
                break;
            case 2:
                value = o.getWiek();
                break;
            case 3:
                value = o.getMail();
                break;
        }
        return value;
    }   
    
    @Override
    public void setValueAt(Object o, int row, int col){
        Osoba os = al.get(row);
        String i = (String)o;
        switch(col){
            case 0:
                os.setImie(i);
                break;
            case 1:
                os.setNazwisko(i);
                break;
            case 2:
                os.setWiek(Integer.parseInt(i));
                break;
            case 3:
                os.setMail(i);
                break;
        }
        
    }
    
}

