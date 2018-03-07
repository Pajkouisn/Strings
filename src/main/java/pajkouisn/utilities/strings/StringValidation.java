package pajkouisn.utilities.strings;


/**	
 * 	Basic string validations.
 * 
 * 	1)	isInteger(String string)
 *  	Checks whether the given string is an integer or not.
 *  
 * 
 * 	@author Kartik
 *
 */
public class StringValidation 
{
	
	StringValidation()
	{
		
	}
	
	/*	Checks whether the given string is an integer or not.
	 * 
	 * 	@param string
	 * 	@return
	 */
	public static boolean isInteger(String string) 
	{
	    if (string == null) 
	    {
	        return false;
	    }
	    
	    int length = string.length();
	    
	    if (length == 0) 
	    {
	        return false;
	    }
	    
	    for (int i = 0; i < length; i++) 
	    {
	        char c = string.charAt(i);
	        if (c < '0' || c > '9') 
	        {
	            return false;
	        }
	    }
	    return true;
	}
}
