import java.util.Scanner;

public class Pyramid{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the height for the pyramid: ");
		int height = input.nextInt();
		int row = 0;                                       // row -> variable for number of outputs 
		int leftspace = height*height-height;              // on one line of the left side of the pyramid
		int mainspace = height*height;                     //calculates middle point 
		System.out.printf("%"+mainspace+"s\n",1);  
		for(int i = 2; i <= height; i++){                  // outputs left side of the pyramid
			for(int k = 1; k < i; k++) {
				if(i == height || k > 1) {                 // leftspace is set to height on the  
					leftspace = height;}                   // second output of each line of the left side
					//System.out.println(leftspace);       // and on the last line as well 
					System.out.printf("%"+leftspace+"s",i-k);
					leftspace -= height; 
					row = k;
			}
			if(i > 2)
				leftspace += height*height-height - row*height; // Ensures leftspace is set back to one space less  
				System.out.printf("%"+height+"s",i);            // than previous line 
			for(int j = row; j != 0; j--) {                     //        1(space 16)  with height 4
				System.out.printf("%"+height+"s",i-j);          //      1 2 1  (space 12)
			}                                                   //    1 2 3 2 1   (space 1->8, 2->4(height))
			System.out.printf("\n");                            //  1 2 3 4 3 2 1  (all spaces -> 4(height))
	}	
		input.close();
	}
}

