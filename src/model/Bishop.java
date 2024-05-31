package model;

import animation.Sprite;

/**
 * This class models a Bishop object in a game of chess
 * 
 * @author jaime
 *
 */
public class Bishop extends Piece {

	/**
	 * this is the constructor for a bishop piece
	 * 
	 * @param color the color of this piece
	 */
	public Bishop(PieceColor color) {
		super(color);
		possibleMovementAngles = new double[] { 45 };
		
		String imageFilepath;
		if (color == PieceColor.BLACK) {
			imageFilepath = "images/bishop_black.png";
		} else {
			imageFilepath = "images/bishop_white.png";
		}
		sprite = new Sprite(imageFilepath, SQUARE_SIZE);
	}

}
