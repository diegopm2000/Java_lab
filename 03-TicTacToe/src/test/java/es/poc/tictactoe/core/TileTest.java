package es.poc.tictactoe.core;

import static com.shazam.shazamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNull.notNullValue;

import org.junit.Before;
import org.junit.Test;

import es.poc.domain.tictactoe.core.Piece;
import es.poc.domain.tictactoe.core.Piece.PieceType;
import es.poc.domain.tictactoe.core.PieceO;
import es.poc.domain.tictactoe.core.PieceX;
import es.poc.domain.tictactoe.core.Tile;

public class TileTest {
	
	private Tile tile;
	private Piece pieceX;
	private Piece pieceO;
	
	@Before
	public void init() {
		
		tile = new Tile();
		this.pieceX = new PieceX();
		this.pieceO = new PieceO();
	}

	@Test
    public void testCreationDefault() {
		
		assertThat(tile, is(notNullValue()));
		assertThat(tile.isEmpty(), is(true));	
	}
	
	@Test
	public void testgetPieceX() {
		
		this.tile.setPiece(pieceX);
		
		assertThat(tile.getPiece().getPieceType(), is(PieceType.X));  
	}
	
	@Test
	public void testgetPieceO() {
		
		this.tile.setPiece(pieceO);
		
		assertThat(tile.getPiece().getPieceType(), is(PieceType.O));  
	}
	
	@Test
    public void testSetPieceX() {
		
		this.tile.setPiece(pieceX);
		
		assertThat(tile, is(notNullValue()));  
		assertThat(tile.contains(pieceX), is(true));	
		assertThat(tile.contains(pieceO), is(false));
		assertThat(tile.isEmpty(), is(false));
	}
	
	@Test
    public void testSetPieceO() {
		
		this.tile.setPiece(pieceO);
		
		assertThat(tile, is(notNullValue()));  
		assertThat(tile.contains(pieceO), is(true));	
		assertThat(tile.contains(pieceX), is(false));
		assertThat(tile.isEmpty(), is(false));
	}
	
	@Test
	public void testToString() {
		
		assertThat(tile.toString(), is(" - "));
		
		this.tile.setPiece(pieceX);
		assertThat(tile.toString(), is(" X "));
		
		this.tile.setPiece(pieceO);
		assertThat(tile.toString(), is(" O "));
	}
}
