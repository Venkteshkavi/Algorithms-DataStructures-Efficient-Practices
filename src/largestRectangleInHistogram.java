import java.util.*;
public class largestRectangleInHistogram {
	public static void main(String[] args) {
		int[] heights = new int[] {2,0,0,0,0};
		int result = 0;
		result = findMaxRectangle(heights);
		System.out.println(result);
	}
	
	public static int findMaxRectangle(int[] heights) {
		Stack<Integer> stack = new Stack<Integer>();
		int i=0,maxarea=0, area=0;
		while(i<heights.length) {
			if(stack.isEmpty() || heights[stack.peek()] <= heights[i]) {
				stack.push(i);
				i++;
			}
			else {
				maxarea = Math.max(maxarea,heights[stack.pop()] * (stack.isEmpty()?i:i-stack.peek()-1));
//				stack.push(i);
			}
		}
		
		while(!stack.isEmpty()) {
			maxarea = Math.max(maxarea, heights[stack.pop()] * (stack.isEmpty()?heights.length:heights.length-stack.peek()-1));
		}
		
		return maxarea;
	}
}
