/*

Starting with a 1-indexed array of zeros and a list of operations, for each operation add a value to each of the array element between two given indices, inclusive.
Once all operations have been performed, return the maximum value in your array.
For example, the length of your array of zeros . Your list of queries is as follows:
a b k
1 5 3
4 8 7
6 9 1

index->	 1 2 3  4  5 6 7 8 9 10
	[0,0,0, 0, 0,0,0,0,0, 0]
	[3,3,3, 3, 3,0,0,0,0, 0]
	[3,3,3,10,10,7,7,7,0, 0]
	[3,3,3,10,10,8,8,8,1, 0]

  Sample Input

5 3
1 2 100
2 5 100
3 4 100
Sample Output

200
*/

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the arrayManipulation function below.
    static long arrayManipulation(int n, int[][] queries) {
        long[] res = new long[n+2];
        long max_sum = Integer.MIN_VALUE;
        for(int i=0; i<queries.length; i++){
                int a = queries[i][0];
                int b = queries[i][1];
                int k = queries[i][2];

                res[a] += k;
                res[b+1] -= k;
            }
            long curr_sum = 0;
            for(int i=0; i<res.length; i++){

                curr_sum += res[i];
                max_sum = Math.max(curr_sum,max_sum);
            }
            return max_sum;

    }
