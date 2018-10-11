/**
 * 
 */
package application;

/**
 * @author a
 *
 */
public class PVCWindow3With2OpenableWings extends PVCWindow {

	public PVCWindow3With2OpenableWings() {
		super();
	}

	@Override
	public double calculateLCmFrame() {
		if (this.horizontal == true) {
			return 2 * this.width + 8 * this.height + 2 * this.wing1Width + 2 * this.wing2Width;
		} else {
			return 8 * this.width + 2 * this.height + 2 * this.wing1Height + 2 * this.wing2Height;
		}
	}

	@Override
	public String toString() {
		double sqM = sqCmGlass / 10000;
		double lM = lCmFrame / 100;
		if (this.horizontal == true) {
			return String.format(
					"Прозорец - 3 хоризонтално разположени крила, 2 отваряеми | Размери: %d см / %d см, Ширина на отваряеми крила: крило 1 - %d см, крило 2 - %d см,%nСтъклопакет: %.3f м%c (%d см%c), Профил: %.2f м (%d см), Цена на прозореца: %.2f лв.",
					(int) width, (int) height, (int) wing1Width, (int) wing2Width, sqM, '\u00B2', (int) sqCmGlass,
					'\u00B2', lM, (int) lCmFrame, windowPrice);
		} else {
			return String.format(
					"Прозорец - 3 вертикално разположени крила, 2 отваряеми | Размери: %d см / %d см, Височина на отваряеми крила: крило 1 - %d см, крило 2 - %d см,%nСтъклопакет: %.3f м%c (%d см%c), Профил: %.2f м (%d см), Цена на прозореца: %.2f лв.",
					(int) width, (int) height, (int) wing1Height, (int) wing2Height, sqM, '\u00B2', (int) sqCmGlass,
					'\u00B2', lM, (int) lCmFrame, windowPrice);
		}
	}

}
