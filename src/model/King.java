package model;

import animation.Sprite;

/**
 * This class models a King object in a game of Chess
 * 
 * @author jaime
 *
 */
public class King extends Piece {

	private boolean hasMoved;

	/**
	 * Constructor for a King object
	 * 
	 * @param color the color of this piece
	 */
	public King(PieceColor color) {
		super(color);
		possibleMovementAngles = new double[] { -1, 0, 45 };
		hasMoved = false;
		
		String imageFilepath;
		if (color == PieceColor.BLACK) {
			imageFilepath = "images/king_black.png";
		} else {
			imageFilepath = "images/king_white.png";
		}
		sprite = new Sprite(imageFilepath, SQUARE_SIZE);
	}

	@Override
	public boolean canMove(BoardPosition newPosition) {
		// check the cases that apply to every type of piece
		if (!super.canMove(newPosition)) {
			return false;
		}

		// cannot move more than 1 spaces
		if (position.getDistance(newPosition) >= 2) {
			return false;
		}

		return true;
	}

	@Override
	public boolean move(BoardPosition newPosition) {
		if (castle(newPosition)) {
			hasMoved = true;
			return true;
		}

		if (super.move(newPosition)) {
			hasMoved = true;
			return true;
		}

		return false;
	}

	/**
	 * Checks if castling applies to the input positions
	 * 
	 * @param position the current position of this piece on the board
	 * @param newPosition     the new position of this piece on the board
	 * @return true if the conditions are met, false otherwise
	 */
	private boolean canCastle(BoardPosition newPosition) {
		// check that the selected piece is a Rook of the same color
		if (!(newPosition.getPiece() instanceof Rook) || newPosition.getPiece().getColor() != color) {
			return false;
		}

		// make sure that neither piece has moved
		if (hasMoved || ((Rook) newPosition.getPiece()).hasMoved) {
			return false;
		}

		// check spaces between to make sure that they are empty
		if (position.getX() > newPosition.getX()) {
			for (int i = newPosition.getX() + 1; i < position.getX(); i++) {
				if (!Board.getBoard()[position.getY()][i].isEmpty()) {
					return false;
				}
			}
		} else {
			for (int i = position.getX() + 1; i < newPosition.getX(); i++) {
				if (!Board.getBoard()[position.getY()][i].isEmpty()) {
					return false;
				}
			}
		}

		// make sure that the king is not in check
		// TODO

		return true;
	}

	/**
	 * Performs castling if this piece meets the conditions
	 * 
	 * @param position the current position of this piece on the board
	 * @param newPosition     the new position of this piece on the board
	 * @return true if the movement was successful, false otherwise
	 */
	private boolean castle(BoardPosition newPosition) {
		if (canCastle(newPosition)) {
			BoardPosition oldKingPos = getPosition();
			BoardPosition oldRookPos = newPosition; 
			if (position.getX() > newPosition.getX()) {
				Board.getBoard()[position.getY()][position.getX() - 2].setPiece(this);
				Board.getBoard()[newPosition.getY()][newPosition.getX() + 3].setPiece(newPosition.getPiece());
			} else {
				Board.getBoard()[position.getY()][position.getX() + 2].setPiece(this);
				Board.getBoard()[newPosition.getY()][newPosition.getX() - 2].setPiece(newPosition.getPiece());
			}
			oldKingPos.setPiece(null);
			oldRookPos.setPiece(null);
			return true;
		}

		return false;
	}

}