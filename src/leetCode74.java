import java.util.*;
public class leetCode74 {
	//Search in a 2D Matrix
	public static void main( String[] args) {
		int[][] matrix = new int[][] {{1,3,5,7},{10,12,14,16},{18,20,22,24}};
		int target = 3;
		boolean result = searchMatrix(matrix,target);
		boolean result_1 = binarySearchInSortedMatrix(matrix,target);
		System.out.println(result + " " + result_1);
	}

	private static boolean binarySearchInSortedMatrix(int[][] matrix, int target) {
		int row_num = matrix.length;
		int col_num = matrix[0].length;
		
		int begin = 0, end = row_num * col_num - 1;
		
		while(begin <= end){
			int mid = (begin + end) / 2;
			int mid_value = matrix[mid/col_num][mid%col_num];
			
			if( mid_value == target){
				return true;
			
			}else if(mid_value < target){
				//Should move a bit further, otherwise dead loop.
				begin = mid+1;
			}else{
				end = mid-1;
			}
		}
		return false;
	}

	private static boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int start = 0, end = matrix[0].length;
	
        if(matrix.length == 0 || matrix[0].length == 0){
            return false;
        }

        
        for(int i=0 ; i<rows; i++){
            if(cols > 1 && (target > matrix[i][0] && target <= matrix[i][cols-1])) {
	                while(start < end){
	                    int mid = start + (end-start) / 2;
	                    if(target == matrix[i][mid]){
	                            return true;
	                    }
	                    else if(target > matrix[i][mid] && target <= matrix[i][end]){
	                            start = mid+1;
	                    }
	                    else{
	                        end = mid;
	                    }
	                }
            }
            else if(cols == 1) {
            	for(int k = 0; i<rows; i++) {
            		if(target == matrix[i][0]) {
            			return true;
            		}
            	}
            }
            else{
                //If it comes here it means that elements in the row are all the same
            	if(target==matrix[i][0]) {
            		return true;
            	}
            }
        }
		return false;
	}
}