package ku.util;

/**
 * Length units that can be used to convert.
 * 
 * @author Sirasath Piyapootinun
 *
 */
public enum Length implements Unit{
	/**
	 * Foot unit.
	 */
	Foot("foot", 0.3048),
	
	/**
	 * Inch unit.
	 */
	Inch("inch", 0.0254),
	
	/**
	 * Meter unit.
	 */
	Meter("meter", 1.0),
	
	/**
	 * Kilometer unit.
	 */
	Kilometer("kilometer", 1000.0);
	
	public final double value;
	public final String name;
	
	/**
	 * Constructor for creating the Length units.
	 * 
	 * @param name is the name of the unit.
	 * @param value is the value of the in meters.
	 */
	Length(String name, double value) {
		this.value = value;
		this.name = name;
	}
	
	/**
	 * Gets the value of the unit in meters.
	 * 
	 * @return value of the unit in meters.
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
		return this.name();
	}
}
