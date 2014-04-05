/**
 * 
 */
package busMetro.client

import static groovyx.net.http.ContentType.JSON
import httprequest.HTTPRequest
import data.MyLogsData

/**
 * @author Raphaël
 * Les données sont fournies par l'API Open Data Tisseo :
 *  licence ODbL (http://data.toulouse-metropole.fr/la-licence).
 *  Requetes : Servira pour les cas d'utilisation 1 et 2 notamment.
 */
class ChoixLigneClient {
	
	/**
	 * Renvoie les stopPoints corresponant à un stopArea.
	 * @param id Id du StopArea ciblé.
	 * @return JSON StopPointList.
	 */
	def getJsonLigneDest(String id) {
		HTTPRequest.Request("http://pt.data.tisseo.fr/stopPointsList?stopAreaId=${id}&displayDestinations=1&displayLines=1&format=json&key=${MyLogsData.TISSEO_KEY}")
	}
	
	/**
	 * Renvoie les infos sur la ligne voulue.
	 * @param id Id de la ligne ciblée.
	 * @return JSON Line.
	 */
	def getJsonLine(String id) {
		HTTPRequest.Request("http://pt.data.tisseo.fr/linesList?lineId=${id}&network=Tisséo&format=json&key=${MyLogsData.TISSEO_KEY}")
	}
	
	/**
	 * Recupere toutes les lignes.
	 * @return JSON Lines.
	 */
	def getAllJsonLines() {
		HTTPRequest.Request("http://pt.data.tisseo.fr/linesList?format=json&key=${MyLogsData.TISSEO_KEY}")
	}

}
