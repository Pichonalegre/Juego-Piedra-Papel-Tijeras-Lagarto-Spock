package start;

import java.util.Scanner;
import services.Funcionamiento;

public class Inicio {
	static Scanner usuario = new Scanner(System.in);
	static Funcionamiento llamada = new Funcionamiento();
	public static void main(String[] args) {
		String[]emojis = Funcionamiento.Emojis();
		
		System.out.println("Bienvenido a Piedra "+emojis[1] + " | Papel  "+emojis[2] + " | Tijera  "+emojis[0] + " | Lagarto  "+emojis[3] + " | Spock "+emojis[4] + " !");
		System.out.println("");
		System.out.println("Introduce una opcion: 1-piedra "+emojis[1] + " | 2-Papel "+emojis[2] + "  | 3-Tijeras  "+emojis[0] + " | 4-Lagarto  "+emojis[3] + " | 5-Spock "+emojis[4] + " ");
		int opcionUsuario=0;
		do {
			System.out.println("Menu:");
			System.out.println("1- Jugador - Maquina");
			System.out.println("2- Jugador - Jugador");
			System.out.println("0- Salir");
			opcionUsuario=usuario.nextInt();
		
		
			switch (opcionUsuario) {
			case 1:
				llamada.JugadorVsMaquina();
				break;
			case 2:
				llamada.JugadorVsJugador();
				break;
			case 0:
				System.out.println("Nos vemos!");
				break;
			default:
				System.out.println("No parece ser una opcion NO valida, prueba de nuevo:");
				break;
			}
		
		}while(opcionUsuario!=0);
	}
	
	
	
	
	
	
	
	

}
