package fahrzeug;
import fahrzeug.service.Werkstatt;
public class Lkw extends Kfz {
	private Werkstatt ws;
	private int load;
	
	//Implicit super constructor Kfz() is undefined. Must explicitly invoke another constructor 
	//WENN KEIN STANDARDKONSTRUKTOR IN KFZ
	public Lkw(Werkstatt ws, int baujahr, int load) {
		super(baujahr);
		this.ws = ws;
		this.load = load;
		
	}
	public int getLoad() {
		return this.load;
	}
	
	public void takeAction() {
		System.out.println(ws.getInfo());
	}

}
