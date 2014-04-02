/**
 * 
 */
package couchdb

/**
 * @author Raphaël
 *
 */
class FirstCouchDB4JTest extends GroovyTestCase {
	
	FirstCouchDB4J t = new FirstCouchDB4J()
	
	void testUsage() {
		t.usage()
		assertTrue(true)
	}

}
