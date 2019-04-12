package com.example.unittesting.UnitTestingMockito.business;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.example.unittesting.business.SomeBusinessImpl;

public class SomeBusinessStubTest {
	
	private SomeBusinessImpl target;

	@Before
	public void setUp() throws Exception {
		target=new SomeBusinessImpl();
	}

	@Test
	public void test_calculateSumUsingDataService_success() {
		
		target.setSomeDataService(new SomeDataServiceStub());
		
		int result=target.calculateSumUsingDataService();
		
		Assert.assertNotNull(target);
		Assert.assertEquals(6, result);
		
		}
	
	@Test
	public void test_calculateSumUsingDataService_empty() {
		
		target.setSomeDataService(new SomeDataServiceEmptyStub());
		int result=target.calculateSumUsingDataService();
		
		Assert.assertNotNull(target);
		Assert.assertEquals(0, result);
	}
	
	@Test
	public void test_calculateUsingDataService_oneelement() {
		
		target.setSomeDataService(new SomeDataServiceOneElementStub());
		int result=target.calculateSumUsingDataService();
		
		Assert.assertEquals(3, result);
	}

}
