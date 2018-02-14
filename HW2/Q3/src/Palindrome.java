
import java.util.Scanner;

public class Palindrome {
	 static String reverse = "";
	public static void main(String[] args){
		boolean check = false;
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a word: ");
			String word = input.nextLine();
			System.out.println(word);
			reverse = Reverse(word);
			check = CheckWord(word, reverse);
			if (check == true)
				System.out.println("The word is palindrome.");
			else System.out.println("The word is not a palindrome.");
			input.close();
	}	

	  // Checks if two words are equal 
	public static boolean CheckWord(String word, String reverse){
		if(word.compareTo(reverse) == 0)
			return true;
		else return false;
		
	}
	// Reverses the word and saves reversed word in variable reverse
	public static String Reverse (String word) {
		for(int i = word.length()-1; i >= 0; i--) {
			reverse += word.charAt(i);
		}
		System.out.println(reverse);
		return reverse;
	}
}