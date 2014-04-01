package couchdb

import groovy.util.GroovyTestCase;

class FirstJcouchDBTest extends GroovyTestCase {
	
	FirstJcouchDB jcouchdb = new FirstJcouchDB()
	
	void testPremiertest() {
		jcouchdb.premierTest()
		assertTrue(true)//TODO
	}

}
