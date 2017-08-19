package asteroids.model;

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

	public Ship(double x, double y, double xVelocity, double yVelocity, double c, double orientation, double shapeRadius )
			throws InvalidXException, InvalidYException, InvalidShapeRadiusException {
		this.setXPosition(x);
		this.setYPosition(y);

		if (! isValidXVelocity(xVelocity))
			xVelocity = 0;
		setXVelocity(xVelocity);

		if (! isValidYVelocity(yVelocity))
			yVelocity = 0;
		setYVelocity(yVelocity);

		if (! canHaveAsMaximumVelocity(c))
			c = 300000;
		this.c = c;

		this.setOrientation(orientation);

		if (! canHaveAsShapeRadius(shapeRadius))
			throw new InvalidShapeRadiusException();
		this.shapeRadius = shapeRadius;



	}


	//////////////////////////////////////
	//			X-POSITION				// Def_mut
	//////////////////////////////////////

	/**
	 * Return the x-position of this spaceship.
	 */
	//	@Basic @Raw
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
	 * @throws InvalidXException
	 *         The given x-position is not a valid x-position for any
	 *         spaceship.
	 *       | ! isValidXPosition(getXPosition())
	 */
	//	@Raw
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
	//	@Basic @Raw
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
	 * @throws InvalidYException
	 *         The given y-position is not a valid y-position for any
	 *         spaceship.
	 *       | ! isValidYPosition(getYPosition())
	 */
	//	@Raw
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
	 *       | result == Math.sqr(xVelocity^2 + getYVelocity^2) > getMaximumVelocity()
	 */
	public static boolean isValidXVelocity(double xVelocity) {
		return false;
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
	//@Basic @Raw
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
	 *       | result == Math.sqr(getXVelocity^2 + yVelocity) > getMaximumVelocity()
	 */
	public static boolean isValidYVelocity(double yVelocity) {
		return false;
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
	//@Raw
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
	//	@Basic @Raw @Immutable
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
	//	@Raw
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
	//	@Basic @Raw
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
	//	@Raw
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
	//	@Basic @Raw @Immutable
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
	//	@Raw
	public boolean canHaveAsShapeRadius(double shapeRadius) {
		return false;
	}

	/**
	 * Variable registering the shapeRadius of this spaceship.
	 */
	private final double shapeRadius;
}
