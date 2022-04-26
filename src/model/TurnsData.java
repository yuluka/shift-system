package model;

public class TurnsData {
	
	private static final int TURNS_LIMIT = 50;
	
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
			return "No se ha enregado ningún turno aún";
		}
		
		return actual.getNumber() + "";
	}
	
	public static boolean nextTurn() {
		return nextTurn(head);
	}
	
	private static boolean nextTurn(Turn current) {		
		if(actual == null) {
			return false;
		} else if(current == actual) {
			actual = current.getNext();
			return true;
		}
		
		return nextTurn(current.getNext());
	}
	
	public static boolean deleteActual() {
		return deleteActual(head);
	}
	
	private static boolean deleteActual(Turn current) {
		if(actual == null) {
			return false;
		} else if(current == actual) {
			current.getPrevious().setNext(current.getNext());
			current.getNext().setPrevious(current.getPrevious());
			actual = current.getNext();
			current = null;
			
			return true;
		}
		
		return deleteActual(current.getNext());
	}
	
	public static String printTurns() {
		return printTurns(0, head, "");
	}
	
	private static String printTurns(int i, Turn current, String turns) {
		if(i == 5) {
			return "";
		}
		
		turns += current.getNumber() + " - ";
		return printTurns(++i, current.getNext(), turns);
	}
}
