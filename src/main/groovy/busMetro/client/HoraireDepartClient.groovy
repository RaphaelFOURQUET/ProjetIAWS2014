/**
 * 
 */
package busMetro.client

import data.MyLogsData;
import groovyx.net.http.HTTPBuilder
import groovyx.net.http.Method

import static groovyx.net.http.ContentType.JSON

/**
 * @author Raphaël
 * Les données sont fournies par l'API Open Data Tisseo :
 *  licence ODbL (http://data.toulouse-metropole.fr/la-licence).
 */
class HoraireDepartClient {
	
	def getJsonDepart(String idArret, String idLine) {
		def res = null
		def http = new HTTPBuilder("http://pt.data.tisseo.fr/departureBoard?stopPointId=${idArret}&lineId=${idLine}&number=1&format=json&key=${MyLogsData.TISSEO_KEY}")
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
