package es.poc.tictactoe.core;

import static com.shazam.shazamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.junit.Before;
import org.junit.Test;

import es.poc.domain.tictactoe.core.Board;
import es.poc.domain.tictactoe.core.Game;
import es.poc.domain.tictactoe.core.Game.GameStatus;
import es.poc.domain.tictactoe.core.Game.TurnStatus;
import es.poc.domain.tictactoe.core.Movement;
import es.poc.domain.tictactoe.core.Piece;
import es.poc.domain.tictactoe.core.PieceO;
import es.poc.domain.tictactoe.core.PieceX;
import es.poc.domain.tictactoe.core.Tile;

public class DozerMapperTest {
	
	DozerBeanMapper mapper = new DozerBeanMapper();
	
	@Before
	public void init() {
		
		//DozerMapper Config
		List<String> list = new ArrayList<>();
		list.add("dozer-mapping.xml");			
		mapper.setMappingFiles(list);
	}
	
	//Piece
	
	@Test
	public void testPieceXDozerMapping() {
		
		Piece pieceA = new PieceX();
		Piece pieceB = mapper.map(pieceA, Piece.class);
		
		assertThat(pieceB.isX(), is(true));
	}
	
	@Test
	public void testPieceODozerMapping() {
		
		Piece pieceC = new PieceO();
		Piece pieceD = mapper.map(pieceC, Piece.class);
		
		assertThat(pieceD.isO(), is(true));
	}
	
	//Tile
	
	@Test
	public void testEmptyTileDozerMapping() {
		
		Tile tile = new Tile();
		Tile tileB = mapper.map(tile, Tile.class);
						
		assertThat(tileB.isEmpty(), is(true));
	}
	
	@Test
	public void testTilePieceXDozerMapping() {
		
		Tile tile = new Tile();
		tile.setPiece(new PieceX());
		
		Tile tileB = mapper.map(tile, Tile.class);
						
		assertThat(tileB.contains(new PieceX()), is(true));
	}
	
	@Test
	public void testTilePieceODozerMapping() {
		
		Tile tile = new Tile();
		tile.setPiece(new PieceO());
		
		Tile tileB = mapper.map(tile, Tile.class);
						
		assertThat(tileB.contains(new PieceO()), is(true));
	}
	
	//Board
	
	@Test 
	public void testCopyEmptyBoardDozerMapping() {
		
		Board board = new Board();
		
		Board boardCopy = mapper.map(board, Board.class);
		
		testCopyBoard(board, boardCopy);
	}
	
	@Test
	public void testCopyBoardDozerMapping() {
		
		Board board = new Board();
		
		board.setPiece(new PieceO(), 0, 2);
		board.setPiece(new PieceO(), 1, 2);
		board.setPiece(new PieceO(), 2, 2);
		board.setEmpty(0, 1);
		board.setPiece(new PieceX(), 1, 1);
		board.setPiece(new PieceX(), 2, 1);
		board.setPiece(new PieceO(), 0, 0);
		board.setPiece(new PieceO(), 1, 0);
		board.setEmpty(2, 0);
		
		Board boardCopy = mapper.map(board, Board.class);
		
		testCopyBoard(board, boardCopy);
	}

	public static void testCopyBoard(Board board, Board boardCopy) {
		for (int row=0;row<Board.MAX_ROWS;row++) {
			for (int col=0;col<Board.MAX_COLS;col++) {
				
				if (board.containsX(row, col)) {
					assertThat(boardCopy.containsX(row, col), is(true));
				} else if (board.containsO(row, col)) {
					assertThat(boardCopy.containsO(row, col), is(true));
				} else {
					assertThat(boardCopy.isEmpty(row, col), is(true));
				}
			}		
		}
	}
	
	//Movement
	
	@Test
	public void testMovementDozerMapping() {
		
		Movement movement = new Movement(TurnStatus.XTURN,0,0);
		Movement movementCopy = mapper.map(movement, Movement.class);
		
		assertThat(movement.getTurnStatus(), is(movementCopy.getTurnStatus()));
		assertThat(movement.getRow(), is(movementCopy.getRow()));
		assertThat(movement.getColumn(), is(movementCopy.getColumn()));
	}
	
	//game
	
	@Test
	public void testGameDozerMapping() {
		
		Game game = new Game(1, new Board(), GameStatus.INGAME, TurnStatus.XTURN);		
		Game gameCopy = mapper.map(game, Game.class);
		
		testCopyBoard(game.getBoard(), gameCopy.getBoard());		
		assertThat(game.getGameStatus(), is(gameCopy.getGameStatus()));
		assertThat(game.getTurnStatus(), is(gameCopy.getTurnStatus()));
	}
	
}
