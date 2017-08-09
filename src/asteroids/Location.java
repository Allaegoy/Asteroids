package asteroids;


/**
 * @invar  The x-position of each entity must be a valid x-position for any
 *         entity.
 *       | isValidXPosition(getXPosition())
 * @invar  The y-coordinate of each entity must be a valid y-coordinate for any
 *         entity.
 *       | isValidYCoordinate(getYCoordinate())
 */
public class Location {

	/**
	 * Variable registering the x-position of this entity.
	 */
	private double x;
	
	/**
	 * Variable registering the y-coordinate of this entity.
	 */
	private double y;
	
	
	/**
	 * Initialize this new entity with given (x, y)-position.
	 * 
	 * @param  x, y
	 *         The (x, y)-position for this new entity.
	 * @pre    The given x-position must be a valid x-position for any entity.
	 *       | isValidXPosition(x-position)
	 * @pre    The given y-position must be a valid y-position for any entity.
	 *       | isValidYPosition(y-position)
	 *       
	 * @post   The x-position of this new entity is equal to the given
	 *         x-position.
	 *       | new.getXPosition() == x
	 * @post   The y-position of this new entity is equal to the given
	 *         y-position.
	 *       | new.getYPosition() == y
	 */
	public Location(double x, double y) {
		this.setXPosition(x);
		this.setYCoordinate(y);
	}

	/**
	 * Return the x-position of this entity.
	 */
	@Basic @Raw
	public double getXPosition() {
		return this.x;
	}

	/**
	 * Check whether the given x-position is a valid x-position for
	 * any entity.
	 *  
	 * @param  x-position
	 *         The x-position to check.
	 * @return 
	 *       | result == true
	 */
	public static boolean isValidXPosition(double Xco) {
		return true;
	}

	/**
	 * Set the x-position of this entity to the given x-position.
	 * 
	 * @param  x
	 *         The new x-position for this entity.
	 * @pre    The given x-position must be a valid x-position for any
	 *         entity.
	 *       | isValidXPosition(x)
	 * @post   The x-position of this entity is equal to the given
	 *         x-position.
	 *       | new.getXPosition() == x
	 */
	@Raw
	public void setXPosition(double x) {
		assert isValidXPosition(x);
		this.x = x;
	}





	/**
	 * Return the y-coordinate of this entity.
	 */
	@Basic @Raw
	public double getYCoordinate() {
		return this.y;
	}

	/**
	 * Check whether the given y-coordinate is a valid y-coordinate for
	 * any entity.
	 *  
	 * @param  y-coordinate
	 *         The y-coordinate to check.
	 * @return 
	 *       | result == true
	 */
	public static boolean isValidYCoordinate(double y) {
		return true;
	}

	/**
	 * Set the y-coordinate of this entity to the given y-coordinate.
	 * 
	 * @param  y
	 *         The new y-coordinate for this entity.
	 * @pre    The given y-coordinate must be a valid y-coordinate for any
	 *         entity.
	 *       | isValidYCoordinate(y)
	 * @post   The y-coordinate of this entity is equal to the given
	 *         y-coordinate.
	 *       | new.getYCoordinate() == y
	 */
	@Raw
	public void setYCoordinate(double y) {
		assert isValidYCoordinate(y);
		this.y = y;
	}
}
