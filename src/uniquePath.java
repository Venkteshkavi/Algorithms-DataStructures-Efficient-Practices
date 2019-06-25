import java.util.*;
public class uniquePath {
	public static void main(String[] args) {
		int m =7, n = 3, result = 0;
		result = findUniquePaths(m,n);
		System.out.println(result);
	}
	
	public static int findUniquePaths(int m, int n) {
        /*  1.Here m is the number of rows and n denotes the number of cols
        	2.We need to create a 2D matrix for this DP problem
        	3.Also we need to fill the first row and first col as 1's
        */
		if(m<=1 && n<=1) {
			return 1;
		}
		int[][] dp = new int[n][m];
		for(int i=0; i<n; i++) {
			dp[i][0] = 1;
		}
		for(int i=0; i<m; i++) {
			dp[0][i] = 1;
		}
		
        for(int i=1; i<n; i++){
            for(int j=1; j<m; j++){
                dp[i][j] = dp[i][j-1] + dp[i-1][j];
            }
        }
		return dp[n-1][m-1];
	}
}
