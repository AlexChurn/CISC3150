//Question 4 

import java.util.Scanner;

public class Cline {

	public static void main (String[] args){
		String text;
		Scanner input = new Scanner(System.in);
		while (input.hasNext()) {
			text = input.next();
			input.useDelimiter("/");
			System.out.println(text);
			}
		input.close();
		}
}
