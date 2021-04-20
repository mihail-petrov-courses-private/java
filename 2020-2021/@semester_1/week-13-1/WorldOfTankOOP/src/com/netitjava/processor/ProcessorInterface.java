package com.netitjava.processor;

import com.netitjava.board.GameBoard;

public interface ProcessorInterface {

	public GameBoard process(GameBoard gameBoard, String actionKey);
}
