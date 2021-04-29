package com.netitjava;

import com.netitjava.gameboard.pieces.Piece;
import com.netitjava.managers.GameManager;

public class Application {

	public static void main(String[] args) {

		GameManager game = new GameManager();
		game.startGame();
	}
}
