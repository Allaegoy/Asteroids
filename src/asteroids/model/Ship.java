package asteroids.model;

import asteroids.Basic;
import asteroids.Raw;
import asteroids.util.ModelException;
import be.kuleuven.cs.som.annotate.Immutable;

/** TO BE ADDED TO CLASS HEADING
 * @invar  The x-position of each spaceship must be a valid x-position for any
 *         spaceship.
 *       | isValidXPosition(getXPosition())
 * @invar  The y-position of each spaceship must be a valid y-position for any
 *         spaceship.
 *       | isValidYPosition(getYPosition())
 * @invar  The xVelocity of each Ship must be a valid xVelocity for any
 *         Ship.
 *       | isValidXVelocity(getXVelocity())
 * @invar  The yVelocity of each Ship must be a valid yVelocity for any
 *         Ship.
 *       | isValidYVelocity(getYVelocity())
 * @invar  Each spaceship can have its maximum velocity as maximum velocity .
 *       | canHaveAsMaximumVelocity(this.getMaximumVelocity())
 * @invar  The orientation of each spaceship must be a valid orientation for any
 *         spaceship.
 *       | isValidOrientation(getOrientation())
 * @invar  Each spaceship can have its shapeRadius as shapeRadius.
 *       | canHaveAsShapeRadius(this.getShapeRadius())
 */
public class Ship {
	static final double MINIMUM_SHAPE_RADIUS = 10;

	/**
	 * Initialize this new spaceship with given (x, y)-position.
	 *
	 * @param  x
	 *         The x-position for this new spaceship.
	 * @effect The x-position of this new spaceship is set to
	 *         the given x-position.
	 *       | this.setXPosition(x)
	 * @param  y
	 *         The y-position for this new spaceship.
	 * @effect The y-position of this new spaceship is set to
	 *         the given y-position.
	 *       | this.setYPosition(y)
	 *
	 * Initialize this new spaceship with given maximum velocity.
	 * 
	 * @param  c
	 *         The maximum velocity for this new spaceship.
	 * @post   If the given maximum velocity is a valid maximum velocity for any spaceship,
	 *         the maximum velocity of this new spaceship is equal to the given
	 *         maximum velocity. Otherwise, the maximum velocity of this new spaceship is equal
	 *         to 300000.
	 *       | if (isValidMaximumVelocity(c))
	 *       |   then new.getMaximumVelocity() == c
	 *       |   else new.getMaximumVelocity() == 300000
	 *       
	 * Initialize this new spaceship with given orientation.
	 * 
	 * @param  orientation
	 *         The orientation for this new spaceship.
	 * @pre    The given orientation must be a valid orientation for any spaceship.
	 *       | isValidOrientation(orientation)
	 * @post   The orientation of this new spaceship is equal to the given
	 *         orientation.
	 *       | new.getOrientation() == orientation
	 *       
	 * Initialize this new spaceship with given shapeRadius.
	 * 
	 * @param  shapeRadius
	 *         The shapeRadius for this new spaceship.
	 * @post   The shapeRadius of this new spaceship is equal to the given
	 *         shapeRadius.
	 *       | new.getShapeRadius() == shapeRadius
	 * @throws InvalidShapeRadiusException
	 *         This new spaceship cannot have the given shapeRadius as its shapeRadius.
	 *       | ! canHaveAsShapeRadius(this.getShapeRadius())
	 *       
	 * Initialize this new Ship with given yVelocity.
	 * 
	 * @param  yVelocity
	 *         The yVelocity for this new Ship.
	 * @post   If the given yVelocity is a valid yVelocity for any Ship,
	 *         the yVelocity of this new Ship is equal to the given
	 *         yVelocity. Otherwise, the yVelocity of this new Ship is equal
	 *         to 0.
	 *       | if (isValidYVelocity(yVelocity))
	 *       |   then new.getYVelocity() == yVelocity
	 *       |   else new.getYVelocity() == 0
	 *       
	 * Initialize this new Ship with given xVelocity.
	 * 
	 * @param  xVelocity
	 *         The xVelocity for this new Ship.
	 * @post   If the given xVelocity is a valid xVelocity for any Ship,
	 *         the xVelocity of this new Ship is equal to the given
	 *         xVelocity. Otherwise, the xVelocity of this new Ship is equal
	 *         to 0.
	 *       | if (isValidXVelocity(xVelocity))
	 *       |   then new.getXVelocity() == xVelocity
	 *       |   else new.getXVelocity() == 0
	 */

