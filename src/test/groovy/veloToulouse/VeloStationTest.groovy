/**
 * 
 */
package veloToulouse

import veloToulouse.VeloStation

/**
 * @author Raphaël
 *
 */
class VeloStationTest {
	
	void testToString() {
		VeloStation v = new VeloStation(
			number:1,
			name:"name",
			adress:"adress",
			status:"status",
			availableBike:20,
			availableBikeStands:10)
		assertEquals("status",v.status)
		println v.toString()
		//println "NAME : "+v.name
	}

}
