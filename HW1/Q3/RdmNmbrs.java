//Question 3

import java.time.Month;
import java.util.Random;

public class RdmNmbrs
{
	public static void main (String[] args)
	{
		Random rand = new Random();
		int a = rand.nextInt(12);
		if(a == 0) 
		{
			a += 1;
			} 
		System.out.println("The month is" + " " + a +" - " + Month.of(a).name());
	}
}