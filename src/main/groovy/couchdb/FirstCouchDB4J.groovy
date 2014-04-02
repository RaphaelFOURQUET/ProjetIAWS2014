package couchdb

import busMetro.SocialLine;

import com.fourspaces.couchdb.Database
import com.fourspaces.couchdb.Document
import com.fourspaces.couchdb.Session
import com.fourspaces.couchdb.ViewResults;


class FirstCouchDB4J {
	
	void usage() {
		
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
		
		Session s = new Session("localhost", 5984)
		Database db = s.getDatabase("linedb")
		
		
		Document doc = new Document()
		doc.put(ligne1.getLineId(),ligne1)
		doc.put(ligne2.getLineId(),ligne2)
		//db.saveDocument(doc) // auto-generated id given by the database
		
		/*Fetching all Document to ViewResult object*/
		ViewResults couchViewResults = db.getAllDocuments();
		 
		/*Retieving all document as result to a List*/
		List<Document> docList = couchViewResults.getResults();
		
		for (Document mydoc : docList) {
			
			String id = mydoc.getJSONObject().getString("id");
			println "TEST DB4J : ID = "+id
			//On recupere bien l'id du document doc créé plus haut
//			println "TEST DB4J : mydoc = "+mydoc
//			println "TEST DB4J : mydocJson = "+mydoc.getJSONObject()
//			println "TEST DB4J : mydocJsonStringValues = "+mydoc.getJSONObject().getString("value")
//			println "TEST DB4J : "+mydoc.values()
//			println "TEST DB4J : mydocJsonGet =  "+mydoc.getJSONObject().get("0001")
//			println "TEST DB4J : mydocJsonValues =  "+mydoc.getJSONObject().values()
//			println "TEST DB4J : mydocload = "+mydoc.load()
//			println "TEST DB4J : mydocget = "+mydoc.get(ligne1.getLineId())
//			println "TEST DB4J : mydoc = "+mydoc.get(ligne1.getLineId())
			println "TEST DB4J : DOCUMENT = "+db.getDocument(id)
			println "TEST DB4J : DOCUMENTJSON = "+db.getDocument(id).getJSONObject()
			println "TEST DB4J : DOCUMENTJSONTEST = "+db.getDocument(id).getJSONObject().get(ligne1.getLineId())
			SocialLine l = db.getDocument(id).getJSONObject().get(ligne1.getLineId())
			println " TEST DB4J : Line "+l
			
			
			
		}
		
	}
	

}
