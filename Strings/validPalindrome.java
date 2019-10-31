import java.util.*;
public class validPalindrome {
	public static void main(String[] args) {
		String s = "A man, a plan, a canal: Panama,";
		System.out.println(isValidPalindrome(s));
		System.out.println(isValidPalindromeUsingRegex(s));
	}
	
	private static boolean isValidPalindrome(String str) {
			if(str.isEmpty())
				return false;
			int head = 0,tail = str.length()-1;
			while(head<tail) {
				if(Character.toLowerCase(str.charAt(head)) == Character.toLowerCase(str.charAt(tail))) {
					head++;
					tail--;
				}
				
				else if(!Character.isLetterOrDigit(str.charAt(head))) {
					head++;
				}
				else if(!Character.isLetterOrDigit(str.charAt(tail))) {
					tail--;
				}
				else {
					return false;
				}
			}
		
		
		return true;
	}
	
	private static boolean isValidPalindromeUsingRegex(String s) {
		if(s.isEmpty())
			return false;
		
		String ans = s.replaceAll("[^A-Za-z0-9]","").toLowerCase();
		String str = new StringBuilder(ans).reverse().toString();
		if(str.equals(ans))
			return true;
		return false;
	}
}
