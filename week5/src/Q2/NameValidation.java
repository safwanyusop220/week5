package Q2;
import java.io.Serializable;

public class NameValidation {

	public String validateItemName(ItemProduct itemProduct)
	{
		
		String result = "Valid Name. ", name = itemProduct.getName();
		
		for(int i=0; i<name.length();i++)
		{
		    
			char ch = name.charAt(i);
		    
			// To check if the character is not alphabet or space
			if (!(Character.isLetter(ch) || ch == ' ') )
			{
				
				result="Invalid Name. ";
				
		    }
		
		}
		return result;	
	

	}

}
