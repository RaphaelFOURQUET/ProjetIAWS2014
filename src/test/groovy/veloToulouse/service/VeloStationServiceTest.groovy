/**
 * 
 */
package veloToulouse.service

import veloToulouse.VeloStation;
import veloToulouse.service.VeloStationService;

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
	
	void testAllVeloStation() {
		def res = vs.allVeloStation()
		assertNotNull(res)
	}

}
