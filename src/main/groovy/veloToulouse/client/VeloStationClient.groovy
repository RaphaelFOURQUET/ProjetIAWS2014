/**
 * API JCDecaux utilisée pour les informations sur le reseau VeloToulouse
 * https://developer.jcdecaux.com/#/home
 */
package veloToulouse.client

import groovyx.net.http.HTTPBuilder
import groovyx.net.http.Method
import veloToulouse.VeloStation

import static groovyx.net.http.ContentType.JSON

/**
 * @author Raphaël
 *
 */
class VeloStationClient {
	
	def getJsonVeloStation(Integer id) {
		def res = null
		def http = new HTTPBuilder("https://api.jcdecaux.com/vls/v1/stations/${id}?contract=Toulouse&apiKey=9882ff33d68063c700fd4764aca42067f4cb6b21")
		http.request(Method.GET, JSON) {
		  //uri.path = 
		  response.success = {
			resp, json -> res = json
		  }
		  // handler for any failure status code:
		  response.failure = { resp ->
			println "Unexpected error: ${resp.statusLine.statusCode} : ${resp.statusLine.reasonPhrase}"
		  }
		}
		res
	}
	
	def getAllJsonVeloStation() {
		def res = null
		def http = new HTTPBuilder("https://api.jcdecaux.com/vls/v1/stations?contract=Toulouse&apiKey=9882ff33d68063c700fd4764aca42067f4cb6b21")
		http.request(Method.GET, JSON) {
		  //uri.path =
		  response.success = {
			resp, json -> res = json
		  }
		  // handler for any failure status code:
		  response.failure = { resp ->
			println "Unexpected error: ${resp.statusLine.statusCode} : ${resp.statusLine.reasonPhrase}"
		  }
		}
		res
	}

}
