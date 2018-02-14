
import java.util.Scanner;

public class Tokenize {
	public static void main(String[] args){
	Scanner input = new Scanner(System.in);
		input.useDelimiter("[,\n]");
		System.out.println("The delimiter is "+input.delimiter());
		System.out.println("Enter values: ");
		while(input.hasNext()){
			System.out.println(input.next());
		}
		input.close();
	}
}