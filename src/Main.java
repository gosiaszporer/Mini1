import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class Main {

	public static void main(String[] args) {
		
		//konsultanci
		Consultant con1 = new Consultant("Betty", "Cooper", "Smith", 2015);
		Consultant con2 = new Consultant("John", null, "Pillow", 2005);
		con1.addWorkPlace("New York");
		con1.addWorkPlace("London");
		
		System.out.println("Ekstencja klasy Consultant:");
		Consultant.showConsultants();
		
		//atrybut powtarzalny
		System.out.println("Atrybut powtarzalny - Miejsca pracy konsultanta " + con1.getName() + " " + con1.getSurname() + ":");
		for(String s: con1.getWorkPlaces()) {
			System.out.println(s.toString());
		}
		System.out.println();
		
		//atrybut pochodny
		System.out.println("Atrybut pochodny - Lata przepracowane: " + con1.getWorkedYears());
		System.out.println();
		
		//atrybut opcjonalny
		System.out.println("Atrybut opcjonalny:");
		System.out.println("Ma nazwisko panienskie " + con1.getName() + " " + con1.getMaidenName() + " " + con1.getSurname() );
		System.out.println("Nie ma nazwiska panienskiego " + con2.getName() + " " + con2.getMaidenName() + " " + con2.getSurname() );
		
		System.out.println();
		
		//wydarzenia
		//astrybut zlozony
		Location loc = new Location();
		loc.city = "Warszawa";
		loc.street = "Aleje Ujazdowskie";
		loc.number = "115";
		Event event1 = new Event("Dream day", loc);
		Event event2 = new Event("Tuscan wedding", loc, 45000); //przeciazenie
		
		System.out.println("Ekstensja klasy Event");
		Event.showEvents();
		
		System.out.println();
		
		System.out.println("Atrybut zlozony: " + event1.getLocation());
		System.out.println();
		
		//atrybut klasowy
		Event.setCompanyName("The Nouveau Romantics");
		System.out.println("Atrybut klasowy: " + Event.getCompanyName());
		System.out.println();
		
		//trwalosc ekstansji
		System.out.println("Ekstansja - trwalosc:");
		//zapis
		try {
			ObjectOutputStream zapis = new ObjectOutputStream(new FileOutputStream(new File("WeddingFile")));
			Consultant.saveConsultants(zapis);
			Event.saveEvents(zapis);
			zapis.close();
			System.out.println("Zapisano do pliku");
			
			//odczyt
			ObjectInputStream odczyt = new ObjectInputStream(new FileInputStream(new File("WeddingFile")));
			Consultant.readConsultants(odczyt);
			Event.readEvents(odczyt);
			odczyt.close();
			System.out.println("Odczytano z pliku");
		} catch (FileNotFoundException ex) {
			System.out.println("Nie znaleziono pliku");
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// wyliczenie zaliczki ze
		event2.advance();
		event2.advance(50);

	}

}
