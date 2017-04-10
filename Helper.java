import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/**
 * @author Ahmet Faruk Bayrak
 *
 */
public class Helper {

	/**
	 * @param path Given file path
	 * @return the string array that contains every line of given text file.
	 */
	public String[] readFile(String path) {
		try{
			int i = 0;
			int lenght = Files.readAllLines(Paths.get(path)).size();
			String[] results = new String[lenght];
			for(String line : Files.readAllLines(Paths.get(path))){
				results[i++] = line;
			}
			return results;
		}
		catch(IOException e){
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * This method organizes general working area.
	 * In the other words it reads personnel and monitor files and finds every personnel and personnel's working hours in monitor file. 
	 * After that creates new personnel objects then writes their datas to text files.
	 * @param monitor_file monitor file 
	 * @param personels_file personnel file
	 */
	public void calculateAll(String[] monitor_file, String[] personels_file){
		Personel[] personelList = new Personel[personels_file.length];
		
		for (int i = 0; i < personels_file.length; i++) {
			switch (personels_file[i].split("\t")[2]) {
			case "MANAGER":
				Personel m = new Manager(personels_file[i].split("\t")[0], personels_file[i].split("\t")[1], 
						personels_file[i].split("\t")[2],Integer.parseInt(personels_file[i].split("\t")[3]), monitor_file);
				personelList[i] = m;
				break;
			case "OFFICER":
				Personel o = new Officer(personels_file[i].split("\t")[0], personels_file[i].split("\t")[1], 
						personels_file[i].split("\t")[2],Integer.parseInt(personels_file[i].split("\t")[3]), monitor_file);
				personelList[i] = o;
				break;
			case "SECURITY":
				Personel s = new Security(personels_file[i].split("\t")[0], personels_file[i].split("\t")[1], 
						personels_file[i].split("\t")[2],Integer.parseInt(personels_file[i].split("\t")[3]), monitor_file);
				personelList[i] = s;
				break;
			case "PARTTIME_EMPLOYEE":
				Personel pt = new ParttimeEmployee(personels_file[i].split("\t")[0], personels_file[i].split("\t")[1], 
						personels_file[i].split("\t")[2],Integer.parseInt(personels_file[i].split("\t")[3]), monitor_file);
				personelList[i] = pt;
				break;	
			case "WORKER":
				Personel w = new Worker(personels_file[i].split("\t")[0], personels_file[i].split("\t")[1], 
						personels_file[i].split("\t")[2],Integer.parseInt(personels_file[i].split("\t")[3]), monitor_file);
				personelList[i] = w;
				break;
			case "CHIEF":
				Personel c = new Chief(personels_file[i].split("\t")[0], personels_file[i].split("\t")[1], 
						personels_file[i].split("\t")[2],Integer.parseInt(personels_file[i].split("\t")[3]), monitor_file);
				personelList[i] = c;
				break;
			default:
				break;
			}
		}
		
		for (int i = 0; i < personelList.length; i++) {
			writeFile(personelList[i]);
		} 
	}
	
	/**
	 * @param personel to write this personnel
	 */
	public void writeFile(Personel personel) {
		Writer writer = null;
		String[] names = nameModifier(personel);
		try {
		    writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(personel.getReg_num() + ".txt"), "utf-8"));
		    writer.write("Name : " + names[0] + "\nSurname : " + names[1] + "\nRegistration Number : " + 
		    personel.getReg_num() + "\nPosition : " + 
		    personel.getPosition() + "\nYear of Start : " +
		    personel.getStart_year() + "\nTotal Salary : " + String.format("%.2f",personel.getSalary()).replace(',', '.') + " TL"	);
		} 
		catch (IOException e) {
			e.printStackTrace();
		} 
		finally {
		   try {writer.close();} catch (Exception ex) {/*ignore*/}
		}
	}
	
	/**
	 * @param personel that name specification organization.
	 * @return name and surname separated.
	 */
	private String[] nameModifier(Personel personel) {
		String[] name = personel.getName().split(" ");
		List<String> nameListed = Arrays.asList(name);
		List<String> firstNameList = nameListed.subList(0, nameListed.size()-1);
		String firstName = "";
		for (int i = 0; i < firstNameList.size(); i++) {firstName += (firstNameList.get(i) + " ");}
		firstName.trim();
		String lastName = nameListed.get(nameListed.size()-1);
		String[] finalname = {firstName, lastName};
		return finalname;
	}
	

}
