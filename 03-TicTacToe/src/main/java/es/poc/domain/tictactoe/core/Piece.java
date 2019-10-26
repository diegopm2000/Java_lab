package es.poc.domain.tictactoe.core;

public interface Piece {

	public enum PieceType {X, O}
	
	//GETTERS AND SETTERS

	public PieceType getPieceType();
	
	//METHODS
	
	public boolean isX();
	
	public boolean isO();
	
	@Override
	public abstract String toString();
}
