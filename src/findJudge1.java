import java.util.*;
public class findJudge1 {
	public static void main(String[] args) {
		int N = 2;
		int[][] trust = new int[][] {{1,2}};
		int result = findTownJudge(N,trust);
		System.out.println(result);
	}

	private static int findTownJudge(int n, int[][] trust) {
		// TODO Auto-generated method stub
		int[] trust_1 = new int[n];
		int[] trust_2 = new int[n];
		for(int i=0; i<trust.length; i++) {
			int a = trust[i][0];
			int b = trust[i][1];
			trust_1[a-1]++;
			trust_2[b-1]++;
		}
        for(int i = 0; i < n; i++){
            if(trust_1[i] == 0 && trust_2[i] == n - 1)
                return i + 1;
        }
		return 0;
	}
}
