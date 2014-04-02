/**
 * 
 */
package busMetro.service

import java.util.ArrayList;

import busMetro.ArretPhysique;
import busMetro.Destination
import busMetro.Ligne;
import busMetro.LineDestArret;
import busMetro.ZoneArret
import busMetro.client.ChoixLigneClient

/**
 * @author Raphaël
 *
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
	 * @return
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
	
	boolean isMetroLine(String lineId) {
		def json = choixLigneClient.getJsonLine(lineId)
		if(json) {
			return ( (json.lines.line.transportMode.name.get(0)).equals("métro") )
		}
	}
	

}
