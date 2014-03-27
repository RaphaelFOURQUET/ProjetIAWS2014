/**
 * 
 */
package veloToulouse

/**
 * @author Raphaël
 *
 */
class StaticVeloStation {
	
	//contractName = "Toulouse"
	Integer number
	String name
	String adress
	//Position position
	
	String toString() {
		def res = "$number $name $adress\n"
		res
	  }
	
	public static void main(String[] args) {
		
		/*Les 4 stations de velo intéressantes à proposer à l'utilisateur*/
		
		StaticVeloStation upsVeloStation = new StaticVeloStation(
			number:227,
			name:"00227 - METRO UPS",
			adress:"118  RTE DE NARBONNE"
			)
		
		StaticVeloStation rangueilVeloStation = new StaticVeloStation(
			number:231,
			name:"00231 - NARBONNE MARFAING",
			adress:"RANGUEIL / CL ROCHE"
			)
		
		StaticVeloStation pharmaVeloStation = new StaticVeloStation(
			number:228,
			name:"00228 - METRO PHARMACIE",
			adress:"FACE 35 CHEMIN DES MARAICHERS"
			)
		
		StaticVeloStation tripodeBVeloStation = new StaticVeloStation(
			number:230,
			name:"00230 - RANGUEIL TRIPODE B",
			adress:"141 AV DE RANGUEIL"
			)
		
	}

}
