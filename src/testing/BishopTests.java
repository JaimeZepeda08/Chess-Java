package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Bishop;
import model.Board;
import model.PieceColor;

class BishopTests {

	@Test
	void testMoveDiagonalOneSpace() {
		Board.init();
		Board.getBoard()[4][4].setPiece(new Bishop(PieceColor.BLACK));
		assertTrue(Board.getBoard()[4][4].getPiece().canMove(Board.getBoard()[5][5]));
	}

	@Test
	void testMoveDiagonalSeveralSpaces() {
		Board.init();
		Board.getBoard()[2][3].setPiece(new Bishop(PieceColor.BLACK));
		assertTrue(Board.getBoard()[2][3].getPiece().canMove(Board.getBoard()[5][6]));
	}

	@Test
	void testMoveDiagonalSeveralSpacesOppositeDirection() {
		Board.init();
		Board.getBoard()[5][4].setPiece(new Bishop(PieceColor.BLACK));
		assertTrue(Board.getBoard()[5][4].getPiece().canMove(Board.getBoard()[3][2]));
	}

	@Test
	void testMoveVertically() {
		Board.init();
		Board.getBoard()[2][2].setPiece(new Bishop(PieceColor.BLACK));
		assertFalse(Board.getBoard()[2][2].getPiece().canMove(Board.getBoard()[3][2]));
	}

	@Test
	void testMoveHorizontally() {
		Board.init();
		Board.getBoard()[2][2].setPiece(new Bishop(PieceColor.BLACK));
		assertFalse(Board.getBoard()[2][2].getPiece().canMove(Board.getBoard()[2][3]));
	}

	@Test
	void testJumpOverPiece() {
		Board.init();
		Board.getBoard()[0][2].setPiece(new Bishop(PieceColor.BLACK));
		assertFalse(Board.getBoard()[0][2].getPiece().canMove(Board.getBoard()[2][4]));
	}

	@Test
	void testCapture() {
		Board.init();
		Board.getBoard()[2][3].setPiece(new Bishop(PieceColor.BLACK));
		Board.getBoard()[4][5].setPiece(new Bishop(PieceColor.WHITE));
		assertTrue(Board.getBoard()[2][3].getPiece().canMove(Board.getBoard()[4][5]));
	}

	@Test
	void testMoveToAPositionWithSameColor() {
		Board.init();
		Board.getBoard()[2][3].setPiece(new Bishop(PieceColor.BLACK));
		Board.getBoard()[4][5].setPiece(new Bishop(PieceColor.BLACK));
		assertFalse(Board.getBoard()[2][3].getPiece().canMove(Board.getBoard()[4][5]));
	}

}
