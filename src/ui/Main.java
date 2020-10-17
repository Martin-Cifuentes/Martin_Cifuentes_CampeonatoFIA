package ui;
import java.util.Scanner;
import model.Championship;
public class Main{
	private static Championship aChamp;
	private static Scanner sc;
	public static void main(String[] args){
		sc = new Scanner(System.in);
		cargarDatos();
		int o = 0;
		while(o != 5){
			o = menu();
			definirAccion(o);
		}
	}
	public static void cargarDatos(){
		double a[] = {200, 400};
		aChamp = new Championship(2,2020);
		aChamp.addPilot("maki",23,4,a,0);
		aChamp.addPilot("martin",21,6,a,1);
	}

	public static int menu(){
		int opcion;
		System.out.println("----MENU----\n\n");
		System.out.println("-(1) Crear Campeonato\n");
		System.out.println("-(2) Crear Piloto\n");
		System.out.println("-(3) Buscar si el piloto existe\n");
		System.out.println("-(4) Consultar promedios de los pilotos\n");
		System.out.println("-(5) Salir");
		opcion = sc.nextInt();
		sc.nextLine();
		return opcion;
	}
	public static void definirAccion(int a){
		switch(a){
			case 1: createChampionship();
			break;
			case 2: createPilot();
			break;
			case 3: showPilot();
			break;
			case 4: showScores();
		}
	}
	public static void createChampionship(){
		int races;
		int year;
		int numPilots;
		System.out.println("Ingrese la cantidad de grandes premios del campeonato");
		races = sc.nextInt();
		sc.nextLine();
		System.out.println("Ingrese el anio del campeonato");
		year = sc.nextInt();
		sc.nextLine();
		
		aChamp = new Championship(year, races);
	}
	public static void createPilot(){
		String name;
		int age;
		int team;
		int cantPilotos;
		double[] times;
		times = new double[aChamp.getNumRaces()];
		System.out.println("Ingrese la cantidad de pilotos");
		cantPilotos = sc.nextInt();
		sc.nextLine();

		if(cantPilotos <= 15){
			for(int i = 0; i < cantPilotos; i++){
				System.out.println("Ingrese el nombre del piloto " + (i+1));
				name = sc.nextLine();
				System.out.println("Ingrese la edad del piloto " + (i+1));
				age = sc.nextInt();
				sc.nextLine();
				System.out.println("Ingrese el equipo:\n(1)Scuderia Ferrari\n(2)McLaren F1 Team" + 
								   "\n(3)Redbull Racing\n(4)Mercedes Amg\n(5)Racing Point" + 
								   "\n(6)Alfa Romero\n(7)Renault\n(8)Williams");
				team = sc.nextInt();
				sc.nextLine();

				for(int o = 0; o < aChamp.getNumRaces(); o++){
					System.out.println("ingrese los tiempos del piloto en el gran premio " + (o + 1) + ", en segundos");
					times[o] = sc.nextInt();
					sc.nextLine();
				}
				aChamp.addPilot(name, age, team, times, i);
			}
		}else{
			System.out.println("Ingrese una cantidad valida de pilotos (menor o igual a 15)");
		}
	} 
	public static void showPilot(){
		String x;
		System.out.println("Escriba el nobre del piloto");
		x = sc.nextLine();
		boolean o = aChamp.findPilot(x);
		if(o == true){
			System.out.println("El piloto si existe");
		}else{
			System.out.println("El piloto no existe");
		}
	}
	public static void showScores(){
		String s = aChamp.showAverageTimes();
		System.out.println(s);

	}
		
}
			
