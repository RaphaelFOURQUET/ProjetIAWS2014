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
	
	def walkingJSONTime(String aStation,String adresse) {
		HTTPRequest.Request("https://maps.googleapis.com/maps/api/distancematrix/json?origins=${aStation}&destinations=${adresse}&mode=walking&language=fr-FR&sensor=false&key=${MyLogsData.GOOGLE_KEY}")
	}
	
	def bicyclingJSONTime(String adresseUPS, String adresseStation) {
		HTTPRequest.Request("https://maps.googleapis.com/maps/api/distancematrix/json?origins=${adresseUPS}&destinations=${adresseStation}&mode=bicycling&language=fr-FR&sensor=false&key=${MyLogsData.GOOGLE_KEY}")
	}

}
