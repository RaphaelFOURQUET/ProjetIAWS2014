package interfacejava.busMetro;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import busMetro.LineDestArret;
import busMetro.service.ChoixLigneService;

/**
 *
 * @author Raphaël
 */
@SuppressWarnings("serial")
public class ModeleStatiqueLineDest extends AbstractTableModel {
    private final ArrayList<LineDestArret> lineDestArrets;
 
    private final String[] entetes = {"Id Arret", "Nom Arret",
        "Id Destination", "Nom Destination", "Id Ligne", "Nom Ligne", "Numero Ligne"};
    
    ChoixLigneService choixLigneService = new ChoixLigneService();
 
    @SuppressWarnings("unchecked")
	public ModeleStatiqueLineDest() {
        super();
 
        //TODO A verifier de près (pour le cast notamment)
        lineDestArrets = (ArrayList<LineDestArret>) choixLigneService.getLigneDestUniversite();
    }
 
    public int getRowCount() {
        return lineDestArrets.size();
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
                return ((LineDestArret) lineDestArrets.get(rowIndex)).getArretId();
            case 1:
                return ((LineDestArret) lineDestArrets.get(rowIndex)).getArretName();
            case 2:
                return ((LineDestArret) lineDestArrets.get(rowIndex)).getDest().getDestinationId();
            case 3:
                return ((LineDestArret) lineDestArrets.get(rowIndex)).getDest().getDestinationName();
            case 4:
                return ((LineDestArret) lineDestArrets.get(rowIndex)).getLine().getLineId();
            case 5:
            	return ((LineDestArret) lineDestArrets.get(rowIndex)).getLine().getLineName();
            case 6:
            	return ((LineDestArret) lineDestArrets.get(rowIndex)).getLine().getShortName();
            default:
                return null; //Ne devrait jamais arriver
        }
    }
}