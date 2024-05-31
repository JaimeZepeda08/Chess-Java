package model;

import controller.MoveValidator;
import utility.Path;

/**
 * This class represents the board of a game of chess
 * 
 * @author jaime
 *
 */
public class Board {

	public static final int SIZE = 8; // number of tiles in the board
	private static BoardPosition[][] board = new BoardPosition[SIZE][SIZE];; // array that represents the board

	/**
	 * This method initializes the board and the initial initialPositions of the
	 * pieces
	 */
	public static void init() {
		// initialize empty initialPositions
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				board[i][j] = new BoardPosition(j, i);
			}
		}

		// set the initial initialPositions of the pieces

		// BLACK
		board[0][0].setPiece(new Rook(PieceColor.BLACK));
		board[0][1].setPiece(new Knight(PieceColor.BLACK));
		board[0][2].setPiece(new Bishop(PieceColor.BLACK));
		board[0][3].setPiece(new Queen(PieceColor.BLACK));
		board[0][4].setPiece(new King(PieceColor.BLACK));
		board[0][5].setPiece(new Bishop(PieceColor.BLACK));
		board[0][6].setPiece(new Knight(PieceColor.BLACK));
		board[0][7].setPiece(new Rook(PieceColor.BLACK));
		for (int i = 0; i < SIZE; i++) {
			board[1][i].setPiece(new Pawn(PieceColor.BLACK));
		}

		// WHITE
		board[7][0].setPiece(new Rook(PieceColor.WHITE));
		board[7][1].setPiece(new Knight(PieceColor.WHITE));
		board[7][2].setPiece(new Bishop(PieceColor.WHITE));
		board[7][3].setPiece(new Queen(PieceColor.WHITE));
		board[7][4].setPiece(new King(PieceColor.WHITE));
		board[7][5].setPiece(new Bishop(PieceColor.WHITE));
		board[7][6].setPiece(new Knight(PieceColor.WHITE));
		board[7][7].setPiece(new Rook(PieceColor.WHITE));
		for (int i = 0; i < SIZE; i++) {
			board[6][i].setPiece(new Pawn(PieceColor.WHITE));
		}

		MoveValidator.init();
	}

	/**
	 * Getter method for the board array
	 * 
	 * @return the array of initialPositions that represent the board of the game
	 */
	public static BoardPosition[][] getBoard() {
		return board;
	}

	/**
	 * This method gets the path of board initialPositions between two
	 * initialPositions on the board
	 * 
	 * @param initialPosition the initial position of the path
	 * @param finalPosition   the final position of the path
	 * @param includeInitial  whether the first position should be included in the
	 *                        path
	 * @return a path object that contains all the positions between the two
	 *         specified positions
	 */
	public static Path<BoardPosition> getPath(BoardPosition initialPosition, BoardPosition finalPosition,
			boolean includeInitial) {
		Path<BoardPosition> path = new Path<>();
		int start;
		if (includeInitial) {
			start = 0;
		} else {
			start = 1;
		}

		// if the initial and final initialPositions are the same return an empty path
		if (initialPosition.equals(finalPosition)) {
			return path;
		}

		double angle = initialPosition.getAngle(finalPosition);

		if (angle == -1) {
			if (initialPosition.getY() < finalPosition.getY()) {
				for (int i = start; i < finalPosition.getY() - initialPosition.getY(); i++) {
					path.enqueue(board[initialPosition.getY() + i][initialPosition.getX()]);
				}
			} else {
				for (int i = start; i < initialPosition.getY() - finalPosition.getY(); i++) {
					path.enqueue(board[initialPosition.getY() - i][initialPosition.getX()]);
				}
			}
		} else if (angle == 0) {
			if (initialPosition.getX() < finalPosition.getX()) {
				for (int i = start; i < finalPosition.getX() - initialPosition.getX(); i++) {
					path.enqueue(board[initialPosition.getY()][initialPosition.getX() + i]);
				}
			} else {
				for (int i = start; i < initialPosition.getX() - finalPosition.getX(); i++) {
					path.enqueue(board[initialPosition.getY()][initialPosition.getX() - i]);
				}
			}
		} else if (angle == 45) {
			if (initialPosition.getY() < finalPosition.getY()) {
				if (initialPosition.getX() < finalPosition.getX()) {
					for (int i = start; i < finalPosition.getY() - initialPosition.getY(); i++) {
						path.enqueue(board[initialPosition.getY() + i][initialPosition.getX() + i]);
					}
				} else {
					for (int i = start; i < initialPosition.getX() - finalPosition.getX(); i++) {
						path.enqueue(board[initialPosition.getY() + i][initialPosition.getX() - i]);
					}
				}
			} else {
				if (initialPosition.getX() < finalPosition.getX()) {
					for (int i = start; i < finalPosition.getX() - initialPosition.getX(); i++) {
						path.enqueue(board[initialPosition.getY() - i][initialPosition.getX() + i]);
					}
				} else {
					for (int i = start; i < initialPosition.getY() - finalPosition.getY(); i++) {
						path.enqueue(board[initialPosition.getY() - i][initialPosition.getX() - i]);
					}
				}
			}
		} else if (angle == Math.toDegrees(Math.atan(2 / 1)) || angle == Math.toDegrees(Math.atan(1 / 2))) {
			path.enqueue(initialPosition);
			return path;
		}

		return path;
	}

}