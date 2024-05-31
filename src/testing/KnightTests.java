package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Board;
import model.Knight;
import model.PieceColor;

class KnightTests {

	@Test
	void testMoveForward() {
		Board.init();
		assertFalse(Board.getBoard()[0][1].getPiece().canMove(Board.getBoard()[2][1]));
	}

	@Test
	void testMoveBack() {
		Board.init();
		Board.getBoard()[4][4].setPiece(new Knight(PieceColor.BLACK));
		assertFalse(Board.getBoard()[4][4].getPiece().canMove(Board.getBoard()[3][4]));
	}

	@Test
	void testMoveHorizontally() {
		Board.init();
		Board.getBoard()[4][4].setPiece(new Knight(PieceColor.BLACK));
		assertFalse(Board.getBoard()[4][4].getPiece().canMove(Board.getBoard()[4][2]));
	}

	@Test
	void testMoveDiagonally() {
		Board.init();
		Board.getBoard()[4][4].setPiece(new Knight(PieceColor.BLACK));
		assertFalse(Board.getBoard()[4][4].getPiece().canMove(Board.getBoard()[5][5]));
	}

	@Test
	void testMove() {
		Board.init();
		assertTrue(Board.getBoard()[0][1].getPiece().canMove(Board.getBoard()[2][0]));
	}

	@Test
	void testMove2() {
		Board.init();
		Board.getBoard()[2][2].setPiece(new Knight(PieceColor.BLACK));
		assertTrue(Board.getBoard()[2][2].getPiece().canMove(Board.getBoard()[3][4]));
	}

	@Test
	void testMoveSeveralSpaces() {
		Board.init();
		assertFalse(Board.getBoard()[0][1].getPiece().canMove(Board.getBoard()[4][3]));
	}

	@Test
	void testCapture() {
		Board.init();
		Board.getBoard()[2][2].setPiece(new Knight(PieceColor.WHITE));
		assertTrue(Board.getBoard()[0][1].getPiece().canMove(Board.getBoard()[2][2]));
	}

	@Test
	void testMoveToAPositionWithSameColor() {
		Board.init();
		Board.getBoard()[2][2].setPiece(new Knight(PieceColor.BLACK));
		assertFalse(Board.getBoard()[0][1].getPiece().canMove(Board.getBoard()[2][2]));
	}

}
