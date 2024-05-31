package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import utility.Point2D;

class Point2DTests {

	@Test
	void testDistanceNorth() {
		Point2D point1 = new Point2D(0, 0);
		Point2D point2 = new Point2D(0, 1);

		assertEquals(point1.getDistance(point2), 1);
	}

	@Test
	void testDistanceSouth() {
		Point2D point1 = new Point2D(0, 1);
		Point2D point2 = new Point2D(0, 0);

		assertEquals(point1.getDistance(point2), 1);
	}

	@Test
	void testDistanceEast() {
		Point2D point1 = new Point2D(0, 0);
		Point2D point2 = new Point2D(0, 1);

		assertEquals(point1.getDistance(point2), 1);
	}

	@Test
	void testDistanceWest() {
		Point2D point1 = new Point2D(1, 0);
		Point2D point2 = new Point2D(0, 0);

		assertEquals(point1.getDistance(point2), 1);
	}

	@Test
	void testDistanceDiagonal() {
		Point2D point1 = new Point2D(1, 1);
		Point2D point2 = new Point2D(0, 0);

		assertEquals(point1.getDistance(point2), Math.sqrt(2));
	}

	@Test
	void testDistanceOppositeDiagonal() {
		Point2D point1 = new Point2D(0, 0);
		Point2D point2 = new Point2D(1, 1);

		assertEquals(point1.getDistance(point2), Math.sqrt(2));
	}

	@Test
	void testAngleZero() {
		Point2D point1 = new Point2D(2, 0);
		Point2D point2 = new Point2D(0, 0);

		assertEquals(point1.getAngle(point2), 0);
	}

	@Test
	void testAngleNaN() {
		Point2D point1 = new Point2D(0, 1);
		Point2D point2 = new Point2D(0, 0);

		assertEquals(point1.getAngle(point2), -1);
	}

	@Test
	void testAngleDiagonal() {
		Point2D point1 = new Point2D(1, 1);
		Point2D point2 = new Point2D(0, 0);

		assertEquals(point1.getAngle(point2), 45);
	}

	@Test
	void testAngleDiagonalLong() {
		Point2D point1 = new Point2D(1, 2);
		Point2D point2 = new Point2D(0, 0);

		assertEquals(point1.getAngle(point2), Math.toDegrees(Math.atan(2 / 1)));
	}
}
