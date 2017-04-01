package ku.util;

public enum Weight implements Unit {
	/**
	 * Ton unit.
	 */
	Ton("tonne", 1E6),
	
	/*
	 * Milligram unit.
	 */
	Milligram("milligram", 1E-3),
	
	/**
	 * Gram unit.
	 */
	Gram("gram", 1.0),
	
	/**
	 * Kilogram unit.
	 */
	Kilogram("kilogram", 1000.0);
	
	public final double value;
	public final String name;
	
	/**
	 * Constructor for creating the Weight units.
	 * 
	 * @param name is the name of the unit.
	 * @param value is the value of the in grams.
	 */
	Weight(String name, double value) {
		this.value = value;
		this.name = name;
	}
	
	/**
	 * Gets the value of the unit in grams.
	 * 
	 * @return value of the unit in grams.
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
