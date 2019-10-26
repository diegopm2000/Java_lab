package es.poc.tictactoe.core.util;

import static com.shazam.shazamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNull.nullValue;

import org.dozer.MappingException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import es.poc.domain.tictactoe.core.Board;
import es.poc.domain.tictactoe.core.util.BoardCustomConverter;
import es.poc.tictactoe.core.DozerMapperTest;

public class BoardCustomConverterTest {
	
	@Rule
	public final ExpectedException exception = ExpectedException.none();

	private BoardCustomConverter customConverter;
	
	@Before
	public void init() {
		
		customConverter = new BoardCustomConverter();
	}
	
	@Test
	public void testBoardSourceNull() {
						
		Board boardSource = null;
		Board boardDestination = new Board();
		
		assertThat(customConverter.convert(boardDestination, boardSource, Board.class,  Board.class), is(nullValue()));		
	}
	
	@Test
	public void testSourceWrongClass() {
		
		String wrongSource = "hola";
		Board boardDestination = new Board();
		
		exception.expect(MappingException.class);
		customConverter.convert(boardDestination, wrongSource, Board.class,  Board.class);		
	}
	
	@Test
	public void testDestinationNull() {
		
		Board boardSource = new Board();
		Board boardDestination = null;
		
		Board boardResult = (Board) customConverter.convert(boardDestination, boardSource, Board.class,  Board.class);
		
		DozerMapperTest.testCopyBoard(boardSource, boardResult);	
	}
	
	@Test
	public void testDestinationNotNull() {
		
		Board boardSource = new Board();
		Board boardDestination = new Board();
		
		Board boardResult = (Board) customConverter.convert(boardDestination, boardSource, Board.class,  Board.class);
		
		DozerMapperTest.testCopyBoard(boardSource, boardResult);	
	}
}
