	 class Test{
		 public static void main (String[] args) {
			 char[] s = {'S', 't', 'r','i', 'n', 'g','s',' ', 'a', 'r','e',' ', 'f', 'u', 'n'};
			 MyString s1 = new MyString(s);
			 //char[] chars2 = {'h', 'e', 'l', 'l', 'o'};
			 // s1 = new MyString(chars2);
			 // chars2[0] = 'c';
			 System.out.println(s1.getMyString());
			 //char[] charsFromMyString = s1.getMyString();
			 //charsFromMyString[4] = 's';
			 System.out.println(s1.length()+" is the length");
			 System.out.println(s1.getMyString());
			 System.out.println("subString is:"+"  "+s1.substring(0, 6));
			 System.out.println(s1.toLowerCase());
			 System.out.println(s1.toUpperCase());
			 System.out.println(s1.charAt(0));
			 System.out.println(MyString.valueOf(34));
			 char[] s3 = {'S', 't', 'r','i', 'n', 'g', 's' ,' ', 'a', 'r','e',' ', 'f', 'u', 'n'};
			 MyString s2 = new MyString(s3);
			 System.out.println(s1.compareTo(s2));
			 // String new1 = "String";
			 //String new2 = "strings";
			 // System.out.println(new1.compareTo(new2));
		 }
		}