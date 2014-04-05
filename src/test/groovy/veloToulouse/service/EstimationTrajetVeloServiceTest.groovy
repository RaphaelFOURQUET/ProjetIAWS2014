/**
 * 
 */
package veloToulouse.service

import data.Position;
import groovy.util.GroovyTestCase;

/**
 * @author Raphaël
 *
 */
class EstimationTrajetVeloServiceTest extends GroovyTestCase {
	
	EstimationTrajetVeloService etvs = new EstimationTrajetVeloService()
	
	void testToTime() {
		String r0 = etvs.toTime(20)
		assertEquals("20 seconde(s).", r0)
		
		String r1 = etvs.toTime(140)
		assertEquals("2 minute(s) 20 seconde(s).", r1)
		
		String r2 = etvs.toTime(3740)
		assertEquals("1 heure(s) 2 minute(s) 20 seconde(s).", r2)
	}
	
	void testParseString() {
		String r = "This is a test."
		String r1 = "This%20is%20a%20test."
		String r0 = etvs.parseString(r)
		assertEquals(r1, r0)
	}
	
	void testBicyclingTime() {
		String r = etvs.bicyclingTime("Toulouse%20118%20Rte%20de%20narbonne", "Toulouse%2014%20Grande%20Rue%20Saint%20michel")
		assertEquals("777", r)
		//https://maps.googleapis.com/maps/api/distancematrix/json?origins=Toulouse+118+Rte+de+narbonne&destinations=Toulouse+14+Grande+Rue+Saint+michel&mode=bicycling&language=fr-FR&sensor=false&key=AIzaSyD_2aZn-8VLOi7s26UBRzsvl4QkXVUeayE
		// 777 = resultat duration.value ... peut changer si nouvelles routes, algo de calcul... test à remettre a jour.
		// Si les conditions de circulation sont prises en compte ce test risque de souvent echouer ?
	}
	
	void testDistanceBeetween() {
		Position p0 = new Position(latitude:"2.35", longitude:"48.856")
		Position p1 = new Position(latitude:"3.063", longitude:"50.63")
		Double d = etvs.distanceBeetween(p0, p1)
		assertEquals(212.39065195499973, d, 0.1)
	}

}
