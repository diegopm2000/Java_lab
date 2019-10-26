package es.poc.tictactoe.core;

import static com.shazam.shazamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.hamcrest.core.IsNull.nullValue;

import org.junit.Before;
import org.junit.Test;

import es.poc.domain.tictactoe.core.Board;
import es.poc.domain.tictactoe.core.Game;
import es.poc.domain.tictactoe.core.Game.GameStatus;
import es.poc.domain.tictactoe.core.Game.TurnStatus;
import es.poc.domain.tictactoe.core.Movement;
import es.poc.domain.tictactoe.core.ia.MovementCalculation;

public class MovementCalculationTest {
	
	
	private MovementCalculation movementCalculation;
	private Game game;
	
	@Before
	public void init() {
						
		game = new Game(1, new Board(), GameStatus.INGAME, TurnStatus.XTURN);
		movementCalculation = new MovementCalculation();
	}

	@Test
	public void testCalculateFirstMovementInitX() {
		
		assertThat(movementCalculation.calculateMiniMax(game).getMovement(), is(notNullValue()));
	}
	
	@Test
	public void testCalculateFirstMovementInitO() {
		
		game = new Game(1, new Board(), GameStatus.INGAME, TurnStatus.OTURN);
		
		assertThat(movementCalculation.calculateMiniMax(game).getMovement(), is(notNullValue()));
	}
	
	@Test
	public void testDrawInitX() {
		
		//Check movement
		movementCalculation.calculateMiniMax(game).getMovement();
		
		game.move(new Movement(TurnStatus.XTURN,0,0));
		game.move(new Movement(TurnStatus.OTURN,0,2));
		
		game.move(new Movement(TurnStatus.XTURN,0,1));
		game.move(new Movement(TurnStatus.OTURN,1,0));
		
		game.move(new Movement(TurnStatus.XTURN,1,2));
		game.move(new Movement(TurnStatus.OTURN,1,1));
		
		game.move(new Movement(TurnStatus.XTURN,2,0));
		game.move(new Movement(TurnStatus.OTURN,2,1));
		
		//Check movement
		movementCalculation.calculateMiniMax(game).getMovement();
				
		//Force this movement
		game.move(new Movement(TurnStatus.XTURN,2,2));
		
		assertThat(movementCalculation.calculateMiniMax(game).getMovement(), is(nullValue()));
		assertThat(game.getGameStatus(), is(GameStatus.DRAW));
		
		//Check that there is no movement calculation availables!
		movementCalculation.calculateMiniMax(game).getMovement();
		assertThat(movementCalculation.calculateMiniMax(game).getMovement(), is(nullValue()));
	}
	
	@Test
	public void testDrawInitO() {
		
		game = new Game(1, new Board(), GameStatus.INGAME, TurnStatus.OTURN);
		
		//Check movement
		movementCalculation.calculateMiniMax(game).getMovement();
		
		game.move(new Movement(TurnStatus.OTURN,0,2));
		game.move(new Movement(TurnStatus.XTURN,0,0));
		
		game.move(new Movement(TurnStatus.OTURN,1,0));
		game.move(new Movement(TurnStatus.XTURN,0,1));
		
		game.move(new Movement(TurnStatus.OTURN,1,1));
		game.move(new Movement(TurnStatus.XTURN,1,2));
		
		game.move(new Movement(TurnStatus.OTURN,2,1));
		game.move(new Movement(TurnStatus.XTURN,2,0));
		
		//Check movement
		movementCalculation.calculateMiniMax(game).getMovement();
				
		//Force this movement		
		game.move(new Movement(TurnStatus.OTURN,2,2));
		
		assertThat(movementCalculation.calculateMiniMax(game).getMovement(), is(nullValue()));
		assertThat(game.getGameStatus(), is(GameStatus.DRAW));
		
		//Check that there is no movement calculation availables!
		movementCalculation.calculateMiniMax(game).getMovement();
		assertThat(movementCalculation.calculateMiniMax(game).getMovement(), is(nullValue()));
	}
	
	@Test
	public void testWinsXInitX() {
		
		game.move(new Movement(TurnStatus.XTURN,0,0));
		game.move(new Movement(TurnStatus.OTURN,1,0));
		
		game.move(new Movement(TurnStatus.XTURN,0,1));
		
		//Check movement
		movementCalculation.calculateMiniMax(game).getMovement();
				
		//Force this movement
		game.move(new Movement(TurnStatus.OTURN,1,1));
						
		movementCalculation.calculateMiniMax(game).getMovement();
		
		game.move(movementCalculation.getMovement());
		
		assertThat(game.getGameStatus(), is(GameStatus.XWINS));
		
		//Check that there is no movement calculation availables!
		movementCalculation.calculateMiniMax(game).getMovement();
		assertThat(movementCalculation.calculateMiniMax(game).getMovement(), is(nullValue()));
				
	}
	
