/**
 * 
 */
package veloToulouse.service

import veloToulouse.StaticVeloStation;
import veloToulouse.client.EstimationTrajetVeloClient;
import data.Position;

/**
 * @author Raphaël
 * Utilisation de diverses API GOOGLE MAP pour le cas d'utilisation 3.
 * Notamment les API : Geocoding et DistanceMatrix.
 *
 */
class EstimationTrajetVeloService {
	
	EstimationTrajetVeloClient etvc = new EstimationTrajetVeloClient()
	
	/**
	 * Calcule le temps de trajet velo depuis ups jusqu'a l'adresse donnee.
	 * @param adresse destination voulue.
	 * @return String temps de trajet.
	 */
	String calculDureeTrajet(String adresse) {
		String res
		//adresse UPS : peut etre mettre ces chiffres dans MylogsData?
		//Position pUPS = new Position(latitude:"43.561566", longitude:"1.462757")
		String adresseUPS = "Toulouse 118 Rte de narbonne"
		
		//Transformer l'adresse en Position : Geocoding.
		Position pos = toPosition(parseString(adresse))
		
		//Chercher la station velo la plus proche
		StaticVeloStation vsProche = nearestVeloStation(pos)
		String adressStation = vsProche.getAdress()
		
		//calculer temps à pied Station-adresse : distanceMatrix
		String r1 = walkingTime(parseString(adressStation), parseString(adresse))
		
		//calculer temps a velo UPS-Station : distanceMatrix
		String r2 = bicyclingTime(parseString(adresseUPS), parseString(adressStation))
		
		//Aditionner les deux temps r1 et r2.
		Integer r = Integer.parseInt(r1)+Integer.parseInt(r2)
		res = toTime(r)
		
		res
	}
	
	Position toPosition(String adresse) {
		Position p
		def json = etvc.toJSONPosition(adresse)
		if(json) {
			p = new Position(latitude:json.results.geometry.location.lat, 
				longitude:json.results.geometry.location.lng)
		}
		p
	}
	
	String walkingTime(String aStation, String adresse) {
		String res
		def json = etvc.walkingJSONTime(aStation, adresse)
		if(json) {
			res = json.rows[0].elements[0].duration.value
		}
		res
	}
	
	String bicyclingTime(String adresseUPS, String adresseStation) {
		String res
		def json = etvc.bicyclingJSONTime(adresseUPS, adresseStation)
		if(json) {
			res = json.rows[0].elements[0].duration.value
		}
		res
	}
	
	String toTime(Integer r) {
		Integer heures = 0
		Integer minutes = 0
		Integer secondes = 0
		for(r; r>=3600; r=r-3600) {
			heures++
		}
		for(r; r>=60; r=r-60) {
			minutes++
		}
		secondes = r
		String res = ""
		if(heures>0) res+= heures+" heure(s) "
		if(minutes>0) res+= minutes+" minute(s) "
		res+= secondes+" seconde(s)."
	}
	
	/**
	 * Transfrome les espaces en %20.
	 * @param s String input.
	 * @return String outpur = input transforme.
	 */
	String parseString(String s) {
		String res = ""
		for(int i=0;i<s.size();i++) {
			if(s.charAt(i).equals(" ".charAt(0))) {
				res += "%20"
			}
			else res += s.charAt(i)
		}
		res
	}

}
