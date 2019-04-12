package com.example.unittesting.UnitTestingMockito.business;

import com.example.unittesting.data.SomeDataService;


// Maintaining the stub would be tedious
// An interface would have many methods in it
// If one more method is added/delete/modify to the interface then there will be compilation errors in the
// in the existing test cases

public class SomeDataServiceStub implements SomeDataService{

	@Override
	public int[] retrieveAllData() {
		
		return new int[] {1,2,3};
	}

}

class SomeDataServiceEmptyStub implements SomeDataService{

	@Override
	public int[] retrieveAllData() {
		return new int[] {};
	}
	
}

class SomeDataServiceOneElementStub implements SomeDataService{

	@Override
	public int[] retrieveAllData() {
		return new int[] {3};
	}
	
}
