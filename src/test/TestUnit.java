package test;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import src.CashRegister;

public class TestUnit {
	public static CashRegister cashregister;
	
	@BeforeClass
	public static void setup() {
		cashregister = new CashRegister();
		Assert.assertEquals(CashRegister.class, cashregister.getClass());
	}
		
	@Test
	public void testRingUp() {
		cashregister.clear();
		cashregister.ringUp(8);
		Assert.assertTrue(CashRegister.pricesTotal== 8.0);
		cashregister.ringUp(2);
		Assert.assertTrue(CashRegister.pricesTotal== 10.0);
	}
	
	@Test
	public void testGetMax() {
		cashregister.clear();
		cashregister.ringUp(8);
		cashregister.ringUp(2);
		cashregister.ringUp(23);
		Assert.assertTrue(cashregister.getMax()== 23);
	}
	
	@Test
	public void testGetMin() {
		cashregister.clear();
		cashregister.ringUp(82);
		cashregister.ringUp(20);
		cashregister.ringUp(23);
		Assert.assertTrue(cashregister.getMin()== 20);
	}
	
	@Test
	public void testGetMean() {
		cashregister.clear();
		cashregister.ringUp(5);
		cashregister.ringUp(1);
		cashregister.ringUp(1);
		Assert.assertTrue(cashregister.getMean()== 2.3333332538604736);
		cashregister.clear();
		cashregister.ringUp(5);
		cashregister.ringUp(1);
		Assert.assertTrue(cashregister.getMean()== 3);
		cashregister.clear();
		cashregister.ringUp(5);
		cashregister.ringUp(2);
		Assert.assertTrue(cashregister.getMean()== 3.5);
	}
	
	@Test
	public void testGetMode() {
		cashregister.clear();
		cashregister.ringUp(5);
		cashregister.ringUp(1);
		cashregister.ringUp(1);
		Assert.assertTrue(cashregister.getMode()== 1);
		cashregister.ringUp(5);
		cashregister.ringUp(5);
		cashregister.ringUp(5);
		Assert.assertTrue(cashregister.getMode()== 5);
		cashregister.ringUp(23);
		cashregister.ringUp(23);
		cashregister.ringUp(23);
		cashregister.ringUp(23);
		cashregister.ringUp(23);
		Assert.assertTrue(cashregister.getMode()== 23);
	}
	
	@AfterClass
	public static void tearDown() {
		cashregister = null;
	}
		

}
