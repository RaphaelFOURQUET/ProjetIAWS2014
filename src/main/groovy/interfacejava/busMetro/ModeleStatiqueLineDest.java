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
        //Remplacer ami par appel méthode..
        lineDestArrets = (ArrayList<LineDestArret>) choixLigneService.getLigneDestUniversite();
        		
        		/*new Ami[]{
                new Ami("Johnathan", "Sykes", Color.red, true, Sport.TENNIS),
                new Ami("Nicolas", "Van de Kampf", Color.black, true, Sport.FOOTBALL),
                new Ami("Damien", "Cuthbert", Color.cyan, true, Sport.RIEN),
                new Ami("Corinne", "Valance", Color.blue, false, Sport.NATATION),
                new Ami("Emilie", "Schrödinger", Color.magenta, false, Sport.FOOTBALL),
                new Ami("Delphine", "Duke", Color.yellow, false, Sport.TENNIS),
                new Ami("Eric", "Trump", Color.pink, true, Sport.FOOTBALL)
        };*/
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