package services;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Scanner;

import model.Jugadores;

public class Funcionamiento {
	static Scanner tecladoJugador1 = new Scanner(System.in);
	static Scanner tecladoJugador2 = new Scanner(System.in);
	static int victoriasUsuario = 0;
	static int victoriasMaquina = 0;
	static int victoriasJugador1 = 0;
	static int victoriasJugador2 = 0;
	static int maquina = (int) (Math.random() * 5 + 1);
	static int piedra = 1;
	static int papel = 2;
	static int tijeras = 3;
	static int lagarto = 4;
	static int spock = 5;
	static Jugadores jugador1 = new Jugadores();
	static Jugadores jugador2 = new Jugadores();
	static Scanner usuario = new Scanner(System.in);
	String[]emojis = Emojis();

	public void JugadorVsMaquina() {

		do {
			System.out.println("Introduce una opcion: 1-piedra "+emojis[1] + " | 2-Papel "+emojis[2] + "  | 3-Tijeras  "+emojis[0] + " | 4-Lagarto  "+emojis[3] + " | 5-Spock "+emojis[4] + " ");
			int opcionUsuario = usuario.nextInt();
			OpcionesJugadorVsMaquina(opcionUsuario);
			
			if (victoriasUsuario == 3) {
				System.out.println("Enhorabuena Jugador has ganado!");
				System.out.println("");
				victoriasMaquina=0;
				victoriasUsuario=0;
				break;
			} else if (victoriasMaquina == 3) {
				System.out.println("Enhorabuena Maquina has ganado y eres un maquina!");
				System.out.println("");
				break;
			}
		} while ((victoriasUsuario <= 3) || (victoriasMaquina <= 3));

	}
	
	public static void OpcionesJugadorVsMaquina(int opcionUsuario) {

		System.out.println("");
		System.out.println(maquina);
		if (opcionUsuario == piedra && (maquina == lagarto || maquina == tijeras)) {
			System.out.println("Gana el jugador!");
			victoriasUsuario++;
		} else if (opcionUsuario == papel && (maquina == piedra || maquina == spock)) {
			System.out.println("Gana el jugador!");
			victoriasUsuario++;
		} else if (opcionUsuario == tijeras && (maquina == papel || maquina == lagarto)) {
			System.out.println("Gana el jugador!");
			victoriasUsuario++;
		} else if (opcionUsuario == lagarto && (maquina == papel || maquina == spock)) {
			System.out.println("Gana el jugador!");
			victoriasUsuario++;
		} else if (opcionUsuario == spock && (maquina == piedra || maquina == tijeras)) {
			System.out.println("Gana el jugador!");
			victoriasUsuario++;
		} else if (opcionUsuario == maquina) {
			System.out.println("Empate!");
		} else {
			System.out.println("Gana la maquina!");
			victoriasMaquina++;
		}
		System.out.println("Jugador: " + victoriasUsuario);
		System.out.println("Maquina: " + victoriasMaquina);
		System.out.println("");

	}

	public void JugadorVsJugador() {
		
		System.out.println("Introduce el nombre del Jugador 1:");
		String nombreJugador1 = tecladoJugador1.nextLine();
		jugador1.setJugador1(nombreJugador1);

		System.out.println("Introduce el nombre del Jugador 2:");
		String nombreJugador2 = tecladoJugador2.nextLine();
		jugador2.setJugador2(nombreJugador2);

		do {
			System.out.println("Turno de " + jugador1.getJugador1() + ":");
			System.out.println("Introduce una opcion: 1-piedra "+emojis[1] + " | 2-Papel "+emojis[2] + "  | 3-Tijeras  "+emojis[0] + " | 4-Lagarto  "+emojis[3] + " | 5-Spock "+emojis[4] + " ");
			int opcionJugador1 = tecladoJugador1.nextInt();

			System.out.println("Turno de " + jugador2.getJugador2() + ":");
			System.out.println("Introduce una opcion: 1-piedra "+emojis[1] + " | 2-Papel "+emojis[2] + "  | 3-Tijeras  "+emojis[0] + " | 4-Lagarto  "+emojis[3] + " | 5-Spock "+emojis[4] + " ");
			int opcionJugador2 = tecladoJugador2.nextInt();

			OpcionesJugadorVsJugador(nombreJugador1, nombreJugador2, opcionJugador1, opcionJugador2);

			if (victoriasJugador1 == 3) {
				System.out.println("Enhorabuena " + jugador1.getJugador1() + " has ganado!");
				System.out.println("");
				break;
			} else if (victoriasJugador2 == 3) {
				System.out.println("Enhorabuena " + jugador2.getJugador2() + " has ganado!");
				System.out.println("");
				
				break;
			}
		} while ((victoriasJugador1 <= 3) || (victoriasJugador2 <= 3));

	}

	public static void OpcionesJugadorVsJugador(String nombreJugador1, String nombreJugador2, int opcionJugador1,
			int opcionJugador2) {

		System.out.println("");
		if (opcionJugador1 == piedra && (opcionJugador2 == lagarto || opcionJugador2 == tijeras)) {
			System.out.println("Gana " + jugador1.getJugador1() + "!");
			victoriasJugador1++;
		} else if (opcionJugador1 == papel && (opcionJugador2 == piedra || opcionJugador2 == spock)) {
			System.out.println("Gana " + jugador1.getJugador1() + "!");
			victoriasJugador1++;
		} else if (opcionJugador1 == tijeras && (opcionJugador2 == papel || opcionJugador2 == lagarto)) {
			System.out.println("Gana " + jugador1.getJugador1() + "!");
			victoriasJugador1++;
		} else if (opcionJugador1 == lagarto && (opcionJugador2 == papel || opcionJugador2 == spock)) {
			System.out.println("Gana " + jugador1.getJugador1() + "!");
			victoriasJugador1++;
		} else if (opcionJugador1 == spock && (opcionJugador2 == piedra || opcionJugador2 == tijeras)) {
			System.out.println("Gana " + jugador1.getJugador1() + "!");
			victoriasJugador1++;
		} else if (opcionJugador1 == opcionJugador2) {
			System.out.println("Empate!");
		} else {
			System.out.println("Gana " + jugador2.getJugador2() + "!");
			victoriasJugador2++;
		}

		System.out.println(jugador1.getJugador1() + ": " + victoriasJugador1);
		System.out.println(jugador2.getJugador2() + ": " + victoriasJugador2);
		System.out.println("");
	}
	
	 static public String[] Emojis() {
		String[] codigoEmojis = new String[5];
		String[] emojis = new String[5];
		codigoEmojis[0]="\u270C";//Tijeras
		codigoEmojis[1]="\u270A";//piedra
		codigoEmojis[2]="\u270B";//papel
		codigoEmojis[3]="\uD83E\uDD8E";//papel
		codigoEmojis[4]="\uD83D\uDD96";//papel
		
		for(int i=0;i<5;i++) {
			String unicodeMessage =codigoEmojis[i];
			try {
	
			byte[] sourceBytes = unicodeMessage.getBytes("UTF-8");
	
			sourceBytes = unicodeMessage.getBytes("UTF-8");
			Charset utf8Charset = Charset.forName("UTF-8");
			Charset defaultCharset = Charset.defaultCharset();
			String data = new String(sourceBytes, defaultCharset.name());
	
			PrintStream out = new PrintStream(System.out, true, utf8Charset.name());
			emojis[i]=data;
			//out.println(emojis[i]);
			} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			}
		}
		return emojis;
	}

}
