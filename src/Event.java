import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Vector;


public class Event implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private Location location; // złożony
	private double price;
	private static String companyName;
	private static Vector<Event> events;
	
	public Event(String name, Location location) {
		setName(name);
		setLocation(location);
		setPrice(0);
		addEvent(this);
	}
	
	// przeciazenie
	public Event(String name, Location location, double price) {
		setName(name);
		setLocation(location);
		setPrice(price);
		addEvent(this);
	}
	
	//gettery i settery
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Location getLocation(){
		return this.location;
	}
	
	public void setLocation(Location location) {
		this.location = location;
	}
	
	public double getPrice() {
		return this.price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	// atrybut klasowy - getter i setter
	public static String getCompanyName() {
		return companyName;
	}
	
	public static void setCompanyName(String company) {
		companyName = company;
	}
	
	public double advance() {
		double advancedPay = this.price*0.2;
		System.out.println("Zaliczka wynosi " + advancedPay + " zl");
		return advancedPay;
	}
	
	public double advance(double advance) {
		double advancedPay = this.price*(advance/100);
		System.out.println("Zaliczka wynosi " + advancedPay + " zl");
		return advancedPay;
	}
	
	//przesloniecie
	public String toString() {
		String str = new String();
		str += "Event: " + getName();
		str += "\nLocation: " + getLocation().toString();
		str += "\nPrice: " + getPrice();
		
		return str;
	}
	
	//ekstensja
	private static void addEvent(Event event) {
		if(events == null) {
			events = new Vector<Event>();
		}
		events.add(event);
	}
	
	public static void removeEvent(Event event) {
		if(events != null) {
			events.remove(event);			
		}
	}
	
	public static void showEvents() {
		for (Event e : events) {
			System.out.println(e.toString());
		}
	}
	
	public static void saveEvents(ObjectOutputStream stream) throws IOException{
		stream.writeObject(events);
	}
	
	@SuppressWarnings("unchecked")
	public static void readEvents(ObjectInputStream stream) throws IOException, ClassNotFoundException{
		events = (Vector<Event>) stream.readObject();
	}
}
