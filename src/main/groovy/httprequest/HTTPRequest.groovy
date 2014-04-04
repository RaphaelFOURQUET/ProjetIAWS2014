/**
 * 
 */
package httprequest

import groovyx.net.http.HTTPBuilder
import groovyx.net.http.Method

import static groovyx.net.http.ContentType.JSON

/**
 * @author Raphaël
 *
 */
class HTTPRequest {
	
	static def Request(String request) {
		def res = null
		def http = new HTTPBuilder(request)
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
