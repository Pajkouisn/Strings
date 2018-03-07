package pajkouisn.unit;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import pajkouisn.utilities.strings.StringOperations;


/**
 * 
 * 	JUnit tests for StringOperations.
 * 	
 * 	@author kartiklaw@gmail.com (www.kartik-reddy.com)
 *
 */
public class TestStringOperations
{	
	/*
	 * 	Test finding the nth token after a split.
	 */
	@Test
	public void testNthTokenAfterSplit()
	{
		boolean check = true;
		String input = "S3://bucketname/prefix1/prefix2/prefix3";
		
		check &= StringOperations.nthTokenAfterSplit(input, "/", 0).equals("S3:");
		check &= StringOperations.nthTokenAfterSplit(input, "/", 1).equals("");
		check &= StringOperations.nthTokenAfterSplit(input, "/", 2).equals("bucketname");
		check &= StringOperations.nthTokenAfterSplit(input, "/", 3).equals("prefix1");
		check &= StringOperations.nthTokenAfterSplit(input, "/", 4).equals("prefix2");
		check &= StringOperations.nthTokenAfterSplit(input, "/", 5).equals("prefix3");
		
		assertTrue(check);
	}
	
	/*
	 * 	Get tokens.
	 */
	@Test
	public void testTokenize()
	{
		boolean check = true;
		String input = "S3://bucketname/prefix1/prefix2/prefix3";
		
		List<String> tokens = StringOperations.tokenize(input, "/");
		check &= tokens.get(0).equals("S3:");
		check &= tokens.get(1).equals("");
		check &= tokens.get(2).equals("bucketname");
		check &= tokens.get(3).equals("prefix1");
		check &= tokens.get(4).equals("prefix2");
		check &= tokens.get(5).equals("prefix3");
		
		assertTrue(check);
	}
	
	/*
	 * 	Concatenate with no indexes specified.
	 */
	@Test
	public void testConcatenateNoIndex()
	{
		boolean check = true;
		String input = "S3://bucketname/prefix1/prefix2/prefix3";
		
		List<String> tokens = StringOperations.tokenize(input, "/");
		
		//	Will concatenate all tokens.
		String concatenatedString = StringOperations.concetenateTokens(tokens, "/");
		check &= concatenatedString.equals("S3://bucketname/prefix1/prefix2/prefix3");
		
		assertTrue(check);
	}
	
	/*
	 * 	Concatenate with start index specified
	 */
	@Test
	public void testConcatenateStartIndex()
	{
		boolean check = true;
		String input = "S3://bucketname/prefix1/prefix2/prefix3";
		
		List<String> tokens = StringOperations.tokenize(input, "/");
		
		//	Will concatenate all tokens from 2nd position onwards.
		String concatenatedString = StringOperations.concetenateTokens(tokens, "/", 2);
		check &= concatenatedString.equals("bucketname/prefix1/prefix2/prefix3");
	
		assertTrue(check);
	}
	
	/*
	 * 	Concatenate with start and end index specified
	 */
	@Test
	public void testConcatenateStartEndIndex()
	{
		boolean check = true;
		String input = "S3://bucketname/prefix1/prefix2/prefix3";
		
		List<String> tokens = StringOperations.tokenize(input, "/");
		
		//	Will concatenate all tokens from 2nd position onwards to 3rd token.
		String concatenatedString = StringOperations.concetenateTokens(tokens, "/", 2, 4);
		check &= concatenatedString.equals("bucketname/prefix1");
		
		assertTrue(check);
	}
	
	/*
	 * 	Concatenate with start and end index specified
	 */
	@Test
	public void testConcatenateStartEndIndexExtraNumbers()
	{
		boolean check = true;
		String input = "S3://bucketname/prefix1/prefix2/prefix3";
		
		List<String> tokens = StringOperations.tokenize(input, "/");
		
		//	Will concatenate all tokens from 2nd position onwards to 3rd token.
		String concatenatedString = StringOperations.concetenateTokens(tokens, "/", 2, 4, 5, 6, 7);
		check &= concatenatedString.equals("bucketname/prefix1");
		
		assertTrue(check);
	}
}
