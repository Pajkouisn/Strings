package pajkouisn.utilities.strings;


import java.util.ArrayList;
import java.util.List;

/**	
 * 	String utilities.
 * 	Uses basic string functionalities that improves performance compared to standard library fucntions.
 *  
 *  1)	nthTokenAfterSplit(String text, String regex, int element)
 *  	Gets the nth element after the occurance of the regex.
 *  
 *  2)	tokenize(String text, String regex)
 *  	Gets a list of tokens split after every "regex".
 *  
 *  3)	concatenateTokens(List<String> tokens, String seperator, int...fromTo)
 *  	Merges 	items in the list based on the seperator.
 * 		Decides range of items from list to use dynamically.
 *  
 * 	@author kartiklaw@gmail.com (www.kartik-reddy.com)
 */

public class StringOperations 
{
	//	Default Constructor
	public StringOperations()
	{
		
	}
	
	/**
	 * 	Gets the nth element after the occurance of the regex.
	 * 	Drastically improves performance.
	 * 
	 * 	@param text
	 * 	@param regex
	 * 	@param element
	 * 	@return String element after split.
	 */
	public static String nthTokenAfterSplit(String text, String regex, int element)
	{
		if (element == 0)	return text.substring(0,text.indexOf(regex));
		
		int temp = 0;
		for(int j=0;j<element;j++)
		{
			temp = text.indexOf(regex, temp) + 1;
		}
		
		if(text.indexOf(regex, temp) >= 0)
		{
			return text.substring(temp, text.indexOf(regex, temp));
		}
		else
		{
			return text.substring(temp, text.length());
		}
	}
	
	
	/**
	 * 	Gets a list of tokens split after every "regex".
	 * 
	 * 	@param text
	 * 	@param regex
	 * 	@return List of tokens
	 */
	public static ArrayList<String> tokenize(String text, String regex)
	{
		ArrayList<String> list = new ArrayList<String>(); 
		int end = 0;
		int start = 0;
		
		while(true)
		{
			start = end;
			end = text.indexOf(regex, start)+1;
			if(end > start)
			{
				String subString = text.substring(start,end-1);
				list.add(subString);
			}
			
			else 
			{
				String subString = text.substring(start,text.length());
				list.add(subString);
				break;
			}
		}
		return list;
	}
	
	/**
	 * 	Merges 	items in the list based on the seperator.
	 * 	Decides range of items from list to use dynamically.
	 * 
	 * 	If no parameters exist for fromTo, then concatenate all tokens.
	 * 	If parameter 0 exists for FromTo, then use that as beginning.
	 * 	If parameter 1 exists for FromTo, then use that as end.
	 * 
	 * 	@param tokens
	 * 	@param fromTo
	 * 	@return
	 */
	public static String concetenateTokens(List<String> tokens, String seperator, int...fromTo)
	{
		/*
		 * 	String to store the concatenated tokens.
		 */
		String concatenatedString = "";
		
		/*
		 * 	Iterate from start index to the end index.
		 * 	If no parameters exist for fromTo, then concatenate all tokens.
		 * 	If parameter 0 exists for FromTo, then use that as beginning.
		 * 	If parameter 1 exists for FromTo, then use that as end.
		 */
		for(int index = fromTo.length > 0 ? fromTo[0] : 0; 
			index < (fromTo.length > 1 ? (fromTo[1] <= tokens.size() ? fromTo[1] : tokens.size()) : tokens.size()); 
			index++)
		{
			if(index ==  (fromTo.length > 1 ? (fromTo[1] <= tokens.size() ? fromTo[1] : tokens.size()) : tokens.size()) - 1)
				concatenatedString += tokens.get(index);
			else	concatenatedString += tokens.get(index) + "/";
		}
		
		return concatenatedString;
	}
}
