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
}
