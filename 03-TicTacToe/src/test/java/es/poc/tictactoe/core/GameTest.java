package es.poc.tictactoe.core;

import static com.shazam.shazamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.hamcrest.core.IsNull.nullValue;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.poc.domain.tictactoe.core.Board;
import es.poc.domain.tictactoe.core.Game;
import es.poc.domain.tictactoe.core.Game.GameStatus;
import es.poc.domain.tictactoe.core.Game.MovValidationResult;
import es.poc.domain.tictactoe.core.Game.TurnStatus;
import es.poc.domain.tictactoe.core.Movement;
import es.poc.domain.tictactoe.core.PieceO;
import es.poc.domain.tictactoe.core.PieceX;

public class GameTest {
	
	private static Logger log = LoggerFactory.getLogger(GameTest.class);	

	private Game game;
	private Board board;
	
	@Before
	public void init() {
		
		game = new Game();
		board = new Board();
	}
	
	@Test
	public void testCreateParametrizedGame() {
		
		game = new Game(1, board, GameStatus.INGAME, TurnStatus.XTURN);
		
		assertThat(game.getBoard(), is(notNullValue()));
		for (int row=0; row<Board.MAX_ROWS; row++) {
			
			for (int col=0; col<Board.MAX_COLS; col++) {
				
				assertThat(game.getBoard().getBoardArray()[row][col].isEmpty(), is(true));				
			}			
		}
		
		assertThat(game.getTurnStatus(), is(TurnStatus.XTURN));
		assertThat(game.getGameStatus(), is(GameStatus.INGAME));
		assertThat(game.getLastValidation(), is(nullValue()));		
	}
	
	@Test
    public void testInitGame() {
		
		game.initGame(TurnStatus.XTURN);
		
		assertThat(game, is(notNullValue()));
		
		assertThat(game.getBoard(), is(notNullValue()));
		assertThat(game.getTurnStatus(), is(TurnStatus.XTURN));
		assertThat(game.getGameStatus(), is(GameStatus.INGAME));
		assertThat(game.getLastValidation(), is(nullValue()));				
	}
	
	@Test
	public void testSetLastValidation() {
		
		game.setLastValidation(MovValidationResult.OK);
		
		assertThat(game.getLastValidation(), is(MovValidationResult.OK));
	}
	
	@Test
	public void testSetBoard() {
		
		game.setBoard(board);
		
		assertThat(game.getBoard(), is(notNullValue()));
		for (int row=0; row<Board.MAX_ROWS; row++) {
			
			for (int col=0; col<Board.MAX_COLS; col++) {
				
				assertThat(game.getBoard().getBoardArray()[row][col].isEmpty(), is(true));				
			}			
		}
	}
	
	@Test
	public void testIsXTurn() {
		
		game = new Game(1, board, GameStatus.INGAME, TurnStatus.XTURN);
		
		assertThat(game.isXTurn(), is(true));
		assertThat(game.isOTurn(), is(false));
	}
	
	@Test
	public void testIsOTurn() {
		
		game = new Game(1, board, GameStatus.INGAME, TurnStatus.OTURN);
						
		assertThat(game.isXTurn(), is(false));
		assertThat(game.isOTurn(), is(true));
	}
	
	@Test
	public void testIsInGame() {
		
		game = new Game(1, board, GameStatus.INGAME, TurnStatus.OTURN);
						
		assertThat(game.isInGame(), is(true));
	}
	
	
	@Test 
	public void testXWonFirstRow() {
		
		game.initGame(TurnStatus.XTURN);
		
		game.move(new Movement(TurnStatus.XTURN, 0, 0));
		game.move(new Movement(TurnStatus.OTURN,1, 0));
		game.move(new Movement(TurnStatus.XTURN, 0, 1));
		game.move(new Movement(TurnStatus.OTURN,2, 0));
		game.move(new Movement(TurnStatus.XTURN, 0, 2));
		
		log.info(game.toString());
		
		assertThat(game.isXWins(), is(true));	
		assertThat(game.isOWins(), is(false));
		assertThat(game.isDraw(), is(false));
	}
	
