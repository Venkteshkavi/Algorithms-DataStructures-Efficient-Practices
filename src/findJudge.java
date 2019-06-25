import java.util.*;
public class findJudge {
	public static void main(String[] args) {
		int N = 4;
		int[][] trust = new int[][] { {1,2},{3,2},{1,3},{4,1},{3,1},{2,1},{2,3},{4,3},{4,2},{3,4},{2,4}};
//		[1,3],[1,4],[2,3],[2,4],[4,3]
		int result = 0;
		result = findJudge(N,trust);
		System.out.println(result);
	}
	
	public static int findJudge(int N, int[][] trust) {
		int judge = 0;
		int flag = 1;
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
//
//		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		int rows = trust.length;
		int cols = trust[0].length;
//		for(int[] row: trust) {
//			int val = row[1];
//            if(map.containsKey(val)){
//                int keyVal = map.get(val);
//                map.put(val,keyVal+1);
//            }
//            else{
//                map.put(val,1);
//            }
//		}
//        int maxVal = Integer.MIN_VALUE;
//        Iterator keySetIterator = map.keySet().iterator();
//        while(keySetIterator.hasNext()){
//             int key = (int) keySetIterator.next();
//             int resultVal = map.get(key);
//            if(resultVal > maxVal){
//                maxVal = resultVal;
//                judge = key;
//            }
//        }
//        if(maxVal == 1 && N>2) {
//        	return -1;
//        }
//        System.out.println(map);
		
		if(trust.length == 1 && trust[0].length == 2) {
			return trust[0][1];
		}
		int[][] dp = new int[N][N];
		dp[0][0] = 0;
		for(int i=1; i<dp.length; i++) {
			for(int j=1; j<dp[0].length; j++)
				dp[i][j] = 0;
		}
		for(int[] row:trust) {
			dp[row[0]-1][row[1]-1] = 1;
		}
		
		for(int i=0; i<dp.length; i++) {
			for(int j=0; j<dp[0].length; j++) {
				if(dp[i][j] == 1) {
					if(map.containsKey(j+1)) {
						int val = map.get(j+1);
						map.put(j+1,val+1);
					}
					else {
						map.put(j+1,1);
					}
				}
			}
		}
		
        int maxVal = Integer.MIN_VALUE;
        Iterator keySetIterator = map.keySet().iterator();
        while(keySetIterator.hasNext()){
             int key = (int) keySetIterator.next();
             int resultVal = map.get(key);
            if(resultVal > maxVal){
                maxVal = resultVal;
                judge = key;
            }
        }
        System.out.println(judge);
        if(maxVal == 1) {
        	return -1;
        }
//		System.out.println(dp.length);
		System.out.println(map);
		System.out.println(Arrays.deepToString(dp));
		for(int i=dp.length-1; i<dp.length;i++) {
			for(int j=0; j<dp[0].length; j++) {
//				System.out.println(i + " " + j);
				if(dp[i][j] == 1) {
					if(judge != j+1) {
						flag = 1;
					}
					else {
						flag = 0;
						break;
					}
				}
			}
		}
		if(flag == 1) {
			return -1;
		}
		System.out.println(map);
		System.out.println(Arrays.deepToString(dp));
        return judge;
	}
}
