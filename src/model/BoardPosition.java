package model;

import utility.Point2D;

/**
 * This class represent a position or tile in a chess board
 * 
 * @author jaime
 *
 */
public class BoardPosition extends Point2D {

	private Piece piece; // keeps track of the piece stored at this position

	/**
	 * Constructor for a board position object
	 * 
	 * @param x the x coordinate
	 * @param y the y coordinate
	 */
	public BoardPosition(int x, int y) {
		super(x, y);
		piece = null;
	}

	/**
	 * Getter method for the piece stored at this position
	 * 
	 * @return the piece at this position
	 */
	public Piece getPiece() {
		return piece;
	}

	/**
	 * Setter method for the piece stored at this position
	 * 
	 * @param piece the new piece that is going to be stored at this board position
	 */
	public void setPiece(Piece piece) {
		this.piece = piece;
		if (piece != null) {
			piece.setPosition(this);
		}
	}

	/**
	 * Checks if this position is empty (i.e. no piece is being stored)
	 * 
	 * @return true if empty, false otherwise
	 */
	public boolean isEmpty() {
		if (piece == null) {
			return true;
		}
		return false;
	}
}
