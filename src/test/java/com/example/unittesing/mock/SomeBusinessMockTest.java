package com.example.unittesing.mock;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.unittesting.business.SomeBusinessImpl;
import com.example.unittesting.data.SomeDataService;

@RunWith(MockitoJUnitRunner.class)
public class SomeBusinessMockTest {
	
	@InjectMocks
	SomeBusinessImpl target;
	
	@Mock
	SomeDataService mockDataService;

	@Test
	public void test_calculateSumUsingDataService_success() {
		
		
		
		Mockito.when(mockDataService.retrieveAllData()).thenReturn(new int[] {1,2,3});
		
		
		
		int result=target.calculateSumUsingDataService();
		
		Assert.assertNotNull(target);
		Assert.assertEquals(6, result);
		
		}
	
	
	@Test
	public void test_calculateSumUsingDataService_empty() {
		
		
		
		Mockito.when(mockDataService.retrieveAllData()).thenReturn(new int[] {});
		
		
		
		int result=target.calculateSumUsingDataService();
		
		Assert.assertNotNull(target);
		Assert.assertEquals(0, result);
	}
	
	
	@Test
	public void test_calculateUsingDataService_oneelement() {
		
		Mockito.when(mockDataService.retrieveAllData()).thenReturn(new int[] {3});
		int result=target.calculateSumUsingDataService();
		
		Assert.assertEquals(3, result);
	}

}
