import java.util.*;
public class gameOfLife {
	public static void main(String[] args) {
		int[][] board = new int[][] {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
//		playGameOfLife(board);
//		playGameOfLife2(board);
		System.out.println(Arrays.deepToString(board));
	}
	
	public static void playGameOfLife(int[][] board) {
		//Creating a copy board
		int[][] copyBoard = new int[board.length][board[0].length];
		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board[0].length; j++) {
				copyBoard[i][j] = board[i][j];
			}
		}
		int livelinessCount = 0;
		boolean liveCell = false;
		boolean deadCell = false;
		int m = board.length;
		int n = board[0].length;
		//Visit Each Element in the original board and apply the rules
		for(int row=0; row<board.length; row++) {
			for(int col=0; col<board[0].length; col++) {
				if(board[row][col] == 1) {
					liveCell = true;
				}
				else
					deadCell = true;
				//We need to traverse 3 rows and 3 cols to check
				for(int i=row-1; i<row+2; i++) {
					if(i < 0) {
						continue;
					}
					else if(i == m) {
						break;
					}
					for(int j=col-1; j<col+2; j++) {
						if(j < 0)
							continue;
						else if(j == n) {
							break;
						}
						else if(row == i && col == j){
							continue;
						}
						else if(board[i][j] == 1) {
							livelinessCount++;
						}
					}
				}
				
				
				if(livelinessCount < 2 && liveCell == true) {
					copyBoard[row][col] = 0;
				}
				
				else if(livelinessCount == 3 && deadCell == true)
					copyBoard[row][col] = 1;
				else if((liveCell == true) && (livelinessCount == 2 || livelinessCount == 3))
					copyBoard[row][col] = 1;
				else if(liveCell == true && livelinessCount > 3)
					copyBoard[row][col] = 0;
				else
					System.out.println("Uncaught Condition");
				livelinessCount = 0;
				liveCell = false;
				deadCell = false;
				
			}
		}
		
		System.out.println("Copy Board is  " + " " + Arrays.deepToString(copyBoard));
	}
	
	public static void playGameOfLife2(int[][] board) {
        // Neighbors array to find 8 neighboring cells for a given cell
        int[] neighbors = {0, 1, -1};

        int rows = board.length;
        int cols = board[0].length;

        // Create a copy of the original board
        int[][] copyBoard = new int[rows][cols];

        // Create a copy of the original board
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                copyBoard[row][col] = board[row][col];
            }
        }

        // Iterate through board cell by cell.
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {

                // For each cell count the number of live neighbors.
                int liveNeighbors = 0;

                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {

                        if (!(neighbors[i] == 0 && neighbors[j] == 0)) {
                            int r = (row + neighbors[i]);
                            int c = (col + neighbors[j]);

                            // Check the validity of the neighboring cell.
                            // and whether it was originally a live cell.
                            // The evaluation is done against the copy, since that is never updated.
                            if ((r < rows && r >= 0) && (c < cols && c >= 0) && (copyBoard[r][c] == 1)) {
                                liveNeighbors += 1;
                            }
                        }
                    }
                }

                // Rule 1 or Rule 3
                if ((copyBoard[row][col] == 1) && (liveNeighbors < 2 || liveNeighbors > 3)) {
                    board[row][col] = 0;
                }
                // Rule 4
                if (copyBoard[row][col] == 0 && liveNeighbors == 3) {
                    board[row][col] = 1;
                }
            }
        }
	}
}
