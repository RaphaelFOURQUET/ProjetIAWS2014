/**
 * 
 */
package busMetro

import com.fourspaces.couchdb.Document;

/**
 * @author Raphaël
 *
 */
class SocialLine extends Ligne {
	
	//Ligne line
	
	Integer cptLike = 0
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
