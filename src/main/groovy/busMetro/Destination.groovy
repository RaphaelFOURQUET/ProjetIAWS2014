/**
 * 
 */
package busMetro

/**
 * @author Raphaël
 * Destination selon la definition Tisséo.
 */
class Destination {
	
	String destinationId
	String destinationName
	
	String toString() {
		def res = " $destinationId, $destinationName,"
		res
	  }
	
//	Supprime les constructeurs par défaut, NE PAS décommenter	
//	public Destination(String destinationId, String destinationName) {
//		this.destinationId = destinationId
//		this.destinationName = destinationName
//	}

}
