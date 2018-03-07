package pajkouisn.unit;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import pajkouisn.utilities.strings.StringValidation;


/**
 * 
 * 	JUnit tests for StringValidation.
 * 	
 * 	@author kartiklaw@gmail.com (www.kartik-reddy.com)
 *
 */
public class TestStringValidation
{	
	/*
	 * 	Validate whether a String is a number
	 */
	@Test
	public void testIsNumber()
	{
		boolean check = true;
			
		check &= StringValidation.isInteger("S3://bucketname/prefix1/prefix2/prefix3") ? false : true;
		check &= !StringValidation.isInteger("30") ? false : true;
		check &= StringValidation.isInteger("50n") ? false : true;
		
		assertTrue(check);
	}
}
