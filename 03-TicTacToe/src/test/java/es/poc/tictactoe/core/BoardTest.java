package es.poc.tictactoe.core;

import static com.shazam.shazamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNull.notNullValue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import es.poc.domain.tictactoe.core.Board;
import es.poc.domain.tictactoe.core.PieceO;
import es.poc.domain.tictactoe.core.PieceX;
import es.poc.domain.tictactoe.core.Tile;

public class BoardTest {
	
	private Board board;
	private Tile[][] boardArray;
	
	@Before
	public void init() {
		
		this.board = new Board();
		
		this.boardArray = new Tile[Board.MAX_ROWS][Board.MAX_COLS];
		
		for (int row=0; row<Board.MAX_ROWS; row++) {
			
			for (int col=0; col<Board.MAX_COLS; col++) {
				
				this.boardArray[row][col] = new Tile();
			}			
		}
	}

	@Test
    public void testCreation() {
		
		assertThat(board, is(notNullValue()));
		
		for (int row=0; row<Board.MAX_ROWS; row++) {
			
			for (int col=0; col<Board.MAX_COLS; col++) {
				
				assertThat(board.getBoardArray()[row][col].isEmpty(), is(true));				
			}			
		}
	}
	
	@Test
	public void testSetEmptyBoardArray() {
				
		board.setBoardArray(boardArray);
		
		for (int row=0; row<Board.MAX_ROWS; row++) {
			
			for (int col=0; col<Board.MAX_COLS; col++) {
				
				try {				
					assertThat(board.isEmpty(row, col), is(true));	
				} catch(Exception e) {
					Assert.fail("setPiece not valid");
				}
			}
		}		
	}
	
	@Test
	public void testSetBoardArray() {
						
		board.setBoardArray(boardArray);
		
		for (int row=0; row<Board.MAX_ROWS; row++) {
			
			for (int col=0; col<Board.MAX_COLS; col++) {
				
				try {
					
					board.setPiece(new PieceX(), row, col);
				
					assertThat(this.board.containsX(row, col), is(true));	
				} catch(Exception e) {
					
					Assert.fail("setPiece not valid");
				}
			}
		}		
		
	}
	
	@Test
	public void testSetPieceX() {
						
		for (int row=0; row<Board.MAX_ROWS; row++) {
			
			for (int col=0; col<Board.MAX_COLS; col++) {
				
				board.setPiece(new PieceX(), row, col);
				
				assertThat(board.containsX(row, col), is(true));									
			}
		}		
	}
	
	@Test
	public void testsetPieceO() {
						
		for (int row=0; row<Board.MAX_ROWS; row++) {
			
			for (int col=0; col<Board.MAX_COLS; col++) {
				
				board.setPiece(new PieceO(), row, col);
				
				assertThat(board.containsO(row, col), is(true));			
			}
		}
		
	}
	
	@Test
	public void testsetEmpty() {
		
		for (int row=0; row<Board.MAX_ROWS; row++) {
			
			for (int col=0; col<Board.MAX_COLS; col++) {
				
				board.setEmpty(row, col);
				
				assertThat(board.isEmpty(row, col), is(true));			
			}
		}
	}
	
	@Test
	public void testXFirstRow() {
		
		try {
			board.setPiece(new PieceX(), 0, 0);
			board.setPiece(new PieceX(), 0, 1);
			board.setPiece(new PieceX(), 0, 2);
			
			assertThat(board.containsXRow(), is(true));
			
		} catch(Exception e) {
			Assert.fail("Movimiento no valido");
		}
	}
	
	@Test
	public void testXSecondRow() {
		
		try {
			board.setPiece(new PieceX(), 1, 0);
			board.setPiece(new PieceX(), 1, 1);
			board.setPiece(new PieceX(), 1, 2);
			
			assertThat(board.containsXRow(), is(true));
			
		} catch(Exception e) {
			Assert.fail("Movimiento no valido");
		}
	}
	
	@Test
	public void testXThirdRow() {
		
		try {
			board.setPiece(new PieceX(), 2, 0);
			board.setPiece(new PieceX(), 2, 1);
			board.setPiece(new PieceX(), 2, 2);
			
			assertThat(board.containsXRow(), is(true));
			
		} catch(Exception e) {
			Assert.fail("Movimiento no valido");
		}
	}
	