	@Test 
	public void testXWonSecondRow() {
		
		game.initGame(TurnStatus.XTURN);
		
		game.move(new Movement(TurnStatus.XTURN, 1, 0));
		game.move(new Movement(TurnStatus.OTURN,0, 0));
		game.move(new Movement(TurnStatus.XTURN, 1, 1));
		game.move(new Movement(TurnStatus.OTURN,0, 1));
		game.move(new Movement(TurnStatus.XTURN, 1, 2));
		
		log.info(game.toString());
		
		assertThat(game.isXWins(), is(true));	
		assertThat(game.isOWins(), is(false));
		assertThat(game.isDraw(), is(false));
	}
	
	@Test 
	public void testXWonThirdRow() {
		
		game.initGame(TurnStatus.XTURN);
		
		game.move(new Movement(TurnStatus.XTURN, 2, 0));
		game.move(new Movement(TurnStatus.OTURN,0, 0));
		game.move(new Movement(TurnStatus.XTURN, 2, 1));
		game.move(new Movement(TurnStatus.OTURN,0, 1));
		game.move(new Movement(TurnStatus.XTURN, 2, 2));
		
		log.info(game.toString());
		
		assertThat(game.isXWins(), is(true));	
		assertThat(game.isOWins(), is(false));
		assertThat(game.isDraw(), is(false));
	}
	
	@Test 
	public void testXWonDiagonalARow() {
		
		game.initGame(TurnStatus.XTURN);
		
		game.move(new Movement(TurnStatus.XTURN, 0, 0));
		game.move(new Movement(TurnStatus.OTURN,1, 0));
		game.move(new Movement(TurnStatus.XTURN, 1, 1));
		game.move(new Movement(TurnStatus.OTURN,1, 2));
		game.move(new Movement(TurnStatus.XTURN, 2, 2));
		
		log.info("---"+game.toString());
		
		assertThat(game.isXWins(), is(true));	
		assertThat(game.isOWins(), is(false));
		assertThat(game.isDraw(), is(false));
	}
	
	@Test 
	public void testXWonDiagonalBRow() {
		
		game.initGame(TurnStatus.XTURN);
		
		game.move(new Movement(TurnStatus.XTURN, 0, 2));
		game.move(new Movement(TurnStatus.OTURN,1, 0));
		game.move(new Movement(TurnStatus.XTURN, 1, 1));
		game.move(new Movement(TurnStatus.OTURN,1, 2));
		game.move(new Movement(TurnStatus.XTURN, 2, 0));
		
		log.info(game.toString());
		
		assertThat(game.isXWins(), is(true));	
		assertThat(game.isOWins(), is(false));
		assertThat(game.isDraw(), is(false));
	}
	
	@Test 
	public void testXWonFirstColumn() {
		
		game.initGame(TurnStatus.XTURN);
		
		game.move(new Movement(TurnStatus.XTURN, 0, 0));
		game.move(new Movement(TurnStatus.OTURN,1, 1));
		game.move(new Movement(TurnStatus.XTURN, 1, 0));
		game.move(new Movement(TurnStatus.OTURN,2, 2));
		game.move(new Movement(TurnStatus.XTURN, 2, 0));
		
		log.info(game.toString());
		
		assertThat(game.isXWins(), is(true));		
		assertThat(game.isOWins(), is(false));
		assertThat(game.isDraw(), is(false));
	}
	
	@Test 
	public void testXWonSecondColumn() {
		
		game.initGame(TurnStatus.XTURN);
		
		game.move(new Movement(TurnStatus.XTURN, 0, 1));
		game.move(new Movement(TurnStatus.OTURN,2, 2));
		game.move(new Movement(TurnStatus.XTURN, 1, 1));
		game.move(new Movement(TurnStatus.OTURN,2, 0));
		game.move(new Movement(TurnStatus.XTURN, 2, 1));
		
		log.info(game.toString());
		
		assertThat(game.isXWins(), is(true));	
		assertThat(game.isOWins(), is(false));
		assertThat(game.isDraw(), is(false));
	}
	
	@Test 
	public void testXWonThirdColumn() {
		
		game.initGame(TurnStatus.XTURN);
		
		game.move(new Movement(TurnStatus.XTURN, 0, 2));
		game.move(new Movement(TurnStatus.OTURN,2, 1));
		game.move(new Movement(TurnStatus.XTURN, 1, 2));
		game.move(new Movement(TurnStatus.OTURN,2, 0));
		game.move(new Movement(TurnStatus.XTURN, 2, 2));
		
		log.info(game.toString());
		
		assertThat(game.isXWins(), is(true));	
		assertThat(game.isOWins(), is(false));
		assertThat(game.isDraw(), is(false));
	}
	
