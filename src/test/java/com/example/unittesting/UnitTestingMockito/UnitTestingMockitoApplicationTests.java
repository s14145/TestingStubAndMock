package com.example.unittesting.UnitTestingMockito;

import org.junit.Before;
import org.junit.Test;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.unittesting.business.SomeBusinessImpl;

import junit.framework.Assert;


public class UnitTestingMockitoApplicationTests {
	
	private SomeBusinessImpl target;
	
	@Before
	public void setUp() {
		target=new SomeBusinessImpl();
	}

	@Test
	public void test_calculateSum_success() {
		
		int result=target.calculateSum(new int[] {1,2,3});
		
		Assert.assertNotNull(result);
		Assert.assertEquals(6,result);
	}
	
	@Test
	public void test_calculateSum_fail() {
		int result=target.calculateSum(new int[] {1,2,3});
		
		Assert.assertNotNull(result);
		Assert.assertNotSame(8, result);
	}
	
	@Test
	public void test_calculateSum_empty() {
		int result=target.calculateSum(new int[] {});
		
		Assert.assertEquals(0, result);
	}

}
