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
				 adress:json.adress,
				 status:json.status,
				 availableBike:json.availableBike,
				 availableBikeStands:json.availableBikeStands
		  )
		}
		v
	  }
	
	def veloDisponibleById(Integer id) {
		VeloStation v = getVeloStationById(id)
		return v.veloDisponible()
	}
	

}
