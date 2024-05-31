package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Board;
import model.Pawn;
import model.PieceColor;
import model.Rook;

class PawnTests {

	@Test
	void testMoveForwardOneSpace() {
		Board.init();
		assertTrue(Board.getBoard()[1][3].getPiece().canMove(Board.getBoard()[2][3]));
	}

	@Test
	void testMoveHorizontally() {
		Board.init();
		assertFalse(Board.getBoard()[1][3].getPiece().canMove(Board.getBoard()[1][4]));
	}

	@Test
	void testMoveDiagonal() {
		Board.init();
		assertFalse(Board.getBoard()[1][3].getPiece().canMove(Board.getBoard()[2][4]));
	}

	@Test
	void testCaptureOpponentDiagonal() {
		Board.init();
		Board.getBoard()[2][4].setPiece(new Rook(PieceColor.WHITE));
		assertTrue(Board.getBoard()[1][3].getPiece().canMove(Board.getBoard()[2][4]));
	}

	@Test
	void testMoveBackwards() {
		Board.init();
		Board.getBoard()[4][4].setPiece(new Pawn(PieceColor.BLACK));
		assertFalse(Board.getBoard()[4][4].getPiece().canMove(Board.getBoard()[3][4]));
	}

	@Test
	void testMoveTwoSpacesOnItsFirstTurn() {
		Board.init();
		assertTrue(Board.getBoard()[1][3].getPiece().canMove(Board.getBoard()[3][3]));
	}

	@Test
	void testMoveOpponent() {
		Board.init();
		assertTrue(Board.getBoard()[6][3].getPiece().canMove(Board.getBoard()[5][3]));
	}

	@Test
	void testMoveTwoSpacesTwice() {
		Board.init();
		Board.getBoard()[1][3].getPiece().move(Board.getBoard()[3][3]);
		assertFalse(Board.getBoard()[3][3].getPiece().canMove(Board.getBoard()[5][3]));
	}

	@Test
	void testJumpOverPiece() {
		Board.init();
		Board.getBoard()[2][4].setPiece(new Pawn(PieceColor.BLACK));
		assertFalse(Board.getBoard()[1][4].getPiece().canMove(Board.getBoard()[3][4]));
	}
}
