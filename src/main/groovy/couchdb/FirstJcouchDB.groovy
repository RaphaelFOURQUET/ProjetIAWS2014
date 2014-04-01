/**
 * 
 */
package couchdb

import org.jcouchdb.db.Database;

/**
 * @author Raphaël
 *
 */
class FirstJcouchDB {
	
	void premierTest() {
		
		// create a database object pointing to the database "mycouchdb" on the local host
		// database must have been created !
		Database db = new Database("localhost", "myfirstdb")
	
		// create a hash map document with two fields
		Map<String,String> doc = new HashMap<String, String>()
		doc.put("foo", "value for the foo attribute")
		doc.put("bar", "value for the bar attribute")
	
		// create the document in couchdb
		//db.createOrUpdateDocument(doc)
		
		//retrouver l'id ?
		def id = db.listDocuments(null, null)
		println "ID : "+id
		
		Map<String,String> retour = db.findDocument(Map.class , "2286dac993403bec4d91d93114003d20", null)
		println "RETOUR : "+retour
	}
	
	
	

}
