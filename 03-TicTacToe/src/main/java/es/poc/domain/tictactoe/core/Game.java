package es.poc.domain.tictactoe.core;

public class Game {
	
	public enum TurnStatus {OTURN, XTURN}
	
	public enum GameStatus {INGAME, OWINS, XWINS, DRAW}
	
	public enum MovValidationResult {OK, PLAYER_NOT_IN_GAME, PLAYER_NOT_IN_TURN, TILE_NOT_EMPTY}

	//PROPERTIES
	
	private Integer id;
	private Board board;
	private TurnStatus turnStatus;
	private GameStatus gameStatus;
	private MovValidationResult lastValidation;
	
	//CONSTRUCTORS
	
	public Game() {
		super();
	}
	
	public Game(Integer id, Board board, GameStatus gameStatus, TurnStatus turnStatus) {
		
		this.id = id;
		this.board = board;
		this.gameStatus = gameStatus;
		this.turnStatus = turnStatus;
	}
	
	//GETTERS AND SETTERS
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public TurnStatus getTurnStatus() {
		return turnStatus;
	}

	public void setTurnStatus(TurnStatus turnStatus) {
		this.turnStatus = turnStatus;
	}

	public MovValidationResult getLastValidation() {
		return lastValidation;
	}

	public void setLastValidation(MovValidationResult lastValidation) {
		this.lastValidation = lastValidation;
	}
	
	public Board getBoard() {
		return board;
	}
	public void setBoard(Board board) {
		this.board = board;
	}
	public GameStatus getGameStatus() {
		return gameStatus;
	}
	
	public void setGameStatus(GameStatus gameStatus) {
		this.gameStatus = gameStatus;
	}
	
	//METHODS
	
	public Game initGame(TurnStatus turnStatus) {
		
		this.board = new Board();
		this.turnStatus = turnStatus;
		this.gameStatus = GameStatus.INGAME;
		
		return this;
	}
	
	public boolean isXTurn() {
		return this.turnStatus == TurnStatus.XTURN;
	}
	
	public boolean isOTurn() {
		return this.turnStatus == TurnStatus.OTURN;
	}
	
	public boolean isDraw() {
		return this.gameStatus == GameStatus.DRAW;
	}
	
	public boolean isInGame() {
		return this.gameStatus == GameStatus.INGAME;
	}
	
	public boolean isXWins() {
		return this.gameStatus == GameStatus.XWINS;
	}
	
	public boolean isOWins() {
		return this.gameStatus == GameStatus.OWINS;
	}
	
	/**
	 * Check if a player movement is valid
	 * 
	 * @param player 
	 * @param row 
	 * @param col
	 * 
	 * @return The result of the validation
	 */
	public MovValidationResult checkMove(Movement movement) {
		
		MovValidationResult movValidationResult;
		
		//Checks if is correct turn
		if (this.getTurnStatus() != movement.getTurnStatus()) {
			movValidationResult = MovValidationResult.PLAYER_NOT_IN_TURN;
		//Then, check if tile is empty
		} else if (!isEmptyTile(movement.getRow(), movement.getColumn())) {
			movValidationResult = MovValidationResult.TILE_NOT_EMPTY;
		} else {			
			movValidationResult = MovValidationResult.OK;
		}
				
		return movValidationResult;
	}
	
	/**
	 * Executes the movement (if is correct) and updates the last Validation Result
	 * 
	 * @param player
	 * @param row
	 * @param col
	 * @return
	 */
	public Game move(Movement movement) {
		
		this.lastValidation = checkMove(movement);
		
		if (this.lastValidation == MovValidationResult.OK) {			
			if (this.isXTurn()) {
				
				this.board.getTile(movement.getRow(), movement.getColumn()).setPiece(new PieceX());
				
				if (this.board.containsXLine()) {
					this.setGameStatus(GameStatus.XWINS);
				} else if(this.board.boardComplete()) {
					this.setGameStatus(GameStatus.DRAW);
				} 
				this.setTurnStatus(TurnStatus.OTURN);
			} else {
				
				this.board.getTile(movement.getRow(), movement.getColumn()).setPiece(new PieceO());
				
				if (this.board.containsOLine()) {
					this.setGameStatus(GameStatus.OWINS);
				} else if(this.board.boardComplete()) {
					this.setGameStatus(GameStatus.DRAW);
				}
				this.setTurnStatus(TurnStatus.XTURN);
			}
		}
		
		return this;		
	}
	
	private boolean isEmptyTile(int row, int col) {	
		return this.board.isEmpty(row, col);
	}
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("Game:"+"\n");
		
		sb.append("Turn status:"+this.turnStatus+"\n");
		sb.append("Game Status:"+this.gameStatus+"\n");
		sb.append("Last Move Validation:"+this.lastValidation+"\n");
		sb.append(board+"\n");
		
		return sb.toString();
	}
	
}
