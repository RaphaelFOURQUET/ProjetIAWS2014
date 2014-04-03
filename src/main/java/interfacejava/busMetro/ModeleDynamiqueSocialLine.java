/**
 * 
 */
package interfacejava.busMetro;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import busMetro.SocialLine;
import busMetro.service.ChoixLigneService;

/**
 * @author Raphaël
 *
 */
@SuppressWarnings("serial")
public class ModeleDynamiqueSocialLine extends AbstractTableModel {
	
	private ArrayList<SocialLine> socialLines = new ArrayList<SocialLine>();
    private final ArrayList<SocialLine> socialLineFull;
 
    private final String[] entetes = {"Id Ligne", "Nom Ligne",
        "Numero Ligne", "Like", "Unlike"};
    
    ChoixLigneService choixLigneService = new ChoixLigneService();
 
    public ModeleDynamiqueSocialLine() {
        super();
 
        socialLineFull = (ArrayList<SocialLine>) choixLigneService.getAllSocialLines();
        socialLines = socialLineFull;
    }
    
    public ModeleDynamiqueSocialLine(String text) {
        super();
 
        //A verifier de près (pour le cast notamment)
        socialLineFull = (ArrayList<SocialLine>) choixLigneService.getAllSocialLines();
        if(!text.equals(""))
        	socialLines = containText(text);
        else
        	socialLines = socialLineFull;
    }
    
    ArrayList<SocialLine> containText(String text) {
    	ArrayList<SocialLine> myList = new ArrayList<SocialLine>();
    	for (SocialLine sl : socialLineFull) {
			if(sl.getShortName().contains(text)) {
				myList.add(sl);
			}
		}
    	return myList;
    }
 
    public int getRowCount() {
        return socialLines.size();
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
                return ((SocialLine) socialLines.get(rowIndex)).getLineId();
            case 1:
                return ((SocialLine) socialLines.get(rowIndex)).getLineName();
            case 2:
                return ((SocialLine) socialLines.get(rowIndex)).getShortName();
            case 3:
                return ((SocialLine) socialLines.get(rowIndex)).getCptLike();
            case 4:
                return ((SocialLine) socialLines.get(rowIndex)).getCptUnlike();
            default:
                return null; //Ne devrait jamais arriver
        }
    }

}
