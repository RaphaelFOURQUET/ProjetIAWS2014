/**
 * 
 */
package busMetro

/**
 * @author Raphaël
 *
 */
class Ligne {
	
	String lineId
	String lineName
	String shortName 
	
	String toString() {
		def res = " $lineId, $lineName, $shortName"
		res
	  }
	
//	Supprime les constructeurs par défaut, NE PAS décommenter
//	public Ligne (String lineId, String lineName, String shortName ) {
//		this.lineId = lineId
//		this.lineName = lineName
//		this.shortName = shortName
//	}

}
