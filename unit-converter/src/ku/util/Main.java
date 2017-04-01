package ku.util;

/**
 * Main for running the ConverterUI.
 * 
 * @author Sirasath Piyapootinun
 *
 */
public class Main {
	
	/**
	 * Runs the Converter.
	 * @param args
	 */
	public static void main(String[] args) {
		UnitConverter c = new UnitConverter();
		ConverterUI ui = new ConverterUI(c);
		ui.run();
	}
}
