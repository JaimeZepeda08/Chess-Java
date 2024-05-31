package model;

import animation.Sprite;

/**
 * This class models a Rook object in a game of Chess
 * 
 * @author jaime
 *
 */
public class Rook extends Piece {

	protected boolean hasMoved;

	/**
	 * Constructor for a Rook object
	 * 
	 * @param color the color of this piece
	 */
	public Rook(PieceColor color) {
		super(color);
		possibleMovementAngles = new double[] { -1, 0 };
		hasMoved = false;

		String imageFilepath;
		if (color == PieceColor.BLACK) {
			imageFilepath = "images/rook_black.png";
		} else {
			imageFilepath = "images/rook_white.png";
		}
		sprite = new Sprite(imageFilepath, SQUARE_SIZE);
	}

	@Override
	public boolean move(BoardPosition newPosition) {
		if (super.move(newPosition)) {
			hasMoved = true;
			return true;
		}
		return false;
	}

}
