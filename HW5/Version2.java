import java.util.Scanner;

import javafx.geometry.Point2D;
import javafx.scene.shape.Circle;

public class Square {
	public static void main (String[] args) {
		long before = System.currentTimeMillis();
		double radius = 0;
		double circle_x = 0;
		double circle_y = 0;
		double cmpare = 0;
		double x = 0;
		double y = 0;
		double error = 0.0000001;
		long max = 4000000000L; 
		long in_crl = max;
		boolean j = true;
	
		circle_x = 20.23;          
		circle_y = 55.12;          
		radius =  203.68;         
		
		radius *= 10000000;
		radius = (int)radius;
		radius /= 10000000;
		
		for(long i = max-1; i >= 0; i--) {
			
			x = (radius + circle_x)- (circle_x + i/((double)(i+i+2)));          
			y = (radius + circle_y)- (circle_y - i/((double)(i+2)));
		
			cmpare = ((x - circle_x)*(x - circle_x)+(y - circle_y)*(y - circle_y));
			cmpare *= 10000000;
			cmpare = (int)cmpare;
			cmpare /= 10000000;
			cmpare -= radius*radius;
			
		if (cmpare > error) 
			j = false;
		if (j == false)
				in_crl--;
					
			}	
		
		double result =((double) in_crl/max);
		System.out.println("difference: "+result+"              "+in_crl);
		System.out.println(result *((Math.PI*Math.PI)/4)+"  -> PI");
		
		System.out.println(((double)(System.currentTimeMillis()-before))/1000+" seconds.");
		
	}
	
	
}	