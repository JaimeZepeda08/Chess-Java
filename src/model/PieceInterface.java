package model;

/**
 * Interface for a piece object in chess
 * 
 * @author jaime
 *
 */
public interface PieceInterface {

	/**
	 * Gets the color of the piece. Either white or black
	 * 
	 * @return the color of the piece
	 */
	public PieceColor getColor();

	/**
	 * Method that checks if a piece can be moved to a certain location. To be
	 * implemented by each individual class separately as they all have unique
	 * movements
	 * 
	 * @param currentPosition the current position of the piece
	 * @param newPosition     the new position of the piece on the board
	 * @return true if the piece can be moved there, false otherwise
	 */
	public boolean canMove(BoardPosition newPosition);

	/**
	 * Checks if there is a piece from the opponent team at the new position
	 * 
	 * @param newPosition the position where the piece is being moved to
	 * @return true if the piece can capture an opponent's piece
	 */
	public boolean canCapture(BoardPosition newPosition);

	/**
	 * Moves this piece to a new position on the board
	 * 
	 * @param currentPosition the current position of the piece on the board
	 * @param newPosition     the new position on the board where the piece will be
	 *                        moved to
	 * @return true if the movement was successful, false otherwise
	 * @throws IllegalArgumentException if this piece is not at the current position
	 */
	public boolean move(BoardPosition newPosition) throws IllegalArgumentException;
}
