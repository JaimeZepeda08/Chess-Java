package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Bishop;
import model.Board;
import model.King;
import model.PieceColor;

class KingTests {

	@Test
	void testMoveForward() {
		Board.init();
		Board.getBoard()[4][4].setPiece(new King(PieceColor.BLACK));
		assertTrue(Board.getBoard()[4][4].getPiece().canMove(Board.getBoard()[5][4]));
	}

	@Test
	void testMoveBack() {
		Board.init();
		Board.getBoard()[4][4].setPiece(new King(PieceColor.BLACK));
		assertTrue(Board.getBoard()[4][4].getPiece().canMove(Board.getBoard()[3][4]));
	}

	@Test
	void testMoveHorizonally() {
		Board.init();
		Board.getBoard()[4][4].setPiece(new King(PieceColor.BLACK));
		assertTrue(Board.getBoard()[4][4].getPiece().canMove(Board.getBoard()[4][5]));
	}

	@Test
	void testMoveDiagonally() {
		Board.init();
		Board.getBoard()[4][4].setPiece(new King(PieceColor.BLACK));
		assertTrue(Board.getBoard()[4][4].getPiece().canMove(Board.getBoard()[3][3]));
	}

	@Test
	void testMoveMoreThanOneSpace() {
		Board.init();
		Board.getBoard()[3][4].setPiece(new King(PieceColor.BLACK));
		assertFalse(Board.getBoard()[3][4].getPiece().canMove(Board.getBoard()[5][4]));
	}

	@Test
	void testCapture() {
		Board.init();
		Board.getBoard()[4][4].setPiece(new King(PieceColor.BLACK));
		Board.getBoard()[4][5].setPiece(new King(PieceColor.WHITE));
		assertTrue(Board.getBoard()[4][4].getPiece().canMove(Board.getBoard()[4][5]));
	}

	@Test
	void testMoveToASpaceWithSameColor() {
		Board.init();
		Board.getBoard()[4][4].setPiece(new King(PieceColor.BLACK));
		Board.getBoard()[4][5].setPiece(new King(PieceColor.BLACK));
		assertFalse(Board.getBoard()[4][4].getPiece().canMove(Board.getBoard()[4][5]));
	}

	@Test
	void testCastlingLeft() {
		Board.init();
		Board.getBoard()[0][1].setPiece(null);
		Board.getBoard()[0][2].setPiece(null);
		Board.getBoard()[0][3].setPiece(null);
		assertTrue(Board.getBoard()[0][4].getPiece().move(Board.getBoard()[0][0]));
	}

	@Test
	void testCastlingRight() {
		Board.init();
		Board.getBoard()[0][5].setPiece(null);
		Board.getBoard()[0][6].setPiece(null);
		assertTrue(Board.getBoard()[0][4].getPiece().move(Board.getBoard()[0][7]));
	}

	@Test
	void testCastlingAfterMovingKing() {
		Board.init();
		Board.getBoard()[0][5].setPiece(null);
		Board.getBoard()[0][6].setPiece(null);
		Board.getBoard()[0][4].getPiece().move(Board.getBoard()[0][5]);
		Board.getBoard()[0][5].getPiece().move(Board.getBoard()[0][4]);
		assertFalse(Board.getBoard()[0][4].getPiece().move(Board.getBoard()[0][7]));
	}

	@Test
	void testCastlingAfterMovingRook() {
		Board.init();
		Board.getBoard()[0][5].setPiece(null);
		Board.getBoard()[0][6].setPiece(null);
		Board.getBoard()[0][7].getPiece().move(Board.getBoard()[0][6]);
		Board.getBoard()[0][6].getPiece().move(Board.getBoard()[0][7]);
		assertFalse(Board.getBoard()[0][4].getPiece().move(Board.getBoard()[0][7]));
	}

	@Test
	void testCastlingWithTheWrongType() {
		Board.init();
		Board.getBoard()[0][7].setPiece(new Bishop(PieceColor.BLACK));
		Board.getBoard()[0][5].setPiece(null);
		Board.getBoard()[0][6].setPiece(null);
		assertFalse(Board.getBoard()[0][4].getPiece().move(Board.getBoard()[0][7]));
	}

	@Test
	void testCastlingWithPiecesInBetween() {
		Board.init();
		Board.getBoard()[0][6].setPiece(null);
		assertFalse(Board.getBoard()[0][4].getPiece().move(Board.getBoard()[0][7]));
	}

}
