package com.test.packer;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.packer.Packer;
import com.packer.exception.APIException;


/**
 * Packer unit test
 */
public class PackerTest {

	@Test(expected = APIException.class)
	public void shouldThrownAnAPIException() {
		new Packer().pack("invalidPathToFile.txt");
	}
	
	@Test
	public void packFourPackages() {
		Assert.assertEquals(new Packer().pack("src/main/resources/pack.txt"), "4\n-\n2,7\n8,9");
	}
	
	@Rule
	public ExpectedException expectedEx = ExpectedException.none();
	
	@Test
	public void shouldThrownItemCostException() throws APIException {
		expectedEx.expect(APIException.class);
	    expectedEx.expectMessage("Item can not cost more than 100.0. Current item cost: 500.0");
		
		new Packer().pack("src/main/resources/RuleItemCostTest.txt");
	}
	
	@Test
	public void shouldThrownItemWeightException() throws APIException {
		expectedEx.expect(APIException.class);
	    expectedEx.expectMessage("Item can not weight more than 100.0. Current item weight: 153.38");
		
		new Packer().pack("src/main/resources/RuleItemWeightTest.txt");
	}
	
	@Test
	public void shouldThrownMaxSetOfItensException() throws APIException {
		expectedEx.expect(APIException.class);
	    expectedEx.expectMessage("Package can not have more than 15 itens. Current size: 20");
		
		new Packer().pack("src/main/resources/RuleMaxSetOfItemsTest.txt");
	}
	
	@Test
	public void shouldThrownPackMaxWeightException() throws APIException {
		expectedEx.expect(APIException.class);
	    expectedEx.expectMessage("Package can not weight more than 100. Current package weight: 150.0");
		
		new Packer().pack("src/main/resources/RulePackMaxWeightTest.txt");
	}
}
