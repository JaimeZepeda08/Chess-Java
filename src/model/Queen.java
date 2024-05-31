package model;

import animation.Sprite;

/**
 * This class models a Queen object in a game of chess
 * 
 * @author jaime
 *
 */
public class Queen extends Piece {

	
	/**
	 * this is the constructor for a queen piece
	 * 
	 * @param color the color of this piece
	 */
	public Queen(PieceColor color) {
		super(color);
		possibleMovementAngles = new double[] { -1, 0, 45 };
		
		String imageFilepath;
		if (color == PieceColor.BLACK) {
			imageFilepath = "images/queen_black.png";
		} else {
			imageFilepath = "images/queen_white.png";
		}
		sprite = new Sprite(imageFilepath, SQUARE_SIZE);
	}

}