	@Test 
	public void testOWonFirstRow() {
		
		game.initGame(TurnStatus.XTURN);
		
		game.move(new Movement(TurnStatus.XTURN, 1, 0));
		game.move(new Movement(TurnStatus.OTURN,0, 0));
		game.move(new Movement(TurnStatus.XTURN, 1, 1));
		game.move(new Movement(TurnStatus.OTURN,0, 1));
		game.move(new Movement(TurnStatus.XTURN, 2, 2));
		game.move(new Movement(TurnStatus.OTURN,0, 2));
		
		log.info(game.toString());
		
		assertThat(game.isOWins(), is(true));	
		assertThat(game.isXWins(), is(false));	
		assertThat(game.isDraw(), is(false));
	}
	
	@Test 
	public void testOWonSecondRow() {
		
		game.initGame(TurnStatus.XTURN);
		
		game.move(new Movement(TurnStatus.XTURN, 0, 0));
		game.move(new Movement(TurnStatus.OTURN,1, 0));
		game.move(new Movement(TurnStatus.XTURN, 0, 1));
		game.move(new Movement(TurnStatus.OTURN,1, 1));
		game.move(new Movement(TurnStatus.XTURN, 2, 2));
		game.move(new Movement(TurnStatus.OTURN,1, 2));
		
		log.info(game.toString());
		
		assertThat(game.isOWins(), is(true));	
		assertThat(game.isXWins(), is(false));
		assertThat(game.isDraw(), is(false));
	}
	
	@Test 
	public void testOWonThirdRow() {
		
		game.initGame(TurnStatus.XTURN);
		
		game.move(new Movement(TurnStatus.XTURN, 1, 0));
		game.move(new Movement(TurnStatus.OTURN,2, 0));
		game.move(new Movement(TurnStatus.XTURN, 1, 1));
		game.move(new Movement(TurnStatus.OTURN,2, 1));
		game.move(new Movement(TurnStatus.XTURN, 0, 2));
		game.move(new Movement(TurnStatus.OTURN,2, 2));
		
		log.info(game.toString());
		
		assertThat(game.isOWins(), is(true));	
		assertThat(game.isXWins(), is(false));
		assertThat(game.isDraw(), is(false));
	}
	
	@Test 
	public void testOWonDiagonalARow() {
		
		game.initGame(TurnStatus.XTURN);
		
		game.move(new Movement(TurnStatus.XTURN, 0, 1));
		game.move(new Movement(TurnStatus.OTURN,0, 0));
		game.move(new Movement(TurnStatus.XTURN, 1, 2));
		game.move(new Movement(TurnStatus.OTURN,1, 1));
		game.move(new Movement(TurnStatus.XTURN, 0, 2));
		game.move(new Movement(TurnStatus.OTURN,2, 2));
		
		log.info("---"+game.toString());
		
		assertThat(game.isOWins(), is(true));	
		assertThat(game.isXWins(), is(false));
		assertThat(game.isDraw(), is(false));
	}
	
	@Test 
	public void testoWonDiagonalBRow() {
		
		game.initGame(TurnStatus.XTURN);
		
		game.move(new Movement(TurnStatus.XTURN, 0, 1));
		game.move(new Movement(TurnStatus.OTURN,0, 2));
		game.move(new Movement(TurnStatus.XTURN, 1, 2));
		game.move(new Movement(TurnStatus.OTURN,1, 1));
		game.move(new Movement(TurnStatus.XTURN, 0, 0));
		game.move(new Movement(TurnStatus.OTURN,2, 0));
		
		log.info(game.toString());
		
		assertThat(game.isOWins(), is(true));	
		assertThat(game.isXWins(), is(false));
		assertThat(game.isDraw(), is(false));
	}
	
	@Test 
	public void testOWonFirstColumn() {
		
		game.initGame(TurnStatus.XTURN);
		
		game.move(new Movement(TurnStatus.XTURN, 0, 1));
		game.move(new Movement(TurnStatus.OTURN,0, 0));
		game.move(new Movement(TurnStatus.XTURN, 1, 1));
		game.move(new Movement(TurnStatus.OTURN,1, 0));
		game.move(new Movement(TurnStatus.XTURN, 2, 2));
		game.move(new Movement(TurnStatus.OTURN,2, 0));
		
		log.info(game.toString());
		
		assertThat(game.isOWins(), is(true));	
		assertThat(game.isXWins(), is(false));
		assertThat(game.isDraw(), is(false));
	}
	
