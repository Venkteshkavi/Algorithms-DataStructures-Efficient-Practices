import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
        int res = Integer.MIN_VALUE;
        for(int i=0; i<=arr.length-3;i++){
            for(int j=0; j<=arr[0].length-3; j++){
                int rs = 0;
                for(int k=i; k<i+3;k++){
                    for(int l=j; l<j+3; l++){
                        if(k==i || k==i+2){
                            rs += arr[k][l];
                        }
                        else{
                            rs += arr[k][j+1];
                            break;
                        }
                    }
                }
                res = Math.max(res,rs);
            }
        }

        return res;
    }

}
