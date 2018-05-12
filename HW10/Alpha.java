import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Alpha {
	public static void main(String args[]) throws InterruptedException {
		 
	        ExecutorService executor= Executors.newFixedThreadPool(4);
	        
	        Thread t1 = new Thread(new HelloRunnable(1));
	        Thread t2 = new Thread(new HelloRunnable(2));
	    	Thread t3 = new Thread(new HelloRunnable(3));
	        Thread t4 = new Thread(new HelloRunnable(4));
	        
	        try{
	            while(Shared.count < 26) {
	            	
	            	if (Shared.count >= 26)
	            		executor.shutdown();
	            	
	            	else {
	            		executor.execute(t1);
	            		executor.execute(t2);
	            		executor.execute(t3);
	            		executor.execute(t4);
	            	}
	            }
	        }catch(Exception err){
	            err.printStackTrace();
	        }
    }
}

class Shared 
{
    static int count;
    static char[] alphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
}


class HelloRunnable implements Runnable {
	
	private static int turn = 1;
	private static int turn_max = 4;
	int id;
	
    public HelloRunnable(int i){
        this.id = i;
    }
    public synchronized void run(){
    	if(Shared.count < 26 && turn == this.id) {
    		try{
    			System.out.println("Thread "+id+" is printing "+ Shared.alphabet[Shared.count]);
    			Shared.count++;
    			turn++;
    			if (turn > turn_max) {
    				turn = 1;
    			}
            
    		}catch(Exception err){
    			err.printStackTrace();
    		}
    	}
    }
}
  