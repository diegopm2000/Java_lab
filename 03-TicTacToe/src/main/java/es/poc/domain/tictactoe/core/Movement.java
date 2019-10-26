package es.poc.domain.tictactoe.core;

import es.poc.domain.tictactoe.core.Game.TurnStatus;

public class Movement {

	//PROPERTIES
	
	private TurnStatus turnStatus;
	private int row;
	private int column;
	
	//CONSTRUCTORS
	
	public Movement() {
		//Default Constructor
	}
	
	public Movement(TurnStatus turnStatus, int row, int column) {
		
		this.turnStatus = turnStatus;
		this.row = row;
		this.column = column;
	}
	
	//GETTERS AND SETTERS
	
	public TurnStatus getTurnStatus() {
		return turnStatus;
	}
	
	public void setTurnStatus(TurnStatus turnStatus) {
		this.turnStatus = turnStatus;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	public Integer getRow() {
		return row;
	}
	
	public Integer getColumn() {
		return column;
	}
	
	//METHODS
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("Turn: "+this.turnStatus + " --> Row: "+this.row + ", Col: "+this.column);
				
		return sb.toString();
		
	}
	
}
