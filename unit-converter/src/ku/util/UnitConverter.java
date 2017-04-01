package ku.util;

/**
 * UnitConverter converts a given value from a unit to another unit.
 * 
 * @author Sirasath Piyapootinun
 *
 */
public class UnitConverter {

	/**
	 * Converts an amount from one unit to another.
	 * 
	 * @param amount
	 *            is the amount to be converted.
	 * @param fromUnit
	 *            is the unit which it is being converted from.
	 * @param toUnit
	 *            is the unit which it is being converted to.
	 * @return
	 */
	public double convert(double amount, Unit fromUnit, Unit toUnit) {
		return amount * fromUnit.getValue() / toUnit.getValue();
	}

	/**
	 * Gets the units from a unit type.
	 * 
	 * @param utype
	 *            is the unit type.
	 * @return the units of a unit type.
	 */
	public Unit[] getUnits(UnitType utype) {
		switch (utype) {
		case Length:
			return Length.values();

		case Area:
			return Area.values();

		case Volume:
			return Volume.values();

		case Weight:
			return Weight.values();
		}
		return null;
	}
}
