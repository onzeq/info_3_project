package fahrzeug;

import fahrzeug.Kfz;

public abstract class KfzRegistry {
	public final int SIZE = 5;
	public int counter = 0;
	private Kfz kfzs[];
	
	public KfzRegistry(int Size){
		kfzs = new Kfz[Size];
	}
	public void register(Kfz pKfz) {
		kfzs[counter++] = pKfz;
		System.out.print("Kfz mit folgendem Kennzeichen wurde registriert: ");
		System.out.println(pKfz.getPlate());
	}
	public void unregister(Kfz pKfz) {
		if(counter !=0) {
			kfzs[--counter] = null;
		}
		else {
			System.out.println("Kein Kfz registriert");
		}
	}
	public void inform() {
		if(counter != 0) {
			for(int i = 0; i< counter; i++)
			{
				System.out.print(kfzs[i].getPlate());
				System.out.println(" wegen Rueckruf zurück in die Werkstatt");
			}
		}
		
	}
	Kfz[] getKfzs() {
		return kfzs;
	}

}
