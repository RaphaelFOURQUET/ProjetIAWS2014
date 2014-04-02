/**
 * 
 */
package busMetro.service

/**
 * @author Raphaël
 *
 */
class ChoixLigneServiceTest extends GroovyTestCase {
	
	ChoixLigneService choixLigneService = new ChoixLigneService()
	
	void testGetLigneDestUniversite() {
		def res = null
		res = choixLigneService.getLigneDestUniversite()
		assertNotNull(res)
		
	}
	
	//peut echouer si l id de la ligne metro A change un jour.
	void testIsMetroLine() {
		def res = null
		res = choixLigneService.isMetroLine("11821949021891694")
		assertTrue(res)
	}

}
