/**
 * 
 */
package veloToulouse

/**
 * @author Raphaël
 *
 */
class VeloStation {
	
	//contractName = "Toulouse"
	Integer number
	String name
	String adress
	//Position position
	String status
	Integer availableBike
	Integer availableBikeStands
	
	
	String toString() {
		def res = "$number $name $adress $status\n"
		res
	  }

}
