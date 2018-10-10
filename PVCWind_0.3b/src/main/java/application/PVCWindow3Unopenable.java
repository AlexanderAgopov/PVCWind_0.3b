/**
 * 
 */
package application;

/**
 * @author a
 *
 */
public class PVCWindow3Unopenable extends PVCWindow {

	// Generate constructors
	public PVCWindow3Unopenable() {
		super();
	}

	public PVCWindow3Unopenable(boolean horizontal) {
		super();
	}

	public boolean isHorizontal() {
		return horizontal;
	}

	public void setHorizontal(boolean horizontal) {
		this.horizontal = horizontal;
	}

	@Override
	public double calculateLCmFrame() {
		if (this.horizontal == true) {
			return 2 * this.width + 4 * this.height;
		} else {
			return 4 * this.width + 2 * this.height;
		}
	}

	@Override
	public String toString() {
		double sqM = sqCmGlass / 10000;
		double lM = lCmFrame / 100;
		if (this.horizontal == true) {
			return String.format(
					"Прозорец - 3 хоризонтално разположени крила, неотваряем | Размери: %d см / %d см, %nСтъклопакет: %.3f м%c (%d см%c), Профил: %.2f м (%d см), Цена на прозореца: %.2f лв.",
					(int) width, (int) height, sqM, '\u00B2', (int) sqCmGlass, '\u00B2', lM, (int) lCmFrame,
					windowPrice);
		} else {
			return String.format(
					"Прозорец - 3 вертикално разположени крила, неотваряем | Размери: %d см / %d см, %nСтъклопакет: %.3f м%c (%d см%c), Профил: %.2f м (%d см), Цена на прозореца: %.2f лв.",
					(int) width, (int) height, sqM, '\u00B2', (int) sqCmGlass, '\u00B2', lM, (int) lCmFrame,
					windowPrice);
		}
	}

}
