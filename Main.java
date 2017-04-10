
/**
 * @author Ahmet Faruk Bayrak
 *
 */
public class Main {

	/**
	 * Operates general working.
	 * @param args first arg is personnel file and second arg is monitor file paths.
	 */
	public static void main(String[] args) {
		Helper helper = new Helper();
		
		String[] monitor_file = helper.readFile(args[1]);
		String[] personels_file = helper.readFile(args[0]);
				
		helper.calculateAll(monitor_file, personels_file);
		
	}

}
