package application;

import java.util.ArrayList;

/**
 * The objects of class Order represent a trade orders of multiple PVC windows
 * and doors. The instance variable 'orderList' of type ArrayList<PVCWindow>
 * stores references to instances of class PVCWindow and its child classes
 * created at runtime.
 * 
 * @author a
 *
 */
public class Order {

	private ArrayList<PVCWindow> orderList;
	private double pricePerSqMGlass;
	private double pricePerLMFrame;
	private double totalSqMGlass;
	private double totalLMFrame;
	private double totalPriceGlass;
	private double totalPriceFrame;
	private double totalPriceOrder;

	public Order() {
		super();
		this.orderList = orderList;
		this.pricePerSqMGlass = pricePerSqMGlass;
		this.pricePerLMFrame = pricePerLMFrame;
		this.totalSqMGlass = totalSqMGlass;
		this.totalLMFrame = totalLMFrame;
		this.totalPriceGlass = totalPriceGlass;
		this.totalPriceFrame = totalPriceFrame;
		this.totalPriceOrder = totalPriceOrder;
	}

	public ArrayList<PVCWindow> getOrderList() {

		if (orderList == null) {
			orderList = new ArrayList<PVCWindow>();
		}
		return orderList;
	}

	public void setOrderList(ArrayList<PVCWindow> orderList) {
		this.orderList = orderList;
	}

	public double getPricePerSqMGlass() {
		return pricePerSqMGlass;
	}

	public void setPricePerSqMGlass(double pricePerSqMGlass) {
		this.pricePerSqMGlass = pricePerSqMGlass;
	}

	public double getPricePerLMFrame() {
		return pricePerLMFrame;
	}

	public void setPricePerLMFrame(double pricePerLMFrame) {
		this.pricePerLMFrame = pricePerLMFrame;
	}

	public double getTotalSqMGlass() {
		return totalSqMGlass;
	}

	public void setTotalSqMGlass(double totalSqMGlass) {
		this.totalSqMGlass = totalSqMGlass;
	}

	public double getTotalLMFrame() {
		return totalLMFrame;
	}

	public void setTotalLMFrame(double totalLMFrame) {
		this.totalLMFrame = totalLMFrame;
	}

	public double getTotalPriceGlass() {
		return totalPriceGlass;
	}

	public void setTotalPriceGlass(double totalPriceGlass) {
		this.totalPriceGlass = totalPriceGlass;
	}

	public double getTotalPriceFrame() {
		return totalPriceFrame;
	}

	public void setTotalPriceFrame(double totalPriceFrame) {
		this.totalPriceFrame = totalPriceFrame;
	}

	public double getTotalPriceOrder() {
		return totalPriceOrder;
	}

	public void setTotalPriceOrder(double totalPriceOrder) {
		this.totalPriceOrder = totalPriceOrder;
	}

	public PVCWindow getLastItem() {
		return this.orderList.get(this.orderList.size() - 1);
	}
	
	public void addItem(PVCWindow win) {
		this.orderList.add(win);
	}

	/**
	 * Calculates the square meters of glass needed for the order fulfillment. In
	 * the for loop the square area of the specific window is divided by 10000
	 * because it is calculated in square centimeters by the method
	 * calculateSqCmGlass() but here it is needed in square meters.
	 * 
	 * @return the square meters of glass needed for the order fulfillment
	 */
	public double calculateTotalSqMGlass() {
		double totalSqM = 0;
		for (int i = 0; i < this.orderList.size(); i++) {
			totalSqM = totalSqM + this.orderList.get(i).calculateSqCmGlass() / 10000;
		}
		return totalSqM;
	}

	/**
	 * Calculates the linear meters of frame needed for the order fulfillment. In
	 * the for loop the total width of the frame of the specific window is divided
	 * by 100 because it is calculated in linear centimeters by the method
	 * calculateLCmFrame() but here it is needed in linear meters.
	 * 
	 * @return the linear meters of frame needed for the order fulfillment
	 */
	public double calculateTotalLMFrame() {
		double totalLM = 0;
		for (int i = 0; i < this.orderList.size(); i++) {
			totalLM = totalLM + this.orderList.get(i).calculateLCmFrame() / 100;
		}
		return totalLM;
	}

	/**
	 * Calculates the total price of the glass needed for the order fulfillment.
	 * 
	 * @return the total price of the glass needed for the order fulfillment
	 */
	public double calculateTotalPriceGlass() {
		return totalSqMGlass * pricePerSqMGlass;
	}

	/**
	 * Calculates the total price of the frame needed for the order fulfillment.
	 * 
	 * @return the total price of the frame needed for the order fulfillment
	 */
	public double calculateTotalPriceFrame() {
		return totalLMFrame * pricePerLMFrame;
	}

	/**
	 * Calculates the total price of the order.
	 * 
	 * @return the total price of the order.
	 */
	public double calculateTotalPriceOrder() {
		return totalSqMGlass * pricePerSqMGlass + totalLMFrame * pricePerLMFrame;
	}
	
	public void setTotalValues() {
		this.setTotalSqMGlass(this.calculateTotalSqMGlass());
		this.setTotalLMFrame(this.calculateTotalLMFrame());
		this.setTotalPriceGlass(this.calculateTotalPriceGlass());
		this.setTotalPriceFrame(this.calculateTotalPriceFrame());
		this.setTotalPriceOrder(this.calculateTotalPriceOrder());
	}

}
