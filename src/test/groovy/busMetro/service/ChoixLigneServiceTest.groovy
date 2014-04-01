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

}
