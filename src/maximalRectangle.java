import java.util.*;
public class maximalRectangle {
	public static void main(String[] args) {
		char[][] matrix = new char[][] {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};	
		int result = 0;
		result = maximalRectangle(matrix);
		System.out.println(result);
	}
	
	public static int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0 || matrix == null)
            return 0;

        int[] dp = new int[matrix[0].length];
        int result = 0;
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                dp[j] = matrix[i][j] == '1'? dp[j]+1:0;
            }
            result = Math.max(result,findRectangleArea(dp));
            System.out.println(result);
        }
        
        return result;
	}
	
    public static int findRectangleArea(int[] dp){
    //Now finding the maximum rectangle area
        System.out.println(Arrays.toString(dp));
        int maxarea=0;
        Stack<Integer> stack = new Stack<Integer>();
        for(int i=0; i<dp.length; i++){
            if(stack.isEmpty() || dp[stack.peek()] <= dp[i]){
                stack.push(i);
            }
            else{
                maxarea = Math.max(maxarea, dp[stack.pop()] * (stack.isEmpty()?i:i-stack.peek()-1));
            }
        }
        
        //Calculating area of remaining elements
        while(!stack.isEmpty()){
            maxarea = Math.max(maxarea, dp[stack.pop()] * (stack.isEmpty()?dp.length:dp.length-stack.peek()-1));
        }
        
        return maxarea;
    }
}
