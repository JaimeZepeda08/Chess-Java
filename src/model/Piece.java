package model;

import animation.Sprite;
import application.Main;
import controller.MoveValidator;
import utility.Path;

/**
 * This class models the shared behavior between all piece types
 * 
 * @author jaime
 *
 */
public abstract class Piece implements PieceInterface {

	protected BoardPosition position; // position of the piece on the board
	protected PieceColor color; // the color of this piece
	protected double[] possibleMovementAngles; // the list of possible angles that this piece can move in

	protected final double SQUARE_SIZE = Main.HEIGHT / Board.SIZE; 
	protected Sprite sprite; 

	/**
	 * Constructor for the piece class. Cannot be called
	 * 
	 * @param color    the color of this piece (white or black)
	 * @param position the position of the piece on the board
	 */
	public Piece(PieceColor color) {
		this.color = color;
		position = null;
	}

	@Override
	public PieceColor getColor() {
		return color;
	}

	/**
	 * Getter method for the position of the piece
	 * 
	 * @return the position of the piece
	 */
	public BoardPosition getPosition() {
		return position;
	}

	/**
	 * Getter method for this object's sprite
	 * 
	 * @return this piece's sprite
	 */
	public Sprite getSprite(){
		return sprite;
	}

	/**
	 * Sets the position of the piece
	 * 
	 * @param position the position of the piece
	 */
	public void setPosition(BoardPosition position) {
		this.position = position;
		if (position != null){
			sprite.setX(position.getX() * SQUARE_SIZE);
			sprite.setY(position.getY() * SQUARE_SIZE);
		}
	}

	@Override
	public boolean canCapture(BoardPosition newPosition) {
		if (newPosition.isEmpty()) {
			return false;
		} else if (newPosition.getPiece().getColor() != color) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean canMove(BoardPosition newPosition) {
		// check that the current position is not the same as the new position
		if (position.equals(newPosition)) {
			return false;
		}

		// check that this piece is being moved in an allowed angle
		if (!checkMovementAngle(position.getAngle(newPosition))) {
			return false;
		}

		// check that the piece is not being moved to a place that holds a piece of the
		// same color
		if (!newPosition.isEmpty()) {
			if (newPosition.getPiece().getColor() == color) {
				return false;
			}
		}

		// if this piece is a knight, skip this check
		if (!(this instanceof Knight)) {
			// check that the piece is not jumping over any other piece
			Path<BoardPosition> path = Board.getPath(position, newPosition, false);
			while (!path.isEmpty()) {
				BoardPosition currentPosition = path.dequeue();
				if (!currentPosition.isEmpty()) {
					return false;
				}
			}
		}

		return true;
	}

	@Override
	public boolean move(BoardPosition newPosition) throws IllegalArgumentException {
		// check that the piece can be moved to the new position
		if (canMove(newPosition)) {
			position.setPiece(null);
			if (!newPosition.isEmpty()) {
				if (color == PieceColor.BLACK) {
					MoveValidator.remove(newPosition.getPiece(), PieceColor.WHITE);
				} else {
					MoveValidator.remove(newPosition.getPiece(), PieceColor.BLACK);
				}
				newPosition.getPiece().setPosition(null);
			}
			newPosition.setPiece(this);
			return true;
		}
		return false;
	}

	/**
	 * This method checks if the provided angle is in the list of possible movement
	 * angles for this piece
	 * 
	 * @param angleTarget the angle that this piece is trying to move in
	 * @return true if allowed, false otherwise
	 */
	protected boolean checkMovementAngle(double angleTarget) {
		for (double angle : possibleMovementAngles) {
			if (angle == angleTarget) {
				return true;
			}
		}
		return false;
	}
}
