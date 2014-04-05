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
 *  Requetes : Servira notamment pour le cas d'utilisation 1.
 */
class HoraireDepartClient {
	
	/**
	 * Recupere les informations de depart pour un arret, sur la ligne cible.
	 * @param idArret ID de l'arret cible.
	 * @param idLine ID de la ligne ciblee.
	 * @return JSON infos de depart..
	 */
	def getJsonDepart(String idArret, String idLine) {
		HTTPRequest.Request("http://pt.data.tisseo.fr/departureBoard?stopPointId=${idArret}&lineId=${idLine}&number=1&format=json&key=${MyLogsData.TISSEO_KEY}")
	}

}
