
/**
 * @author Ahmet Faruk Bayrak
 *
 */
public class ParttimeEmployee extends Employee {
	
	//CONSTRUCTOR
	/**
	 * @param name_ name of the personnel
	 * @param reg_num_ registration number of personnel
	 * @param position_ position of personnel
	 * @param start_year_ start year of the personnel
	 * @param monitor_file_ monitor file to calculate salary
	 */
	public ParttimeEmployee(String name_, String reg_num_, String position_, int start_year_, String[] monitor_file_) {
		super(name_, reg_num_, position_, start_year_, monitor_file_);
	}
	//END CONSTRUCTOR
	
	//GETTERS
	/* (non-Javadoc)
	 * @see Personel#calculateSalary(java.lang.String[])
	 */
	@Override
	public double calculateSalary(String[] monitor_file){
		salary = 0;
		for (int i = 0; i < monitor_file.length; i++) {
			if(monitor_file[i].split("\t")[0].equals(reg_num)){
				salary += getPartTimeSalary(monitor_file[i]);
				break;
			}
		}
		return salary;
	}
	/**
	 * @param personelLine personnel monitor line on monitor file.
	 * @return the part time working salary.
	 */
	public double getPartTimeSalary(String personelLine){
		double ptSalary = 0;
		for (int i = 1; i <= 4; i++) {
			if(Integer.parseInt(personelLine.split("\t")[i]) >= 10 && Integer.parseInt(personelLine.split("\t")[i]) <= 20){
				ptSalary += (double) Integer.parseInt(personelLine.split("\t")[i]) * 12;
			}
		}
		return ptSalary;
	}
	/* (non-Javadoc)
	 * @see Personel#getSalary()
	 */
	@Override
	public double getSalary(){
		return this.salary;
	}
	//END GETTERS
}