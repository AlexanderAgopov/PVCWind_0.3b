/**
 * 
 */
package application;

/**
 * @author a
 *
 */
public class PVCWindow4Unopenable extends PVCWindow {

	// Generate constructors
	public PVCWindow4Unopenable() {
		super();
	}

	public PVCWindow4Unopenable(boolean horizontal) {
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
			return 2 * this.width + 5 * this.height;
		} else {
			return 5 * this.width + 2 * this.height;
		}
	}

	@Override
	public String toString() {
		double sqM = sqCmGlass / 10000;
		double lM = lCmFrame / 100;
		if (this.horizontal == true) {
			return String.format(
					"Прозорец - 4 хоризонтално разположени крила, неотваряем | Размери: %d см / %d см, %nСтъклопакет: %.3f м%c (%d см%c), Профил: %.2f м (%d см), Цена на прозореца: %.2f лв.",
					(int) width, (int) height, sqM, '\u00B2', (int) sqCmGlass, '\u00B2', lM, (int) lCmFrame,
					windowPrice);
		} else {
			return String.format(
					"Прозорец - 4 вертикално разположени крила, неотваряем | Размери: %d см / %d см, %nСтъклопакет: %.3f м%c (%d см%c), Профил: %.2f м (%d см), Цена на прозореца: %.2f лв.",
					(int) width, (int) height, sqM, '\u00B2', (int) sqCmGlass, '\u00B2', lM, (int) lCmFrame,
					windowPrice);
		}
	}

}
