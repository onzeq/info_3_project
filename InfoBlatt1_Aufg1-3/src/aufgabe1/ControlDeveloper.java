package aufgabe1;
/**
 * Excercise 1 create a class variable and a instance variable and call them
 * @author christian
 * @version 1.0.
 */
public class ControlDeveloper {
	public static String ControlDeveloper_Class = "CLASS Control-Developer"; //static für Klassenvariable --> Lebensdauer ganzes Programm
	private String ControlDeveloper_Member = "MEMBER Control-Developer";
	
	public static void main(String[] Irgendwie)
	{ 
		System.out.println(ControlDeveloper.ControlDeveloper_Class);
		ControlDeveloper TestDeveloper = new ControlDeveloper(); //Muss erst Instanziert werden (InstanzVariable)
		System.out.println(TestDeveloper.ControlDeveloper_Member);
	}
	
}
