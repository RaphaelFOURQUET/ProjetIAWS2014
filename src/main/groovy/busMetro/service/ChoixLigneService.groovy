/**
 * 
 */
package busMetro.service

import java.awt.geom.LineIterator;
import java.util.ArrayList;

import com.fourspaces.couchdb.Database;
import com.fourspaces.couchdb.Document;
import com.fourspaces.couchdb.Session
import couchdb.DBInteraction;
import data.MyLogsData;

import busMetro.ArretPhysique;
import busMetro.Destination
import busMetro.Ligne;
import busMetro.LineDestArret;
import busMetro.SocialLine;
import busMetro.ZoneArret
import busMetro.client.ChoixLigneClient

/**
 * @author Raphaël
 * Service : Servira pour les cas d'utilisation 1 et 2 notamment.
 */
class ChoixLigneService {
	
	/*Les 6 Zones d'arrets intéressantes à retenir*/
	ZoneArret champMagnetiqueArret = new ZoneArret(
		arretId:"1970324837648738",
		arretName:"Champs Magnétiques")
	
	ZoneArret pharmaArret= new ZoneArret(
		arretId:"1970324837185357",
		arretName:"Faculté de Pharmacie")
	
	ZoneArret giordanoArret = new ZoneArret(
		arretId:"1970329131942066",
		arretName:"Giordano Bruno")
	
	ZoneArret naturopoleArret = new ZoneArret(
		arretId:"1970329131942064",
		arretName:"Naturopole")
	
	ZoneArret sportUArret = new ZoneArret(
		arretId:"1970329131942065",
		arretName:"Sports Universitaires")
	
	ZoneArret upsArret = new ZoneArret(
		arretId:"1970324837185012",
		arretName:"Université Paul Sabatier")
	
	def zoneArretList = [champMagnetiqueArret, pharmaArret, giordanoArret, naturopoleArret, sportUArret, upsArret]
	
	ChoixLigneClient choixLigneClient = new ChoixLigneClient()
	
	/**
	 * Recupere la requete json contenant lignes et destinations pour l'université 
	 * et cree la liste des arrets physiques.
	 * @return liste des arrets physiques compatibles.
	 */
	def getLigneDestUniversite() {
		def lineChoiceTable = []
		def arretPhysiqueList = []
		zoneArretList.each {
			def t0 = it.arretId
			def jsonZoneArret = choixLigneClient.getJsonLigneDest(it.arretId)
			jsonZoneArret.physicalStops.physicalStop.each {
				ArretPhysique arretPhysique = new ArretPhysique(
					arretPId:it.id,
					arretPName:it.name,
					destinationList:it.destinations)
				arretPhysiqueList += arretPhysique
			}
		}
		lineChoiceTable = toTable(arretPhysiqueList)
	}
	
	/**
	 * Transforme la liste des arrets physiques en collection
	 * utilisable par une jTable.
	 * @param arretPList liste des arrets physiques.
	 * @return ArrayList des LineDestArret.
	 */
	ArrayList<LineDestArret> toTable(def arretPList) {
		ArrayList<LineDestArret> res = new ArrayList<LineDestArret>()
		String currentArretId
		String currentArretName
		String currentDestid
		String currentDestname
		String currentLineId
		String currentlineName
		String currentShortName
		
		arretPList.each {
			currentArretId = it.arretPId
			currentArretName = it.arretPName
			it.destinationList.each {
				currentDestid = it.id
				currentDestname = it.name
				it.line.each {
					currentLineId = it.id
					currentlineName = it.name
					currentShortName = it.shortName
					res += new LineDestArret(
						currentArretId,
						currentArretName,
						new Destination(
							destinationId:currentDestid,
							destinationName:currentDestname),
						new Ligne(
							lineId:currentLineId,
							lineName:currentlineName,
							shortName:currentShortName )
						)
				}
			}
		}
		//println "Table : "+res
		res
	}
	
	/**
	 * Verifie si la ligne est une ligne de metro ou pas.
	 * @param lineId ID de la ligne ciblee.
	 * @return boolean est une ligne de metro ?
	 */
	boolean isMetroLine(String lineId) {
		def json = choixLigneClient.getJsonLine(lineId)
		if(json) {
			return ( (json.lines.line.transportMode.name.get(0)).equals("métro") )
		}
	}
	
	/**
	 * Recuperer les SocialLine en DB ou en creer de nouvelles si
	 *  pas en DB.
	 * @return Liste des SocialLine.
	 */
	ArrayList<SocialLine> getAllSocialLines() {
		ArrayList<SocialLine> res = new ArrayList<SocialLine>()
		SocialLine currentSocialLine
		
		/*Paraméter la db pour récuperer les données si elles existent*/
		DBInteraction dbi = new DBInteraction()
		Session s = dbi.createSession(MyLogsData.DB_HOST, MyLogsData.DB_PORT)
		Database db = dbi.createOrGetDatabase(MyLogsData.DB_NAME, s)
		Document d = dbi.createOrGetDocument(db)
		
		def json = choixLigneClient.getAllJsonLines()
		if(json) {
			json.lines.line.each {
				if(dbi.keyInDocument(d, it.id)) {
					/*Recuperer depuis DB et mettre en liste*/
					currentSocialLine = dbi.getSocialLine(d, it.id)
					res+=currentSocialLine
				} else { /*mettre en DB et en liste*/
					currentSocialLine = new SocialLine(
						lineId:it.id,
						lineName:it.name,
						shortName:it.shortName)
					dbi.putSocialLine(d, it.id, currentSocialLine)
					res+=currentSocialLine
				}
				 
			}
		}
		//mettre à jour DB ?
		dbi.saveDocument(db, d)
		return res
	}
	
	/**
	 * Ajoute un like a une SocialLine, et met à jour la BdD.
	 * @param sl SocialLine ciblee.
	 */
	void majLike(SocialLine sl) {
		sl.like()
		
		DBInteraction dbi = new DBInteraction()
		Session s = dbi.createSession(MyLogsData.DB_HOST, MyLogsData.DB_PORT)
		Database db = dbi.createOrGetDatabase(MyLogsData.DB_NAME, s)
		Document d = dbi.createOrGetDocument(db)
		
		dbi.putSocialLine(d, sl.lineId, sl)
		dbi.saveDocument(db, d)
	}
	
	/**
	 * Ajoute un unlike a une SocialLine, et met à jour la BdD.
	 * @param sl SocialLine ciblee
	 */
	void majUnlike(SocialLine sl) {
		sl.unlike()
		
		DBInteraction dbi = new DBInteraction()
		Session s = dbi.createSession(MyLogsData.DB_HOST, MyLogsData.DB_PORT)
		Database db = dbi.createOrGetDatabase(MyLogsData.DB_NAME, s)
		Document d = dbi.createOrGetDocument(db)
		
		dbi.putSocialLine(d, sl.lineId, sl)
		dbi.saveDocument(db, d)
	}
	
	

}
