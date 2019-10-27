import java.util.*;
public class longestSubstringWithoutRepeatingCharacters {
	public static void main(String[] args) {
		String s = "tmmzuxt";
		System.out.println(findLongest(s));
	}
	
	public static Integer findLongest(String s) {
        int n = s.length();
        if(s.isEmpty())
        	return 0;
        int ans = 0,i=0,j=0;
        Map<Character,Integer> charMap = new HashMap<>();
        while(i<n && j<n) {
        	if(charMap.containsKey(s.charAt(j))) {
        		i = Math.max(charMap.get(s.charAt(j)),i);
        	}
        	
        	ans = Math.max(ans, j-i);
        	charMap.put(s.charAt(j),j+1);
        	j++;
        }
        
        return ans;
	}
}
