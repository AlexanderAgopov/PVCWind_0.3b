/**
 * 
 */
package application;

/**
 * @author a
 *
 */
public class PVCWindow1With1OpenableWing extends PVCWindow {

	public PVCWindow1With1OpenableWing() {
		super();
	}

	/**
	 * The method calculateLCmFrame() calculates the linear centimeters of frame
	 * required for the production of window with one wing which is openable.
	 * 
	 * @return the linear centimeters of frame required for the production of the
	 *         window
	 */
	@Override
	public double calculateLCmFrame() {
		return 2 * (2 * this.width + 2 * this.height);
	}

	@Override
	public String toString() {
		double sqM = sqCmGlass / 10000;
		double lM = lCmFrame / 100;
		return String.format(
				"Прозорец - 1 крило, отваряемо | Размери: %d см / %d см, %nСтъклопакет: %.3f м%c (%d см%c), Профил: %.2f м (%d см), Цена на прозореца: %.2f лв.",
				(int) width, (int) height, sqM, '\u00B2', (int) sqCmGlass, '\u00B2', lM, (int) lCmFrame, windowPrice);
	}

}
