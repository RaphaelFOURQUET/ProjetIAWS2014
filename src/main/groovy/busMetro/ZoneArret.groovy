/**
 * 
 */
package busMetro

/**
 * @author Raphaël
 * StopArea Tisseo.
 */
class ZoneArret {
	
	String arretId
	String arretName

	
	
	
	public static void main(String[] args) {
		
		/*Les 6 Zones d'arrets intéressantes à proposer à l'utilisateur*/
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
		
		def zoneArretlist = [champMagnetiqueArret, pharmaArret, giordanoArret, naturopoleArret, sportUArret, upsArret]
		
		
	}
	
}
