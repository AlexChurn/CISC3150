
import java.util.EmptyStackException;
import java.util.Stack;


public class Calculator{                                                            
                                                                                  
	public static void main(String[] args) {                                       
                                                                                   
    	                                                                          
		String exprsn = new String("");                                              
		double result = 0;                                                        
		boolean check = false; // to check  if an open ( is closed                                                
		int char_cnt = 0;    
		boolean check_for_int[] = {true};
		String doubleOrInt = new String("");
		
		for(int i = 0; i < args.length; i++) {                                      
			exprsn += args[i]; 
			doubleOrInt += args[i];
		}
		
		for(int i = 0; i < args.length; i++) { 
			if (check_for_int[0] == false)
				break;
			for(int j = 0; j < doubleOrInt.length(); j++) {
				char f = doubleOrInt.charAt(j);
				if (f == '.') {
					check_for_int[0] = false;
					break;
				}
			}
		}                                                                          
                                                                                    
    
    Stack<Character> operator = new Stack<>();
    Stack<Double> operand = new Stack<>();
     
    for (int i = 0; i<args.length; ++i)
    {
        char c = exprsn.charAt(char_cnt);
        try {
        	if (i == 0 && c != '(' && (!Character.isLetterOrDigit(c) || c == 'x'))
        		throw new UserIsADumbassException();
        }catch(UserIsADumbassException e) {
        	System.err.println("An operand missing");
    		System.exit(0);
        }
        if (Character.isLetterOrDigit(c) && (c != 'x' || args.length == 1)) {
        		try {																
        			char_cnt = Parse(operand, args, i, check_for_int, 0);
        		}catch (QuitMashingOnYourKeyboardException ex) {
        			System.err.println("Invalid operand");
        			System.exit(0);
            	}
        }
        
        else if (c == '(') {
            operator.push(c);
            check = true;
        }
        
        else if (c == ')')
        {
        	  result = Compute(result, operand, operator);	
              check = false;
        }
        else 
        {	
        	try {
        		while (!operator.isEmpty() && operator.peek() != '(' && PrecOrder(c) <= PrecOrder(operator.peek())) 
            	
        			result = Compute(result, operand, operator); 
        	
        	}catch (EmptyStackException e ) {
        			System.out.println("");	
        	}
        		
        	operator.push(c);
        }
      
        if (i != args.length-1)
        	try {
        		if(Character.isLetterOrDigit(c) && Character.isLetterOrDigit(exprsn.charAt(char_cnt+1)) && exprsn.charAt(char_cnt+1) != 'x' && c != 'x') 
        			throw new UserIsADumbassException();
        	}catch(UserIsADumbassException ex) {
        		System.err.println("Missing an operator");
        		System.exit(0);
        	}
       
        char_cnt++;	
  
    }
  
    
    while (!operator.isEmpty()) {
    	if(check == true)
    		throw new IlleglArgumentException("Quit Missing Things");
    	else {
    		result = Compute(result, operand, operator);
    	}
    	if (!operator.isEmpty())
    		operator.pop();
    }
    if (check_for_int[0] == true)
    	System.out.println( "The result is "+(int)result); 
    else
    	System.out.println("The result is "+result); 
 
      
        }
     

	private static int PrecOrder(char operator) {
		
		switch (operator) {
		
		case '+':
        case '-':
            return 1;
      
        case '.':
        case '/':
            return 2;
		}
		return -1;
	}

