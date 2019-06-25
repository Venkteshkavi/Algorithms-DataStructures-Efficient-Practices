import java.util.*;
public class fibonacciSeriesDP {
	private static Integer[] memo;
	public static void main(String[] args) {
		int N = 8;
		int result=0, result_1=0, result_2=0;
//		result_1 = findRecursiveSol(N);
		memo = new Integer[N+1];
		result_2 = findDPTopDown(N);
//		result = findDPBottomUp(N);
		System.out.println(result_1 + " " + result_2 + " " + result);
	}
	
	public static int findRecursiveSol(int N){
		if(N<=1) {
			return N;
		}
		else {
			return findRecursiveSol(N-1) + findRecursiveSol(N-2);
		}
	}
	
	public static int findDPTopDown(int N) {
		if(memo[N] != null) {
			return memo[N];
		}
		if(N<=1) {
			memo[N] = N;
			return N;
		}
		
		memo[N] = findDPTopDown(N-1) + findDPTopDown(N-2);

		return memo[N];
	}
}
