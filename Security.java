
/**
 * @author Ahmet Faruk Bayrak
 *
 */
public class Security extends Personel{
	
	private double severencePay;
	
	//CONSTRUCTOR
	/**
	 * @param name_ name of the personnel
	 * @param reg_num_ registration number of personnel
	 * @param position_ position of personnel
	 * @param start_year_ start year of the personnel
	 * @param monitor_file_ monitor file to calculate salary
	 */
	public Security(String name_, String reg_num_, String position_, int start_year_, String[] monitor_file_) {
		super(name_, reg_num_, position_, start_year_, monitor_file_);
	}
	// END CONSTRUCTOR
	
	//GETTERES	
	/**
	 * @return teh severence pay
	 */
	public double getSeverencePay(){
		severencePay = (2016-start_year) * 20 * 0.8;
		return severencePay;
	}
	/* (non-Javadoc)
	 * @see Personel#calculateSalary(java.lang.String[])
	 */
	@Override
	public double calculateSalary(String[] monitor_file){
		salary = 0;
		for (int i = 0; i < monitor_file.length; i++) {
			if(monitor_file[i].split("\t")[0].equals(reg_num)){
				salary += getSeverencePay() + getSalaryByHour(monitor_file[i]);
				break;
			}
		}
		return salary;
	}
	/**
	 * @param monitor_file_line personel line in monitor file.
	 * @return the total security personnel salary.
	 */
	public double getSalaryByHour(String monitor_file_line){
		double salaryByHour = 0;
		for (int i = 1; i <= 4; i++) {
			if (Integer.parseInt(monitor_file_line.split("\t")[i]) >= 30 && Integer.parseInt(monitor_file_line.split("\t")[i]) <= 54) {
				salaryByHour += (double) Integer.parseInt(monitor_file_line.split("\t")[i]) * 6.5;
				salaryByHour += (6 * 4) + (6 * 5);
			}
			else if (Integer.parseInt(monitor_file_line.split("\t")[i]) < 30) {
				salaryByHour += (6 * 4) + (6 * 5);
			}
			else if (Integer.parseInt(monitor_file_line.split("\t")[i]) > 54) {
				salaryByHour += 54 * 6.5;
				salaryByHour += (6 * 4) + (6 * 5);
			}
		}
		return salaryByHour;
	}
	/* (non-Javadoc)
	 * @see Personel#getSalary()
	 */
	@Override
	public double getSalary(){
		return this.salary;
	}
	// END GETTERES
	

}
