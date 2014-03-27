/**
 * 
 */
package veloToulouse.client

/**
 * @author Raphaël
 *
 */
class VeloStationClientTest extends GroovyTestCase {
	
	VeloStationClient v = new VeloStationClient()
	
	void testGetJsonVeloStation() {
		def json = v.getJsonVeloStation(227)
		assertNotNull(json)
	}

}
