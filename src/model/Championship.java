package model;
public class Championship{
	private int year;
	private int numRaces;
	private Pilot[] pilots;

	public Championship(int y, int r){
		this.year = y;
		this.numRaces = r;
		this.pilots = new Pilot[15];
	}
	public void addPilot(String n, int a, int t, double s[], int i){
		Team team;
		switch(t){
			case 1: team = Team.SCUDERIA_FERRARI;
			break;
			case 2: team = Team.MCLAREN_F1_TEAM;
			break;
			case 3: team = Team.REDBULL_RACING;
			break;
			case 4: team = Team.MERCEDES_AMG;
			break;
			case 5: team = Team.RACING_POINT;
			break;
			case 6: team = Team.ALFA_ROMERO;
			break;
			case 7: team = Team.RENAULT;
			break;
			default: team = Team.WILLIAMS;
			break;
		}

		
		pilots[i] = new Pilot(n, a, s, team);
	}
	private String convertHMS(double x){
		String hms;
		int hora = 0, min = 0, seg = 0;
        hora = (int) x/3600;
        min = (int)(x%3600)/60;
        seg = (int)((x%3600)%60);
        hms = "Tiempo promedio piloto  = " + hora + ":" + min + ":" + seg;
        return hms;
	}
	public String showAverageTimes(){
		double x = 0;
		String hms = "";
		String o = "";
		for(int i = 0; i < 15; i++){
			if(pilots[i] != null){
				x = pilots[i].calculateAverage();
				hms = convertHMS(x);
				o += (pilots[i].getName() + " " + hms + "\n");
			}
		}
		return o;
	}
	public boolean findPilot(String name){
		int i = 0;
		boolean x = false;
		while(i < 15 && x != true){
			if(pilots[i] != null && pilots[i].getName().equalsIgnoreCase(name)){
				x = true;
			}
			i++;
		}
		return x;
	}
//Gets
	public int getYear(){
		return this.year;
	}
	public int getNumRaces(){
		return this.numRaces;
	}
//Sets
	public void setYear(int y){
		this.year = y;
	}
	public void setRace(int r){
		this.numRaces = r;
	}
}