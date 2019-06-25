import java.util.*;
public class leetCode73 {
	public static void main(String[] args) {
		int[][] matrix = new int[][] {{1,1,1},{1,0,1},{1,1,1}};
		int[][] result = new int[matrix.length][matrix[0].length];
		int[][] result2 = new int[matrix.length][matrix[0].length];
 		result = setZeroes(matrix);
		result2 = setZeroesNoSpace(matrix);
		System.out.println(Arrays.deepToString(result));
	}

	private static int[][] setZeroes(int[][] matrix) {
		int MODIFIED = -100000;
		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix[0].length; j++) {
				if(matrix[i][j] == 0) {
						for(int col = 0; col<matrix[0].length; col++) {
							if(matrix[i][col] !=0)
								matrix[i][col] = MODIFIED;
						}
						for(int row = 0; row<matrix.length; row++) {
							if(matrix[row][j] != 0)
								matrix[row][j] = MODIFIED;
						}
				}
			}
		}
		
		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix[0].length; j++) {
				if(matrix[i][j] == MODIFIED) {
					matrix[i][j] = 0;
				}
			}
		}
		return matrix;	
	}
	
	private static int[][] setZeroesNoSpace(int[][] matrix){
		Boolean isCol = false;
		int R = matrix.length;
		int C = matrix[0].length;
		
		for(int i=0; i<R; i++) {
			if(matrix[i][0] == 0) {
				isCol = true;
			}
			for(int j=1; j<C; j++) {
				if(matrix[i][j] == 0) {
					matrix[0][j] = 0;
					matrix[i][0] = 0;
				}
			}
		}
		
		
		
		
		return matrix;
	}
}
