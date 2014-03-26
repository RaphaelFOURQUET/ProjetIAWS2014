package scolarite

/**
 *
 * @author Raphael FOURQUET
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
		def res = "$number $name $adress\n"
		res
	  }

}
