import java.io.Serializable;


public class Location implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String city;
	String street;
	String number;
	
	public String toString(){
		return street + " " + number + ", " + city; 
	}

}
