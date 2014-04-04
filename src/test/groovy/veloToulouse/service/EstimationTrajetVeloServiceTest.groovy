/**
 * 
 */
package veloToulouse.service

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

}
