package asteroids.model;

/** TO BE ADDED TO CLASS HEADING
 * @invar  The x-position of each spaceship must be a valid x-position for any
 *         spaceship.
 *       | isValidXPosition(getXPosition())
 * @invar  The y-position of each spaceship must be a valid y-position for any
 *         spaceship.
 *       | isValidYPosition(getYPosition())
 * @invar  Each spaceship can have its maximum velocity as maximum velocity .
 *       | canHaveAsMaximumVelocity(this.getMaximumVelocity())
 * @invar  The orientation of each spaceship must be a valid orientation for any
 *         spaceship.
 *       | isValidOrientation(getOrientation())
 */
public class Ship {

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
	 */

	public Ship(double x, double y, double c, double orientation)
			throws Exception1, Exception2 {
		this.setXPosition(x);
		this.setYPosition(y);

		if (! canHaveAsMaximumVelocity(c))
			c = 300000;
		this.c = c;

		this.setOrientation(orientation);

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
		return false;
	}

	/**
	 * Set the x-position of this spaceship to the given x-position.
	 * 
	 * @param  x
	 *         The new x-position for this spaceship.
	 * @post   The x-position of this new spaceship is equal to
	 *         the given x-position.
	 *       | new.getXPosition() == x
	 * @throws Exception1
	 *         The given x-position is not a valid x-position for any
	 *         spaceship.
	 *       | ! isValidXPosition(getXPosition())
	 */
	@Raw
	public void setXPosition(double x) 
			throws Exception1 {
		if (! isValidXPosition(x))
			throw new Exception1();
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
		return false;
	}

	/**
	 * Set the y-position of this spaceship to the given y-position.
	 * 
	 * @param  y
	 *         The new y-position for this spaceship.
	 * @post   The y-position of this new spaceship is equal to
	 *         the given y-position.
	 *       | new.getYPosition() == y
	 * @throws Exception2
	 *         The given y-position is not a valid y-position for any
	 *         spaceship.
	 *       | ! isValidYPosition(getYPosition())
	 */
	@Raw
	public void setYPosition(double y) 
			throws Exception2 {
		if (! isValidYPosition(y))
			throw new Exception2();
		this.y = y;
	}

	/**
	 * Variable registering the y-position of this spaceship.
	 */
	private double y;


	//////////////////////////////////////
	//			MAXIMUM VELOCITY		// Tot_inmut
	//////////////////////////////////////

	/**
	 * Return the maximum velocity of this spaceship.
	 */
	@Basic @Raw @Immutable
	public double getMaximumVelocity() {
		return this.c;
	}

	/**
	 * Check whether this spaceship can have the given maximum velocity as its maximum velocity.
	 *  
	 * @param  c
	 *         The maximum velocity to check.
	 * @return 
	 *       | result == (c >= 0 && c<= 300000)
	 */
	@Raw
	public boolean canHaveAsMaximumVelocity(double c) {
		return false;
	}

	/**
	 * Variable registering the maximum velocity of this spaceship.
	 */
	private final double c;


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
		return false;
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
	//			ORIENTATION				// Def_inmut
	//////////////////////////////////////

	/** TO BE ADDED TO CLASS HEADING
	 * @invar  Each spaceship can have its shapeRadius as shapeRadius.
	 *       | canHaveAsShapeRadius(this.getShapeRadius())
	 */

/**
 * Initialize this new spaceship with given shapeRadius.
 * 
 * @param  shapeRadius
 *         The shapeRadius for this new spaceship.
 * @post   The shapeRadius of this new spaceship is equal to the given
 *         shapeRadius.
 *       | new.getShapeRadius() == shapeRadius
 * @throws Exception3
 *         This new spaceship cannot have the given shapeRadius as its shapeRadius.
 *       | ! canHaveAsShapeRadius(this.getShapeRadius())
 */
public Ship(double shapeRadius) throws Exception3 {
	if (! canHaveAsShapeRadius(shapeRadius))
		throw new Exception3();
	this.shapeRadius = shapeRadius;
}

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
	return false;
}

/**
 * Variable registering the shapeRadius of this spaceship.
 */
private final double shapeRadius;
}
