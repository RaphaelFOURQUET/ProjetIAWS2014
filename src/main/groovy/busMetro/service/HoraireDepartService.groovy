/**
 * 
 */
package busMetro.service

import busMetro.client.HoraireDepartClient

/**
 * @author Raphaël
 *
 */
class HoraireDepartService {
	
	HoraireDepartClient hdClient = new HoraireDepartClient();
	
	String getHoraireDepart(String idArret, String idLine, String destName) {
		String res
		def json = hdClient.getJsonDepart(idArret, idLine)
		if (json) {
		 res = chooseFirstGoodResult(json, destName)
		}
		else {
			println "Erreur : impossible de récupérer la station demandée."
		}
		res
	}
	
	/**
	 * Renvoie le premier horaire de depart à bonne destination.
	 * @param destName Destination voulue.
	 * @return String Horaire depart
	 */
	String chooseFirstGoodResult(def json, String destName) {
		String res = "\nNo solution found :\nPlus de départs imminents ou cette ligne est un métro."
		json.departures.departure.each {
			if(!it.isEmpty()) {//Attention le dernier départure est {}  get impossible dessus
				//def t0 = it.destination.name
				String t1 = it.destination.get(0).name
				//def t2 = it.destination.get(0).getName()
				//def t3 = t1.equals(destName)
				//println "tests"
				
				if(t1.equals(destName)) {
					res = it.dateTime // on ne peut pas return dans une closure
					//println "TEST2"
				}
			}
		}
		return res
		//Pas de solutions
		//return "Erreur : No solution found"
	}

}
