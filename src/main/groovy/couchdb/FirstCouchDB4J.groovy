package couchdb

import java.util.Iterator;

import busMetro.SocialLine;

import com.fourspaces.couchdb.Database
import com.fourspaces.couchdb.Document
import com.fourspaces.couchdb.Session
import com.fourspaces.couchdb.ViewResults;

/**
 * @author Raphaël
 * Mes premiers tests (laborieux) sur couchDB4J, classe d'entrainement non necessaire
 * au fonctionnement de l'application.
 *
 */
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
		
//		for (Document mydoc : docList) {
//				
//			def test0 = mydoc
//			String id = mydoc.getJSONObject().getString("id");
//			String id2 = mydoc.getString("id");
//			println "TEST DB4J : ID = "+id
//			//On recupere bien l'id du document doc créé plus haut
////			println "TEST DB4J : mydoc = "+mydoc
////			println "TEST DB4J : mydocJson = "+mydoc.getJSONObject()
////			println "TEST DB4J : mydocJsonStringValues = "+mydoc.getJSONObject().getString("value")
////			println "TEST DB4J : "+mydoc.values()
////			println "TEST DB4J : mydocJsonGet =  "+mydoc.getJSONObject().get("0001")
////			println "TEST DB4J : mydocJsonValues =  "+mydoc.getJSONObject().values()
////			println "TEST DB4J : mydocload = "+mydoc.load()
////			println "TEST DB4J : mydocget = "+mydoc.get(ligne1.getLineId())
////			println "TEST DB4J : mydoc = "+mydoc.get(ligne1.getLineId())
//			def d = db.getDocument(id)
//			println "TEST DB4J : DOCUMENT = "+db.getDocument(id)
//			println "TEST DB4J : DOCUMENTJSON = "+db.getDocument(id).getJSONObject()
//			println "TEST DB4J : DOCUMENTJSONTEST = "+db.getDocument(id).getJSONObject().get(ligne1.getLineId())
//			println "TEST DB4J : DOCUMENTTEST = "+d.get(ligne1.getLineId())
//			SocialLine l = d.get(ligne1.getLineId())
//			println " TEST DB4J : Line "+l
//			
//			
//			l.like()
//			println "Line : "+l
//			
//			def t2 = d.containsKey(l.getLineId())
//			d.put(l.getLineId(),l)
//			def t0 = d.entrySet()
//			def t1 = d.keys
//			println "TEST"
//			t0.size()
//			
//			db.saveDocument(d)
//			//le doc dans la db a 1 like de plus.
//			
//			//test boucle
////			for(int i=2;i<d.entrySet().size();i++) {
////				d.entry
////			}
////			
//		}
		
		Document document = db.getDocument(docList.get(0).getString("id"))
		if(document.containsKey(ligne1.getLineId())) {
			println "TESTOK"
		}
		
		
		
	}
	

}
