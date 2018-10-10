/**
 * 
 */
package application;

/**
 * @author a
 *
 */
public abstract class PVC {
	
	abstract double calculateSqCmGlass();
	
	abstract double calculateLCmFrame();
	
	abstract double calculateWindowPrice(double glassPricePerSqM, double framePricePerLM);
	
	public abstract String toString();

}
