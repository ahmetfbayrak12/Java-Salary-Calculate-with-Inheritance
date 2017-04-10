
/**
 * @author Ahmet Faruk Bayrak
 *
 */
public class Personel {
	
	protected String name;
	protected String reg_num;
	protected String position;
	protected int start_year;
	protected double salary;
	
	//CONSTRUCTOR
	/**
	 * This is super constructor for this personnel hierarchy.
	 * @param name_ name of the personnel
	 * @param reg_num_ registration number of personnel
	 * @param position_ position of personnel
	 * @param start_year_ start year of the personnel
	 * @param monitor_file_ monitor file to calculate salary
	 */
	public Personel(String name_, String reg_num_, String position_, int start_year_, String[] monitor_file_) {
		name = name_;
		reg_num = reg_num_;
		position = position_;
		start_year = start_year_;
		salary = calculateSalary(monitor_file_);
	}
	//END CONSTRUCTOR
	
	
	//GETTERS
	/**
	 * @return the salary
	 */
	public double getSalary(){
		return 0;
	}
	/**
	 * @return the personnel name
	 */
	public String getName(){
		return this.name;
	}
	/**
	 * @param monitor_file monitor file
	 * @return 0 default value
	 */
	public double calculateSalary(String[] monitor_file){
		return 0;
	}
	/**
	 * @return registration number
	 */
	public String getReg_num() {
		return this.reg_num;
	}
	/**
	 * @return position
	 */
	public String getPosition() {
		return this.position;
	}
	/**
	 * @return start year
	 */
	public int getStart_year() {
		return this.start_year;
	}
	//END GETTERS

}

