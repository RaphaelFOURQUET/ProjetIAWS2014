/**
 * 
 */
package couchdb

import org.jcouchdb.db.Database;
import org.jcouchdb.document.BaseDocument;

import busMetro.SocialLine;

/**
 * @author Raphaël
 *
 */
class FirstJcouchDB {
	
	void usage() {
		
//		// create a database object pointing to the database "mycouchdb" on the local host
//		// database must have been created !
//		Database db = new Database("localhost", "linedb")
//	
//		// create a hash map document with two fields
//		Map<String,String> doc = new HashMap<String, String>()
//		doc.put("foo", "value for the foo attribute")
//		doc.put("bar", "value for the bar attribute")
//	
//		// create the document in couchdb
//		//db.createOrUpdateDocument(doc)
//		
//		//retrouver l'id ?
//		def id = db.listDocuments(null, null)
//		println "ID : "+id
//		
//		Map<String,String> retour = db.findDocument(Map.class , "2286dac993403bec4d91d93114003d20", null)
//		println "RETOUR : "+retour
		
		SocialLine ligne1 = new SocialLine()
		ligne1.setLineId("0001")
		ligne1.setLineName("ligne 1")
		ligne1.setShortName("1")
		
		SocialLine ligne2 = new SocialLine()
		ligne2.setLineId("0002")
		ligne2.setLineName("ligne 2")
		ligne2.setShortName("2")
		
		ArrayList<SocialLine> lineList = new ArrayList<SocialLine>()
		lineList.add(ligne1)
		lineList.add(ligne2)
		
		Database db = new Database("localhost", "linedb")
		
		
		//BaseDocument doc = new BaseDocument()
		Map<String,SocialLine> doc = new HashMap<String, SocialLine>()
		doc.put(ligne1.getLineId(),ligne1)
		doc.put(ligne2.getLineId(),ligne2)
		//createDocument ne marche pas dans ce cas ? pk ?
		//db.createDocument(doc)
	}
	
	
	

}
