import java.util.*;
public class validParanthesis {
	public static void main(String[] args) {
		
		String s = "()";
		String s1 = "()[]{}";
		String s2 = "(]";
		String s3 = "([)]";
		String s4 = "{[]}";
		String s5 = "";

		List<String> strArr = new ArrayList<String>() {
			{
				add(s);
				add(s1);
				add(s2);
				add(s3);
				add(s4);
				add(s5);
			}
		};
		
		System.out.println(strArr);
		for(int i=0; i<strArr.size(); i++) {
			System.out.println(checkforValidity(strArr.get(i)));
		}
	}
	
	
	public static boolean checkforValidity(String s) {
		if(s.isEmpty()) {
			return false;
		}
		Stack<Character> stack = new Stack();
		Map<Character,Character> map = new HashMap<>();
		map.put(')','(');
		map.put('}','{');
		map.put(']','[');
		for(int i=0; i<s.length(); i++) {
			if(map.containsKey(s.charAt(i))) {
				char topElement = stack.isEmpty()?'#':stack.pop();
				if(topElement != map.get(s.charAt(i))) {
					return false;
				}
			}
			else {			
				stack.push(s.charAt(i));
			}
		}
		
		
		
		return stack.isEmpty();
	}
}
