/**
 * 
 */
package veloToulouse

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
	 * 
	 * @param id integer représentant la station
	 * @return nombre de velo disponibles ou -1 si erreur
	 */
	def veloDisponibleById(Integer id) {
		VeloStation v = getVeloStationById(id)
		return v.veloDisponible()
	}
	

}
