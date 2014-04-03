/**
 * 
 */
package busMetro.service

import busMetro.client.HoraireDepartClient

/**
 * @author Raphaël
 * Service : Servira pour le cas d'utilisation 1 notamment.
 */
class HoraireDepartService {
	
	HoraireDepartClient hdClient = new HoraireDepartClient();
	
	/**
	 * Retourne le premier horaire de depart pour l'arret, la ligne et la destination voulue.
	 * @param idArret ID arret cible.
	 * @param idLine ID ligne ciblee.
	 * @param destName Nom destination ciblee.
	 * @return String Horaire depart
	 */
	String getHoraireDepart(String idArret, String idLine, String destName) {
		String res
		def json = hdClient.getJsonDepart(idArret, idLine)
		if (json) {
		 res = chooseFirstGoodResult(json, destName)
		}
		else {
			println "\nErreur : impossible de récupérer la station demandée."
		}
		res
	}
	
	/**
	 * Renvoie le premier horaire de depart à bonne destination.
	 * @param destName Destination voulue.
	 * @return String Horaire depart
	 */
	String chooseFirstGoodResult(def json, String destName) {
		String res = "\nNo solution found :\nPlus de départs imminents."
		json.departures.departure.each {
			if(!it.isEmpty()) {//Attention le dernier départure est {}  get impossible dessus
				String t1 = it.destination.get(0).name
				
				if(t1.equals(destName)) {
					res = it.dateTime // !! on ne peut pas return dans une closure
				}
			}
		}
		return res
	}

}
