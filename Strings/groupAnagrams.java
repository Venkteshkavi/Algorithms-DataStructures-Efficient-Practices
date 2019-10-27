import java.util.*;
public class groupAnagrams {
	public static void main(String[] args) {
		String[] s = {"eat", "tea", "tan", "ate", "nat", "bat"};
		System.out.println(groupTheAnagrams(s));
	}
	
	private static List<List<String>> groupTheAnagrams(String[] strArray) {
		if(strArray.length == 0)
			return new ArrayList<>();
		Map<String,List<String>> anagramMap = new HashMap<>();
		for(String s : strArray) {
			char[] c = s.toCharArray();
			int[] counter = new int[26];
			for(char ch: c) {
				counter[ch-'a']++;
			}
			
			StringBuilder keyBuilder = new StringBuilder();
			for(int i=0; i<26; i++) {
				keyBuilder.append("#");
				keyBuilder.append(counter[i]);
			}
			
			String keyToInsert = keyBuilder.toString();
			if(!anagramMap.containsKey(keyToInsert)) {
				anagramMap.put(keyToInsert,new ArrayList());
			}
			anagramMap.get(keyToInsert).add(s);
		}	
		return new ArrayList<>(anagramMap.values());
	}
}
