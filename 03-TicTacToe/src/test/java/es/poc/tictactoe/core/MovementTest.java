package es.poc.tictactoe.core;

import static com.shazam.shazamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

import org.junit.Test;

import es.poc.domain.tictactoe.core.Game.TurnStatus;
import es.poc.domain.tictactoe.core.Movement;

public class MovementTest {
	
	private Movement movement;
	private int row = 1;
	private int col = 2;
	
	@Test
	public void testCreation() {
		
		movement = new Movement(TurnStatus.XTURN, row, col);
		
		assertThat(movement.getTurnStatus(), is(TurnStatus.XTURN));
		assertThat(movement.getRow(), is(row));
		assertThat(movement.getColumn(), is(col));
	}
	
	@Test
	public void testSetters() {
		
		movement = new Movement();
		
		movement.setColumn(col);
		movement.setRow(row);
		movement.setTurnStatus(TurnStatus.XTURN);
		
		assertThat(movement.getTurnStatus(), is(TurnStatus.XTURN));
		assertThat(movement.getRow(), is(row));
		assertThat(movement.getColumn(), is(col));
	}
	
	@Test
	public void testToString() {
		
		movement = new Movement(TurnStatus.XTURN, row, col);
		
		assertThat(movement.toString(), is("Turn: "+movement.getTurnStatus() + " --> Row: "+movement.getRow() + ", Col: "+movement.getColumn()));
	}
	
}
