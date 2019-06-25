import java.util.*;
public class maximumLengthOfRepeatedSubarray {
	public static void main(String[] args) {
		int[] A = new int[] {1,2,3,2,1,5};
		int[] B = new int[] {3,2,1,3,3};
		int result = 0,result1;
		result = findLengthUsingCharacterMap(A,B);
//		result1 = findLengthUsingDynamicProgramming(A,B);
		System.out.println("Using Character Map " + result);
//		System.out.println("Using Dynamic Programming " + result1);
	}
	
	public static int findLengthUsingCharacterMap(int[] A,int[] B) {
        int ans = 0;
        Map<Integer, ArrayList<Integer>> Bstarts = new HashMap();
        for (int j = 0; j < B.length; j++) {
            Bstarts.computeIfAbsent(B[j], x -> new ArrayList()).add(j);
        }

        for (int i = 0; i < A.length; i++) if (Bstarts.containsKey(A[i])) {
            for (int j: Bstarts.get(A[i])) {
                int k = 0;
                while (i+k < A.length && j+k < B.length && A[i+k] == B[j+k]) {
                    k++;
                }
                ans = Math.max(ans, k);
            }
        }
		return ans;
	}
	
	public static int findLengthUsingDynamicProgramming(int[]A,int[] B) {
        int ans = 0;
        int[][] memo = new int[A.length + 1][B.length + 1];
        for (int i = A.length - 1; i >= 0; --i) {
            for (int j = B.length - 1; j >= 0; --j) {
                if (A[i] == B[j]) {
                    memo[i][j] = memo[i+1][j+1] + 1;
                    if (ans < memo[i][j]) ans = memo[i][j];
                }
            }
        }
		return ans;
	}
}
