/**
 * 
 */
package veloToulouse

import java.util.ArrayList;

import busMetro.LineDestArret;
import veloToulouse.client.VeloStationClient

/**
 * @author Raphaël
 *
 */
class VeloStationService {
	
	VeloStationClient veloStationClient = new VeloStationClient()
	
	VeloStation getVeloStationById(Integer id) {
		VeloStation v = null
		def json = veloStationClient.getJsonVeloStation(id)
		if (json) {
		  v = new VeloStation(
				 number:json.number,
				 name:json.name,
				 adress:json.address,
				 status:json.status,
				 availableBike:json.available_bikes,
				 availableBikeStands:json.available_bike_stands
		  )
		}
		else {
			println "Erreur : impossible de récupérer la station demandée."
		}
		v
	  }
	
	/**
	 * Retourne le nombre de velo disponible à
	 * partir de l'id station.
	 * @param id integer représentant la station
	 * @return nombre de velo disponibles ou -1 si erreur
	 */
	def veloDisponibleById(Integer id) {
		VeloStation v = getVeloStationById(id)
		return v.veloDisponible()
	}
	
	/**
	 * Retourne toutes les stations veloTOULOUSE
	 * @return ArrayList<StaticVeloStation> liste de toutes les statios veloToulouse.
	 */
	def allVeloStation() {
		ArrayList<StaticVeloStation> veloStationList = new ArrayList<StaticVeloStation>()
		def json = veloStationClient.getAllJsonVeloStation()
		if (json) {
			json.each {
				veloStationList.add(new StaticVeloStation(
					number:it.number,
					name:it.name,
					adress:it.address))
			}
		}
		else {
			println "Erreur : La requete a échoué."
		}
		veloStationList
	}
	

}