	public Ship(double x, double y, double xVelocity, double yVelocity, double orientation, double shapeRadius )
			throws ModelException {
		try{
		this.setXPosition(x);
		this.setYPosition(y);

		if (! isValidXVelocity(xVelocity))
			xVelocity = 0;
		setXVelocity(xVelocity);

		if (! isValidYVelocity(yVelocity))
			yVelocity = 0;
		setYVelocity(yVelocity);

		this.setOrientation(orientation);

		if (! canHaveAsShapeRadius(shapeRadius))
			throw new InvalidShapeRadiusException();
		this.shapeRadius = shapeRadius;
		}catch (InvalidXException e) {
			throw new ModelException("InValidXException thrown at Ship.Ship");
		}catch (InvalidYException e) {
			throw new ModelException("InValidYException thrown at Ship.Ship");
		}catch (InvalidShapeRadiusException e) {
			throw new ModelException("InvalidShapeRadiusException thrown at Ship.Ship");
		}


	}


	//////////////////////////////////////
	//			X-POSITION				// Def_mut
	//////////////////////////////////////

	/**
	 * Return the x-position of this spaceship.
	 */
	@Basic @Raw
	public double getXPosition() {
		return this.x;
	}

	/**
	 * Check whether the given x-position is a valid x-position for
	 * any spaceship.
	 *  
	 * @param  x-position
	 *         The x-position to check.
	 * @return 
	 *       | result == true (unbounded)
	 */
	public static boolean isValidXPosition(double x) {
		return true;
	}

	/**
	 * Set the x-position of this spaceship to the given x-position.
	 * 
	 * @param  x
	 *         The new x-position for this spaceship.
	 * @post   The x-position of this new spaceship is equal to
	 *         the given x-position.
	 *       | new.getXPosition() == x
	 * @throws InvalidXException
	 *         The given x-position is not a valid x-position for any
	 *         spaceship.
	 *       | ! isValidXPosition(getXPosition())
	 */
	@Raw
	public void setXPosition(double x) 
			throws InvalidXException {
		if (! isValidXPosition(x))
			throw new InvalidXException();
		this.x = x;
	}

	/**
	 * Variable registering the x-position of this spaceship.
	 */
	private double x;


	//////////////////////////////////////
	//			Y-POSITION				// Def_mut
	//////////////////////////////////////

	/**
	 * Return the y-position of this spaceship.
	 */
	@Basic @Raw
	public double getYPosition() {
		return this.y;
	}

	/**
	 * Check whether the given y-position is a valid y-position for
	 * any spaceship.
	 *  
	 * @param  y-position
	 *         The y-position to check.
	 * @return 
	 *       | result == true (unbounded)
	 */
	public static boolean isValidYPosition(double y) {
		return true;
	}

	/**
	 * Set the y-position of this spaceship to the given y-position.
	 * 
	 * @param  y
	 *         The new y-position for this spaceship.
	 * @post   The y-position of this new spaceship is equal to
	 *         the given y-position.
	 *       | new.getYPosition() == y
	 * @throws InvalidYException
	 *         The given y-position is not a valid y-position for any
	 *         spaceship.
	 *       | ! isValidYPosition(getYPosition())
	 */
	@Raw
	public void setYPosition(double y) 
			throws InvalidYException {
		if (! isValidYPosition(y))
			throw new InvalidYException();
		this.y = y;
	}

