/**
 * 
 */
package interfacejava.veloToulouse;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import veloToulouse.StaticVeloStation;
import veloToulouse.VeloStationService;

/**
 *
 * @author Raphaël
 */
@SuppressWarnings("serial")
public class ModeleStatiqueVeloStation extends AbstractTableModel {
    private final ArrayList<StaticVeloStation> veloStationList;
 
    private final String[] entetes = {"Id Station", "Nom Station",
        "Adresse"};
    
    VeloStationService veloStationService = new VeloStationService();
 
    @SuppressWarnings("unchecked")
	public ModeleStatiqueVeloStation() {
        super();
 
        //A verifier de près (pour le cast notamment)
        veloStationList = (ArrayList<StaticVeloStation>) veloStationService.allVeloStation();
    }
 
    public int getRowCount() {
        return veloStationList.size();
    }
 
    public int getColumnCount() {
        return entetes.length;
    }
 
    public String getColumnName(int columnIndex) {
        return entetes[columnIndex];
    }
 
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return ((StaticVeloStation) veloStationList.get(rowIndex)).getNumber();
            case 1:
                return ((StaticVeloStation) veloStationList.get(rowIndex)).getName();
            case 2:
                return ((StaticVeloStation) veloStationList.get(rowIndex)).getAdress();
            default:
                return null; //Ne devrait jamais arriver
        }
    }
    
    
}
