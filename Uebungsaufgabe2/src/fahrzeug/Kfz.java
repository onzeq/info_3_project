package fahrzeug;

public abstract class Kfz {

	
	private int baujahr;//Laut UML private, wird aber in Lkw genutzt
	private String plate;
	
	//inherited classes use it to value private Kfz attribute baujahr
	public Kfz(int baujahr) {
		this.baujahr = baujahr;
		this.plate = null;
	}
	
	public int getBaujahr() {
		return this.baujahr;
	}
	public void setPlate(String plate) {
		this.plate = plate;
	}
	
	public String getPlate() {
		return this.plate;
	}
	
	public abstract void takeAction();
	
}
