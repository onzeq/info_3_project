package fahrzeug;
import fahrzeug.service.Werkstatt;
public class Pkw extends Kfz {
	
	private Werkstatt ws;
	private int seats;
	
	public final int JAHR = 2020; //to calculate if it is an oldtimer
	public Pkw(Werkstatt ws, int baujahr, int seats) {
		super(baujahr);
		// TODO Auto-generated constructor stub
		this.ws = ws;
		this.seats = seats;
		
	}
	public int getSeats() {
		return this.seats;
	}
	public boolean isOldtimer(){
		boolean oldtimer = false;
		if((JAHR - getBaujahr()) > 25) {
			oldtimer = true;
		}
		
		return oldtimer;
	}
	 

	@Override
	public void takeAction() {
		// TODO Auto-generated method stub
		ws.getAppointment();

	}

}
