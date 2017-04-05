package ku.util;

public enum Area implements Unit {
	/**
	 * Square foot unit.
	 */
	SQUAREFOOT("Square foot", 0.092903),
	
	/**
	 * Square inch unit.
	 */
	SQUAREINCH("Square inch", 0.00064516),
	
	/**
	 * Square meter unit.
	 */
	SQUAREMETER("Square meter", 1.0),
	
	/**
	 * Square kilometer unit.
	 */
	SQUAREKILOMETER("Square kilometer", 1E6);
	
	public final double value;
	public final String name;
	
	/**
	 * Constructor for creating the Area units.
	 * 
	 * @param name is the name of the unit.
	 * @param value is the value of the in square meters.
	 */
	Area(String name, double value) {
		this.value = value;
		this.name = name;
	}
	
	/**
	 * Gets the value of the unit in square meters.
	 * 
	 * @return value of the unit in square meters.
	 */
	@Override
	public double getValue() {
		return this.value;
	}
	
	
	/**
	 * Return the String representation of the unit.
	 * 
	 *  @return the String representation of the unit. 
	 */
	@Override
	public String toString() {
		return this.name;
	}

}
