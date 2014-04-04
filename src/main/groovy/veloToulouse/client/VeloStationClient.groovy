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
//		def res = null
//		def http = new HTTPBuilder("https://api.jcdecaux.com/vls/v1/stations/${id}?contract=Toulouse&apiKey=${MyLogsData.VELO_KEY}")
//		http.request(Method.GET, JSON) {
//		  //uri.path = 
//		  response.success = {
//			resp, json -> res = json
//		  }
//		  // handler for any failure status code:
//		  response.failure = { resp ->
//			println "Unexpected error: ${resp.statusLine.statusCode} : ${resp.statusLine.reasonPhrase}"
//		  }
//		}
//		res
		HTTPRequest.Request("https://api.jcdecaux.com/vls/v1/stations/${id}?contract=Toulouse&apiKey=${MyLogsData.VELO_KEY}")
	}
	
	/**
	 * Recupere toutes les stations veloToulouse au format JSON.
	 * @return JSON veloStations.
	 */
	def getAllJsonVeloStation() {
//		def res = null
//		def http = new HTTPBuilder("https://api.jcdecaux.com/vls/v1/stations?contract=Toulouse&apiKey=9882ff33d68063c700fd4764aca42067f4cb6b21")
//		http.request(Method.GET, JSON) {
//		  //uri.path =
//		  response.success = {
//			resp, json -> res = json
//		  }
//		  // handler for any failure status code:
//		  response.failure = { resp ->
//			println "Unexpected error: ${resp.statusLine.statusCode} : ${resp.statusLine.reasonPhrase}"
//		  }
//		}
//		res
		HTTPRequest.Request("https://api.jcdecaux.com/vls/v1/stations?contract=Toulouse&apiKey=${MyLogsData.VELO_KEY}")
	}

}
