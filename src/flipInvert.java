import java.util.*;
public class flipInvert {
	public static void main(String[] args) {
		int[][] A = new int[][] {{1,1,0},{1,0,1},{0,0,0}};
		int[][] newMatrix = new int[A.length][A[0].length];
		newMatrix = findInvertedMatrix(A);
		System.out.println(Arrays.deepToString(newMatrix));
	}
	
	public static int[][] findInvertedMatrix(int[][] A){
		int C = A[0].length;
		for(int[] row: A) {
			for(int i=0; i< (C+1)/2; ++i) {
				int temp = row[i] ^ 1;
				row[i] = row[C-1-i] ^ 1;
				row[C-1-i] = temp;
			}
		}
		return A;
	}
}
