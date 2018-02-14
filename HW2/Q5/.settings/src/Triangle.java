import java.util.Scanner;

import javafx.geometry.Point2D;


public class Triangle
{
	static Scanner input;
	public static void main(String[] args) {
		double x = 0, y = 0;
		double sideA, sideB, sideC;
		Point2D pointA, pointB, pointC;
		pointA = assignvalues(x,y);
		pointB = assignvalues(x,y);
		pointC = assignvalues(x,y);
		printpoints(pointA,pointB,pointC);
		sideA = calcsides(pointA, pointB);
		sideB = calcsides(pointB, pointC);
		sideC = calcsides(pointA, pointC);
		System.out.println(sideA+"  "+sideB+"  "+sideC);
		triangletype(sideA, sideB, sideC);
		input.close();
	}
	
	public static Point2D assignvalues (double x, double y) {
		Scanner input = new Scanner(System.in);
			System.out.println("Enter coordinates:");
			x = input.nextDouble();
			y = input.nextDouble();
			Point2D point = new Point2D(x,y); 
			return point;
	}

	public static void printpoints (Point2D pointA, Point2D pointB, Point2D pointC) {
		System.out.println(pointA+" "+pointB+" "+pointC);
}
	public static double calcsides (Point2D point1, Point2D point2) {
		return Math.sqrt(Math.pow((point1.getX()-point2.getX()),2)+Math.pow((point1.getY()-point2.getY()),2));
	}
	
	public static void triangletype (double sideA, double sideB, double sideC) {
		if(sideC < sideA + sideB ||sideA < sideC + sideB ||sideB < sideA + sideC ) {
			System.out.println("The triangle is right.");
		}
		else System.out.println("The triangle is not right.");
	}
}