import java.util.Scanner;

public class NQueens {                                      // N-Queen problem -> no queen on the same row,
	public static void main(String[] args) {                // same column or diagonally 
		
		Scanner input = new Scanner(System.in);             // find diagn. left ->  row-- column--
		System.out.println("Enter number of rows");         // find diagn. right -> row++ column--
		int row = input.nextInt();                          
		int column = row;
		NQueen call = new NQueen();
		call.start(row, column);

	}
	
}

                               
	class NQueen { 
	boolean start(int row, int column)
    {
        char game[][] = new char [row][column];               // output 
      
        for(int f = 0; f < game.length; f++) 
        {                                                     // N -> no queen
        	for(int h = 0; h < column; h++)                   // Q -> queen  
        	game[f][h] = 'N';
        }
        
   //     System.out.println(game.length);
    //    print(game, row);
 
       
        if (FindRow(game, 0) == false)
        {
            return false;
        }
 
        print(game, row);

        return true;
    }
	                                                       // recursive function to find solution
	 boolean FindRow(char game[][], int column)
	    {
	//	 System.out.println("call  "+column);
		 
	        // full -> all queens placed
	        if (column >= game.length)
	            return true;
	 
	        // queen placement 
	        for (int i = 0; i < game.length; i++)
	        {
	            // condition check
	            if (check(game, i, column))
	            {
	                //place the queen 
	                game[i][column] = 'Q';
	 
	                // proceed
	                if (FindRow(game, column + 1) == true)
	                    return true;
	 
	                // queen removed
	                game[i][column] = 'N'; 
	            }
	        }
	 
	        // no placement made
	        return false;
	    }
	 
	 boolean check(char game[][], int row, int column)
	    {
	        int i, j;
	 
	        // checks the row
	        for (i = 0; i < column; i++)
	            if (game[row][i] == 'Q')
	                return false;
	 
	       //  diagonal l. s.
	        for (i = row, j = column; i >= 0 && j >= 0; i--, j--)
	            if (game[i][j] == 'Q')
	                return false;
	 
	       // diagonal r. s.
	        for (i = row, j = column; j >= 0 && i < game.length; i++, j--)
	            if (game[i][j] == 'Q')
	                return false;
	 
	        return true;
	    } 
	
	void print(char game[][], int row)
    {
        for (int i = 0; i < row ; i++)
        {
            for (int k = 0; k < row; k++)
                System.out.print(" " + game[i][k]+ " ");
            System.out.println();
        }
        System.out.println();
    }
}
