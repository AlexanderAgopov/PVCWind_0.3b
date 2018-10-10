package application;

/**
 * The objects of class PVCWindow represent the windows which should be included
 * in the order. The instance variable sqCmGlass stores the square centimeters
 * of glass required for the production of the window. The instance variable
 * lCmFrame stores the linear centimeters of PVC frame required for the
 * production of the window. The variable 'horizontal' defines the position of
 * the window which could be horizontal (horizontal = true) or vertical
 * (horizontal = false). 
 * 
 * @author a
 *
 */
public class PVCWindow extends PVC {
	// Create fields
	protected double width;
	protected double height;
	protected double sqCmGlass;
	protected double lCmFrame;
	protected double wing1Width;
	protected double wing1Height;
	protected double wing2Width;
	protected double wing2Height;
	protected double wing3Width;
	protected double wing3Height;
	protected double wing4Width;
	protected double wing4Height;
	protected double windowGlassPrice;
	protected double windowFramePrice;
	protected double windowPrice;
	protected boolean horizontal;

	// Generate constructor
	public PVCWindow() {
		super();
		this.width = width;
		this.height = height;
		this.sqCmGlass = sqCmGlass;
		this.lCmFrame = lCmFrame;
		this.wing1Width = wing1Width;
		this.wing1Height = wing1Height;
		this.wing2Width = wing2Width;
		this.wing2Height = wing2Height;
		this.wing3Width = wing3Width;
		this.wing3Height = wing3Height;
		this.wing4Width = wing4Width;
		this.wing4Height = wing4Height;
		this.windowGlassPrice = windowGlassPrice;
		this.windowFramePrice = windowFramePrice;
		this.windowPrice = windowPrice;
		this.horizontal = horizontal;
	}

	public double getWidth() {
		return width;
	}

	public double getWing1Width() {
		return wing1Width;
	}

	public void setWing1Width(double wing1Width) {
		this.wing1Width = wing1Width;
	}

	public double getWing1Height() {
		return wing1Height;
	}

	public void setWing1Height(double wing1Height) {
		this.wing1Height = wing1Height;
	}

	public double getWing2Width() {
		return wing2Width;
	}

	public void setWing2Width(double wing2Width) {
		this.wing2Width = wing2Width;
	}

	public double getWing2Height() {
		return wing2Height;
	}

	public void setWing2Height(double wing2Height) {
		this.wing2Height = wing2Height;
	}

	public double getWing3Width() {
		return wing3Width;
	}

	public void setWing3Width(double wing3Width) {
		this.wing3Width = wing3Width;
	}

	public double getWing3Height() {
		return wing3Height;
	}

	public void setWing3Height(double wing3Height) {
		this.wing3Height = wing3Height;
	}

	public double getWing4Width() {
		return wing4Width;
	}

	public void setWing4Width(double wing4Width) {
		this.wing4Width = wing4Width;
	}

	public double getWing4Height() {
		return wing4Height;
	}

	public void setWing4Height(double wing4Height) {
		this.wing4Height = wing4Height;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getSqCmGlass() {
		return sqCmGlass;
	}

	public void setSqCmGlass(double d) {
		this.sqCmGlass = d;
	}

	public double getLCmFrame() {
		return lCmFrame;
	}

	public void setLCmFrame(double d) {
		this.lCmFrame = d;
	}

	public double getWindowGlassPrice() {
		return windowGlassPrice;
	}

	public void setWindowGlassPrice(double windowGlassPrice) {
		this.windowGlassPrice = windowGlassPrice;
	}

	public double getWindowFramePrice() {
		return windowFramePrice;
	}

	public void setWindowFramePrice(double windowFramePrice) {
		this.windowFramePrice = windowFramePrice;
	}

	public double getWindowPrice() {
		return windowPrice;
	}

	public void setWindowPrice(double windowPrice) {
		this.windowPrice = windowPrice;
	}

	public boolean isHorizontal() {
		return horizontal;
	}

	public void setHorizontal(boolean horizontal) {
		this.horizontal = horizontal;
	}

	/**
	 * The method calculateSqCmGlass() calculates the square centimeters of glass
	 * required for the production of the window.
	 * 
	 * @return the square centimeters of glass required for the production of the
	 *         window
	 */
	@Override
	public double calculateSqCmGlass() {
		return this.width * this.height;
	}

	/**
	 * The method calculateLCmFrame() calculates the linear centimeters of frame
	 * required for the production of the window.
	 * 
	 * @return the linear centimeters of frame required for the production of the
	 *         window
	 */
	@Override
	public double calculateLCmFrame() {
		return 2 * this.width + 2 * this.height;
	}

	@Override
	public double calculateWindowPrice(double glassPricePerSqM, double framePricePerLM) {

		return (calculateSqCmGlass() * glassPricePerSqM) / 10000 + (calculateLCmFrame() * framePricePerLM) / 100;
	}

	@Override
	public String toString() {
		double sqM = sqCmGlass / 10000;
		double lM = lCmFrame / 100;
		return String.format(
				"Прозорец - 1 крило, неотваряемо | Размери: %d см / %d см, %nСтъклопакет: %.3f м%c (%d см%c), Профил: %.2f м (%d см), Цена на прозореца: %.2f лв.",
				(int) width, (int) height, sqM, '\u00B2', (int) sqCmGlass, '\u00B2', lM, (int) lCmFrame, windowPrice);
	}

}
