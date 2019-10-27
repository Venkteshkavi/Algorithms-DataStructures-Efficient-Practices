import java.util.*;
public class removeVowelsFromString {
	public static void main(String[] args) {
		String[] s = {"aeiou","vrwjzolzzkfulwgioksfxmcxmnnjto"};
		for(String str : s) {
			System.out.println(removeFunctionUsingBuilder(str));
			System.out.println("Using Two Pointed Approach");
		}
	}
	
	
	public static String removeFunctionUsingBuilder(String str) {
		if(str.isEmpty())
			return "";
		Character vowels[] = {'a','e','i','o','u','A','E','I','O','U'};
		List<Character> vowelList = Arrays.asList(vowels);
		Stack<Integer> stack = new Stack();
		
		StringBuilder sb = new StringBuilder(str);
		
		for(int i=0; i<sb.length(); i++) {
			if(vowelList.contains(sb.charAt(i))) {
				sb.replace(i,i+1,""); 
				i--;
				
			}
		}
		
		return sb.toString();
		
	}

}




