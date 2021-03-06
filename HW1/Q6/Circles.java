import java.util.Scanner;

import javafx.scene.shape.Circle;

public class Circles {
	static Circle circle1 = new Circle();
	static Circle circle2 = new Circle();
	public static void main (String[] args) {
		AssignValues();
		CalcDistance();
	}
	public static void AssignValues () {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter coordinates and radius: ");
		circle1.setCenterX(input.nextDouble());
		circle1.setCenterY(input.nextDouble());
		circle1.setRadius(input.nextDouble());
		circle2.setCenterX(input.nextDouble());
		circle2.setCenterY(input.nextDouble());
		circle2.setRadius(input.nextDouble());
		input.close();
	}
	
	
	// The function uses x,y coordinates and radiuses of 2 circles, calculates distances and determines 
	// if the circles overlap, touch, don't touch, or one within another.
	
	public static void CalcDistance () {	
		if (Math.sqrt(Math.pow(circle1.getCenterX()-circle2.getCenterX(),2)+ 
				Math.pow(circle1.getCenterY()-circle2.getCenterY(),2))+ circle1.getRadius() <= Math.pow(circle2.getRadius(), 2)
				|| Math.sqrt(Math.pow(circle1.getCenterX()-circle2.getCenterX(),2)+ 
						Math.pow(circle1.getCenterY()-circle2.getCenterY(),2))+ circle2.getRadius() <= Math.pow(circle1.getRadius(), 2)) 
			System.out.println("The first circle is within the second cicrcle. ");
		else if (circle1.getRadius()+circle2.getRadius() > Math.sqrt(Math.pow(circle1.getCenterX()-circle2.getCenterX(),2)+ 
				Math.pow(circle1.getCenterY()-circle2.getCenterY(),2)))
			System.out.println("The circles overlap with each other. ");
		else if(circle1.getRadius()+circle2.getRadius() == Math.sqrt(Math.pow(circle1.getCenterX()-circle2.getCenterX(),2)+ 
				Math.pow(circle1.getCenterY()-circle2.getCenterY(),2)))
			 System.out.println("The circles touch each other. ");
		 else System.out.println("The circles do not touch each other. ");
	}	
}