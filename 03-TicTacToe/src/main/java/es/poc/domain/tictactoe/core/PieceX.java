package es.poc.domain.tictactoe.core;

public class PieceX implements Piece {
	
	public static final String PIECEX_STRING = " X ";
	
	//PROPIEDADES
	
	private PieceType pieceType;
	
	//CONSTRUCTORS

	public PieceX() {
		this.pieceType = PieceType.X;
	}
	
	//GETTERS AND SETTERS

	@Override
	public PieceType getPieceType() {
		return pieceType;
	}

	//METHDOS
	
	@Override
	public boolean isX() {
		return true;
	}
	
	@Override
	public boolean isO() {
		return false;
	}
	
	@Override
	public String toString() {
								
		return PIECEX_STRING;
	}
	
}
