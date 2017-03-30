import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;


public class Consultant implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String surname;
	private String maidenName; //opcjonalny
	private int hireYear;
	private int workedYears; //pochodny
	private ArrayList<String> workPlaces;
	
	
	private static ArrayList<Consultant> consultants; // = new ArrayList<Consultant>();
	
	public Consultant(String name, String maidenName, String surname, int hireYear){
		setName(name);
		setMaidenName(maidenName);
		setSurname(surname);
		setHireYear(hireYear);
		this.workPlaces = new ArrayList<String>();
		addConsultant(this);	
	}
	
	//gettery i settery
	public String getName(){
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSurname() {
		return this.surname;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public String getMaidenName() {
		return this.maidenName;
	}
	
	public void setMaidenName(String maidenName) {
		this.maidenName = maidenName;
	}
	
	public int getHireYear() {
		return this.hireYear;
	}
	
	public void setHireYear(int hireYear) {
		this.hireYear = hireYear;
		this.workedYears = Calendar.getInstance().get(Calendar.YEAR) - this.hireYear; //pochodny
	}
	
	public int getWorkedYears(){
		return this.workedYears;
	}
	
	// atrybut powtarzalny
	public ArrayList<String> getWorkPlaces() {
		return this.workPlaces;
	}
	
	public void addWorkPlace(String place) {
		this.workPlaces.add(place);
	}
	
	public void removeWorkPlace(String place) {
		this.workPlaces.remove(place);
	}
	
	//przesloniecie
	public String toString() {
		String str = new String();
		str += "Name: " + getName();
		if(maidenName != null) {
		str += "\nMaiden name: ";  //opcjonalny
			str += maidenName;
		}
		str += "\nSurname: " + getSurname();
		str += "\nYears with company " + getWorkedYears();
		str += "\n";
		return str;
	}
	
	//ekstensja
	private static void addConsultant(Consultant consultant) {
		if(consultants == null) 
			consultants = new ArrayList<Consultant>();
		consultants.add(consultant);
	}
	
	public static void removeConsultant(Consultant consultant) {
		if(consultants != null)
			consultants.remove(consultant);
	}
	
	public static void showConsultants() {
		for(Consultant c : consultants) {
			System.out.println(c.toString());
		}
	}
	
	public static void saveConsultants(ObjectOutputStream stream) throws IOException {
		stream.writeObject(consultants);
	}
	
	@SuppressWarnings("unchecked")
	public static void readConsultants(ObjectInputStream stream) throws ClassNotFoundException, IOException {
		consultants = (ArrayList<Consultant>) stream.readObject();
	}
	
}
