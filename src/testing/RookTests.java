package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Board;
import model.PieceColor;
import model.Rook;

class RookTests {

	@Test
	void testMoveVerticallyOneSpace() {
		Board.init();
		Board.getBoard()[4][4].setPiece(new Rook(PieceColor.BLACK));
		assertTrue(Board.getBoard()[4][4].getPiece().canMove(Board.getBoard()[5][4]));
	}

	@Test
	void testMoveVerticallySeveralSpaces() {
		Board.init();
		Board.getBoard()[2][4].setPiece(new Rook(PieceColor.BLACK));
		assertTrue(Board.getBoard()[2][4].getPiece().canMove(Board.getBoard()[5][4]));
	}

	@Test
	void testMoveHorizontallyOneSpace() {
		Board.init();
		Board.getBoard()[4][4].setPiece(new Rook(PieceColor.BLACK));
		assertTrue(Board.getBoard()[4][4].getPiece().canMove(Board.getBoard()[4][5]));
	}

	@Test
	void testMoveVerticallyHorizontallySpaces() {
		Board.init();
		Board.getBoard()[4][0].setPiece(new Rook(PieceColor.BLACK));
		assertTrue(Board.getBoard()[4][0].getPiece().canMove(Board.getBoard()[4][7]));
	}

	@Test
	void testMoveDiagonally() {
		Board.init();
		Board.getBoard()[2][0].setPiece(new Rook(PieceColor.BLACK));
		assertFalse(Board.getBoard()[2][0].getPiece().canMove(Board.getBoard()[5][3]));
	}

	@Test
	void testJumpOverPiece() {
		Board.init();
		Board.getBoard()[2][0].setPiece(new Rook(PieceColor.BLACK));
		Board.getBoard()[3][0].setPiece(new Rook(PieceColor.BLACK));
		assertFalse(Board.getBoard()[2][0].getPiece().canMove(Board.getBoard()[4][0]));
	}

	@Test
	void testCapture() {
		Board.init();
		Board.getBoard()[2][0].setPiece(new Rook(PieceColor.BLACK));
		Board.getBoard()[5][0].setPiece(new Rook(PieceColor.WHITE));
		assertTrue(Board.getBoard()[2][0].getPiece().canMove(Board.getBoard()[5][0]));
	}

	@Test
	void testMoveToASpaceWithSameColor() {
		Board.init();
		Board.getBoard()[2][0].setPiece(new Rook(PieceColor.BLACK));
		Board.getBoard()[5][0].setPiece(new Rook(PieceColor.BLACK));
		assertFalse(Board.getBoard()[2][0].getPiece().canMove(Board.getBoard()[5][0]));
	}

}
