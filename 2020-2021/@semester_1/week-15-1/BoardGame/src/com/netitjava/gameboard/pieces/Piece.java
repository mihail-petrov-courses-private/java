package com.netitjava.gameboard.pieces;

import com.netitjava.gameboard.GameBoardObject;

public abstract class Piece extends GameBoardObject {

	protected int row;
	protected int col;
	
	protected int attack;
	protected int deffence;
	protected int health;
	protected int distance;
	protected int speed;
	
	public Piece(int row, int col, int attack, int deffence, int health, int distance, int speed) {

		super(row, col);
		
		this.row = row;
		this.col = col;
		
		this.attack = attack;
		this.deffence = deffence;
		this.health = health;
		this.distance = distance;
		this.speed = speed;
	}
	public int getAttack() {
		return attack;
	}
	public void setAttack(int attack) {
		this.attack = attack;
	}
	public int getDeffence() {
		return deffence;
	}
	public void setDeffence(int deffence) {
		this.deffence = deffence;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}	
	
	public void move(int row, int col) {
		this.row = row;
		this.col = col;
	}
	
	public abstract boolean isMovePossible(int row, int col);
	public abstract void isAttackPossible();
	public abstract void isHealPossible();
	
	public abstract String getPieceName();
}