	/**
	 * Variable registering the y-position of this spaceship.
	 */
	private double y;


	//////////////////////////////////////
	//			X_VELOCITY				// Tot_inmut
	//////////////////////////////////////




	/**
	 * Return the xVelocity of this Ship.
	 */
	@Basic @Raw
	public double getXVelocity() {
		return this.xVelocity;
	}

	/**
	 * Check whether the given xVelocity is a valid xVelocity for
	 * any Ship.
	 *  
	 * @param  xVelocity
	 *         The xVelocity to check.
	 * @return 
	 *       | result == true (unbounded) //not looking at maximumVelocity
	 */
	public static boolean isValidXVelocity(double xVelocity) {
		return true;
	}

	/**
	 * Set the xVelocity of this Ship to the given xVelocity.
	 * 
	 * @param  xVelocity
	 *         The new xVelocity for this Ship.
	 * @post   If the given xVelocity is a valid xVelocity for any Ship,
	 *         the xVelocity of this new Ship is equal to the given
	 *         xVelocity.
	 *       | if (isValidXVelocity(xVelocity))
	 *       |   then new.getXVelocity() == xVelocity
	 */
	@Raw
	public void setXVelocity(double xVelocity) {
		if (isValidXVelocity(xVelocity))
			this.xVelocity = xVelocity;
	}

	/**
	 * Variable registering the xVelocity of this Ship.
	 */
	private double xVelocity;




	//////////////////////////////////////
	//			Y_VELOCITY				// Tot_inmut
	//////////////////////////////////////

	/**
	 * Return the yVelocity of this Ship.
	 */
	@Basic @Raw
	public double getYVelocity() {
		return this.yVelocity;
	}

	/**
	 * Check whether the given yVelocity is a valid yVelocity for
	 * any Ship.
	 *  
	 * @param  yVelocity
	 *         The yVelocity to check.
	 * @return 
	 *       | result == true (unbounded) //not looking at maximumVelocity
	 */
	public static boolean isValidYVelocity(double yVelocity) {
		return true;
	}

	/**
	 * Set the yVelocity of this Ship to the given yVelocity.
	 * 
	 * @param  yVelocity
	 *         The new yVelocity for this Ship.
	 * @post   If the given yVelocity is a valid yVelocity for any Ship,
	 *         the yVelocity of this new Ship is equal to the given
	 *         yVelocity.
	 *       | if (isValidYVelocity(yVelocity))
	 *       |   then new.getYVelocity() == yVelocity
	 */
	@Raw
	public void setYVelocity(double yVelocity) {
		if (isValidYVelocity(yVelocity))
			this.yVelocity = yVelocity;
	}

	/**
	 * Variable registering the yVelocity of this Ship.
	 */
	private double yVelocity;


	//////////////////////////////////////
	//			MAXIMUM VELOCITY		// Tot_inmut
	//////////////////////////////////////



	/**
	 * Return the maximum velocity of this spaceship.
	 */
	@Basic @Raw @Immutable
	public double getMaximumVelocity() {
		return c;
	}

	/**
	 * Check whether this spaceship can have the given maximum velocity as its maximum velocity.
	 *  
	 * @param  c
	 *         The maximum velocity to check.
	 * @return 
	 *       | result == (c >= 0 && c<= MaximumVelocity)
	 */
	@Raw
	public boolean canHaveAsMaximumVelocity(double c) {
		if(c >= 0 && c<= this.getMaximumVelocity()) {
			return true;
		}else{
			return false;
		}
	}

	/**
	 * Variable registering the maximum velocity of this spaceship.
	 */
	private final double c = 300000;


	//////////////////////////////////////
	//			ORIENTATION				// Nom_mut
	//////////////////////////////////////

	/**
	 * Return the orientation of this spaceship.
	 */
	@Basic @Raw
	public double getOrientation() {
		return this.orientation;
	}

