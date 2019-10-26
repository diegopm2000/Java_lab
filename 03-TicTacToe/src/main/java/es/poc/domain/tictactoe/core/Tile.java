package es.poc.domain.tictactoe.core;

public class Tile {
	
	//CONSTANTS
	
	public static final String EMPTY_TILE_STRING = " - ";

	//PROPERTIES
	
	private Piece piece;
	
	//CONSTRUCTORS
	
	public Tile() {
		//Default constructor for empty tile
	}
	
	//GETTERS AND SETTERS
	
	public Piece getPiece() {
		return piece;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	}
	
	//METHODS
	
	public boolean isEmpty() {
		return this.piece == null;
	}
	
	public void setEmpty() {
		this.piece = null;
	}
	
	public boolean contains(Piece piece) {
		return this.piece!=null && this.piece.getPieceType() == piece.getPieceType();
	}
	
	@Override
	public String toString() {
				
		String sText;
		
		if (this.piece==null) {
			sText = EMPTY_TILE_STRING;
		} else
			sText = this.piece.toString();
					
		return sText;
	}
	
}

