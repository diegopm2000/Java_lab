package es.poc.domain.tictactoe.core;

public class Board {
	
	//CONSTANTS
	
	public static final int MAX_COLS = 3;
	public static final int MAX_ROWS = 3;
	
	//PROPERTIES
	
	private Tile[][] boardArray;
	
	//CONSTRUCTORS
	
	public Board() {
		
		this.boardArray = new Tile[MAX_ROWS][MAX_COLS];
				
		for (int row=0; row<MAX_ROWS; row++) {			
			for (int col=0; col<MAX_COLS; col++) {				
				this.boardArray[row][col] = new Tile();
			}			
		}
	}
	
	//GETTERS AND SETTERS
	
	public Tile[][] getBoardArray() {
		return boardArray;
	}

	public void setBoardArray(Tile[][] boardArray) {
		this.boardArray = boardArray;
	}
	
	//METHODS
	
	public void setPiece(Piece piece, int row, int col) {
		
		this.boardArray[row][col].setPiece(piece);
	}
	
	public Tile getTile(int row, int col) {
		
		return this.boardArray[row][col];
	}
	
	public boolean isEmpty(int row, int col) {
		
		return this.boardArray[row][col].isEmpty();
	}
	
	public void setEmpty(int row, int col) {
		
		this.boardArray[row][col].setEmpty();
	}
	
	public boolean containsX(int row, int col) {
		
		return this.boardArray[row][col].contains(new PieceX());
	}
	
	public boolean containsO(int row, int col) {
		
		return this.boardArray[row][col].contains(new PieceO());
	}
	
	public boolean containsXLine() {	
		
		return containsXRow() || containsXDiagonal() || containsXColumn();
	}
	
	public boolean containsOLine() {	
		
		return containsORow() || containsODiagonal() || containsOColumn();
	}
	
	public boolean containsXRow() {
		
		Piece pieceX = new PieceX();
		return containPieceRow(0, pieceX) || containPieceRow(1, pieceX) || containPieceRow(2, pieceX);
	}
	
	public boolean containsORow() {
		
		Piece pieceO = new PieceO();
		return containPieceRow(0, pieceO) || containPieceRow(1, pieceO) || containPieceRow(2, pieceO);
	}
	
	public boolean containsXDiagonal() {
				
		return containsPieceDiagonal(new PieceX());
	}
	
	public boolean containsODiagonal() {
		
		return containsPieceDiagonal(new PieceO());
	}
	
	public boolean containsXColumn() {
		
		Piece pieceX = new PieceX();
		return containPieceColumn(0, pieceX) || containPieceColumn(1, pieceX) || containPieceColumn(2, pieceX);
	}
	
	public boolean containsOColumn() {
		
		Piece pieceO = new PieceO();
		return containPieceColumn(0, pieceO) || containPieceColumn(1, pieceO) || containPieceColumn(2, pieceO);
	}
	
	public boolean boardComplete() {	
		
		return isRowComplete(0) && isRowComplete(1) && isRowComplete(2);
	}
	
	private boolean isRowComplete(int i) {
		
		return !this.boardArray[i][0].isEmpty() && !this.boardArray[i][1].isEmpty() && !this.boardArray[i][2].isEmpty();
	}
	
	private boolean containPieceRow(int i, Piece piece) {		
		
		return this.boardArray[i][0].contains(piece) && this.boardArray[i][1].contains(piece) && this.boardArray[i][2].contains(piece);
	}
	
	private boolean containPieceColumn(int j, Piece piece) {
		
		return this.boardArray[0][j].contains(piece) && this.boardArray[1][j].contains(piece) && this.boardArray[2][j].contains(piece);
	}
	
	private boolean containsPieceDiagonal(Piece piece) {		
		
		return containsPieceDiagonalA(piece) || containsPieceDiagonalB(piece);
	}
	
	private boolean containsPieceDiagonalA(Piece piece) {
		
		return this.boardArray[0][0].contains(piece) && this.boardArray[1][1].contains(piece) && this.boardArray[2][2].contains(piece);
	}
	
	private boolean containsPieceDiagonalB(Piece piece) {
		
		return this.boardArray[0][2].contains(piece) && this.boardArray[1][1].contains(piece) && this.boardArray[2][0].contains(piece);
	}
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("Board:\n");
		for (int row=0; row<MAX_ROWS; row++) {			
			for (int col=0; col<MAX_COLS; col++) {				
				sb.append(this.boardArray[row][col]);
			}			
			sb.append("\n");
		}
				
		return sb.toString();		
	}

}
