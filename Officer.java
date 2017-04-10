
/**
 * @author Ahmet Faruk Bayrak
 *
 */
public class Officer extends Personel {

	private double baseSalary;
	private double ssBenefits;
	private double overWorkSalary;
	private double severencePay;
	
	//CONSTRUCTOR
	/**
	 * @param name_ name of the personnel
	 * @param reg_num_ registration number of personnel
	 * @param position_ position of personnel
	 * @param start_year_ start year of the personnel
	 * @param monitor_file_ monitor file to calculate salary
	 */
	public Officer(String name_, String reg_num_, String position_, int start_year_, String[] monitor_file_) {
		super(name_, reg_num_, position_, start_year_, monitor_file_);
	}
	//END CONSTRUCTOR
	
	//GETTERES	
	/**
	 * @return the base salary
	 */
	public double getBaseSalary(){
		baseSalary = 1800;
		return baseSalary;
	}
	/**
	 * @return special service benefits
	 */
	public double getSsBenefits(){
		ssBenefits = getBaseSalary() * 0.49;
		return ssBenefits;
	}
	/**
	 * @return the severence pay
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
		salary = getBaseSalary() + getSsBenefits() + getSeverencePay();
		for (int i = 0; i < monitor_file.length; i++) {
			if(monitor_file[i].split("\t")[0].equals(reg_num)){
				salary += getOverWorkSalary(monitor_file[i]);
			}
//			break;
		}
		return salary;
	}
	/**
	 * @param personelOnMonitorLine personnel line in the monitor file
	 * @return the officer's overwork salary.
	 */
	public double getOverWorkSalary(String personelOnMonitorLine){
		overWorkSalary = 0;
		for (int j = 1; j <= 4; j++) {
			if (Integer.parseInt(personelOnMonitorLine.split("\t")[j]) > 40 && Integer.parseInt(personelOnMonitorLine.split("\t")[j]) <= 50) {
				overWorkSalary += (Integer.parseInt(personelOnMonitorLine.split("\t")[j]) - 40) * 4;
			} else if (Integer.parseInt(personelOnMonitorLine.split("\t")[j]) > 50) {
				overWorkSalary += (10 * 4);
			} 
		}
		return overWorkSalary;
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
