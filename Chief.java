/**
 * @author Ahmet Faruk Bayrak
 *
 */
public class Chief extends FulltimeEmployee{

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
	public Chief(String name_, String reg_num_, String position_, int start_year_, String[] monitor_file_) {
		super(name_, reg_num_, position_, start_year_, monitor_file_);
	}
	//END CONSTRUCTOR
	
	//GETTERES	
	public double getSeverencePay(){
		severencePay =  (2016-start_year) * 20 * 0.8;
		return severencePay;
	}
	@Override
	public double calculateSalary(String[] monitor_file){
		salary = getSeverencePay();
		for (int i = 0; i < monitor_file.length; i++) {
			if(monitor_file[i].split("\t")[0].equals(reg_num)){
				salary += getChiefSalary(monitor_file[i]);
				break;
			}
		}
		return salary;
	}
	public double getChiefSalary(String personelOnMonitorLine){
		overWorkSalary = 84 * 20;
		for (int j = 1; j <= 4; j++) {
			if (Integer.parseInt(personelOnMonitorLine.split("\t")[j]) > 40 && Integer.parseInt(personelOnMonitorLine.split("\t")[j]) <= 48) {
				overWorkSalary += (Integer.parseInt(personelOnMonitorLine.split("\t")[j]) - 40) * 5;
			} 
			else if (Integer.parseInt(personelOnMonitorLine.split("\t")[j]) > 48) {
				overWorkSalary += (8 * 5);
			} 
		}
		return overWorkSalary;
	}
	@Override
	public double getSalary(){
		return this.salary;
	}
	// END GETTERES
}