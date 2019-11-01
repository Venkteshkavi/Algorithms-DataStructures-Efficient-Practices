import java.util.*;
public class validPalindrome2 {
	public static void main(String[] args) {
		String s = "abcca";
		System.out.println(isValidPalindrome2GreedyApproach(s));
		System.out.println(isValidPalindrome2BruteForce(s));
	}
	
	private static boolean isValidPalindrome2GreedyApproach(String s) {
		int i = 0, j = s.length()-1;
		char start, end;
		while(i<j) {
			start = s.charAt(i);
			end = s.charAt(j);
			
			if(start!=end) {
				return checkPalindromicity(i+1,j,s) || checkPalindromicity(i,j-1,s); 
			}
			
			i++;
			j--;
			
		}
		
		return true;
	}
	
	private static boolean isValidPalindrome2BruteForce(String s) {
		StringBuilder sb = new StringBuilder(s);
		
		int i=0,j=s.length()-1;
		
		while(i<j) {
			if(s.charAt(i) != s.charAt(j)){
				sb.deleteCharAt(i);
				boolean res1 = checkPalindromicity(0,sb.length()-1,sb.toString());
				sb.insert(i,s.charAt(i));
				sb.deleteCharAt(j);
				boolean res2 = checkPalindromicity(0,sb.length()-1,sb.toString());
				sb.insert(j, s.charAt(j));
				return res1 || res2;
			}
			i++;
			j--;
		}
		
		return true;
	}
	private static boolean checkPalindromicity(int i,int j,String s) {
		
		while(i<j) {
			if(s.charAt(i) != s.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		
		
		return true;
	}
}

