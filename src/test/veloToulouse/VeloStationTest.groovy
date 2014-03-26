package scolarite

import groovy.util.GroovyTestCase;

/**
 *
 * @author Raphael FOURQUET
 */
class VeloStationTest extends GroovyTestCase {
	
	void testToString() {
		VeloStation v = new VeloStation(1,"name","adress","status",20,10)
		println v.toString()
	}



}
