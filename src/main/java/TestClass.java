import java.awt.List;
import java.util.ArrayList;

public class TestClass {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		String otp = "916634";
		
		ArrayList otpelemts = new ArrayList();
		
		char[] cArray = otp.toCharArray();
		
		for (int i = 0 ; i < cArray.length ; i ++)
		{
			for (int j = i ; j <= i ; j++)
			{
				otpelemts.add(cArray[i]);
			}
			System.out.println(cArray[i]);
			
		}
		System.out.println("List element");
		for (int i = 0 ; i < otpelemts.size() ; i ++)
		{
			System.out.println(otpelemts.get(i));
		}
		
	}

}
