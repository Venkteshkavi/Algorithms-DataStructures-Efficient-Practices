import java.util.*;
public class leetCode56 {
	public static void main(String[] args) {
		int[][] intervals = new int[][] {{1,3},{8,10},{2,6},{15,18}};
		System.out.println(Arrays.deepToString(merge(intervals)));
	}
	
	public static int[][] merge(int[][] intervals){
		if (intervals.length <= 1)
			return intervals;

		// Sort by ascending starting point
		Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));

		List<int[]> result = new ArrayList<>();
		int[] newInterval = intervals[0];
		result.add(newInterval);
		for (int[] interval : intervals) {
			if (interval[0] <= newInterval[1]) {// Overlapping intervals, move the end if needed
				System.out.println(interval[0] + " " + newInterval[1]);
				newInterval[1] = Math.max(newInterval[1], interval[1]);
			}
			else {                             // Disjoint intervals, add the new interval to the list
				newInterval = interval;
				result.add(newInterval);
			}
		}
		Object[] output = result.toArray();
		for(Object item: output) {
			System.out.println(item);
		}
		return result.toArray(new int[result.size()][]);
	}
}
