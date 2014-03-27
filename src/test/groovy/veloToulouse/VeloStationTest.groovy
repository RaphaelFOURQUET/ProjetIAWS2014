/**
 * 
 */
package veloToulouse

import veloToulouse.VeloStation

/**
 * @author Raphaël
 *
 */
class VeloStationTest extends GroovyTestCase {
	
	VeloStation v = new VeloStation(
		number:1,
		name:"name",
		adress:"adress",
		status:"OPEN",
		availableBike:20,
		availableBikeStands:10
		)
	
	void testToString() {
		assertEquals("name",v.name)
		println v.toString()
		//println "NAME : "+v.name
	}
	
	void testStationOuverte() {
		assertTrue(v.stationOuverte())
	}
	
	void testVeloDisponible() {
		assertEquals(20,v.veloDisponible())
	}

}
