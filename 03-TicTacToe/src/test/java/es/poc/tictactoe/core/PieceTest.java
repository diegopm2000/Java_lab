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

public class PieceTest {

	private Piece pieceX;
	private Piece pieceO;
	
	@Before
	public void init() {
		
		this.pieceX = new PieceX();
		this.pieceO = new PieceO();
	}
	
	@Test
    public void testCreationDefault() {
		
		assertThat(pieceX, is(notNullValue()));		
		assertThat(pieceX.getPieceType(), is(PieceType.X));		
		
		assertThat(pieceO, is(notNullValue()));
		assertThat(pieceO.getPieceType(), is(PieceType.O));	
	}
	
	@Test
	public void testIsX() {
		
		assertThat(pieceX.isX(), is(true));
		assertThat(pieceO.isX(), is(false));
	}
	
	@Test
	public void testIsO() {
		
		assertThat(pieceO.isO(), is(true));
		assertThat(pieceX.isO(), is(false));
	}
	
	@Test
	public void testToString() {
		
		assertThat(pieceX.toString(), is(" X "));
		assertThat(pieceO.toString(), is(" O "));
	}
		
}
