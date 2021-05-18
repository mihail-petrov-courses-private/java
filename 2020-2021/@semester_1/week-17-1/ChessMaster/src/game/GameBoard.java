package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import gameboardobjects.contracts.GameBoardObjectDimention;
import gameboardobjects.contracts.GameObjectColorEnum;
import gameboardobjects.parents.GameBoardObject;
import gameboardobjects.parents.Piece;
import gameboardobjects.piece.Bishop;
import gameboardobjects.piece.King;
import gameboardobjects.piece.Knight;
import gameboardobjects.piece.Pawn;
import gameboardobjects.piece.Queen;
import gameboardobjects.piece.Rook;
import gameboardobjects.tile.Tile;

public class GameBoard extends JPanel implements MouseListener {

	private final int GAME_GOARD_ROW_COUNT = 8;
	private final int GAME_GOARD_COL_COUNT = 8;
	
	private GameBoardObject[][] gameBoard;
	private Piece selectedPiece;
	
	public GameBoard() {
		this.bootstrap();
		
		this.addMouseListener(this);
		
		//this.setVisible(true);
		//this.setSize(640, 640);
	}

	public void bootstrap() {
		
		this.gameBoard = new GameBoardObject[GAME_GOARD_ROW_COUNT][GAME_GOARD_COL_COUNT];
		
		// manage all Tiles
		for(int row = 0; row < GAME_GOARD_ROW_COUNT; row++) {
			for(int col = 0; col < GAME_GOARD_COL_COUNT; col++) {
				
				GameObjectColorEnum tileColor = getTileColor(row, col);
				this.gameBoard[row][col] = new Tile(row, col, tileColor); 
			}	
		}
		
		// manage all Pawns
		for(int col = 0; col < GAME_GOARD_COL_COUNT; col++) {
			this.gameBoard[6][col] = new Pawn(6, col, GameObjectColorEnum.BLACK);
			this.gameBoard[1][col] = new Pawn(1, col, GameObjectColorEnum.WHITE);
		}
		
		this.gameBoard[0][0] = new Rook(0, 0, GameObjectColorEnum.WHITE);
		this.gameBoard[0][7] = new Rook(0, 7, GameObjectColorEnum.WHITE);
		
		this.gameBoard[0][1] = new Knight(0, 1, GameObjectColorEnum.WHITE);
		this.gameBoard[0][6] = new Knight(0, 6, GameObjectColorEnum.WHITE);
		
		this.gameBoard[0][2] = new Bishop(0, 2, GameObjectColorEnum.WHITE);
		this.gameBoard[0][5] = new Bishop(0, 5, GameObjectColorEnum.WHITE);
		
		this.gameBoard[0][3] = new King(0, 3, GameObjectColorEnum.WHITE);
		this.gameBoard[0][4] = new Queen(0, 4, GameObjectColorEnum.WHITE);
		
		this.gameBoard[7][0] = new Rook(7, 0, GameObjectColorEnum.BLACK);
		this.gameBoard[7][7] = new Rook(7, 7, GameObjectColorEnum.BLACK);
		
		this.gameBoard[7][1] = new Knight(7, 1, GameObjectColorEnum.BLACK);
		this.gameBoard[7][6] = new Knight(7, 6, GameObjectColorEnum.BLACK);
		
		this.gameBoard[7][2] = new Bishop(7, 2, GameObjectColorEnum.BLACK);
		this.gameBoard[7][5] = new Bishop(7, 5, GameObjectColorEnum.BLACK);
		
		this.gameBoard[7][3] = new King(7, 3, GameObjectColorEnum.BLACK);
		this.gameBoard[7][4] = new Queen(7, 4, GameObjectColorEnum.BLACK);		
	}
	
	@Override
	public void paint(Graphics g) {

		super.paint(g);
		
		for(int row = 0; row < GAME_GOARD_ROW_COUNT; row++) {
			for(int col = 0; col < GAME_GOARD_COL_COUNT; col++) {
				this.gameBoard[row][col].render(g);		
			}	
		}	
	}
	
	private GameObjectColorEnum getTileColor(int row, int col) {
		
		boolean isRowColEven = (row % 2 == 0) && (col % 2 == 0);
		boolean isRowColOdd  = (row % 2 != 0) && (col % 2 != 0);
		
		if(isRowColEven || isRowColOdd) {
			return GameObjectColorEnum.BLACK;
		}
		
		return GameObjectColorEnum.WHITE;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		int row = getGameBoardRowBasedOnCoordinates(e.getY());
		int col = getGameBoardRowBasedOnCoordinates(e.getX());
		
		GameBoardObject selectedElement = this.getGameBoardObject(row, col);
		
		if(this.isSelectionPosible(selectedElement)) {
			this.setSelectedPiece((Piece) selectedElement);
		}
		
		if(this.isAttackPosible(selectedElement, row, col)) {

			this.moveSelectedPiece(row, col);
			this.repaint(); // re render the whole component
		}
		
		if(this.isMovePosible(selectedElement, row, col)) {

			this.moveSelectedPiece(row, col);
			this.repaint(); // re render the whole component
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	private int getGameBoardRowBasedOnCoordinates(int coordinates) {
		return coordinates / GameBoardObjectDimention.SIZE;
	}
	
	private boolean isTile(GameBoardObject instance) {
		return instance instanceof Tile;
	}
	
	private boolean isPiece(GameBoardObject instance) {
		return instance instanceof Piece;
	}
	
	private GameBoardObject getGameBoardObject(int row, int col) {
		return this.gameBoard[row][col];
	}
	
	private void setSelectedPiece(Piece element) {
		this.selectedPiece = element;
	}
	
	private Piece getSelectedPiece() {
		return this.selectedPiece;
	}	
	
	private boolean isPieceAlreadySelected() {
		return this.selectedPiece != null;
	}
	
	private void moveSelectedPiece(int toRow, int toCol) {
		
		// remove selected piece from original position 
		int originalRow = this.getSelectedPiece().getRow();
		int originalCol = this.getSelectedPiece().getCol();
		this.gameBoard[originalRow][originalCol] = new Tile(originalRow, originalCol, getTileColor(originalRow, originalCol));
		
		// move selected piece object to new position
		this.getSelectedPiece().setRow(toRow);
		this.getSelectedPiece().setCol(toCol);
		this.gameBoard[toRow][toCol] = this.getSelectedPiece();
	}
	
	
	private boolean isMovePosible(GameBoardObject selectedElement, int row, int col) {
	
		return this.isTile(selectedElement) &&
				this.isPieceAlreadySelected() && 
				this.getSelectedPiece().isMovePosible(row, col);
	}
	
	private boolean isAttackPosible(GameBoardObject selectedElement, int row, int col) {
		
		return this.isPiece(selectedElement) &&
				this.isPieceAlreadySelected() && 
				this.getSelectedPiece().isAttackPosible(row, col);
	}	
	
	private boolean isSelectionPosible(GameBoardObject selectedElement) {
		
		return 	this.isPiece(selectedElement) &&
				!this.isPieceAlreadySelected();
	}
}
