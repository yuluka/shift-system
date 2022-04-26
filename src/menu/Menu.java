package menu;

import java.util.Scanner;

import model.TurnsData;

public class Menu {

	private static Scanner in = new Scanner(System.in);
	
	public static void startProgram() {
		System.out.println("�Bienvenido!");
		mainMenu();
	}
	
	public static void mainMenu() {
		System.out.println("\n------ Menu ------"
				+ "\n�Qu� desea hacer?"
				+ "\n1) Dar turno."
				+ "\n2) Mostrar turno."
				+ "\n3) Pasar turno."
				+ "\n4) Eliminar turno actual."
				+ "\n0) Salir.");
		
		int selection = in.nextInt();
		
		switch (selection) {
		case 1:
			giveTurn();
			break;
			
		case 2:
			showTurn();
			break;
			
		case 3:
			nextTurn();
			break;
		
		case 4:
			deleteActualTurn();	
			break;
			
		case 0:
			exit();
			break;
			
		default:
			System.out.println("\nUsted ha hecho una elecci�n inv�lida. Intente nuevamente");
			mainMenu();
			break;
		}
	}
	
	public static void giveTurn() {
		System.out.println("\n------ Dar turno ------");
		
		if(TurnsData.addTurn()) {
			System.out.println("\nTurno dado correctamente.");
		} else {
			System.out.println("\nNo hay turnos disponibles para dar.");
		}
		
		mainMenu();
	}
	
	public static void showTurn() {
		System.out.println("\n------ Mostrar turno ------");

		System.out.println("El turno actual es: " + TurnsData.showActual());

		mainMenu();
	}
	
	public static void nextTurn() {
		System.out.println("\n------ Pasar turno ------");
		
		if(TurnsData.nextTurn()) {
			System.out.println("\nTurno pasado correctamente.");
		} else {
			System.out.println("\nNo se ha dado ning�n turno a�n.");
		}
		
		mainMenu();
	}
	
	public static void deleteActualTurn() {
		System.out.println("\n------ Eliminar turno actual ------");
		
		if(TurnsData.deleteActual()) {
			System.out.println("\nTurno eliminado correctamente.");
		} else {
			System.out.println("\nNo se ha dado ning�n turno a�n.");
		}
		
		System.out.println("Los turnos ahora son:"
				+ "\n" + TurnsData.printTurns());
		
		mainMenu();
	}
	
	public static void exit() {
		System.out.println("\n�Adi�s! :-)");
		System.exit(0);
	}
}
