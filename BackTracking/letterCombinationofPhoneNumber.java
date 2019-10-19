import java.util.*;
public class letterCombinationofPhoneNumber {
	public static void main(String[] args) {
		String digits = "23";
		Map<String,String> phoneMap = new HashMap<>();
		phoneMap.put("2","abc");
		phoneMap.put("3","def");
		phoneMap.put("4","ghi");
		phoneMap.put("5","jkl");
		phoneMap.put("6","mno");
		phoneMap.put("7","pqrs");
		phoneMap.put("8","tuv");
		phoneMap.put("9","wxyz");
		List<String> result = new ArrayList<>();
		System.out.println(findLetterCombinations(digits, phoneMap,result));
	}
	
	
	private static List<String> findLetterCombinations(String digits,Map<String,String> phoneMap,List<String> result) {	
		if(digits.isEmpty()) {
			return result;
		}
		backTrack("",digits,phoneMap,result);
		return result;
	}
	
	
	private static void backTrack(String combination,String new_digit, Map<String,String> phoneMap,List<String> result) {
		if(new_digit.length() == 0) {
			result.add(combination);
			return;
		}
		
		String digit_1 = new_digit.substring(0,1);
		String digit_1Letters = phoneMap.get(digit_1);
		for(int i=0; i<digit_1Letters.length(); i++) {
			String digit_1Letter = phoneMap.get(digit_1).substring(i,i+1);
			//Substring .substring(1) will give all the character till the end of the string excluding the 
			// given character :

			backTrack(combination+digit_1Letter, new_digit.substring(1),phoneMap,result);
		}
	}
}
