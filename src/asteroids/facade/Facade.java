package asteroids.facade;

import asteroids.model.Ship;
import asteroids.part1.facade.IFacade;
import asteroids.util.ModelException;

public class Facade implements IFacade {

	@Override
	public Ship createShip() throws ModelException {
		return null;
	}

	@Override
	public Ship createShip(double x, double y, double xVelocity, double yVelocity, double radius, double orientation) throws ModelException {
		Ship ship = new Ship(x, y, xVelocity, yVelocity, c, orientation, radius);
		return ship;
	}

	@Override
	public double[] getShipPosition(Ship ship) throws ModelException {
		double[] position = new double[]{ship.getXPosition(), ship.getYPosition()};
		return position;
	}

	@Override
	public double[] getShipVelocity(Ship ship) throws ModelException {
		double[] velocity = new double[]{ship.getXVelocity(), ship.getYVelocity()};
		return velocity;
	}

	@Override
	public double getShipRadius(Ship ship) throws ModelException {
		double radius = ship.getShapeRadius();
		return radius;
}

	@Override
	public double getShipOrientation(Ship ship) throws ModelException {
		double orientation = ship.getOrientation();
		return orientation;
	}

	@Override
	public void move(Ship ship, double dt) throws ModelException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void thrust(Ship ship, double amount) throws ModelException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void turn(Ship ship, double angle) throws ModelException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double getDistanceBetween(Ship ship1, Ship ship2) throws ModelException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean overlap(Ship ship1, Ship ship2) throws ModelException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public double getTimeToCollision(Ship ship1, Ship ship2) throws ModelException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double[] getCollisionPosition(Ship ship1, Ship ship2) throws ModelException {
		// TODO Auto-generated method stub
		return null;
	}

}
