package controller;

import application.Main;
import model.Board;
import model.BoardPosition;
import model.Piece;
import model.PieceColor;

/**
 * 
 * 
 * @author jaime 
 */
public class GameController {
	
	private static GameState gameState= GameState.WHITETURN; // initial game state

	private static Piece piece = null; // the currently selected piece
	private static BoardPosition position = null; // the currently selected new position

	/**
	 * 
	 * 
	 * @param row
	 * @param col
	 */
	public static void selectPiece(int row, int col) {
		// if no piece has been selected yet, set this is the current piece
		if (piece != null) {
			position = Board.getBoard()[row][col];
			return;
		}
		
		if (!Board.getBoard()[row][col].isEmpty()) {
			if (gameState == GameState.BLACKTURN){
				if (Board.getBoard()[row][col].getPiece().getColor() == PieceColor.BLACK){
					piece = Board.getBoard()[row][col].getPiece();
					piece.getSprite().selectPiece();
				}
			} else if (gameState == GameState.WHITETURN){
				if (Board.getBoard()[row][col].getPiece().getColor() == PieceColor.WHITE){
					piece = Board.getBoard()[row][col].getPiece();	
					piece.getSprite().selectPiece();			
				}
			}
			return;
		}
	}
	
	/**
	 * 
	 * 
	 * @return
	 */
	public static boolean move() {
		if (piece != null && position != null) {
			piece.getSprite().deselectPiece();
			if (piece.canMove(position)){
				if (!position.isEmpty()){
					if (position.getPiece().getColor() != piece.getColor()){
						Main.getPieceGrid().getChildren().remove(position.getPiece().getSprite());
					}
				}
			}
			if (piece.move(position)) {
				piece = null;
				position = null;
				// change the current player's turn
				if (gameState == GameState.WHITETURN){
					gameState = GameState.BLACKTURN;
				} else{
					gameState = GameState.WHITETURN;
				}
				Main.changeTitle(gameState);
				return true;
			}
			piece = null;
			position = null;
		}
		return false;
	}
}