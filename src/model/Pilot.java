package model;
enum Team{
	SCUDERIA_FERRARI, MCLAREN_F1_TEAM, REDBULL_RACING, MERCEDES_AMG, RACING_POINT, ALFA_ROMERO, RENAULT, WILLIAMS
}
public class Pilot{
	private String name;
	private int age;
	private double scores[];
	private Team aTeam;

	public Pilot(String n, int a, double sc[], Team t){
		this.name = n;
		this.age = a;
		this.scores = sc;
		this.aTeam = t;
	}
	public double calculateAverage(){
		double prom = 0;
		for(int i = 0; i < scores.length; i++){
			prom += scores[i];
		}
		prom = prom/scores.length;
		return prom;
	}
	//Gets
	public String getName(){
		return this.name;
	}
	public int getAge(){
		return this.age;
	}
	public double[] getScore(){
		return this.scores;
	}
	public Team getTeam(){
		return this.aTeam;
	}
	//Sets
	public void setName(String n){
		this.name = n;
	}
	public void setAge(int a){
		this.age = a;
	}
	public void setScore(double s[]){
		this.scores = s;
	}
	public void setTeam(Team t){
		this.aTeam = t;
	}
}