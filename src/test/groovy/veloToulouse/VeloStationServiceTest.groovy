/**
 * 
 */
package veloToulouse

/**
 * @author Raphaël
 *
 */
class VeloStationServiceTest extends GroovyTestCase {
	
	VeloStationService vs = new VeloStationService()
	
	void testGetVeloStationById() {
		VeloStation v = vs.getVeloStationById(227)
		assertEquals(v.name,"00227 - METRO UPS")
	}

}
