/**
 * 
 */
package application;

/**
 * @author a
 *
 */
public class PVCWindow2With1OpenableWing extends PVCWindow {

	// Generate constructors
	public PVCWindow2With1OpenableWing() {
		super();
	}

	public PVCWindow2With1OpenableWing(boolean horizontal) {
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
			return 2 * this.width + 5 * this.height + 2 * this.wing1Width;
		} else {
			return 5 * this.width + 2 * this.height + 2 * this.wing1Height;
		}
	}

	@Override
	public String toString() {
		double sqM = sqCmGlass / 10000;
		double lM = lCmFrame / 100;
		if (this.horizontal == true) {
			return String.format(
					"Прозорец - 2 хоризонтално разположени крила, 1 отваряемо | Размери: %d см / %d см, Ширина на отваряемо крило: %d см,%nСтъклопакет: %.3f м%c (%d см%c), Профил: %.2f м (%d см), Цена на прозореца: %.2f лв.",
					(int) width, (int) height, (int) wing1Width, sqM, '\u00B2', (int) sqCmGlass, '\u00B2', lM,
					(int) lCmFrame, windowPrice);
		} else {
			return String.format(
					"Прозорец - 2 вертикално разположени крила, 1 отваряемо | Размери: %d см / %d см, Височина на отваряемо крило: %d см,%nСтъклопакет: %.3f м%c (%d см%c), Профил: %.2f м (%d см), Цена на прозореца: %.2f лв.",
					(int) width, (int) height, (int) wing1Height, sqM, '\u00B2', (int) sqCmGlass, '\u00B2', lM,
					(int) lCmFrame, windowPrice);
		}
	}

}
