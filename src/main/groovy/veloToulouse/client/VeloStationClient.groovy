/**
 * API JCDecaux utilisée pour les informations sur le reseau VeloToulouse
 * https://developer.jcdecaux.com/#/home
 */
package veloToulouse.client

import static groovyx.net.http.ContentType.JSON
import httprequest.HTTPRequest
import data.MyLogsData

/**
 * @author Raphaël
 * Requetes : Servira pour les cas d'utilisation 3 et 4 notamment.
 */
class VeloStationClient {
	
	/**
	 * Recupere les informations d'une station veloTOULOUSE.
	 * @param id ID station ciblee.
	 * @return JSON veloStation.
	 */
	def getJsonVeloStation(Integer id) {
		HTTPRequest.Request("https://api.jcdecaux.com/vls/v1/stations/${id}?contract=Toulouse&apiKey=${MyLogsData.VELO_KEY}")
	}
	
	/**
	 * Recupere toutes les stations veloToulouse au format JSON.
	 * @return JSON veloStations.
	 */
	def getAllJsonVeloStation() {
		HTTPRequest.Request("https://api.jcdecaux.com/vls/v1/stations?contract=Toulouse&apiKey=${MyLogsData.VELO_KEY}")
	}

}
