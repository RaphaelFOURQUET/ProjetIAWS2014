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
public class ModeleDynamiqueLineDest extends AbstractTableModel {
	private ArrayList<LineDestArret> lineDestArrets = new ArrayList<LineDestArret>();
    private final ArrayList<LineDestArret> lineDestArretsFull;
 
    private final String[] entetes = {"Id Arret", "Nom Arret",
        "Id Destination", "Nom Destination", "Id Ligne", "Nom Ligne", "Numero Ligne"};
    
    //private final String[] entetes = {"Nom Arret", "Nom Destination", "Nom Ligne", "Numero Ligne"};
    
    ChoixLigneService choixLigneService = new ChoixLigneService();
 
    @SuppressWarnings("unchecked")
	public ModeleDynamiqueLineDest() {
        super();
 
        //A verifier de près (pour le cast notamment)
        lineDestArretsFull = (ArrayList<LineDestArret>) choixLigneService.getLigneDestUniversite();
        lineDestArrets = lineDestArretsFull;
    }
    
    @SuppressWarnings("unchecked")
	public ModeleDynamiqueLineDest(String text) {
        super();
 
        //A verifier de près (pour le cast notamment)
        lineDestArretsFull = (ArrayList<LineDestArret>) choixLigneService.getLigneDestUniversite();
        if(!text.equals(""))
        	lineDestArrets = containText(text);
        else
        	lineDestArrets = lineDestArretsFull;
    }
    
    ArrayList<LineDestArret> containText(String text) {
    	ArrayList<LineDestArret> myList = new ArrayList<LineDestArret>();
    	for (LineDestArret lineDestArret : lineDestArretsFull) {
			if(lineDestArret.getLine().getShortName().contains(text)) {
				myList.add(lineDestArret);
			}
		}
    	return myList;
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
    
//    public Object getValueAt(int rowIndex, int columnIndex) {
//        switch(columnIndex){
//            case 0:
//                return ((LineDestArret) lineDestArrets.get(rowIndex)).getArretName();
//            case 1:
//                return ((LineDestArret) lineDestArrets.get(rowIndex)).getDest().getDestinationName();
//            case 2:
//                return ((LineDestArret) lineDestArrets.get(rowIndex)).getLine().getLineName();
//            case 3:
//                return ((LineDestArret) lineDestArrets.get(rowIndex)).getLine().getShortName();
//            default:
//                return null; //Ne devrait jamais arriver
//        }
//    }
}