
import java.util.Scanner;

 class Radius {
	public static void main( String[] args )
    {  
	   double radius = 0;
       Scanner input = new Scanner(System.in);
       do {
    	   System.out.println("Enter a radius: ");
    	   radius = input.nextDouble();
           System.out.println("The radius is: " + radius);
       
        	   Area.CalcArea(radius);
        	   }while (input.hasNext()); 
       input.close();
       }
    }