/**
 * 
 */
package busMetro

import com.fourspaces.couchdb.Document;

/**
 * @author Raphaël
 * Une ligne(bus ou métro) + des compteurs pour estimer sa popularité/fiabilité.
 */
class SocialLine extends Ligne {
	
	//Ligne line
	
	/**
	 * Compteur des 'Likes'.
	 */
	Integer cptLike = 0
	/**
	 * Compteur des 'Unlikes'.
	 */
	Integer cptUnlike = 0
	
	void like() {
		cptLike++
	}
	
	void unlike() {
		cptUnlike++
	}
	
	String toString() {
		String res = super.toString()+", $cptLike, $cptUnlike"
		res
	}

}
