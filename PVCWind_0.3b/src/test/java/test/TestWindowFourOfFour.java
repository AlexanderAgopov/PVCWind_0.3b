package test;

import static org.junit.Assert.*;

import org.junit.Test;

import application.PVCWindow4With4OpenableWings;

public class TestWindowFourOfFour {

	@Test
	public void testCalculateLCmFrame() {
		PVCWindow4With4OpenableWings w = new PVCWindow4With4OpenableWings();
		w.setHorizontal(true);
		w.setHeight(100);
		w.setWidth(400);
		w.setWing1Width(100);
		w.setWing2Width(100);
		w.setWing3Width(100);
		w.setWing4Width(100);
		assertEquals(2900, w.calculateLCmFrame(), 0.01);
		
	}

	@Test
	public void testCalculateSqCmGlass() {
		PVCWindow4With4OpenableWings w = new PVCWindow4With4OpenableWings();
		w.setHorizontal(true);
		w.setHeight(100);
		w.setWidth(400);
		w.setWing1Width(100);
		w.setWing2Width(100);
		w.setWing3Width(100);
		w.setWing4Width(100);
		assertEquals(40000, w.calculateSqCmGlass(), 0.01);
	}

	@Test
	public void testCalculateWindowPrice() {
		PVCWindow4With4OpenableWings w = new PVCWindow4With4OpenableWings();
		w.setHorizontal(true);
		w.setHeight(100);
		w.setWidth(400);
		w.setWing1Width(100);
		w.setWing2Width(100);
		w.setWing3Width(100);
		w.setWing4Width(100);
		assertEquals(490, w.calculateWindowPrice(50, 10), 0.01);
	}

}
