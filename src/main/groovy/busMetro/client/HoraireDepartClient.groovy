/**
 * 
 */
package busMetro.client

import groovyx.net.http.HTTPBuilder
import groovyx.net.http.Method

import static groovyx.net.http.ContentType.JSON

/**
 * @author Raphaël
 *
 */
class HoraireDepartClient {
	
	def getJsonDepart(String idArret, String idLine) {
		def res = null
		def http = new HTTPBuilder("http://pt.data.tisseo.fr/departureBoard?stopPointId=${idArret}&lineId=${idLine}&number=1&format=json&key=a03561f2fd10641d96fb8188d209414d8")
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
