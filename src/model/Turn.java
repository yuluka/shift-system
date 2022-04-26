package model;

public class Turn {

	private Turn next;
	private Turn previous;
	
	private int number;
	private boolean actual;
	private int passed; //Counts the number of times a person has passed the turn.
	
	public Turn(int number) {
		super();
		this.number = number;
	}

	public Turn getNext() {
		return next;
	}

	public void setNext(Turn next) {
		this.next = next;
	}

	public Turn getPrevious() {
		return previous;
	}

	public void setPrevious(Turn previous) {
		this.previous = previous;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public boolean isActual() {
		return actual;
	}

	public void setActual(boolean actual) {
		this.actual = actual;
	}

	public int getPassed() {
		return passed;
	}

	public void addPassed() {
		++passed;
	}
}
