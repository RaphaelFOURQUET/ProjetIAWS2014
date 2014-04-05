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
	VeloStationService vsv = new VeloStationService()
	
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
		Position pos = toPosition(adresse)
		
		//Chercher la station velo la plus proche
		StaticVeloStation vsProche = nearestVeloStation(pos)
		String adressStation = vsProche.getAdress()
		
		//calculer temps à pied Station-adresse : distanceMatrix
		String r1 = walkingTime(adressStation, adresse)
		
		//calculer temps a velo UPS-Station : distanceMatrix
		String r2 = bicyclingTime(adresseUPS, adressStation)
		
		//Aditionner les deux temps r1 et r2.
		Integer r = Integer.parseInt(r1)+Integer.parseInt(r2)
		res = toTime(r)
		
		res
	}
	
	Position toPosition(String adresse) {
		Position p
		def json = etvc.toJSONPosition(parseString(adresse))
		if(json) {
//			def t0 = json.results.geometry.location.lat
//			def t1 = json.results.geometry.location.lat[0]
			p = new Position(latitude:json.results.geometry.location.lat[0], 
				longitude:json.results.geometry.location.lng[0])
		}
		p
	}
	
	String walkingTime(String aStation, String adresse) {
		String res
		def json = etvc.walkingJSONTime(parseString(aStation), parseString(adresse))
		if(json) {
			res = json.rows[0].elements[0].duration.value
		}
		res
	}
	
	String bicyclingTime(String adresseUPS, String adresseStation) {
		String res
		def json = etvc.bicyclingJSONTime(parseString(adresseUPS), parseString(adresseStation))
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
	 * Transforme les espaces en %20.
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
	
	StaticVeloStation nearestVeloStation(Position pos) {
		//recuperer toutes les stations.
		ArrayList<StaticVeloStation> stationList = vsv.allVeloStation()
		//initialiser la distance + la currentstation avec 1ere station
		StaticVeloStation currentSVS = stationList.get(0)
		Double distanceMin = distanceBeetween(pos, currentSVS.getPosition())
		
		Double currentD
		//boucle pour les autres stations
		for (StaticVeloStation svsB : stationList) {
			currentD = distanceBeetween(pos, svsB.getPosition())
			if(currentD < distanceMin) {
				distanceMin = currentD
				currentSVS = svsB
			}
		}
		//retourner la current station
		currentSVS
	}
	
	Double distanceBeetween(Position pos, Position pos1) {
		Double res
		Double rayon = 6371
		
		//Avec tous les lat lng en radians.
		def t = Double.parseDouble(pos.getLatitude())
		Double latpos = toRadian(Double.parseDouble(pos.getLatitude()))
		Double lngpos = toRadian(Double.parseDouble(pos.getLongitude()))
		Double latpos1 = toRadian(Double.parseDouble(pos1.getLatitude()))
		Double lngpos1 = toRadian(Double.parseDouble(pos1.getLongitude()))
		
		//rayon*ACos( Sin(latpos)Sin(latpos1)+Cos(latpos)Cos(latpos1)Cos(lngpos1-lngpos) )
		def t0 = Math.sin(latpos)
		def t1 = Math.cos(latpos)
		def t2 = Math.cos(lngpos1-lngpos)
		def t3 = Math.acos(0.5)
		
		def t4 = Math.sin(latpos)*Math.sin(latpos1)
		def t5 = Math.cos(latpos)*Math.cos(latpos1)*Math.cos(lngpos1-lngpos)
		def t6 = Math.sin(latpos)*Math.sin(latpos1) + Math.cos(latpos)*Math.cos(latpos1)*Math.cos(lngpos1-lngpos)
		def t7 = Math.acos( Math.sin(latpos)*Math.sin(latpos1) + Math.cos(latpos)*Math.cos(latpos1)*Math.cos(lngpos1-lngpos) )
		
		res = rayon * Math.acos( Math.sin(latpos)*Math.sin(latpos1) + Math.cos(latpos)*Math.cos(latpos1)*Math.cos(lngpos1-lngpos) )
		
		res
	}
	
	Double toRadian(Double d) {
		//d divise par (360/2*pi)
		def t0 = 360/(2*Math.PI)
		Double res = d/(360/(2*Math.PI))
	}

}