	public static int Parse (Stack<Double> operand, String args[], int i, boolean[] check_for_int, int k) throws IlleglArgumentException {
		try {
			
			operand.push(Double.parseDouble(args[i]));
					return opernd_length(operand, i);
		} catch (NumberFormatException ex) {
    		throw new QuitMashingOnYourKeyboardException();
    	}
	}
	
	
	private static double Compute(double result, Stack<Double> operand, Stack<Character> operator)  throws IlleglArgumentException, EmptyStackException {
		
		Stack<Double> resul_t = new Stack<>();
		
		while (!operator.isEmpty() && operator.peek() != '(') {
			char opertr = operator.peek();
			try {
				switch (opertr) {	
					case '+': //Addition
						if(result == 0.0) {
							result = operand.pop() + operand.pop();
							operand.push(result);
					}
						else {
							resul_t.push(operand.pop() + operand.pop());
							operand.push(resul_t.pop());
						}
						break;
					
					case '-': //Subtraction
						if(result == 0.0) {
							double last_opernd = operand.pop();
							result = operand.pop() - last_opernd;
							operand.push(result);
						}
						else {
							double la_stopernd = operand.pop();
							resul_t.push(operand.pop() - la_stopernd);
							operand.push(resul_t.pop());
						}
						break;
					
/* Overall logic. Small functions skipped. args are concatenated into String exprsn variable. Each character of exprsn   letter or digit is passed to Parse function. (Parse function description) 
 * Digits are parsed, letters trigger exception QuitMashingOnYourKeyboardException. Parsed values are pushed to operand stack. (Parse function end of description)
 * All exceptions are handled by main. User only sees error messages, not the Exceptions themselves. (First if statement )If '(' is encountered it’s pushed onto
 * the operator stack, variable check is set to true. (Second if statement) If ")" is encountered Compute function is called. After Compute finishes the check 
 * is set to back to false. (Compute function description) Loop until '(' is encountered or the operator stack is empty. The operator stack is popped after
 *  each iteration. If the passed to function variable result is 0 for addition and multiplication first operand is popped and added to the second popped 
 *  operand, same logic used for multiplication, the sum and product are stored in result variable. For subtraction and division order matters, so the
 *  operand is popped and stored into lastopernd variable then it is subtracted from the popped operand, division is done using the same logic. 
 *  If the variable result is not 0 then all operations are performed in the same manner but resulting values are store in another stack variable 
 *  resul_t. The value of resul_t is then pushed onto the operand stack and resul_t stack is popped. If the operation is not supported the
 * AlgebraFailException exception is triggered. The division by 0 results in error that is output to console, program stops. After loop finishes the result 
 * variable is assigned a value in the operand stack, the result is returned to main. (Compute function description end) The else statement implements 
 *  the postfix logic of computations by calling PrecOrder and checking the precedence of operators. Compute is called here in a loop until ‘(’ 
 *  is encountered or the operator stack is empty. The third if statement checks whether the operator is not missing. If it is missing the
 *  UserIsADumbassException exception is triggered. At this point if stack is not empty the last while loop executes. It checks if an open
 *  ‘(’ is not missing a close ‘)’ by checking variable check which should be false. If it is true the IlleglArgumentException is triggered.
 *  Compute is called. The operator stack is popped then because the Compute function does not pop ‘(’ of the operator stack. Program outputs result if 
 *   all went well without errors. Program finished. 
 */

import java.util.EmptyStackException;
import java.util.Stack;


public class Calculator{                                                            
                                                                                  
	public static void main(String[] args) {                                       
                                                                                   
    	                                                                          
		String exprsn = new String("");                                              
		double result = 0;                                                        
		boolean check = false; // to check  if an open ( is closed                                                
		int char_cnt = 0;    
		boolean check_for_int[] = {true};
		String doubleOrInt = new String("");
		
		for(int i = 0; i < args.length; i++) {                                      
			exprsn += args[i]; 
			doubleOrInt += args[i];
		}
		
		for(int i = 0; i < args.length; i++) { 
			if (check_for_int[0] == false)
				break;
			for(int j = 0; j < doubleOrInt.length(); j++) {
				char f = doubleOrInt.charAt(j);
				if (f == '.') {
					check_for_int[0] = false;
					break;
				}
			}
		}                                                                          
                                                                                    
    
    Stack<Character> operator = new Stack<>();
    Stack<Double> operand = new Stack<>();
     
    for (int i = 0; i<args.length; ++i)
    {
        char c = exprsn.charAt(char_cnt);
        try {
        	if (i == 0 && c != '(' && (!Character.isLetterOrDigit(c) || c == 'x'))
        		throw new UserIsADumbassException();
        }catch(UserIsADumbassException e) {
        	System.err.println("An operand missing");
    		System.exit(0);
        }
        if (Character.isLetterOrDigit(c) && (c != 'x' || args.length == 1)) {
        		try {																
        			char_cnt = Parse(operand, args, i, check_for_int, 0);
        			//System.out
        		}catch (QuitMashingOnYourKeyboardException ex) {
        			System.err.println("Invalid operand");
        			System.exit(0);
            	}
        }
        
        else if (c == '(') {
            operator.push(c);
            check = true;
        }
        
        else if (c == ')')
        {
        	  result = Compute(result, operand, operator);	
              check = false;
        }
        else 
        {	System.out.println(c);
        	try {
        		while (!operator.isEmpty() && operator.peek() != '(' && PrecOrder(c) <= PrecOrder(operator.peek())) {
        			System.out.println(operator.peek());
        			result = Compute(result, operand, operator); 
        		}
        	}catch (EmptyStackException e ) {
        			System.out.println("");	
        	}
        		
        	operator.push(c);
        }
      
        if (i != args.length-1)
        	try { System.out.println(exprsn.charAt(char_cnt+1)+ "  "+c);
        		if(Character.isLetterOrDigit(c) && Character.isLetterOrDigit(exprsn.charAt(char_cnt+1)) && exprsn.charAt(char_cnt+1) != 'x' && c != 'x') 
        			throw new UserIsADumbassException();
        	}catch(UserIsADumbassException ex) {
        		System.err.println("Missing an operator");
        		System.exit(0);
        	}
       
        char_cnt++;	
  
    }
  
    
    while (!operator.isEmpty()) {
    	if(check == true)
    		throw new IlleglArgumentException("Quit Missing Things");
    	else {
    		result = Compute(result, operand, operator);
    	}
    	if (!operator.isEmpty())
    		operator.pop();
    }
    if (check_for_int[0] == true)
    	System.out.println( "The result is "+(int)result); 
    else
    	System.out.println("The result is "+result); 
 
      
        }
     

	private static int PrecOrder(char operator) {
		
		switch (operator) {
		
		case '+':
			return 1;
        case '-':
            return 1;
      
        case 'x':
        	return 2;
        case '/':
            return 2;
		}
		return -1;
	}

	public static int Parse (Stack<Double> operand, String args[], int i, boolean[] check_for_int, int k) throws IlleglArgumentException {
		try {
			
			operand.push(Double.parseDouble(args[i]));
					return opernd_length(operand, i);
		} catch (NumberFormatException ex) {
    		throw new QuitMashingOnYourKeyboardException();
    	}
	}
	
	
	private static double Compute(double result, Stack<Double> operand, Stack<Character> operator)  throws IlleglArgumentException, EmptyStackException {
		
		Stack<Double> resul_t = new Stack<>();
		
		while (!operator.isEmpty() && operator.peek() != '(') {
			char opertr = operator.peek();
			try {
				switch (opertr) {	
					case '+': //Addition
						if(result == 0.0) {
							result = operand.pop() + operand.pop();
							operand.push(result);
					}
						else {
							resul_t.push(operand.pop() + operand.pop());
							operand.push(resul_t.pop());
						}
						break;
					
					case '-': //Subtraction
						if(result == 0.0) {
							double last_opernd = operand.pop();
							result = operand.pop() - last_opernd;
							operand.push(result);
						}
						else {
							double la_stopernd = operand.pop();
							resul_t.push(operand.pop() - la_stopernd);
							operand.push(resul_t.pop());
						}
						break;
					
					case 'x': //Multiplication
						if(result == 0) {
							result = operand.pop() * operand.pop();
							operand.push(result);
						}
					else {
						resul_t.push(operand.pop() * operand.pop());
						operand.push(resul_t.pop());
					}
						break;
					
					case '/': //Division
						if( operand.peek() != 0) {
							if(result == 0 ) {
								double lastopernd = operand.pop(); 
								result = operand.pop() / lastopernd;
								operand.push(result);
							}
						else {
							double lastopern_d = operand.pop(); 
							resul_t.push(operand.pop() / lastopern_d);
							operand.push(resul_t.pop());
						}
					}
					else { System.err.println("Division by zero!!!");
						System.exit(0);
						}
					break;
					
					default: throw new AlgebraFailException ();
				}
			}catch (AlgebraFailException  e) {
				System.err.print("Operator is not supported");
				System.exit(0);
			}
			operator.pop();
		}
		
		try {
			result = operand.peek();
		}catch (EmptyStackException e) {}
		
			return result;
	}


public static int opernd_length(Stack<Double> operand, int i) {
	
	if(operand.peek() >= 10000000)
		return i += 6;
	if(operand.peek() >= 100000) 
		return i += 5;
	if(operand.peek() >= 10000)
		return i += 4;
	if(operand.peek() >= 1000)
		return i += 3;
	if(operand.peek() >= 100)
		return i += 2;
	if(operand.peek() >= 10)
		return i += 1;
	return i;
}
}


class IlleglArgumentException extends RuntimeException{
	
	public IlleglArgumentException(String s) {
		super(s);
	}
}


class AlgebraFailException extends IllegalStateException {
    public AlgebraFailException () {
        super();
    }
}
 
class QuitMashingOnYourKeyboardException extends IllegalStateException {
    public QuitMashingOnYourKeyboardException  () {
        super();
    }
}

class UserIsADumbassException extends IllegalStateException {
    public UserIsADumbassException  () {
        super();
    }
}