package es.poc.domain.tictactoe.core.ia;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;

import es.poc.domain.tictactoe.core.Board;
import es.poc.domain.tictactoe.core.Game;
import es.poc.domain.tictactoe.core.Game.MovValidationResult;
import es.poc.domain.tictactoe.core.Game.TurnStatus;
import es.poc.domain.tictactoe.core.Movement;

public class MovementCalculation {
	
	//PROPERTIES
	
	private DozerBeanMapper mapper;
	
	private Movement movement;
	
	//CONSTRUCTORS
	
	public MovementCalculation() {
		
		List<String> list = new ArrayList<>();
		list.add("dozer-mapping.xml");
		
		mapper = new DozerBeanMapper();
		mapper.setMappingFiles(list);
	}
	
	//GETTERS AND SETTERS

	public Movement getMovement() {
		return movement;
	}
		
	//METHODS
	
	public MovementCalculation calculateMiniMax(Game game) {
		
		if (game.isInGame()) {			
			this.miniMax(game, game.getTurnStatus());
		} else {
			this.movement = null;
		}
		return this;
	}

	private int miniMax(Game game, TurnStatus initialTurnStatus) {
						
		if (!game.isInGame()) {
		
			return getScore(game, initialTurnStatus);			
		} else {
		
			List<Integer> scoreList = new ArrayList<>();
			List<Movement> movementList = new ArrayList<>();
			
			for (Movement movementIndex: getAvailableMovements(game)) {
				
				Game possibleGame = mapper.map(game, Game.class);
				possibleGame.move(movementIndex);
				scoreList.add(miniMax(possibleGame,initialTurnStatus));
				movementList.add(movementIndex);
			}
			
			if (game.getTurnStatus() == initialTurnStatus) {	
				
				int indexMaxScore = getMaxIndex(scoreList);
				this.movement = movementList.get(indexMaxScore);
				
				return scoreList.get(indexMaxScore);
				
			} else {
			
				int indexMinScore = getMinIndex(scoreList);
				this.movement = movementList.get(indexMinScore);
					
				return scoreList.get(indexMinScore);
			}
		}
	}
	
	private int getMaxIndex(List<Integer> integerList) {
		
		int indexResult = 0;
		int valueResult = -1000;
		
		for (int i=0;i<integerList.size(); i++) {
			
			Integer valueIndex = integerList.get(i);
			
			if (valueIndex.intValue() >= valueResult) {						
				valueResult = valueIndex.intValue();
				indexResult = i;
			}
		}
		
		return indexResult;
	}
	
	private int getMinIndex(List<Integer> integerList) {
		
		int indexResult = 0;
		int valueResult = 1000; //value big enough at starting 
		
		for (int i=0;i<integerList.size(); i++) {
			
			Integer valueIndex = integerList.get(i);
			
			if (valueIndex.intValue() <= valueResult) {		
				valueResult = valueIndex.intValue();
				indexResult = i;
			}
		}
		
		return indexResult;
	}
	
	/**
	 * Get all available movements for a game state
	 * 
	 * @param game
	 * @return
	 */
	private List<Movement> getAvailableMovements(Game game) {
	
		List<Movement> resultList = new ArrayList<>();
			
		for (int i=0;i<Board.MAX_ROWS;i++) {			
			for (int j=0; j<Board.MAX_COLS;j++) {
					
				Movement movementCandidate = new Movement(game.getTurnStatus(),i, j);
				if (game.checkMove(movementCandidate).equals(MovValidationResult.OK)) {
					resultList.add(movementCandidate);
				}
			}
		}
							
		return resultList;
	}
	
	/**
	 * Getting the score for a game state
	 * 
	 * @param game
	 * @param playerActual
	 * @return
	 */
	private int getScore(Game game, TurnStatus initialTurnStatus) {
		
		if (game.isXWins()) {
			
			if (TurnStatus.XTURN == initialTurnStatus) {
				return 10;
			} else {
				return -10;
			}
			
		} else if (game.isOWins()) {
			
			if (TurnStatus.OTURN == initialTurnStatus) {
				return 10;
			} else {
				return -10;
			}
			
		} else {
			return 0;
		}
	}
	
}
