package ku.util;

public enum Volume implements Unit {
	/**
	 * Liter unit.
	 */
	LITER("Liter", 0.001),
	
	/**
	 * Milliliter unit.
	 */
	MILLILITER("Milliliter", 1E-6),
	/**
	 * Cubic foot unit.
	 */
	CUBICFOOT("Cubic foot", 0.0283168),
	/**
	 * Cubic meter unit.
	 */
	CUBICMETER("Cubic meter", 1.0);
	
	public final double value;
	public final String name;
	
	/**
	 * Constructor for creating the Volume units.
	 * 
	 * @param name is the name of the unit.
	 * @param value is the value of the in cubic meters.
	 */
	Volume(String name, double value) {
		this.value = value;
		this.name = name;
	}
	
	/**
	 * Gets the value of the unit in cubic meters.
	 * 
	 * @return value of the unit in cubic meters.
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
