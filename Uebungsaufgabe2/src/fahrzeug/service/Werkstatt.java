package fahrzeug.service;
import fahrzeug.KfzRegistry;
import fahrzeug.*;
import java.util.Scanner;
public class Werkstatt extends KfzRegistry {
	
	public Werkstatt(int Size){
		super(Size);
	}
	//todo implement
	public static void main(String[] args) {
		Werkstatt ws1 = new Werkstatt(5);
		Pkw pkw1 = new Pkw(ws1, 2000, 4);
		Lkw lkw1 = new Lkw(ws1, 1950, 6);
		pkw1.setPlate("Rt-J2798");
		lkw1.setPlate("ES-KW200");
		ws1.register(pkw1);
		ws1.register(lkw1);
		ws1.inform();
	}
	
	//todo implement
	public int getAppointment() {
		int date;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Wann wollen Sie Termin? ");
		date = scanner.nextInt(); 
		System.out.print("Termin erstellt am:");
		System.out.println(date);
		return date;
	}
	//todo implement
	public String getInfo() {
		String message = "Ihr Kfz muss in die Werkstatt";
		return message;
	}
	
	
}
