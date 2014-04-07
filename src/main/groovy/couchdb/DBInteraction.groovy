/**
 * 
 */
package couchdb

import busMetro.SocialLine;

import com.fourspaces.couchdb.Database;
import com.fourspaces.couchdb.Document;
import com.fourspaces.couchdb.Session;
import com.fourspaces.couchdb.ViewResults;

/**
 * @author Raphaël
 * interactions avec la BdD.
 */
class DBInteraction {
	
	/**
	 * Creer une session couchdb4j.
	 * @param host
	 * @param port
	 * @return Session.
	 */
	Session createSession(String host, int port) {
		Session session = new Session(host, port)
		return session
	}
	
	//Genere un warning quand on essaie de creer une db existante? faire autrement ?
	//Peut etre plutôt essayer de récupérer en premier -> erreur si get dbname inexistant...
	/**
	 * Creer ou recuperer une database couchdb.
	 * @param dbName Nom database.
	 * @param dbSession Session couchdb4j.
	 * @return Database au sens couchdb4j.
	 */
	Database createOrGetDatabase(String dbName, Session dbSession) {
		Database db = dbSession.createDatabase(dbName)
		/*Si db existe deja*/
		if(db==null)
			db = dbSession.getDatabase(dbName)
			
		return db
		
	}
	
	/*Work only if there is only ONE document in the DB ???*/
	/**
	 * Creer ou recuperer un document couchdb.
	 * @param db Database.
	 * @return Document au sens couchdb4j.
	 */
	Document createOrGetDocument(Database db) {
		Document res
		/*Fetching all Document to ViewResult object*/
		ViewResults couchViewResults = db.getAllDocuments();		 
		/*Retieving all document as result to a List*/
		List<Document> docList = couchViewResults.getResults();
		/*Si pas de documents*/
		if(docList.size()==0)
			res = new Document()
		else
			res = db.getDocument(docList.get(0).getString("id"))
		return res
	}
	
	boolean keyInDocument(Document d, String key) {
		return d.containsKey(key)
	}
	
	SocialLine getSocialLine(Document d, String key) {
		return d.get(key)
	}
	
	def putSocialLine(Document d, String key, SocialLine sl) {
		d.put(key, sl)
	}
	
	/**
	 * Met à jour le document dans la BdD.
	 * @param db Database
	 * @param d Document couchdb
	 * @return
	 */
	def saveDocument(Database db, Document d) {
		db.saveDocument(d)
	}

}
