import java.util.*;
public class findJudgeGraph {
	public static void main(String[] args) {
		int N = 4;
		int[][] trust = new int[][] { {1,2},{3,2},{1,3},{4,1},{3,1},{2,1},{2,3},{4,3},{4,2},{3,4},{2,4}};
//		[1,3],[1,4],[2,3],[2,4],[4,3]
		int result = 0;
		result = findJudge(N,trust);
		System.out.println(result);
	}
	
	public static int findJudge(int N, int[][] trust) {
		/*	1. Using Graph to solve this question
		 * 	2. The number which has no outgoing edges is the Judge, because the judge trusts no one and all others trust the judge
		 * 	3. Therefore we create an adjacency list and store all the trusted people as keys. 
		 * 	4. In the Map if the given numbers key is not present then he is the judge.
		 */	
		
		//Creating an adjacency list 
		Map<Integer,List<Integer>> town = new HashMap<Integer,List<Integer>>();
		for(int[] t : trust) {
			if(town.containsKey(t[0])) {
				town.get(t[0]).add(t[1]);
			}
			else {
				List<Integer> l = town.getOrDefault(t[0],new ArrayList<Integer>());
				l.add(t[1]);
				town.put(t[0],l);
//				town.put(t[0],new ArrayList<>());
//				ArrayList<Integer> trustList = (ArrayList<Integer>) town.get(t[0]);
//				trustList.add(t[1]);
//				town.put(t[0],trustList);
			}
		}
		
		//Now Doing Trust Couting
		Map<Integer,Integer> trustCount = new HashMap<>();
		for(List<Integer> items : town.values()) {
			for(int i:items) {
				trustCount.put(i,trustCount.getOrDefault(i,0)+1);
			}
		}
		
		//Now Finding the person trusted by everyone
		 for(int items: trustCount.keySet()) {
			  if(trustCount.get(items) == N-1 && !town.containsKey(items)) {
				   return items;
			  }
		 }
		 
		 return -1;

	}
}
