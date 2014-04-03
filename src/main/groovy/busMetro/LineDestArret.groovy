/**
 * 
 */
package busMetro

/**
 * @author Raphaël
 * Triplet Ligne/Destination/Arret(de bus ou de métro).
 */
class LineDestArret {
	
	String arretId
	String arretName
	Destination dest
	Ligne line
	
	//constructeur
	public LineDestArret(String arretId, String arretName, Destination dest, Ligne line) {
		this.arretId = arretId
		this.arretName = arretName
		this.dest = dest
		this.line = line		
	}
	
	String toString() {
		def res = "[$arretId, $arretName,"+dest+" "+line+"]"
		res
	  }

}
