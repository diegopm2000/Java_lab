package es.poc.domain.tictactoe.core;

public class PieceO implements Piece {

public static final String PIECEO_STRING = " O ";
	
	//PROPIEDADES
	
	private PieceType pieceType;
	
	//CONSTRUCTORS

	public PieceO() {
		this.pieceType = PieceType.O;
	}
	
	//GETTERS AND SETTERS

	@Override
	public PieceType getPieceType() {
		return pieceType;
	}

	//METHODS
	
	@Override
	public boolean isX() {
		return false;
	}
	
	@Override
	public boolean isO() {
		return true;
	}
	
	@Override
	public String toString() {
								
		return PIECEO_STRING;
	}
}
