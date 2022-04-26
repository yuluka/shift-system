package model;

public class TurnsData {
	
	private static final int TURNS_LIMIT = 50;
	private static final int PASS_TURNS_LIMIT = 3;
	
	private static Turn head;
	private static Turn tail;
	
	private static Turn actual;
	
	private static int gaveTurns;

	public TurnsData() {
		
	}
	
	public static boolean addTurn() {
		if(gaveTurns == TURNS_LIMIT) {
			return false;
		} 
		
		if(head == null) {
			head = new Turn(1);
			tail = head;
			actual = head;
			
			head.setNext(tail);
			head.setPrevious(tail);
			
			tail.setNext(head);
			tail.setPrevious(head);
			
			++gaveTurns;
		} else {
			Turn newTurn = new Turn(tail.getNumber()+1);
			
			tail.setNext(newTurn);
			newTurn.setNext(head);
			newTurn.setPrevious(tail);
			tail = newTurn;
			head.setPrevious(tail);
			
			++gaveTurns;
		}
		
		return true;
	}
	
	public static String showActual() {
		if(actual == null) {
			return "No se ha enregado ningún turno aún.";
		}
		
		return actual.getNumber() + "";
	}
	
	public static boolean nextTurn() {		
		if(actual == null) {
			return false;
		}
		
		actual.addPassed();
			
		if (actual.getPassed() == PASS_TURNS_LIMIT) {
			deleteActual();
		} else {
			actual = actual.getNext();
		}
		
		return true;
	}
	
	public static boolean deleteActual() {
		if(actual == null) {
			return false;
		} else if(head == tail) {
			actual = null;
			head = null;
			tail = null;

			--gaveTurns;
			return true;
		} else if(head == actual) {
			head.getPrevious().setNext(head.getNext());
			head.getNext().setPrevious(head.getPrevious());
			head = head.getNext();
			actual = head;

			--gaveTurns;
			return true;
		} else if(tail == actual) {
			tail.getPrevious().setNext(tail.getNext());
			tail.getNext().setPrevious(tail.getPrevious());
			tail = tail.getPrevious();
			actual = head;

			--gaveTurns;
			return true;
		} else {
			actual.getPrevious().setNext(actual.getNext());
			actual.getNext().setPrevious(actual.getPrevious());
			actual = actual.getNext();
			
			--gaveTurns;
			return true;	
		}	
	}
	
	public static void printTurns() {
		printTurns(head);
	}
	
	private static void printTurns(Turn current) {
		if(current == null) {
			System.out.println("No se han entregado turnos aún.");
			return;
		}
		
		if(current.getNext() == head) {
			System.out.println(current.getNumber());
			return;
		}
		
		System.out.print(current.getNumber() + " - ");
		printTurns(current.getNext());
	}
}
