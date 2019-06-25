import java.util.*;
public class taskScheduler {
	public static void main(String[] args) {
		char[] tasks = new char[] {'A','A','A','B','B','B'};
		int coolingInterval = 2;
		int result = 0;
		result = findLeastCycleCount(tasks,coolingInterval);
		System.out.println(result);
	}
	
	public static int findLeastCycleCount(char[] tasks,int n) {
		int[] map = new int[25];
		for(char c : tasks) {
			map[c-'A']++;
		}
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(26,Collections.reverseOrder());
		for(int item : map) {
			if(item > 0)
				maxHeap.add(item);
		}
		
		int time = 0;
		while(!maxHeap.isEmpty()) {
			int i = 0;
			List<Integer> temp = new ArrayList<Integer>();
			while(i<=n) {
				if(!maxHeap.isEmpty()) {
					if(maxHeap.peek() > 1)
						temp.add(maxHeap.poll()-1);
					else
						maxHeap.poll();
				}
				time++;
				if(maxHeap.isEmpty() && temp.size() == 0) {
					break;
				}
				
				i++;
			}
			
			for(int l : temp) {
				maxHeap.add(l);
			}
		}
		
		return time;
	}
}
