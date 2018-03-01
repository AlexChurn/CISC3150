import java.util.Scanner;

public class Arrays {
	public static void main (String[] args){
		
		int length = 0 , i = 0;;
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter your input: ");                 // as a string, no spaces  
		String s = input.nextLine();
		
		System.out.println("Enter number of rows: ");
		int rows = input.nextInt();
		
		int [] max = new int [rows];
		
		char [][] array = new char [rows][];                              // 2d array to keep user input -> chars
		
		System.out.println("Enter number of colums for each row: ");            // loops through each row assigns number of columns -> user input       
		for(int k = 0; k < rows; k++) {                                         
			System.out.println("Enter number of columns for row "+k+" :");
			max[k] = input.nextInt();
			//System.out.println(max[k]);
			array[k] = new char [max[k]];
		}
		
		input.close();
		
		for (int row = 0; row < rows; row++) {                            // breaks downs the string into chars, 
			for (int column = 0; column < max[i]; column++) {             // fills in 2d array with chars
				char ch	= s.charAt(length);                   
				array [row]	[column] = ch;
				length++;
			}
			i++;
		}

		int[] index= new int[array.length];                               // keeps track of the column length -> print next line
		
		do {
		   print(index, array);
	       System.out.println();
		                             
		}
		while (CheckLength(index, array));

	}


	static boolean CheckLength(int[] index, char[][] array) {
		   for (int i = index.length ; i > 0; i--) 
		      if (++index[i-1] >= array[i-1].length) 
		         index[i-1]= 0;
		      else 
		          return true;
		   return false;
		}
	
	
	static void print (int[] index, char[][] array) {
		   for (int i = 0; i < index.length; i++) 
		      System.out.print(array[i][index[i]]);                      // loops through the last row index[i] -> number of columns  
		   return;
		}
	
}