	@Test
	public void testWinsXInitO() {
		
		game = new Game(1, new Board(), GameStatus.INGAME, TurnStatus.OTURN);
		
		game.move(new Movement(TurnStatus.OTURN,2,0));
		
		game.move(new Movement(TurnStatus.XTURN,0,0));
		game.move(new Movement(TurnStatus.OTURN,1,0));
		
		game.move(new Movement(TurnStatus.XTURN,0,1));
		
		//Check movement
		movementCalculation.calculateMiniMax(game).getMovement();
		
		//Force this movement
		game.move(new Movement(TurnStatus.OTURN,1,1));
						
		movementCalculation.calculateMiniMax(game).getMovement();
		
		game.move(movementCalculation.getMovement());
		
		assertThat(game.getGameStatus(), is(GameStatus.XWINS));
		
		//Check that there is no movement calculation availables!
		movementCalculation.calculateMiniMax(game).getMovement();
		assertThat(movementCalculation.calculateMiniMax(game).getMovement(), is(nullValue()));
				
	}
	
	@Test
	public void testWinsOInitX() {
		
		game.move(new Movement(TurnStatus.XTURN,0,0));
		game.move(new Movement(TurnStatus.OTURN,1,0));
		
		game.move(new Movement(TurnStatus.XTURN,2,0));
		game.move(new Movement(TurnStatus.OTURN,1,1));
		
		game.move(new Movement(TurnStatus.XTURN,2,1));
		
		movementCalculation.calculateMiniMax(game).getMovement();
		
		game.move(movementCalculation.getMovement());
		
		assertThat(game.getGameStatus(), is(GameStatus.OWINS));
		
		//Check that there is no movement calculation availables!
		movementCalculation.calculateMiniMax(game).getMovement();
		assertThat(movementCalculation.calculateMiniMax(game).getMovement(), is(nullValue()));
	}
	
	@Test
	public void testWinsOInitO() {
		
		game = new Game(1, new Board(), GameStatus.INGAME, TurnStatus.OTURN);
		
		game.move(new Movement(TurnStatus.OTURN,0,1));
		
		game.move(new Movement(TurnStatus.XTURN,0,0));
		game.move(new Movement(TurnStatus.OTURN,1,0));
		
		game.move(new Movement(TurnStatus.XTURN,2,0));
		game.move(new Movement(TurnStatus.OTURN,1,1));
		
		game.move(new Movement(TurnStatus.XTURN,2,1));
		
		movementCalculation.calculateMiniMax(game).getMovement();
		
		game.move(movementCalculation.getMovement());
		
		assertThat(game.getGameStatus(), is(GameStatus.OWINS));
		
		//Check that there is no movement calculation availables!
		movementCalculation.calculateMiniMax(game).getMovement();
		assertThat(movementCalculation.calculateMiniMax(game).getMovement(), is(nullValue()));		
	}
	
	@Test
	public void testCompleteGamingAutoInitX() {
		
		while (game.isInGame()) {
		
			movementCalculation.calculateMiniMax(game).getMovement();
			game.move(movementCalculation.getMovement());
		}
		
		//Check that there is no movement calculation availables!
		movementCalculation.calculateMiniMax(game).getMovement();
		assertThat(movementCalculation.calculateMiniMax(game).getMovement(), is(nullValue()));
	}
	
	@Test
	public void testCompleteGamingAutoInitO() {
		
		game = new Game(1, new Board(), GameStatus.INGAME, TurnStatus.OTURN);
		
		while (game.isInGame()) {
		
			movementCalculation.calculateMiniMax(game).getMovement();
			game.move(movementCalculation.getMovement());
		}
		
		//Check that there is no movement calculation availables!
		movementCalculation.calculateMiniMax(game).getMovement();
		assertThat(movementCalculation.calculateMiniMax(game).getMovement(), is(nullValue()));
	}

	@Test
	public void testAbortXwinsInitX() {
		
		game.move(new Movement(TurnStatus.XTURN,0,0));
		game.move(new Movement(TurnStatus.OTURN,2,2));
		
		game.move(new Movement(TurnStatus.XTURN,0,2));
		
		movementCalculation.calculateMiniMax(game).getMovement();
		game.move(movementCalculation.getMovement());
		
		assertThat(game.getGameStatus(), is(GameStatus.INGAME));
				
	}
	
	@Test
	public void testAbortXwinsInitO() {
		
		game = new Game(1, new Board(), GameStatus.INGAME, TurnStatus.OTURN);
		
		game.move(new Movement(TurnStatus.OTURN,2,2));
		movementCalculation.calculateMiniMax(game).getMovement();
		game.move(new Movement(TurnStatus.XTURN,0,0));
		movementCalculation.calculateMiniMax(game).getMovement();
		
		game.move(new Movement(TurnStatus.OTURN,1,1));
		movementCalculation.calculateMiniMax(game).getMovement();
		game.move(new Movement(TurnStatus.XTURN,0,2));
		movementCalculation.calculateMiniMax(game).getMovement();
		
		movementCalculation.calculateMiniMax(game).getMovement();
		game.move(movementCalculation.getMovement());
		
		assertThat(game.getGameStatus(), is(GameStatus.INGAME));
				
	}
}
