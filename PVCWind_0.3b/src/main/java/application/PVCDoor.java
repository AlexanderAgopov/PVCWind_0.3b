/**
 * 
 */
package application;

/**
 * @author a
 *
 */
public class PVCDoor extends PVCWindow {

	public PVCDoor() {
		super();
	}

	@Override
	public double calculateLCmFrame() {
		return 2 * (2 * this.width + 2 * this.height);
	}

	@Override
	public String toString() {
		double sqM = sqCmGlass / 10000;
		double lM = lCmFrame / 100;
		return String.format(
				"Врата | Размери: %d см / %d см, %nСтъклопакет: %.3f м%c (%d см%c), Профил: %.2f м (%d см), Цена на вратата: %.2f лв.",
				(int) width, (int) height, sqM, '\u00B2', (int) sqCmGlass, '\u00B2', lM, (int) lCmFrame, windowPrice);
	}

}
