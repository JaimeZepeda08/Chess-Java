package model;

import animation.Sprite;

/**
 * This class models a Pawn object in a game of Chess
 * 
 * @author jaime
 *
 */
public class Pawn extends Piece {

	private boolean hasMoved;

	/**
	 * Constructor for a Pawn object
	 * 
	 * @param color the color of this piece
	 */
	public Pawn(PieceColor color) {
		super(color);
		possibleMovementAngles = new double[] { -1, 45 };
		hasMoved = false;
		
		String imageFilepath;
		if (color == PieceColor.BLACK) {
			imageFilepath = "images/pawn_black.png";
		} else {
			imageFilepath = "images/pawn_white.png";
		}
		sprite = new Sprite(imageFilepath, SQUARE_SIZE);
	}

	@Override
	public boolean canMove(BoardPosition newPosition) {
		// check the cases that apply to every type of piece
		if (!super.canMove(newPosition)) {
			return false;
		}

		// special case: to move in a diagonal check that the player can capture an
		// opponent's piece
		if (position.getAngle(newPosition) == 45) {
			if (!canCapture(newPosition)) {
				return false;
			}
		}

		// special case: pawn cannot capture moving forward
		if (position.getAngle(newPosition) == -1) {
			if (canCapture(newPosition)) {
				return false;
			}
		}

		// check that this piece is moving forward
		if (color == PieceColor.WHITE) {
			if (position.getY() < newPosition.getY()) {
				return false;
			}
		} else if (color == PieceColor.BLACK) {
			if (position.getY() > newPosition.getY()) {
				return false;
			}
		}

		// the pawn can only move two spaces on its first turn
		if (position.getDistance(newPosition) == 2) {
			if (hasMoved) {
				return false;
			}
		}

		// cannot move more than 2 spaces
		if (position.getDistance(newPosition) > 2) {
			return false;
		}

		return true;
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
