/**
 * 
 */
package application;

/**
 * @author a
 *
 */
public class PVCWindow3With3OpenableWings extends PVCWindow {

	public PVCWindow3With3OpenableWings() {
		super();
	}

	@Override
	public double calculateLCmFrame() {
		if (this.horizontal == true) {
			return 4 * this.width + 10 * this.height;
		} else {
			return 10 * this.width + 4 * this.height;
		}
	}

	@Override
	public String toString() {
		double sqM = sqCmGlass / 10000;
		double lM = lCmFrame / 100;
		if (this.horizontal == true) {
			return String.format(
					"Прозорец - 3 хоризонтално разположени крила, 3 отваряеми | Размери: %d см / %d см, %nСтъклопакет: %.3f м%c (%d см%c), Профил: %.2f м (%d см), Цена на прозореца: %.2f лв.",
					(int) width, (int) height, sqM, '\u00B2', (int) sqCmGlass, '\u00B2', lM, (int) lCmFrame,
					windowPrice);
		} else {
			return String.format(
					"Прозорец - 3 вертикално разположени крила, 3 отваряеми | Размери: %d см / %d см, %nСтъклопакет: %.3f м%c (%d см%c), Профил: %.2f м (%d см), Цена на прозореца: %.2f лв.",
					(int) width, (int) height, sqM, '\u00B2', (int) sqCmGlass, '\u00B2', lM, (int) lCmFrame,
					windowPrice);
		}
	}

}
