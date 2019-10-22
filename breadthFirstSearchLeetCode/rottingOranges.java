package breadthFirstSearchLeetCode;
import java.util.*;
public class rottingOranges {
	public static void main(String[] args) {
		int[][] orangeYard = {{1,1,1},{1,2,1},{2,1,0}};
		System.out.println(findTimeForRotting(orangeYard));
	}
	
	
	public static int findTimeForRotting(int[][] orangeYard) {
		
	    int[] dr = new int[]{-1, 0, 1, 0};
	    int[] dc = new int[]{0, -1, 0, 1};
		
		int R = orangeYard.length;
		int C = orangeYard[0].length;
		
		/* Finding the the locations where we have rotten oranges
		 * So that we can start a BFS from those locations and calculate 
		 * the time required.
		 */
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		Map<Integer,Integer> depth = new HashMap<>();
		for(int r=0; r<R; r++) {
			for(int c=0; c<C; c++) {
				if(orangeYard[r][c]== 2) {
					//r*C + c gives the index number
					int label = r*C+c;
					pq.add(label);
					depth.put(label,0);
				}
			}
		}
		int ans = 0;
		while(!pq.isEmpty()) {
			int label = pq.remove();
			//Now we need to traverse top,down,left and right
			int r = label/C;
			int c = label%C;
			
			for(int k=0; k<4; k++) {
                int nr = r + dr[k];
                int nc = c + dc[k];
				if(0<=nr && nr<R && 0<=nc && nc<C && orangeYard[nr][nc] == 1) {
					orangeYard[nr][nc] = 2;
					int new_label = nr*C+nc;
					pq.add(new_label);
					depth.put(new_label,depth.get(label)+1);
					ans = depth.get(new_label);
						
				}
			}
			
		}
		return ans;
	}
}

// dr = {-1,0,1,0}
// dc = {0,-1,0,1}
// (1,1) -> (0,1) ; (1,0) ; (1,1) ; (1,2) ; (2,1)