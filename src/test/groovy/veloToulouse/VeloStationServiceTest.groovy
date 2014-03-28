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
	
	void testVeloDisponibleById() {
		def res = vs.veloDisponibleById(227)
		println "velo disponible station 227 : "+res
		assertTrue(res>=-1)
	}

}