	/**
	 * Check whether the given orientation is a valid orientation for
	 * any spaceship.
	 *  
	 * @param  orientation
	 *         The orientation to check.
	 * @return 
	 *       | result == ( 0 <= orientation <= 2*Math.PI)
	 */
	public static boolean isValidOrientation(double orientation) {
		if( 0 <= orientation && orientation <= 2*Math.PI) {
			return true;
		}else{
			return false;
		}
	}

	/**
	 * Set the orientation of this spaceship to the given orientation.
	 * 
	 * @param  orientation
	 *         The new orientation for this spaceship.
	 * @pre    The given orientation must be a valid orientation for any
	 *         spaceship.
	 *       | isValidOrientation(orientation)
	 * @post   The orientation of this spaceship is equal to the given
	 *         orientation.
	 *       | new.getOrientation() == orientation
	 */
	@Raw
	public void setOrientation(double orientation) {
		assert isValidOrientation(orientation);
		this.orientation = orientation;
	}

	/**
	 * Variable registering the orientation of this spaceship.
	 */
	private double orientation;


	//////////////////////////////////////
	//			SHAPE_RADIUS			// Def_inmut
	//////////////////////////////////////


	/**
	 * Return the shapeRadius of this spaceship.
	 */
	@Basic @Raw @Immutable
	public double getShapeRadius() {
		return this.shapeRadius;
	}

	/**
	 * Check whether this spaceship can have the given shapeRadius as its shapeRadius.
	 *  
	 * @param  shapeRadius
	 *         The shapeRadius to check.
	 * @return 
	 *       | result == (10 <= shapeRadius)
	 */
	@Raw
	public boolean canHaveAsShapeRadius(double shapeRadius) {
		if(MINIMUM_SHAPE_RADIUS <= shapeRadius) {
			return true;
		}else{
			return false;
		}
	}

	/**
	 * Variable registering the shapeRadius of this spaceship.
	 */
	private final double shapeRadius;



	//////////////////////////////////////
	//				MOVE				// Def
	//////////////////////////////////////

	/**
	 * Change the position of the spaceship based on it's current position, it's velocity, and the duration.
	 *  
	 * @param  dt
	 *         the time duration of the move
	 * @post   The x-position of the spaceship is changed to represent it's new x-position after the move.
	 *       | new.getXPosition() == x + xVelocity*dt
	 * @throws InvalidXException
	 *         The given x-position is not a valid x-position for any
	 *         spaceship.
	 *       | ! isValidXPosition(getXPosition())
	 * @post   The y-position of the spaceship is changed to represent it's new y-position after the move.
	 *         the given y-position.
	 *       | new.getYPosition() == y + yVelocity*dt
	 * @throws InvalidYException
	 *         The given y-position is not a valid y-position for any
	 *         spaceship.
	 *       | ! isValidYPosition(getYPosition())
	 * @throws ModelException 
	 */
	public void move(double dt) throws ModelException {
		if(dt < 0) {
			//throw new negativeTimeException();
			throw new ModelException("negativeTimeException thrown at Ship.Move");
		}
		try{
			setXPosition(this.getXPosition() + this.getXVelocity()*dt);
			setYPosition(this.getYPosition() + this.getYVelocity()*dt);
		}catch (InvalidXException e) {
			throw new ModelException("InvalidXException in Ship.Move");
		}catch (InvalidYException e) {
			throw new ModelException("InvalidYException in Ship.Move");
		}
	}
	
	

	//////////////////////////////////////
	//				TURN				// Nom
	//////////////////////////////////////
	
	
	/**
	 * Changes the orientation given a certain turn angle.
	 *  
	 * @param  angle
	 *         the added angle to the current orientation
	 */
	public void turn(double angle) {
		double temp = this.getOrientation() + angle;
		double result = temp % (Math.PI*2); //+ Math.PI*2;
		if(result < 0) {
			result += Math.PI*2;
		}
		this.setOrientation(result);
		
	}
	

	//////////////////////////////////////
	//				THRUST				// Tot
	//////////////////////////////////////
	