	@Test 
	public void testOWonSecondColumn() {
		
		game.initGame(TurnStatus.XTURN);
		
		game.move(new Movement(TurnStatus.XTURN, 1, 0));
		game.move(new Movement(TurnStatus.OTURN,0, 1));
		game.move(new Movement(TurnStatus.XTURN, 2, 2));
		game.move(new Movement(TurnStatus.OTURN,1, 1));
		game.move(new Movement(TurnStatus.XTURN, 0, 2));
		game.move(new Movement(TurnStatus.OTURN,2, 1));
		
		log.info(game.toString());
		
		assertThat(game.isOWins(), is(true));	
		assertThat(game.isXWins(), is(false));
		assertThat(game.isDraw(), is(false));
	}
	
	@Test 
	public void testOWonThirdColumn() {
		
		game.initGame(TurnStatus.XTURN);
		
		game.move(new Movement(TurnStatus.XTURN, 0, 1));
		game.move(new Movement(TurnStatus.OTURN,0, 2));
		game.move(new Movement(TurnStatus.XTURN, 1, 1));
		game.move(new Movement(TurnStatus.OTURN,1, 2));
		game.move(new Movement(TurnStatus.XTURN, 0, 0));
		game.move(new Movement(TurnStatus.OTURN,2, 2));
		
		log.info(game.toString());
		
		assertThat(game.isOWins(), is(true));	
		assertThat(game.isXWins(), is(false));
		assertThat(game.isDraw(), is(false));
	}
	
	@Test
	public void testDrawXStarts() {
		
		game.initGame(TurnStatus.XTURN);
				
		game.move(new Movement(TurnStatus.XTURN, 0, 0));
		game.move(new Movement(TurnStatus.OTURN,0, 1));
		game.move(new Movement(TurnStatus.XTURN, 1, 0));
		game.move(new Movement(TurnStatus.OTURN,2, 0));
		game.move(new Movement(TurnStatus.XTURN, 1, 1));
		game.move(new Movement(TurnStatus.OTURN,2, 2));
		game.move(new Movement(TurnStatus.XTURN, 0, 2));
		game.move(new Movement(TurnStatus.OTURN,1, 2));
		game.move(new Movement(TurnStatus.XTURN, 2, 1));
				
		log.info(game.toString());
		
		assertThat(game.isDraw(), is(true));	
		assertThat(game.isXWins(), is(false));
		assertThat(game.isOWins(), is(false));
	}
	
	@Test
	public void testDrawOStarts() {
		
		game.initGame(TurnStatus.OTURN);
				
		game.move(new Movement(TurnStatus.OTURN, 0, 0));
		game.move(new Movement(TurnStatus.XTURN,0, 1));
		game.move(new Movement(TurnStatus.OTURN, 1, 0));
		game.move(new Movement(TurnStatus.XTURN,2, 0));
		game.move(new Movement(TurnStatus.OTURN, 1, 1));
		game.move(new Movement(TurnStatus.XTURN,2, 2));
		game.move(new Movement(TurnStatus.OTURN, 0, 2));
		game.move(new Movement(TurnStatus.XTURN,1, 2));
		game.move(new Movement(TurnStatus.OTURN, 2, 1));
				
		log.info(game.toString());
		
		assertThat(game.isDraw(), is(true));	
		assertThat(game.isXWins(), is(false));
		assertThat(game.isOWins(), is(false));
	}
	
