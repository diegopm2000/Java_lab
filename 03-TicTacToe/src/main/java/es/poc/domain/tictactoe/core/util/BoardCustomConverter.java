package es.poc.domain.tictactoe.core.util;


import org.dozer.CustomConverter;
import org.dozer.MappingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.poc.domain.tictactoe.core.Board;
import es.poc.domain.tictactoe.core.PieceO;
import es.poc.domain.tictactoe.core.PieceX;

public class BoardCustomConverter implements CustomConverter {
	
	Logger log = LoggerFactory.getLogger(BoardCustomConverter.class);

	@Override
	public Object convert(Object objboardDestination, Object objboardSource, Class<?> arg2, Class<?> arg3) {
		
		if (objboardSource==null) {
			log.debug("Entrando en el if del source nulo!");
			return null;
		} 
		
		if (objboardSource instanceof Board) {
					
			Board boardDestination;
			
			if (objboardDestination == null) {
				boardDestination = new Board();
			} else {			
				boardDestination = (Board) objboardDestination;
			}
			
			Board boardSource = (Board) objboardSource;
						
			copyBoard(boardDestination, boardSource);
			
			return boardDestination;
		} else {
			throw new MappingException("Converter BoardCustomConverter " + "used incorrectly. Arguments passed in were:" + objboardSource + " and " + objboardDestination);
		}
	}

	private void copyBoard(Board boardDestination, Board boardSource) {
		
		for (int row=0; row<Board.MAX_ROWS; row++) {			
			for (int col=0; col<Board.MAX_COLS; col++) {
									
				if (boardSource.containsX(row, col)) {
					boardDestination.setPiece(new PieceX(), row, col);
				} else if (boardSource.containsO(row, col)){
					boardDestination.setPiece(new PieceO(), row, col);
				} else {
					boardDestination.setEmpty(row, col);
				}
			}
		}
	}
}