	/**
	 * Changes the velocities of the ship (x and y) according to the ship current orientation and the amount.
	 *  
	 * @param  a
	 *         the amount of thrust
	 * @todo   total velocity is reduced if exceeds c
	 */
	public void thrust(double a) {
		if(a < 0) {
			a = 0;
		}
		
		double newXVelocity = this.getXVelocity() + a*Math.cos(this.getOrientation());
		double newYVelocity = this.getYVelocity() + a*Math.sin(this.getOrientation());
		double newTotalVelocity = Math.sqrt(newXVelocity*newXVelocity + newYVelocity*newYVelocity);
		
		
		if(newTotalVelocity > this.getMaximumVelocity()) {
			double d = newTotalVelocity/this.getMaximumVelocity();
			newXVelocity /= d;
			newYVelocity /= d;
		}
		
		this.setXVelocity(newXVelocity);
		this.setYVelocity(newYVelocity);
	}
	
	

	//////////////////////////////////////
	//				THRUST				// Def
	//////////////////////////////////////
	
	
	
	public static double getDistanceBetween (Ship ship1, Ship ship2) {
		if(ship1 == ship2) {
			return 0;
		}
		
		double xDistance = ship1.getXPosition() - ship2.getXPosition();
		double yDistance = ship1.getYPosition() - ship2.getYPosition();
		
		double pointBlankDistance = Math.sqrt(xDistance*xDistance + yDistance* yDistance);
		double distance = pointBlankDistance - ship1.getShapeRadius() - ship2.getShapeRadius();
		
		return distance;
	}
	
	public static boolean overlap (Ship ship1, Ship ship2) {
		if(getDistanceBetween(ship1, ship2) <= 0) {
			return true;
		}else{
			return false;
		}
	}
	
	public static double getTimeToCollision(Ship ship1, Ship ship2) {
		double dt;
		double dvx = Math.abs(ship1.getXVelocity() - ship2.getXVelocity());
		double dx = Math.abs(ship1.getXPosition() - ship2.getXPosition());
		double dvy = Math.abs(ship1.getYVelocity() - ship2.getYVelocity());
		double dy = Math.abs(ship1.getYPosition() - ship2.getYPosition());
		double dv_dr = dvx*dx + dvy*dy;
		double dv_dv = dvx*dvx + dvy*dvy;
		double dr_dr = dx*dx + dy*dy;
		double collisionDistance = ship1.getShapeRadius() + ship2.getShapeRadius();
		
		double d = dv_dr*dv_dr - dv_dv*(dr_dr - collisionDistance*collisionDistance);
		
		if(dv_dr >= 0) {
			return Double.POSITIVE_INFINITY;
		}
		if(d <= 0) {
			return Double.POSITIVE_INFINITY;
		}
		
		dt = -(dv_dr + Math.sqrt(d))/(dv_dv);
		return dt;
	}
	
	
	public static double[] getCollisionPosition(Ship ship1, Ship ship2) {
		if(Ship.getTimeToCollision(ship1, ship2) == Double.POSITIVE_INFINITY) {
			return null;
		}else{
			double timeTC = Ship.getDistanceBetween(ship1, ship2);
			double x1 = ship1.getXPosition() + ship1.getXVelocity()*timeTC;
			double y1 = ship1.getYPosition() + ship1.getYVelocity()*timeTC;
			double x2 = ship2.getXPosition() + ship2.getXVelocity()*timeTC;
			double y2 = ship2.getYPosition() + ship2.getYVelocity()*timeTC;
			double dx = Math.abs(x2 - x1);
			double dy = Math.abs(y2 - y1);
			double r1 = ship1.getShapeRadius();
			double r2 = ship2.getShapeRadius();
			
			double a = r1/(r1+r2);
			
			double collisionX = x1 + dx*a;
			double collisionY = y1 + dy*a;
			
			double[] collisionPosition = {collisionX, collisionY}; 
			
			return collisionPosition;
		}
	}
}
