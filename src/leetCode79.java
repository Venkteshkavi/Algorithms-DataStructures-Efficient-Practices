import java.util.*;
public class leetCode79 {
	public static void main(String[] args) {
		 char board[][] = new char[][] {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
		 String word = "ABCCED";
		 boolean result = searchWord(board,word);
		 System.out.println(result);
	}
	
	public static boolean searchWord(char[][] board, String word) {
		
		//First we need to search whether the first letter exists in the grid
		
		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board[i].length; j++) {
				if(board[i][j] == word.charAt(0) && dfs(board,i,j,0,word)) {
					return true;
				}
			}
		}
		return false;
	}
	
	public static boolean dfs(char[][] board, int i, int j, int count, String word) {
		
		//If our count is equal to word length we directly exit
		if(count == word.length()) {
			return true;
		}
		
		if(i <0 || i>=board.length || j<0 || j>=board[i].length || board[i][j] != word.charAt(count)) {
			return false;
		}
		
        // We havent found the remainder of the characters, we havent gone out of boun and we have 
		// just found a character we are looking for
        
        /* The same letter cell may not be used more than once. In order to meet that once we                    
         * encounter the desired character we mark the cell as empty i.e.., board[i][j] = " "
         * but we need to remember the value in that cell because we need to add it back
        */
		
		char temp = board[i][j];
		board[i][j] = ' ';
		
        
        //Traverse down, up ,left, right
        boolean found = dfs(board,i+1,j,count+1,word) || dfs(board,i-1,j,count+1,word) || dfs(board,i,j+1,count+1,word) || dfs(board,i,j-1,count+1,word);
    
        board[i][j] = temp;
        return found;
	}
}