	@Test
	public void testXFirstDiagonal() {
		
		try {
			board.setPiece(new PieceX(), 0, 0);
			board.setPiece(new PieceX(), 1, 1);
			board.setPiece(new PieceX(), 2, 2);
			
			assertThat(board.containsXDiagonal(), is(true));			
			
		} catch(Exception e) {
			Assert.fail("Movimiento no valido");
		}
	}
	
	@Test
	public void testXSecondDiagonal() {
		
		try {
			board.setPiece(new PieceX(), 2, 0);
			board.setPiece(new PieceX(), 1, 1);
			board.setPiece(new PieceX(), 0, 2);
			
			assertThat(board.containsXDiagonal(), is(true));
			
		} catch(Exception e) {
			Assert.fail("Movimiento no valido");
		}
	}
	
	@Test
	public void testXFirstColumn() {
		
		try {
			board.setPiece(new PieceX(), 0, 0);
			board.setPiece(new PieceX(), 1, 0);
			board.setPiece(new PieceX(), 2, 0);
			
			assertThat(board.containsXColumn(), is(true));			
			
		} catch(Exception e) {
			Assert.fail("Movimiento no valido");
		}
	}
	
	@Test
	public void testXSecondColumn() {
		
		try {
			board.setPiece(new PieceX(), 0, 1);
			board.setPiece(new PieceX(), 1, 1);
			board.setPiece(new PieceX(), 2, 1);
			
			assertThat(board.containsXColumn(), is(true));
			
		} catch(Exception e) {
			Assert.fail("Movimiento no valido");
		}
	}
	
	@Test
	public void testXThirdColumn() {
		
		try {
			board.setPiece(new PieceX(), 0, 2);
			board.setPiece(new PieceX(), 1, 2);
			board.setPiece(new PieceX(), 2, 2);
			
			assertThat(board.containsXColumn(), is(true));
			
		} catch(Exception e) {
			Assert.fail("Movimiento no valido");
		}
	}
	
	@Test
	public void testOFirstRow() {
		
		try {
			board.setPiece(new PieceO(), 0, 0);
			board.setPiece(new PieceO(), 0, 1);
			board.setPiece(new PieceO(), 0, 2);
			
			assertThat(board.containsORow(), is(true));			
			
		} catch(Exception e) {
			Assert.fail("Movimiento no valido");
		}
	}
	
	@Test
	public void testOSecondRow() {
		
		try {
			board.setPiece(new PieceO(), 1, 0);
			board.setPiece(new PieceO(), 1, 1);
			board.setPiece(new PieceO(), 1, 2);
			
			assertThat(board.containsORow(), is(true));
			
		} catch(Exception e) {
			Assert.fail("Movimiento no valido");
		}
	}
	
	@Test
	public void testOThirdRow() {
		
		try {
			board.setPiece(new PieceO(), 2, 0);
			board.setPiece(new PieceO(), 2, 1);
			board.setPiece(new PieceO(), 2, 2);
			
			assertThat(board.containsORow(), is(true));
			
		} catch(Exception e) {
			Assert.fail("Movimiento no valido");
		}
	}
	
	@Test
	public void testOFirstDiagonal() {
		
		try {
			board.setPiece(new PieceO(), 0, 0);
			board.setPiece(new PieceO(), 1, 1);
			board.setPiece(new PieceO(), 2, 2);
			
			assertThat(board.containsODiagonal(), is(true));			
			
		} catch(Exception e) {
			Assert.fail("Movimiento no valido");
		}
	}
	
	@Test
	public void testOSecondDiagonal() {
		
		try {
			board.setPiece(new PieceO(), 2, 0);
			board.setPiece(new PieceO(), 1, 1);
			board.setPiece(new PieceO(), 0, 2);
			
			assertThat(board.containsODiagonal(), is(true));	
			
		} catch(Exception e) {
			Assert.fail("Movimiento no valido");
		}
	}
	
	@Test
	public void testOFirstColumn() {
		
		try {
			board.setPiece(new PieceO(), 0, 0);
			board.setPiece(new PieceO(), 1, 0);
			board.setPiece(new PieceO(), 2, 0);
			
			assertThat(board.containsOColumn(), is(true));				
			
		} catch(Exception e) {
			Assert.fail("Movimiento no valido");
		}
	}
	
