package com.example.unittesing.mock;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import junit.framework.Assert;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeastOnce;

public class ListMockTest {

	List mock=mock(List.class);

	@Test
	public void test_simpleList_success() {
		
		
		Mockito.when(mock.size()).thenReturn(5);
		
		Assert.assertEquals(5, mock.size());
		
	}
	
	@Test
	public void test_returnListDifferentValues_success() {
		Mockito.when(mock.size()).thenReturn(5).thenReturn(10);
		
		Assert.assertEquals(5, mock.size());
		Assert.assertEquals(10, mock.size());
	}

	@Test
	public void test_returnWithParameter_success() {
		
		Mockito.when(mock.get(0)).thenReturn("in 28 Minutes");
		
		Assert.assertEquals("in 28 Minutes",mock.get(0));
		
	}
	
	@Test
	public void test_returnWithGenericParameter_success() {
		
		Mockito.when(mock.get(anyInt())).thenReturn("in28Minutes");
		
		Assert.assertEquals("in28Minutes", mock.get(0));
		Assert.assertEquals("in28Minutes", mock.get(1));
		
	}
	
	@Test
	public void verficationBasics() {
		
		// System Under Test (SUT)
		String value=(String) mock.get(0);
		String value2=(String) mock.get(1);
		
		Mockito.verify(mock,times(2)).get(anyInt());
	}
	
	@Test
	public void test_argumentCapturing() {
		// System Under Test
		mock.add("SomeString");
		
		// Verification
		ArgumentCaptor<String> captor=ArgumentCaptor.forClass(String.class);
		
		Mockito.verify(mock).add(captor.capture());
		
		Assert.assertEquals("SomeString",captor.getValue());
		
	}
	
	
	@Test
	public void test_argumentCapturingWithMultipleCalls() {
		
		// SUT
		mock.add("SomeString1");
		mock.add("SomeString2");
		
		// Verification
		ArgumentCaptor<String> captor=ArgumentCaptor.forClass(String.class);
		Mockito.verify(mock,times(2)).add(captor.capture());
		
		List<String> allValues=captor.getAllValues();
		
		Assert.assertEquals("SomeString1", allValues.get(0));
		Assert.assertEquals("SomeString2", allValues.get(1));
	}
	
	@Test
	public void test_spying() {
		ArrayList spyList=spy(ArrayList.class);
		spyList.add("Test0");
		System.out.println(spyList.get(0));
		System.out.println(spyList.size());
		spyList.add("Test1");
		spyList.add("Test2");
		System.out.println(spyList.size());
		Mockito.when(spyList.size()).thenReturn(5);
		System.out.println(spyList.size());
		
		spyList.add("Test4");
		
		Mockito.verify(spyList).add("Test4");
	}
	
}
