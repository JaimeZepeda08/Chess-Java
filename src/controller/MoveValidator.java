package controller;

import java.util.ArrayList;

import model.Board;
import model.BoardPosition;
import model.King;
import model.Piece;
import model.PieceColor;
import utility.Path;

public class MoveValidator {

	private static King blackKing;
	private static King whiteKing;
	private static ArrayList<Piece> blackPieces;
	private static ArrayList<Piece> whitePieces;

	public static void init() {
		BoardPosition[][] board = Board.getBoard();
		blackPieces = new ArrayList<Piece>();
		whitePieces = new ArrayList<Piece>();

		// get each team's pieces
		// BLACK
		{
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < Board.SIZE; j++) {
					if (board[i][j].getPiece() instanceof King) {
						blackKing = (King) board[i][j].getPiece();
					} else {
						blackPieces.add(board[i][j].getPiece());
					}
				}
			}
		}
		// WHITE
		{
			for (int i = 6; i < 8; i++) {
				for (int j = 0; j < Board.SIZE; j++) {
					if (board[i][j].getPiece() instanceof King) {
						whiteKing = (King) board[i][j].getPiece();
					} else {
						whitePieces.add(board[i][j].getPiece());
					}
				}
			}
		}
	}

	public static void remove(Piece piece, PieceColor color) {
		if (color == PieceColor.BLACK) {
			blackPieces.remove(piece);
		} else {
			whitePieces.remove(piece);
		}
	}

	public static boolean isInCheck(PieceColor color) {
		if (color == PieceColor.BLACK) {
			for (Piece piece : whitePieces) {
				if (piece.canMove(blackKing.getPosition())) {
					return true;
				}
			}
		} else {
			for (Piece piece : blackPieces) {
				if (piece.canMove(whiteKing.getPosition())) {
					return true;
				}
			}
		}

		return false;
	}

	public static boolean checkmate(PieceColor color) {
		// Get all the king's possible movements
		int[][] kingMovements = new int[][] { new int[] { 0, 1 }, new int[] { 0, -1 }, new int[] { 1, 0 },
				new int[] { -1, 0 }, new int[] { 1, 1 }, new int[] { -1, -1 }, new int[] { 1, -1 },
				new int[] { -1, 1 }, };

		// get the king of the color that we are going to check
		King king;
		if (color == PieceColor.BLACK) {
			king = blackKing;
		} else {
			king = whiteKing;
		}

		// iterate through the king's movements
		for (int i = 0; i < kingMovements.length; i++) {
			int newX = king.getPosition().getX() + kingMovements[i][1];
			int newY = king.getPosition().getY() + kingMovements[i][0];
			// if the new position is not in within the bound of the board, skip
			if (newX < 0 || newX > 7 || newY < 0 || newY > 7) {
				continue;
			}
			// save the current and new position
			BoardPosition newPosition = Board.getBoard()[newY][newX];
			BoardPosition oldPosition = king.getPosition();
			if (!newPosition.isEmpty()) {
				// save the piece at the new position
				Piece temp = newPosition.getPiece();
				if (king.move(newPosition)) {
					if (!isInCheck(color)) {
						king.move(oldPosition);
						return false;
					}
				}
			} else {
				if (king.move(newPosition)) {
					if (!isInCheck(color)) {
						king.move(oldPosition);
						return false;
					}
				}
			}
		}

		// check if any other piece can be moved
		/**
		 * Get the path of the piece that is checking the king to the king check if any
		 * other piece can be moved to a position on the path check if any movement
		 * causes another check
		 */
		if (color == PieceColor.BLACK) {
			for (Piece Wpiece : whitePieces) {
				if (Wpiece.canMove(king.getPosition())) {
					Path<BoardPosition> path = Board.getPath(Wpiece.getPosition(), king.getPosition(), true);
					while (!path.isEmpty()) {
						BoardPosition pos = path.dequeue();
						for (Piece Bpiece : blackPieces) {
							// TODO
						}
					}
				}
			}
		} else {

		}

		return true;
	}

}