	@Test
	public void testCompleteGame() {
		
		game.initGame(TurnStatus.XTURN);
		
		//1. First move of player 1
		
		game.move(new Movement(TurnStatus.XTURN, 0, 0));
		log.info(game.toString());
		
		assertThat(game.getTurnStatus(), is(TurnStatus.OTURN));
		assertThat(game.getGameStatus(), is(GameStatus.INGAME));	
		assertThat(game.getLastValidation(), is(Game.MovValidationResult.OK));
		assertThat(game.getBoard().getTile(0, 0).contains(new PieceX()), is(true));
									
		//2. Move of player 2
		
		game.move(new Movement(TurnStatus.OTURN,1, 1));
		log.info(game.toString());
		
		assertThat(game.getTurnStatus(), is(TurnStatus.XTURN));
		assertThat(game.getGameStatus(), is(GameStatus.INGAME));		
		assertThat(game.getLastValidation(), is(Game.MovValidationResult.OK));
		assertThat(game.getBoard().getTile(1, 1).contains(new PieceO()), is(true));
						
		//3. Movement not valid of player 1
		
		game.move(new Movement(TurnStatus.XTURN, 1, 1));
		log.info(game.toString());
		
		assertThat(game.getTurnStatus(), is(TurnStatus.XTURN));
		assertThat(game.getGameStatus(), is(GameStatus.INGAME));
		assertThat(game.getLastValidation(), is(Game.MovValidationResult.TILE_NOT_EMPTY));
		assertThat(game.getBoard().getTile(1, 1).contains(new PieceO()), is(true));
								
		//4. Movement not valid of player 2 (not in turn)
		
		game.move(new Movement(TurnStatus.OTURN,1, 2));
		log.info(game.toString());
		
		assertThat(game.getTurnStatus(), is(TurnStatus.XTURN));
		assertThat(game.getGameStatus(), is(GameStatus.INGAME));
		assertThat(game.getLastValidation(), is(Game.MovValidationResult.PLAYER_NOT_IN_TURN));
		assertThat(game.getBoard().getTile(1, 2).isEmpty(), is(true));
		
		//5. Movement of player 1
		
		game.move(new Movement(TurnStatus.XTURN, 0, 1));
		log.info(game.toString());
		
		assertThat(game.getTurnStatus(), is(TurnStatus.OTURN));
		assertThat(game.getGameStatus(), is(GameStatus.INGAME));
		assertThat(game.getLastValidation(), is(Game.MovValidationResult.OK));
		assertThat(game.getBoard().getTile(0, 1).contains(new PieceX()), is(true));
								
		//6. Movement of player 2
		
		game.move(new Movement(TurnStatus.OTURN,0, 2));
		log.info(game.toString());
		
		assertThat(game.getTurnStatus(), is(TurnStatus.XTURN));
		assertThat(game.getGameStatus(), is(GameStatus.INGAME));
		assertThat(game.getLastValidation(), is(Game.MovValidationResult.OK));
		assertThat(game.getBoard().getTile(0, 2).contains(new PieceO()), is(true));
								
		//7. Movement of player 1
		
		game.move(new Movement(TurnStatus.XTURN, 2, 0));
		log.info(game.toString());
		
		assertThat(game.getTurnStatus(), is(TurnStatus.OTURN));
		assertThat(game.getGameStatus(), is(GameStatus.INGAME));
		assertThat(game.getLastValidation(), is(Game.MovValidationResult.OK));
		assertThat(game.getBoard().getTile(2, 0).contains(new PieceX()), is(true));
		
		//8. Movement of player 1 Not Valid (not in turn)
		
		game.move(new Movement(TurnStatus.XTURN, 1, 0));
		log.info(game.toString());
		
		assertThat(game.getTurnStatus(), is(TurnStatus.OTURN));
		assertThat(game.getGameStatus(), is(GameStatus.INGAME));
		log.info(game.toString());
		
		assertThat(game.getTurnStatus(), is(TurnStatus.OTURN));
		assertThat(game.getGameStatus(), is(GameStatus.INGAME));
		assertThat(game.getLastValidation(), is(Game.MovValidationResult.PLAYER_NOT_IN_TURN));
		assertThat(game.getBoard().getTile(1, 0).isEmpty(), is(true));
								
		//9. Movement of player 2
		
		game.move(new Movement(TurnStatus.OTURN,2, 2));
		log.info(game.toString());
		
		assertThat(game.getTurnStatus(), is(TurnStatus.XTURN));
		assertThat(game.getGameStatus(), is(GameStatus.INGAME));
		assertThat(game.getLastValidation(), is(Game.MovValidationResult.OK));
		assertThat(game.getBoard().getTile(2, 2).contains(new PieceO()), is(true));
						
		//10. Movement of player 1 (X Player Wins)
		
		game.move(new Movement(TurnStatus.XTURN, 1, 0));
		log.info(game.toString());
		
		assertThat(game.getTurnStatus(), is(TurnStatus.OTURN));
		assertThat(game.getGameStatus(), is(GameStatus.XWINS));
		assertThat(game.isInGame(), is(false));
		assertThat(game.getLastValidation(), is(Game.MovValidationResult.OK));
		assertThat(game.getBoard().getTile(1, 0).contains(new PieceX()), is(true));
								
	}

}
