import java.util.Scanner;

import javafx.geometry.Point2D;
import javafx.scene.shape.Circle;

public class Version1 {
	public static void main (String[] args) {
		long before = System.currentTimeMillis();
		double radius = 0;
		double circle_x = 0;
		double circle_y = 0;
		long in_crl = 0L;
		long out_crl = 0L;
		double cmpare = 0;
		double error = 0.0000001;
		long max = 4000000000L; 
			
		circle_x = (double) (Math.random()*300);
		circle_y = (double) (Math.random()*300);
		radius = (double) (Math.random()*300);
		
		radius *= 10000000;
		radius = (int)radius;
		radius /= 10000000;
		
		for (long i = 1 ; i <= max; i++){

			double x = circle_x + (double) (Math.random()*radius);
			double y = circle_y + (double) (Math.random()*radius);	

			cmpare = Double.compare((x - circle_x)*(x - circle_x)*(y - circle_y)*(y - circle_y), radius *radius);
			
			if (cmpare - radius*radius < error)
					in_crl++;
					
		}
		double result =((double) in_crl/max);
		System.out.println("The number of points inside the quadrant of the cirle: "+result);
		System.out.println("The Pi is: "+result *((Math.PI*Math.PI)/4)+"  -> PI");
		System.out.println(System.currentTimeMillis()-before);
	}
}