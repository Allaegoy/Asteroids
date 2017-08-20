package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import asteroids.model.Ship;
import asteroids.model.negativeTimeException;
import asteroids.util.ModelException;
import asteroids.util.Util;

public class ShipTest {
	Ship ship;
	Ship ship1;
	Ship ship2;
	Ship ship3;
	Ship ship4;
	
	
	@Test
	public void testShipStruct() throws ModelException {
		ship = new Ship(200,300,-10,10,Math.PI,20);
		assertNotNull(ship);
		assertEquals(200, ship.getXPosition(), Util.EPSILON);
		assertEquals(300, ship.getYPosition(), Util.EPSILON);
		assertEquals(-10, ship.getXVelocity(), Util.EPSILON);
		assertEquals( 10, ship.getYVelocity(), Util.EPSILON);
		assertEquals(Math.PI, ship.getOrientation(), Util.EPSILON);
		assertEquals(20, ship.getShapeRadius(), Util.EPSILON);
	}
	
	@Test
	public void testMaximumVelocity() throws ModelException {
		ship = new Ship(200,300,-10,10,Math.PI,20);
		assert( ship.canHaveAsMaximumVelocity(299999));
		assert(!ship.canHaveAsMaximumVelocity(300001));
	}
	
	@Test
	public void testOrientation() throws ModelException {
		assert(!Ship.isValidOrientation(-1));
		assert( Ship.isValidOrientation(Math.PI*2));
		assert(!Ship.isValidOrientation(Math.PI*3));
	}
	
	@Test
	public void testShapeRadius() throws ModelException {
		ship = new Ship(200,300,-10,10,Math.PI,20);
		assert(!ship.canHaveAsShapeRadius(-1));
		assert(ship.canHaveAsShapeRadius(10));
		assert(ship.canHaveAsShapeRadius(12));
		assert(ship.canHaveAsShapeRadius(20));
	}
	
	@Test
	public void testMove() throws ModelException {
		ship = new Ship(0,0,-10,10,Math.PI,20);
		ship.move(1);
		assertEquals(-10, ship.getXPosition(), Util.EPSILON);
		assertEquals( 10, ship.getYPosition(), Util.EPSILON);
	}
	
	@Test(expected=ModelException.class)
	public void testMoveExceptions() throws ModelException{
		ship = new Ship(0,0,-10,10,Math.PI,20);
		ship.move(0);
		ship.move(-1);
	}
	
	@Test
	public void testTurn() throws ModelException {
		ship = new Ship(0,0,-10,10,Math.PI,20);
		assertEquals(Math.PI, ship.getOrientation(), Util.EPSILON);
		ship.turn(0);
		assertEquals(Math.PI, ship.getOrientation(), Util.EPSILON);
		ship.turn(Math.PI*2);
		assertEquals(Math.PI, ship.getOrientation(), Util.EPSILON);
		ship.turn(-Math.PI);
		assertEquals(0, ship.getOrientation(), Util.EPSILON);
		ship.turn(-Math.PI/2);
		assertEquals(3*Math.PI/2, ship.getOrientation(), Util.EPSILON);	
	}
	
	@Test
	public void testThrust() throws ModelException {
		ship = new Ship(0,0,0,0,Math.PI/2,20);
		assertEquals(0, ship.getYVelocity(), Util.EPSILON);
		ship.thrust(5);
		assertEquals(5, ship.getYVelocity(), Util.EPSILON);
		ship.turn(Math.PI/2);
		ship.thrust(10);
		assertEquals(-10, ship.getXVelocity(), Util.EPSILON);
	}
	
	@Test
	public void testGetDistanceBetween() throws ModelException {
		ship1 = new Ship( 200,0,0,0,Math.PI/2,20);
		ship2 = new Ship(-100,0,0,0,Math.PI/2,20);
		ship3 = new Ship( 0,200,0,0,Math.PI/2,20);
		ship4 = new Ship( 0,220,0,0,Math.PI/2,20);
		assertEquals(260, Ship.getDistanceBetween(ship1, ship2), Util.EPSILON);
		assertEquals(0, Ship.getDistanceBetween(ship1, ship1), Util.EPSILON);
		assertEquals(200*Math.sqrt(2)-20-20, Ship.getDistanceBetween(ship1, ship3), Util.EPSILON);
		assertEquals(-20, Ship.getDistanceBetween(ship3, ship4), Util.EPSILON);
	}
	
	@Test
	public void overlap() throws ModelException {
		ship1 = new Ship( 200,0,0,0,Math.PI/2,20);
		ship2 = new Ship(-100,0,0,0,Math.PI/2,20);
		ship3 = new Ship( 0,200,0,0,Math.PI/2,20);
		ship4 = new Ship( 0,220,0,0,Math.PI/2,20);
		assert(!Ship.overlap(ship1, ship2));
		assert( Ship.overlap(ship1, ship1));
		assert(!Ship.overlap(ship1, ship3));
		assert( Ship.overlap(ship3, ship4));
	}
	
	@Test
	public void testTimeToCollision(){
		
	}
	
	@Test
	public void testCollisionPosition() {
		
	}
	
	
	
}
