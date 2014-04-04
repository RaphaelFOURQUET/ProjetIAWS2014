/**
 * 
 */
package veloToulouse

/**
 * @author Raphaël
 *
 */
class VeloStation extends StaticVeloStation {
	
	String status
	Integer availableBike
	Integer availableBikeStands
	
	
	String toString() {
		def res = "$number $name $adress $status\n"
		res
	  }
	
	/**
	 * Station ouverte ou non ?
	 * @return boolean 
	 */
	def stationOuverte() {
		return status.equalsIgnoreCase("OPEN")
		println "Statut : "+status
	}
	
	/**
	 * Nombre de velos disponible si station ouverte
	 * sinon code erreur -1
	 * @param v station de velo concernee
	 * @return nombre de velos disponibles
	 */
	def veloDisponible() {
		if (stationOuverte())
			return availableBike
		else {
			println "erreur : station actuellement fermée"
			return -1;
		}
	}

}
