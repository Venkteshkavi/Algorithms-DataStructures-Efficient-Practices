import java.util.*;
public class generateParanthesis {
	public static void main(String[] args) {
		int noToGenerate = 3;
 		List<String> ans = generateAllParanthesisComb(noToGenerate);
 		System.out.println(ans);
	}
	
	public static List<String> generateAllParanthesisComb(int n) {
		List<String> result = new ArrayList<String>();
		if(n == 0)
			return result;
		
		helper("",n,result,0,0);
		
		
		
		return result;
	}
	
	
	public static void helper(String s,int n, List<String> result,int open,int close){
		if(s.length() == n*2) {
			result.add(s);
			return;
		}
		
		if(open < n) {
			helper(s+'(',n,result,open+1,close);
		}
		
		if(close<open) {
			helper(s+')',n,result,open,close+1);
		}
		
	}
}
