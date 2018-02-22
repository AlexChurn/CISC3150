import java.util.HashSet;
import java.util.Set;
	
	   public final class MyString {
				private final char[] chars;
				int count = 0;                           // used by the constructor, length(), set to 0 before each use 
			
		public MyString(char[] chars) {
			Set<Character> uniqueCharSet = new HashSet<Character>();
			count = 0;
			//Character sp = new Character(' ');                      //    In case need to count spaces 
			for(char c : chars) {                                     
				//if(new Character(c) == sp) {
					//continue;
				//}else {
					count++;
			//	}
				uniqueCharSet.add(c);
			}
			this.chars = new char[count];
	        System.arraycopy(chars, 0, this.chars, 0, count);  // System.out.println("Used constructor"+"   "+count);
		}
		
		public char charAt(int index) {
			return this.chars[index];
			
		}
		
		public int length() {
			Set<Character> uniqueCharSet = new HashSet<Character>();
			count = 0 ;
				for(char c : chars) {
					count++;
					uniqueCharSet.add(c);
			}
		
//			int num = 0;                                                                //         works as well, just wanted to try out something new I learned -> HashSet 
//			while (true) {
//			    try {
//			    	int t = this.crs[num]; //System.out.println(num+"  "+ string[num]);
//			    	num++;
//			    } catch (ArrayIndexOutOfBoundsException ex) {
//			        break;
//			   }
//			}
			        return count;
	}
	
		public MyString substring(int begin, int end) {                                //  naming char[] chars different results in no output !!!
			char[] chars = new char[end - begin];
	        for (int i = begin; i < end; i++) {
	            chars[i - begin ] = this.charAt(i);
	        }
			return new MyString(chars);
			
		}
		
		public MyString toLowerCase() {
			 char[] lowerCase = new char[count];

		        for (int i = 0; i < count; i++) {
		            if (chars[i] >= 'A' && this.chars[i] <= 'Z') {
		                lowerCase[i] = (char)(this.chars[i] + 32);        // ASCII A #65; a #97
		            } else {
		                lowerCase[i] = this.chars[i];
		            }
		        }

		        return new MyString(lowerCase);
		}
		public MyString toUpperCase() {
			char[] upperCase = new char[count];

	        for (int i = 0; i < count; i++) {
	            if (chars[i] >= 'a' && this.chars[i] <= 'z') {
	            	upperCase[i] = (char)(this.chars[i] - 32);   
	            } else {
	                upperCase[i] = this.chars[i];
	            }
	        }

	        return new MyString(upperCase);
			
		}
		public int compareTo(MyString s) {
			int k = 0;
			for (int i = 0; i < this.length() &&            // length1 && length2 in case -> compute and computer 
                    i < s.length(); i++) {
         if ((int)this.charAt(i) == 
             (int)s.charAt(i)) {
             continue;
         } 
         else {                          // System.out.println("Output here /compare.");
             return (int)this.charAt(i) -                   // Lower and upper cases differ String != string 
                    (int)s.charAt(i);
         }
     }
			if(this.length() > s.length())                  // Same upper/lower case differ. in # of letters
				return k = this.length() - s.length();
			if(this.length() < s.length())
				return k = this.length() - s.length();
			else return 0;
		}
		
		public MyString getMyString() {
			 return new MyString(this.chars);
			 
		}
	
		public String toString() {
			String output = new String(this.chars);
			return output;
			
		}
		
		public static int findIntLength(int i) {      //  finds length of char[?] for valueof() method
			 int length = 0; 
		     while (i > 0) {
		    	 i /= 10;
		    	 length++;//System.out.println(length);
		     }
			return length;
		}
		
		public static MyString valueOf(int i) {
			int length = findIntLength(i);
	        char[] charsNum = new char[length];
	        for (int k = length - 1; k >= 0; k--) {
	            charsNum[k] = (char)('0' + (i % 10));     
	            i /= 10;
	        }
	        return new MyString(charsNum);
	    }
}
