package in.licious.java;

public class ReverseString {
	
	/*public static void main(String[] args) {
		// Using StringBuffer class
		StringBuffer a = new StringBuffer("Software Testing Material");
		// use reverse() method to reverse string
		System.out.println(a.reverse());
		}*/
	
	
	public static void main(String[] args) {
		 String input="Software Testing Material";
		 StringBuilder input1 = new StringBuilder();
		 input1.append(input);
		 input1=input1.reverse(); 
		 for (int i=0;i<input1.length();i++)
		 System.out.print(input1.charAt(i));
		 }

}
