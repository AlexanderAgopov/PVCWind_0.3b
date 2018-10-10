package test;

import static org.junit.Assert.*;
import org.junit.Test;

import application.Order;
import application.PVCWindow;

public class TestOrder {

	
	@Test
	public void testCalculateTotalSqMGlass() {
		Order order = new Order();
		order.getOrderList().add(new PVCWindow());
		order.getOrderList().add(new PVCWindow());
		order.getOrderList().add(new PVCWindow());
		order.getOrderList().get(0).setWidth(100);
		order.getOrderList().get(0).setHeight(100);
		order.getOrderList().get(1).setWidth(1000);
		order.getOrderList().get(1).setHeight(1000);
		order.getOrderList().get(2).setWidth(10);
		order.getOrderList().get(2).setHeight(10);
		assertEquals(101.01, order.calculateTotalSqMGlass(), 0.001);
	}

	@Test
	public void testCalculateTotalLMFrame() {
		Order order = new Order();
		order.getOrderList().add(new PVCWindow());
		order.getOrderList().add(new PVCWindow());
		order.getOrderList().add(new PVCWindow());
		order.getOrderList().get(0).setWidth(100);
		order.getOrderList().get(0).setHeight(100);
		order.getOrderList().get(1).setWidth(1000);
		order.getOrderList().get(1).setHeight(1000);
		order.getOrderList().get(2).setWidth(10);
		order.getOrderList().get(2).setHeight(10);
		assertEquals(44.4, order.calculateTotalLMFrame(), 0.01);
	}

	@Test
	public void testCalculateTotalPriceGlass() {
		Order order = new Order();
		order.setPricePerSqMGlass(10);
		order.setTotalSqMGlass(5);
		assertEquals(50, order.calculateTotalPriceOrder(), 0.01);
	}

	@Test
	public void testCalculateTotalPriceFrame() {
		Order order = new Order();
		order.setPricePerLMFrame(2.5);
		order.setTotalLMFrame(5);
		assertEquals(12.5, order.calculateTotalPriceFrame(), 0.01);
	}

	@Test
	public void testCalculateTotalPriceOrder() {
		Order order = new Order();
		order.setPricePerSqMGlass(10);
		order.setTotalSqMGlass(5);
		order.setPricePerLMFrame(2.5);
		order.setTotalLMFrame(5);
		assertEquals(62.5, order.calculateTotalPriceOrder(), 0.01);
	}

}
