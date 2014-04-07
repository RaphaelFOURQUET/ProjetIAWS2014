/**
 * 
 */
package data

/**
 * @author Raphaël
 * Contient des données nécessaires comme des codes d'accés, 
 * ou des ports de connexion.
 */
class MyLogsData {
	
	/**
	 * Clé Tisséo pour accéder à l'API.
	 */
	private static final String TISSEO_KEY = "a03561f2fd10641d96fb8188d209414d8"
	
	/**
	 * Clé JCDecaux pour accéder à l'API.
	 */
	private static final String VELO_KEY = "9882ff33d68063c700fd4764aca42067f4cb6b21"
	
	/**
	 * Emplacement(host) de couchdb.
	 */
	private static final String DB_HOST = "localhost"
	
	/**
	 * Port utilisé par couchdb.
	 */
	private static final int DB_PORT = 5984
	
	/**
	 * Nom de la BdD utilisée dans couchDB.
	 */
	private static final String DB_NAME = "iawsdb2014fr"
	
	/**
	 * Cle acces API GOOGLE utilisees.
	 */
	private static final String GOOGLE_KEY = "AIzaSyD_2aZn-8VLOi7s26UBRzsvl4QkXVUeayE"
	
	/**
	 * Un seul Constructeur privé pour empécher de creer des instances de MyLogsData.
	 */
	private MyLogsData() {}
	

}
