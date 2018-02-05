//Question 5


import java.util.Scanner;

import javafx.geometry.Point2D;


public class Triangle
{	
	private static Scanner input;

	public static void main(String[] args) { 
		double x = 0, y = 0;
		double sideA, sideB, sideC;
		Point2D pointA, pointB, pointC;
		pointA = AssignValues(x,y);
		pointB = AssignValues(x,y);
		pointC = AssignValues(x,y);
	//	PrintPoints(pointA,pointB,pointC);
		sideA = CalcSides(pointA, pointB);
		sideB = CalcSides(pointB, pointC);
		sideC = CalcSides(pointA, pointC);
		TriangleType(sideA, sideB, sideC);
	//	System.out.println(sideA+ " "+ sideB+ " "+ sideC);
		input.close();
	}
	
	public static Point2D AssignValues (double x, double y) {
		input = new Scanner(System.in);
			System.out.println("Enter coordinates:");
			x = input.nextFloat();
			y = input.nextFloat();
			Point2D point = new Point2D(x,y); 
			return point;
	}

	
//	public static void PrintPoints (Point2D pointA, Point2D pointB, Point2D pointC) {
//		System.out.println(pointA+" "+pointB+" "+pointC);
//}
	public static double CalcSides (Point2D point1, Point2D point2) {
		double side = Math.sqrt(Math.pow((point1.getX()-point2.getX()),2)+Math.pow((point1.getY()-point2.getY()),2));
		return side = (Math.round(side *100.0)/100.0);
	}
	
	public static void TriangleType (double sideA, double sideB, double sideC){
		System.out.println("The side are: "+ " "+sideA+ " , "+ sideB+ " , "+ sideC);
		if(sideC < sideA + sideB && sideA < sideC + sideB && sideB < sideA + sideC) {
			System.out.println("The triangle is right.");
		}
		else System.out.println("The triangle is not right.");
	}
}