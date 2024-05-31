package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Board;
import model.PieceColor;
import model.Queen;

class QueenTests {

	@Test
	void testMoveForwardOneSpace() {
		Board.init();
		Board.getBoard()[2][3].setPiece(new Queen(PieceColor.WHITE));
		assertTrue(Board.getBoard()[2][3].getPiece().canMove(Board.getBoard()[3][3]));
	}

	@Test
	void testMoveForwardSeveralSpaces() {
		Board.init();
		Board.getBoard()[2][3].setPiece(new Queen(PieceColor.WHITE));
		assertTrue(Board.getBoard()[2][3].getPiece().canMove(Board.getBoard()[5][3]));
	}

	@Test
	void testMoveBackOneSpace() {
		Board.init();
		Board.getBoard()[3][3].setPiece(new Queen(PieceColor.WHITE));
		assertTrue(Board.getBoard()[3][3].getPiece().canMove(Board.getBoard()[2][3]));
	}

	@Test
	void testMoveBackSeveralSpaces() {
		Board.init();
		Board.getBoard()[5][3].setPiece(new Queen(PieceColor.WHITE));
		assertTrue(Board.getBoard()[5][3].getPiece().canMove(Board.getBoard()[2][3]));
	}

	@Test
	void testMoveHorizontallyOneSpace() {
		Board.init();
		Board.getBoard()[2][3].setPiece(new Queen(PieceColor.WHITE));
		assertTrue(Board.getBoard()[2][3].getPiece().canMove(Board.getBoard()[2][4]));
	}

	@Test
	void testMoveHorizontallySeveralSpaces() {
		Board.init();
		Board.getBoard()[2][3].setPiece(new Queen(PieceColor.WHITE));
		assertTrue(Board.getBoard()[2][3].getPiece().canMove(Board.getBoard()[2][0]));
	}

	@Test
	void testMoveDiagonallyOneSpace() {
		Board.init();
		Board.getBoard()[2][3].setPiece(new Queen(PieceColor.WHITE));
		assertTrue(Board.getBoard()[2][3].getPiece().canMove(Board.getBoard()[3][4]));
	}

	@Test
	void testMoveDiagonallySeveralSpaces() {
		Board.init();
		Board.getBoard()[5][7].setPiece(new Queen(PieceColor.WHITE));
		assertTrue(Board.getBoard()[5][7].getPiece().canMove(Board.getBoard()[2][4]));
	}

	@Test
	void testJumpOverPiece() {
		Board.init();
		Board.getBoard()[2][3].setPiece(new Queen(PieceColor.WHITE));
		Board.getBoard()[3][4].setPiece(new Queen(PieceColor.WHITE));
		assertFalse(Board.getBoard()[2][3].getPiece().canMove(Board.getBoard()[5][6]));
	}

	@Test
	void testCaptureOpponentPiece() {
		Board.init();
		Board.getBoard()[2][3].setPiece(new Queen(PieceColor.BLACK));
		assertTrue(Board.getBoard()[2][3].getPiece().canMove(Board.getBoard()[6][7]));
	}

	@Test
	void testMoveToPositionWithSameColor() {
		Board.init();
		Board.getBoard()[2][3].setPiece(new Queen(PieceColor.WHITE));
		assertFalse(Board.getBoard()[2][3].getPiece().canMove(Board.getBoard()[6][7]));
	}

	@Test
	void testMoveNonLinearDirection() {
		Board.init();
		Board.getBoard()[2][3].setPiece(new Queen(PieceColor.BLACK));
		assertFalse(Board.getBoard()[2][3].getPiece().canMove(Board.getBoard()[4][4]));
	}

}