	@Test
	public void testOSecondColumn() {
		
		try {
			board.setPiece(new PieceO(), 0, 1);
			board.setPiece(new PieceO(), 1, 1);
			board.setPiece(new PieceO(), 2, 1);
			
			assertThat(board.containsOColumn(), is(true));	
			
		} catch(Exception e) {
			Assert.fail("Movimiento no valido");
		}
	}
	
	@Test
	public void testOThirdColumn() {
		
		try {
			board.setPiece(new PieceO(), 0, 2);
			board.setPiece(new PieceO(), 1, 2);
			board.setPiece(new PieceO(), 2, 2);
			
			assertThat(board.containsOColumn(), is(true));	
			
		} catch(Exception e) {
			Assert.fail("Movimiento no valido");
		}
	}
	
	@Test
	public void testBoardNotCompleteFirstRow() {
		
		try {
			board.setPiece(new PieceO(), 0, 0);
			board.setPiece(new PieceO(), 0, 1);
			board.setPiece(new PieceO(), 0, 2);
			
			assertThat(board.boardComplete(), is(false));	
			
		} catch(Exception e) {
			Assert.fail("Movimiento no valido");
		}
	}
	
	@Test
	public void testBoardNotCompleteFirstAndSecondRow() {
		
		try {
			board.setPiece(new PieceO(), 0, 0);
			board.setPiece(new PieceO(), 0, 1);
			board.setPiece(new PieceO(), 0, 2);
			board.setPiece(new PieceO(), 1, 0);
			board.setPiece(new PieceO(), 1, 1);
			board.setPiece(new PieceO(), 1, 2);
			
			assertThat(board.boardComplete(), is(false));	
			
		} catch(Exception e) {
			Assert.fail("Movimiento no valido");
		}
	}
	
	@Test
	public void testBoardNotCompleteFirstAndThirdRow() {
		
		try {
			board.setPiece(new PieceO(), 0, 0);
			board.setPiece(new PieceO(), 0, 1);
			board.setPiece(new PieceO(), 0, 2);
			board.setPiece(new PieceO(), 2, 0);
			board.setPiece(new PieceO(), 2, 1);
			board.setPiece(new PieceO(), 2, 2);
			
			assertThat(board.boardComplete(), is(false));	
			
		} catch(Exception e) {
			Assert.fail("Movimiento no valido");
		}
	}
	
	@Test
	public void testBoardNotCompleteSecondRow() {
		
		try {
			board.setPiece(new PieceO(), 1, 0);
			board.setPiece(new PieceO(), 1, 1);
			board.setPiece(new PieceO(), 1, 2);
			
			assertThat(board.boardComplete(), is(false));	
			
		} catch(Exception e) {
			Assert.fail("Movimiento no valido");
		}
	}
	
	@Test
	public void testBoardNotCompleteSecondAndThirdRow() {
		
		try {
			board.setPiece(new PieceO(), 1, 0);
			board.setPiece(new PieceO(), 1, 1);
			board.setPiece(new PieceO(), 1, 2);
			board.setPiece(new PieceO(), 2, 0);
			board.setPiece(new PieceO(), 2, 1);
			board.setPiece(new PieceO(), 2, 2);
			
			assertThat(board.boardComplete(), is(false));	
			
		} catch(Exception e) {
			Assert.fail("Movimiento no valido");
		}
	}
	
	@Test
	public void testBoardNotCompleteThirdRow() {
		
		try {
			board.setPiece(new PieceO(), 2, 0);
			board.setPiece(new PieceO(), 2, 1);
			board.setPiece(new PieceO(), 2, 2);
			
			assertThat(board.boardComplete(), is(false));	
			
		} catch(Exception e) {
			Assert.fail("Movimiento no valido");
		}
	}
	
	@Test
	public void testBoardComplete() {
		
		try {
			board.setPiece(new PieceO(), 0, 2);
			board.setPiece(new PieceO(), 1, 2);
			board.setPiece(new PieceO(), 2, 2);
			board.setPiece(new PieceX(), 0, 1);
			board.setPiece(new PieceX(), 1, 1);
			board.setPiece(new PieceX(), 2, 1);
			board.setPiece(new PieceO(), 0, 0);
			board.setPiece(new PieceO(), 1, 0);
			board.setPiece(new PieceO(), 2, 0);
			
			assertThat(board.boardComplete(), is(true));	
			
		} catch(Exception e) {
			Assert.fail("Movimiento no valido");
		}
	}
}
