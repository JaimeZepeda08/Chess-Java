package model;

import animation.Sprite;
import utility.Point2D;

/**
 * This class models a Knight object in a game of chess
 * 
 * @author jaime
 *
 */
public class Knight extends Piece {
	
	
	/**
	 * this is the constructor for a knight piece
	 * 
	 * @param color the color of this piece
	 */
	public Knight(PieceColor color) {
		super(color);
		possibleMovementAngles = new double[] { Math.toDegrees(Math.atan(2)), Math.toDegrees(Math.atan(0.5)) };

		String imageFilepath;
		if (color == PieceColor.BLACK) {
			imageFilepath = "images/knight_black.png";
		} else {
			imageFilepath = "images/knight_white.png";
		}
		sprite = new Sprite(imageFilepath, SQUARE_SIZE);
	}

	@Override
	public boolean canMove(BoardPosition newPosition) {
		// check the cases that apply to every type of piece
		if (!super.canMove(newPosition)) {
			return false;
		}

		// check that the distance moved is correct
		double correctDistance = new Point2D(0, 0).getDistance(new Point2D(1, 2));
		if (position.getDistance(newPosition) != correctDistance) {
			return false;
		}

		return true;
	}

}