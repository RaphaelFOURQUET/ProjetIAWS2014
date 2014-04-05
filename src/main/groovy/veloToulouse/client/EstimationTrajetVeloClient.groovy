/**
 * 
 */
package veloToulouse.client

import httprequest.HTTPRequest;
import data.MyLogsData;

/**
 * @author Raphaël
 * Utilisation de diverses API GOOGLE MAP pour le cas d'utilisation 3.
 * Notamment les API : Geocoding et DistanceMatrix.
 */
class EstimationTrajetVeloClient {
	
	def toJSONPosition(String adresse) {
		HTTPRequest.Request("https://maps.googleapis.com/maps/api/geocode/json?address=${adresse}&sensor=false&key=${MyLogsData.GOOGLE_KEY}")
	}
	
	def walkingJSONTime(String a1,String adresse) {
		HTTPRequest.Request("https://maps.googleapis.com/maps/api/distancematrix/json?origins=${a1}&destinations=${adresse}&mode=walking&language=fr-FR&sensor=false&key=${MyLogsData.GOOGLE_KEY}")
	}
	
	def bicyclingJSONTime(String a1, String a2) {
		HTTPRequest.Request("https://maps.googleapis.com/maps/api/distancematrix/json?origins=${a1}&destinations=${a2}&mode=bicycling&language=fr-FR&sensor=false&key=${MyLogsData.GOOGLE_KEY}")
	}

}
